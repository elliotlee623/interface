/*package gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.wb.swt.SWTResourceManager;

public class MainWindow {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	private Text text_7;
	private Text text_8;
	private Text text_9;
	private Text text_14;
	private Text text_15;
	private Text text_16;
	private Text text_17;
	private Text text_18;
	private Text text_19;
	private Text text_10;
	private Text text_11;
	private Text text_12;
	private Text text_13;

	
	 // Launch the application.
	 // @param args
	 
	public static void main(String[] args) {
		try {
			MainWindow window = new MainWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	 // Open the window.
	 
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	
	 // Create contents of the window.
	 
	protected void createContents() {
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		shell.setSize(520, 500);
		shell.setText("AI Coach");
		shell.setLayout(null);
		
		Label lblBestMove = new Label(shell, SWT.NONE);
		lblBestMove.setBounds(10, 10, 83, 21);
		lblBestMove.setText("Best Move:");
		
		text = new Text(shell, SWT.BORDER);
		text.setEditable(false);
		text.setBounds(84, 7, 225, 19);
		
		Label lblExplanation = new Label(shell, SWT.NONE);
		lblExplanation.setBounds(10, 37, 83, 28);
		lblExplanation.setText("Explanation:");
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setEditable(false);
		text_1.setBounds(84, 32, 225, 40);
		
		Label lblAltnerativeMove = new Label(shell, SWT.NONE);
		lblAltnerativeMove.setText("Best Move:");
		lblAltnerativeMove.setBounds(10, 98, 83, 21);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setText("Explanation:");
		label_1.setBounds(10, 125, 83, 36);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setEditable(false);
		text_2.setBounds(84, 120, 225, 40);
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setEditable(false);
		text_3.setBounds(84, 95, 225, 19);
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setText("Best Move:");
		label_2.setBounds(10, 192, 83, 21);
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setText("Explanation:");
		label_3.setBounds(10, 219, 83, 32);
		
		text_4 = new Text(shell, SWT.BORDER);
		text_4.setEditable(false);
		text_4.setBounds(84, 214, 225, 40);
		
		text_5 = new Text(shell, SWT.BORDER);
		text_5.setEditable(false);
		text_5.setBounds(84, 189, 225, 19);
		
		Label label_4 = new Label(shell, SWT.NONE);
		label_4.setText("Best Move:");
		label_4.setBounds(10, 288, 83, 21);
		
		Label label_5 = new Label(shell, SWT.NONE);
		label_5.setText("Explanation:");
		label_5.setBounds(10, 315, 83, 30);
		
		text_6 = new Text(shell, SWT.BORDER);
		text_6.setEditable(false);
		text_6.setBounds(84, 310, 225, 40);
		
		text_7 = new Text(shell, SWT.BORDER);
		text_7.setEditable(false);
		text_7.setBounds(84, 285, 225, 19);
		
		Label label_6 = new Label(shell, SWT.NONE);
		label_6.setText("Best Move:");
		label_6.setBounds(10, 394, 83, 21);
		
		Label label_7 = new Label(shell, SWT.NONE);
		label_7.setText("Explanation:");
		label_7.setBounds(10, 421, 83, 28);
		
		text_8 = new Text(shell, SWT.BORDER);
		text_8.setEditable(false);
		text_8.setBounds(84, 416, 225, 40);
		
		text_9 = new Text(shell, SWT.BORDER);
		text_9.setEditable(false);
		text_9.setBounds(84, 391, 225, 19);
		
		Label label_8 = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label_8.setForeground(SWTResourceManager.getColor(255, 204, 0));
		label_8.setBackground(SWTResourceManager.getColor(255, 204, 0));
		label_8.setBounds(315, 0, 2, 492);
		
		Label label_9 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_9.setBounds(315, 132, 205, 2);
		
		Label lblHpDifference = new Label(shell, SWT.NONE);
		lblHpDifference.setBounds(325, 140, 94, 14);
		lblHpDifference.setText("HP difference");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(323, 160, 96, 14);
		lblNewLabel.setText("Card difference");
		
		Label lblSelfMinionCount = new Label(shell, SWT.NONE);
		lblSelfMinionCount.setBounds(323, 180, 117, 14);
		lblSelfMinionCount.setText("Self minion count");
		
		Label lblOppMinionCount = new Label(shell, SWT.NONE);
		lblOppMinionCount.setBounds(323, 199, 117, 14);
		lblOppMinionCount.setText("Opp minion count");
		
		Label lblMinionAtt = new Label(shell, SWT.NONE);
		lblMinionAtt.setBounds(323, 219, 88, 14);
		lblMinionAtt.setText("Minion Att");
		
		Label lblMinionHp = new Label(shell, SWT.NONE);
		lblMinionHp.setBounds(323, 240, 59, 14);
		lblMinionHp.setText("Minion HP");
		
		Label lblMinionTaunt = new Label(shell, SWT.NONE);
		lblMinionTaunt.setBounds(323, 260, 96, 14);
		lblMinionTaunt.setText("Minion Taunt");
		
		Label lblMinionWindfury = new Label(shell, SWT.NONE);
		lblMinionWindfury.setBounds(323, 280, 96, 21);
		lblMinionWindfury.setText("Minion Windfury");
		
		Label lblMinionDivineShield = new Label(shell, SWT.NONE);
		lblMinionDivineShield.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblMinionDivineShield.setBounds(323, 300, 117, 14);
		lblMinionDivineShield.setText("Minion Divine shield");
		
		Label lblMinionSpellPower = new Label(shell, SWT.NONE);
		lblMinionSpellPower.setBounds(323, 320, 125, 14);
		lblMinionSpellPower.setText("Minion Spell Power");
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBounds(323, 340, 136, 34);
		lblNewLabel_1.setText("Minion Untargetable\nBy Spells");
		
		Label lblMinionStealthed = new Label(shell, SWT.NONE);
		lblMinionStealthed.setBounds(323, 374, 136, 14);
		lblMinionStealthed.setText("Minion Stealthed");
		
		text_14 = new Text(shell, SWT.BORDER);
		text_14.setEditable(false);
		text_14.setBounds(446, 138, 64, 19);
		
		text_15 = new Text(shell, SWT.BORDER);
		text_15.setEditable(false);
		text_15.setBounds(446, 157, 64, 19);
		
		text_16 = new Text(shell, SWT.BORDER);
		text_16.setEditable(false);
		text_16.setBounds(446, 177, 64, 19);
		
		text_17 = new Text(shell, SWT.BORDER);
		text_17.setEditable(false);
		text_17.setBounds(446, 196, 64, 19);
		
		text_18 = new Text(shell, SWT.BORDER);
		text_18.setEditable(false);
		text_18.setBounds(446, 215, 64, 19);
		
		text_19 = new Text(shell, SWT.BORDER);
		text_19.setEditable(false);
		text_19.setBounds(446, 235, 64, 19);
		
		Button button = new Button(shell, SWT.CHECK);
		button.setBounds(446, 259, 22, 18);
		
		Button button_1 = new Button(shell, SWT.CHECK);
		button_1.setBounds(446, 279, 22, 18);
		
		Button button_2 = new Button(shell, SWT.CHECK);
		button_2.setBounds(446, 299, 22, 18);
		
		Button button_3 = new Button(shell, SWT.CHECK);
		button_3.setBounds(446, 370, 22, 18);
		
		Button button_4 = new Button(shell, SWT.CHECK);
		button_4.setBounds(446, 340, 22, 18);
		
		Button button_5 = new Button(shell, SWT.CHECK);
		button_5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		button_5.setBounds(446, 319, 22, 18);
		
		Label lblUserInputLog = new Label(shell, SWT.NONE);
		lblUserInputLog.setAlignment(SWT.CENTER);
		lblUserInputLog.setBounds(365, 10, 94, 23);
		lblUserInputLog.setText("User Input Log");
		
		text_10 = new Text(shell, SWT.BORDER);
		text_10.setEditable(false);
		text_10.setBounds(325, 32, 185, 19);
		
		text_11 = new Text(shell, SWT.BORDER);
		text_11.setEditable(false);
		text_11.setBounds(325, 57, 185, 19);
		
		text_12 = new Text(shell, SWT.BORDER);
		text_12.setEditable(false);
		text_12.setBounds(325, 82, 185, 19);
		
		text_13 = new Text(shell, SWT.BORDER);
		text_13.setEditable(false);
		text_13.setBounds(325, 107, 185, 19);

	}
}*/

package gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.wb.swt.SWTResourceManager;

import java.lang.*;
import java.io.*;
import java.net.*;


	public class MainWindow {
	
		protected Shell shell;
		private Text text;
		private Text text_1;
		private Text text_2;
		private Text text_3;
		private Text text_4;
		private Text text_5;
		private Text text_6;
		private Text text_7;
		private Text text_8;
		private Text text_9;
		private Text text_14;
		private Text text_15;
		private Text text_16;
		private Text text_17;
		private Text text_18;
		private Text text_19;
		private Text text_10;
		private Text text_11;
		private Text text_12;
		private Text text_13;
	
		/**
		 * Launch the application.
		 * @param args
		 */
		public static void main(String[] args) {
			try {
				MainWindow window = new MainWindow();
				window.open();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		/**
		 * Open the window.
		 */
		public void open() {
			Display display = Display.getDefault();
			createContents();
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		}
	
		/**
		 * Create contents of the window.
		 */
		protected void createContents() {
			shell = new Shell();
			shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
			shell.setSize(520, 500);
			shell.setText("AI Coach");
			shell.setLayout(null);
			

			Label lblBestMove = new Label(shell, SWT.NONE);
			lblBestMove.setBounds(10, 10, 266, 21);
			try{
				Socket skt = new Socket("localhost",1234);
				BufferedReader in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
				
				while(!in.ready()){}
				lblBestMove.setText("Best Move:" + in.readLine());
				in.close();
			}
			catch(Exception e){
				System.out.println("Error");
			}
			
			text = new Text(shell, SWT.BORDER);
			text.setEditable(true);
			text.setBounds(84, 7, 225, 19);
			
			Label lblExplanation = new Label(shell, SWT.NONE);
			lblExplanation.setBounds(10, 37, 83, 28);
			lblExplanation.setText("Explanation:");
			
			text_1 = new Text(shell, SWT.BORDER);
			text_1.setEditable(true);
			text_1.setBounds(84, 32, 225, 40);
			
			Label lblAltnerativeMove = new Label(shell, SWT.NONE);
			lblAltnerativeMove.setText("Best Move:");
			lblAltnerativeMove.setBounds(10, 98, 83, 21);
			
			Label label_1 = new Label(shell, SWT.NONE);
			label_1.setText("Explanation:");
			label_1.setBounds(10, 125, 83, 36);
			
			text_2 = new Text(shell, SWT.BORDER);
			text_2.setEditable(true);
			text_2.setBounds(84, 120, 225, 40);
			
			text_3 = new Text(shell, SWT.BORDER);
			text_3.setEditable(true);
			text_3.setBounds(84, 95, 225, 19);
			
			Label label_2 = new Label(shell, SWT.NONE);
			label_2.setText("Best Move:");
			label_2.setBounds(10, 192, 83, 21);
			
			Label label_3 = new Label(shell, SWT.NONE);
			label_3.setText("Explanation:");
			label_3.setBounds(10, 219, 83, 32);
			
			text_4 = new Text(shell, SWT.BORDER);
			text_4.setEditable(true);
			text_4.setBounds(84, 214, 225, 40);
			
			text_5 = new Text(shell, SWT.BORDER);
			text_5.setEditable(true);
			text_5.setBounds(84, 189, 225, 19);
			
			Label label_4 = new Label(shell, SWT.NONE);
			label_4.setText("Best Move:");
			label_4.setBounds(10, 288, 83, 21);
			
			Label label_5 = new Label(shell, SWT.NONE);
			label_5.setText("Explanation:");
			label_5.setBounds(10, 315, 83, 30);
			
			text_6 = new Text(shell, SWT.BORDER);
			text_6.setEditable(true);
			text_6.setBounds(84, 310, 225, 40);
			
			text_7 = new Text(shell, SWT.BORDER);
			text_7.setEditable(true);
			text_7.setBounds(84, 285, 225, 19);
			
			Label label_6 = new Label(shell, SWT.NONE);
			label_6.setText("Best Move:");
			label_6.setBounds(10, 394, 83, 21);
			
			Label label_7 = new Label(shell, SWT.NONE);
			label_7.setText("Explanation:");
			label_7.setBounds(10, 421, 83, 28);
			
			text_8 = new Text(shell, SWT.BORDER);
			text_8.setEditable(true);
			text_8.setBounds(84, 416, 225, 40);
			
			text_9 = new Text(shell, SWT.BORDER);
			text_9.setEditable(true);
			text_9.setBounds(84, 391, 225, 19);
			
			Label label_8 = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
			label_8.setForeground(SWTResourceManager.getColor(255, 204, 0));
			label_8.setBackground(SWTResourceManager.getColor(255, 204, 0));
			label_8.setBounds(315, 0, 2, 492);
			
			Label label_9 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
			label_9.setBounds(315, 132, 205, 2);
			
			Label lblHpDifference = new Label(shell, SWT.NONE);
			lblHpDifference.setBounds(325, 140, 94, 14);
			lblHpDifference.setText("HP difference");
			
			Label lblNewLabel = new Label(shell, SWT.NONE);
			lblNewLabel.setBounds(323, 160, 96, 14);
			lblNewLabel.setText("Card difference");
			
			Label lblSelfMinionCount = new Label(shell, SWT.NONE);
			lblSelfMinionCount.setBounds(323, 180, 117, 14);
			lblSelfMinionCount.setText("Self minion count");
			
			Label lblOppMinionCount = new Label(shell, SWT.NONE);
			lblOppMinionCount.setBounds(323, 199, 117, 14);
			lblOppMinionCount.setText("Opp minion count");
			
			Label lblMinionAtt = new Label(shell, SWT.NONE);
			lblMinionAtt.setBounds(323, 219, 88, 14);
			lblMinionAtt.setText("Minion Att");
			
			Label lblMinionHp = new Label(shell, SWT.NONE);
			lblMinionHp.setBounds(323, 240, 59, 14);
			lblMinionHp.setText("Minion HP");
			
			Label lblMinionTaunt = new Label(shell, SWT.NONE);
			lblMinionTaunt.setBounds(323, 260, 96, 14);
			lblMinionTaunt.setText("Minion Taunt");
			
			Label lblMinionWindfury = new Label(shell, SWT.NONE);
			lblMinionWindfury.setBounds(323, 280, 96, 21);
			lblMinionWindfury.setText("Minion Windfury");
			
			Label lblMinionDivineShield = new Label(shell, SWT.NONE);
			lblMinionDivineShield.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
			lblMinionDivineShield.setBounds(323, 300, 117, 14);
			lblMinionDivineShield.setText("Minion Divine shield");
			
			Label lblMinionSpellPower = new Label(shell, SWT.NONE);
			lblMinionSpellPower.setBounds(323, 320, 125, 14);
			lblMinionSpellPower.setText("Minion Spell Power");
			
			Label lblNewLabel_1 = new Label(shell, SWT.NONE);
			lblNewLabel_1.setBounds(323, 340, 136, 34);
			lblNewLabel_1.setText("Minion Untargetable\nBy Spells");
			
			Label lblMinionStealthed = new Label(shell, SWT.NONE);
			lblMinionStealthed.setBounds(323, 374, 136, 14);
			lblMinionStealthed.setText("Minion Stealthed");
			
			text_14 = new Text(shell, SWT.BORDER);
			text_14.setEditable(true);
			text_14.setBounds(446, 138, 64, 19);
			
			text_15 = new Text(shell, SWT.BORDER);
			text_15.setEditable(true);
			text_15.setBounds(446, 157, 64, 19);
			
			text_16 = new Text(shell, SWT.BORDER);
			text_16.setEditable(true);
			text_16.setBounds(446, 177, 64, 19);
			
			text_17 = new Text(shell, SWT.BORDER);
			text_17.setEditable(true);
			text_17.setBounds(446, 196, 64, 19);
			
			text_18 = new Text(shell, SWT.BORDER);
			text_18.setEditable(true);
			text_18.setBounds(446, 215, 64, 19);
			
			text_19 = new Text(shell, SWT.BORDER);
			text_19.setEditable(true);
			text_19.setBounds(446, 235, 64, 19);
			
			Button button = new Button(shell, SWT.CHECK);
			button.setBounds(446, 259, 22, 18);
			
			Button button_1 = new Button(shell, SWT.CHECK);
			button_1.setBounds(446, 279, 22, 18);
			
			Button button_2 = new Button(shell, SWT.CHECK);
			button_2.setBounds(446, 299, 22, 18);
			
			Button button_3 = new Button(shell, SWT.CHECK);
			button_3.setBounds(446, 370, 22, 18);
			
			Button button_4 = new Button(shell, SWT.CHECK);
			button_4.setBounds(446, 340, 22, 18);
			
			Button button_5 = new Button(shell, SWT.CHECK);
			button_5.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
				}
			});
			button_5.setBounds(446, 319, 22, 18);
			
			Label lblUserInputLog = new Label(shell, SWT.NONE);
			lblUserInputLog.setAlignment(SWT.CENTER);
			lblUserInputLog.setBounds(365, 10, 94, 23);
			lblUserInputLog.setText("User Input Log");
			
			text_10 = new Text(shell, SWT.BORDER);
			text_10.setEditable(true);
			text_10.setBounds(325, 32, 185, 19);
			
			text_11 = new Text(shell, SWT.BORDER);
			text_11.setEditable(true);
			text_11.setBounds(325, 57, 185, 19);
			
			text_12 = new Text(shell, SWT.BORDER);
			text_12.setEditable(true);
			text_12.setBounds(325, 82, 185, 19);
			
			text_13 = new Text(shell, SWT.BORDER);
			text_13.setEditable(true);
			text_13.setBounds(325, 107, 185, 19);
	
		}
	}

