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
		//TODO: Decide what to do if opponent cannot win next turn
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
		char[] column = new char[3];
		for(int i = 0; i < board.length; i++){ //column
			for(int j = 0; j < board.length; j++){ //row
				column[j] = board[j][i];
				if(j == 2){
					int row = checkCol(column);
					if(row != -1){
						return new Pair(row, i);
					}
				}
			}
		}
		return checkDiagonal(board); 
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

	public int checkCol(char[] col){
		int count = 0, row = -1;
		for(int i = 0; i < col.length; i++){
			if(col[i] != getSymbol() && col[i] != 0){
				count++;
			}
			else if(col[i] == 0){
				 row = i;
			}
		}
		if(count == 2){
			return row;
		}
		return -1;
	}

	public Pair checkDiagonal(char[][] board){
		int count = 0, count2 = 0;
		Pair result = new Pair(0, 0) , result2 = new Pair(0, 0);
		for(int i = 0; i < board.length; i++){
			if(board[i][i] != getSymbol() && board[i][i] != 0){
				count++;
			}
			else if(board[i][i] == 0){
				result = new Pair(i, i);
			}
			if(board[i][board.length - i - 1] != getSymbol() && board[i][board.length - i - 1] != 0){
                count2++;
            }
            else if(board[i][board.length - i - 1] == 0){
                result2 = new Pair(i, board.length - i - 1);
            }
		}
		if(count == 2){
			return result;
		}
		else if(count2 == 2){
			return result2;
		}
		return new Pair(-1, -1);
	}

}