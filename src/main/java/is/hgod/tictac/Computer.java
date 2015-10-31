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

}