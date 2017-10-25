package net.demilich.metastone.game.behaviour.threat;

import java.util.ArrayList;
import java.util.List;

import net.demilich.metastone.NotificationProxy;
import net.demilich.metastone.trainingmode.RequestTrainingDataNotification;
import net.demilich.metastone.trainingmode.TrainingData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.demilich.metastone.game.GameContext;
import net.demilich.metastone.game.Player;
import net.demilich.metastone.game.actions.ActionType;
import net.demilich.metastone.game.actions.GameAction;
import net.demilich.metastone.game.behaviour.Behaviour;
import net.demilich.metastone.game.behaviour.IBehaviour;
import net.demilich.metastone.game.behaviour.heuristic.IGameStateHeuristic;
import net.demilich.metastone.game.cards.Card;

import net.demilich.metastone.game.Attribute;
import net.demilich.metastone.game.entities.heroes.Hero;
import net.demilich.metastone.game.entities.heroes.HeroClass;
import net.demilich.metastone.game.entities.minions.Minion;

public class GameStateValueBehaviour extends Behaviour {

		//private final FeatureVector weights;

	/*public GameStateValueBehaviour(FeatureVector vector) {
		this.weights = vector;
	}*/

	private final jdk.internal.instrumentation.Logger logger = LoggerFactory.getLogger(GameStateValueBehaviour.class);

	private IGameStateHeuristic heuristic;
	private FeatureVector featureVector;
	private String nameSuffix = "";


	public GameStateValueBehaviour() {	
	}

	

	public GameStateValueBehaviour(FeatureVector featureVector, String nameSuffix) {
		this.featureVector = featureVector;
		this.nameSuffix = nameSuffix;
		this.heuristic = new ThreatBasedHeuristic(featureVector);
	}

	private double alphaBeta(GameContext context, int playerId, GameAction action, int depth) {
		GameContext simulation = context.clone();
		simulation.getLogic().performGameAction(playerId, action);
		if (depth == 0 || simulation.getActivePlayerId() != playerId || simulation.gameDecided()) {
			return heuristic.getScore(simulation, playerId);
		}

		List<GameAction> validActions = simulation.getValidActions();

		double score = Float.NEGATIVE_INFINITY;

		for (GameAction gameAction : validActions) {
			score = Math.max(score, alphaBeta(simulation, playerId, gameAction, depth - 1));
			if (score >= 100000) {
				break;
			}
		}

		return score;
	}

	private void answerTrainingData(TrainingData trainingData) {
		featureVector = trainingData != null ? trainingData.getFeatureVector() : FeatureVector.getFittest();
		heuristic = new ThreatBasedHeuristic(featureVector);
		nameSuffix = trainingData != null ? "(trained)" : "(untrained)";
	}

	@Override
	public IBehaviour clone() {
		if (featureVector != null) {
			return new GameStateValueBehaviour(featureVector.clone(), nameSuffix);
		}
		return new GameStateValueBehaviour();
	}

	@Override
	public String getName() {
		return "Game state value " + nameSuffix;
	}

	@Override
	public List<Card> mulligan(GameContext context, Player player, List<Card> cards) {
		requestTrainingData(player);
		List<Card> discardedCards = new ArrayList<Card>();
		for (Card card : cards) {
			if (card.getBaseManaCost() > 3) {
				discardedCards.add(card);
			}
		}
		return discardedCards;
	}

	@Override
	public GameAction requestAction(GameContext context, Player player, List<GameAction> validActions) {
		if (validActions.size() == 1) {
			return validActions.get(0);
		}

		int depth = 2;
		// when evaluating battlecry and discover actions, only optimize the immediate value
		if (validActions.get(0).getActionType() == ActionType.BATTLECRY) {
			depth = 0;
		} else if (validActions.get(0).getActionType() == ActionType.DISCOVER) {
			return validActions.get(0);
		}

		GameAction bestAction = validActions.get(0);
		GameAction secondAction = validActions.get(0);
		GameAction thirdAction = validActions.get(0);
		GameAction fourthAction = validActions.get(0);
		GameAction fifthAction = validActions.get(0);
		double bestScore = Double.NEGATIVE_INFINITY;
		double secondOption = Double.NEGATIVE_INFINITY;
		double thirdOption = Double.NEGATIVE_INFINITY;
		double fourthOption = Double.NEGATIVE_INFINITY;
		double fifthOption = Double.NEGATIVE_INFINITY;

		for (GameAction gameAction : validActions) {
			double score = alphaBeta(context, player.getId(), gameAction, depth);
			if (score > bestScore) {
				fifthAction = fourthAction;
				fourthAction = thirdAction;
				thirdAction = secondAction;
				secondAction = bestAction;
				bestAction = gameAction;
				fifthOption = fourthOption;
				fourthOption = thirdOption;
				thirdOption = secondOption;
				secondOption = bestScore;
				bestScore = score;
			}
		}


		logger.info("Selecting best action {} with score {}\n", bestAction, bestScore);
		logger.info("Alternative action 1 {} with score {}\n", secondAction, secondOption);
		logger.info("Alternative action 2 {} with score {}\n", thirdAction, thirdOption);
		logger.info("Alternative action 3 {} with score {}\n", fourthAction, fourthOption);
		logger.info("Alternative action 4 {} with score {}\n", fifthAction, fifthOption);
		return bestAction;
	}

	private void requestTrainingData(Player player) {
		if (heuristic != null) {
			return;
		}

		RequestTrainingDataNotification request = new RequestTrainingDataNotification(player.getDeckName(), this::answerTrainingData);
		NotificationProxy.notifyObservers(request);
	}

}
