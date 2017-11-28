package net.demilich.metastone.game.behaviour.human;

import java.util.ArrayList;
import java.util.List;

import net.demilich.metastone.BuildConfig;
import net.demilich.metastone.GameNotification;
import net.demilich.metastone.NotificationProxy;
import net.demilich.metastone.game.GameContext;
import net.demilich.metastone.game.Player;
import net.demilich.metastone.game.actions.ActionType;
import net.demilich.metastone.game.actions.GameAction;
import net.demilich.metastone.game.actions.IActionSelectionListener;
import net.demilich.metastone.game.behaviour.Behaviour;
import net.demilich.metastone.game.cards.Card;
import net.demilich.metastone.game.behaviour.threat.GameStateValueBehaviour;

public class HumanBehaviour extends Behaviour implements IActionSelectionListener {

	private GameAction selectedAction;
	private boolean waitingForInput;
	private List<Card> mulliganCards;

	@Override
	public String getName() {
		return "<Human controlled>";
	}

	@Override
	public List<Card> mulligan(GameContext context, Player player, List<Card> cards) {
		if (context.ignoreEvents()) {
			return new ArrayList<Card>();
		}
		waitingForInput = true;
		HumanMulliganOptions options = new HumanMulliganOptions(player, this, cards);
		NotificationProxy.sendNotification(GameNotification.HUMAN_PROMPT_FOR_MULLIGAN, options);
		while (waitingForInput) {
			try {
				Thread.sleep(BuildConfig.DEFAULT_SLEEP_DELAY);
			} catch (InterruptedException e) {
			}
		}
		return mulliganCards;
	}

	@Override
	public void onActionSelected(GameAction action) {
		this.selectedAction = action;
		waitingForInput = false;
	}

	@Override
	public GameAction requestAction(GameContext context, Player player, List<GameAction> validActions) {
		waitingForInput = true;
		System.out.println("waiting for input");
		
		GameStateValueBehaviour test = new GameStateValueBehaviour();
		test.printExplanation(context,player,validActions.get(0));

			int depth = 2;
			// when evaluating battlecry and discover actions, only optimize the immediate value
			if (validActions.get(0).getActionType() == ActionType.BATTLECRY) {
				depth = 0;
			}// else if (validActions.get(0).getActionType() == ActionType.DISCOVER) {
				//return validActions.get(0);
			//}
			GameAction bestAction = validActions.get(0); //these were all 0
			GameAction secondAction = validActions.get(0);
			GameAction thirdAction = validActions.get(0);
			GameAction fourthAction = validActions.get(0);
			GameAction fifthAction = validActions.get(0);

			double bestScore = Double.NEGATIVE_INFINITY;
			double secondScore = Double.NEGATIVE_INFINITY;
			double thirdScore = Double.NEGATIVE_INFINITY;
			double fourthScore = Double.NEGATIVE_INFINITY;
			double fifthScore = Double.NEGATIVE_INFINITY;
	//&& (bestAction.isSameActionGroup(secondAction))
			for (GameAction gameAction : validActions) {
				double score = GameStateValueBehaviour.alphaBeta(context, player.getId(), gameAction, depth);
				if (score > bestScore ) {
					fifthAction = fourthAction;
					fourthAction = thirdAction;
					thirdAction = secondAction;
					if(!bestAction.isSameActionGroup(secondAction)){
					secondAction = bestAction;
				}
					bestAction = gameAction;
					fifthScore = fourthScore;
					fourthScore = thirdScore;
					thirdScore = secondScore;
					if(!bestAction.isSameActionGroup(secondAction)){
					secondScore = bestScore;
				}
					bestScore = score;
				}
				else if(score > secondScore && score <= bestScore){
					fifthAction = fourthAction;
					fourthAction = thirdAction;
					if(!secondAction.isSameActionGroup(thirdAction)){
					thirdAction = secondAction;
				}
					secondAction = gameAction;
					fifthScore = fourthScore;
					fourthScore = thirdScore;
					if(!secondAction.isSameActionGroup(thirdAction)){
					thirdScore = secondScore;
				}
					secondScore = score;
				}
				else if(score > thirdScore && score <= secondScore){
					fifthAction = fourthAction;
					if(!thirdAction.isSameActionGroup(fourthAction)){
					fourthAction = thirdAction;
				}
					thirdAction = gameAction;
					fifthScore = fourthScore;
					if(!thirdAction.isSameActionGroup(fourthAction)){
					fourthScore = thirdScore;
				}
					thirdScore = score;
				}
				else if(score > fourthScore && score <= thirdScore){
					fifthAction = fourthAction;
					fourthAction = gameAction;
					fifthScore = fourthScore;
					fourthScore = score;
				}
				else if(score > fifthScore && score <= fifthScore){
					fifthAction = gameAction;
					fifthScore = score;
				}
			}

			System.out.println("Best action is " + bestAction + "\n");
			test.printExplanation(context,player,bestAction);
			System.out.println("Alternative action 1 is " + secondAction + "\n");
			test.printExplanation(context,player,secondAction);
			System.out.println("Alternative action 2 is " + thirdAction + "\n");
			test.printExplanation(context,player,thirdAction);
			System.out.println("Alternative action 3 is " + fourthAction + "\n");
			test.printExplanation(context,player,fourthAction);
			System.out.println("Alternative action 4 is " + fifthAction + "\n");
			test.printExplanation(context,player,fifthAction);


		HumanActionOptions options = new HumanActionOptions(this, context, player, validActions);
		NotificationProxy.sendNotification(GameNotification.HUMAN_PROMPT_FOR_ACTION, options);
		while (waitingForInput) {
			try {
				Thread.sleep(BuildConfig.DEFAULT_SLEEP_DELAY);
				if (context.ignoreEvents()) {
					return null;
				}
			} catch (InterruptedException e) {
			}
		}
		return selectedAction;
	}

	public void setMulliganCards(List<Card> mulliganCards) {
		this.mulliganCards = mulliganCards;
		waitingForInput = false;
	}

}
