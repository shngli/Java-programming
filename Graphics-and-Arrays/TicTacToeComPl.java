//************************************************************************
// Class Name: TicTacToeComPl.java
// 
// Author: Chisheng Li
// 
// Description of the class: This class is a supplementary class to TicTacToe.java. 
// The human player is player one (X), and the computer is player two (O). 
// The computer selects an available move after the human player, but does not always
// win ie. the computer is not a smart player. The class determines if the last move
// wins the game, but does not differentiate vertical/horizontal/diagonal win.
//
// Supplementary files: TicTacToe.java is needed to run the game.
//*************************************************************************


public class TicTacToeComPl {

	private int board[][];				
	public static final int empty = 0;	
	public static final int one = 1;	//Player one = human X player
	public static final int two = 2;	//Player two = computer O player

	public TicTacToeComPl() {
		board = new int[3][3];
	}

	//Get position (i,j) board value//
	public int getBoardValue(int i,int j) {
		if(i < 0 || i >= 3) return empty;
		if(j < 0 || j >= 3) return empty;
		return board[i][j];
	}

	//Set board value for position (i,j) // 
	public void setBoardValue(int i,int j,int XOpiece) {
		if(i < 0 || i >= 3) return;
		if(j < 0 || j >= 3) return;
		board[i][j] = XOpiece;	//XOpiece is the X or O piece
    }

	public int inverse(int XOpiece) {
		return XOpiece==one ? two : one;
	}

	//Computer selects the next available move, but does not always win//
	public int []nextMove(int XOpiece) {
	
		if(getBoardValue(1, 1)==empty) return new int[]{1,1};
	
		for(int i=0;i<3;i++)				
			for(int j=0;j<3;j++)
				if(getBoardValue(i, j)==empty) {
					board[i][j] = XOpiece;	
					board[i][j] = empty;
				}
		
			for(int i=0;i<3;i++) 
				for(int j=0;j<3;j++)
					if(getBoardValue(i, j)==empty)
						return new int[]{i,j};
	
			return null;	//If there is no available move
	}

	//Determines if the last move wins the game, regardless horizontal/vertical/diagonal win//
	public boolean isWin(int XOpiece) {
		final int DI[]={-1,0,1,1};
		final int DJ[]={1,1,1,0};
		for(int i=0;i<3;i++)
		for(int j=0;j<3;j++) {
			if(getBoardValue(i, j) != XOpiece) continue;
			
			for(int k=0;k<4;k++) {
				int ctr = 0;
					while(getBoardValue(i+DI[k]*ctr, j+DJ[k]*ctr)==XOpiece) ctr++;
					if(ctr==3) return true;
				}
		}
		return false;
	}
} 
