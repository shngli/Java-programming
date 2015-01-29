//************************************************************************
// Author: Chisheng Li
// Class Name: TicTacToe.java
// 
// Description of the class: This class is a Tic-Tac-Toe game. The human player is
// X by default, and always starts the game first. The computer player is O by default. 
// The game prompts the human player by displaying the message "PLAYER X, YOUR TURN."
// The game ends when X wins, O wins, or the game is tied. 
//
// Supplementary files: TicTacToeComPl.java is needed to run the game.
//*************************************************************************

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class TicTacToe extends JFrame implements ActionListener {

	private JButton [][]buttons = new JButton[3][3];	//Create 3x3 JButtons
	private JLabel statusLabel = new JLabel("");
	private TicTacToeComPl game = null;				//Implements computer player in TicTacToeComPl.java	
	private int playerX = 0;						//Human player is X by default
	private int playerO = 0;						//Computer player is O by default
	private boolean win = false;
	private String []chars=new String[]{"","X","O"};

	private void setStatus(String message) {
		statusLabel.setText(message);
	}
	
	private void setButtonsEnabled(boolean enabled) {
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++) {
				buttons[i][j].setEnabled(enabled);
				if(enabled) buttons[i][j].setText(" ");
			}
	}

	public TicTacToe() {

		setTitle("Tic-Tac-Toe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,400);		//Default 400x400 panel size 
		setResizable(true);		//Allows the panel size to be adjusted
		setVisible(true);

		//Create a center panel and the font for the JButtons via Grid Layout.
		JPanel centerPanel = new JPanel(new GridLayout(3,3));	
		Font font = new Font("Times",Font.BOLD, 40);
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++) {
				buttons[i][j] = new JButton(" ");
				buttons[i][j].setFont(font);
				buttons[i][j].addActionListener(this);
				buttons[i][j].setFocusable(false);
				centerPanel.add(buttons[i][j]);
			}

		JPanel topPanel = new JPanel(); 	//Top panel displays message
		topPanel.add(statusLabel);
			
		game = new TicTacToeComPl();		//Click any button to start game
		playerX = TicTacToeComPl.one;
		playerO = TicTacToeComPl.two;
		setButtonsEnabled(true);
		setStatus("PLAYER X, YOUR TURN.");	//Prompts the human player to play
		win = true;
		
		add(topPanel,"North"); 
		add(centerPanel,"Center");
	}

	public static void main(String []args) {
		new TicTacToe().setVisible(true);
	}

	public void actionPerformed(ActionEvent event) {
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				if(event.getSource()==buttons[i][j]){
					click(i,j);
				}	
	}
	
	//Set Player O's turn.
	private void playerOTurn() {
		if(!win) return;
		int []pos = game.nextMove(playerO);

		if(pos!=null) {
			int i = pos[0];
			int j = pos[1];
			buttons[i][j].setText(chars[playerO]);
			game.setBoardValue(i,j,playerO);
		}
		checkWin();
	}

	private void gameOver(String message) {
		setStatus(message);
		setButtonsEnabled(false);
		win = false;
	}

	//Check if X wins, O wins, or the game is tied//
	private void checkWin() {
		if(game.isWin(playerX)) {
			gameOver("GAME OVER. X WINS.");
		} else if(game.isWin(playerO)) {
			gameOver("GAME OVER. O WINS.");
		} else if(game.nextMove(playerX)==null && game.nextMove(playerO)==null) {
			gameOver("TIE GAME.");
		}
	}

	//Check if the last move made by Player X wins. If there is an available move, it will be Player O's turn//
	private void click(int i,int j) {
		if(game.getBoardValue(i,j)==TicTacToeComPl.empty) {
			buttons[i][j].setText(chars[playerX]);
			game.setBoardValue(i,j,playerX);
			checkWin();
			playerOTurn();
		}
	}
}