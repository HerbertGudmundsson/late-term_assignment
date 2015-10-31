package is.hgod.tictac;

import java.util.Random;

public class Computer extends Player{

	Computer(char symbol){
		super(symbol);
	}
	

	public Pair checkBoard(char[][] board){
		if(isEmpty(board)){
			Random rand = new Random();
			return new Pair(rand.nextInt(board[0].length), rand.nextInt(board[0].length));
		}
		Pair play = checkOpponentWin(board);
		if(play.getCol() != -1){
			return play;
		}
		return new Pair(0, 0);
	}

	public boolean isEmpty(char[][] board){
		int count = 0;
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				if(board[i][j] != 0){
					count++;
				}
			}
		}
		if(count == 0){
			return true;
		}
		return false;
	}

	public Pair nextPlay(char[][] board){
		Pair play = checkBoard(board);
		return play;
	}

	public Pair checkOpponentWin(char [][] board){
		for(int i = 0; i < board.length; i++){
			int col = checkRow(board[i]);
			if(col != -1){
				return new Pair(i, col);
			}
		}
		//TODO: Check columns and diagonal lines
		return new Pair(0, 0); 
	}

	public int checkRow(char[] row){
		int count = 0, col = -1;
		for(int i = 0; i < row.length; i++){
			if(row[i] != getSymbol() && row[i] != 0){
				count++;
			}
			else if(row[i] == 0){
				 col = i;
			}
		}
		if(count == 2){
			return col;
		}
		return -1;
	}

}