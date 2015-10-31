package is.hgod.tictac;

import java.util.HashMap;
import java.util.ArrayList;

public class Engine{

	private static final int ROWS = 3;
    private static final int COLS = 3;

    private char[][] board = new char[ROWS][COLS];

    public void play(int row, int col, char symbol){
        if(!isOccupied(row, col)){
            board[row][col] = symbol;
        }
    }

    public boolean isOccupied(int row, int col){
        if(board[row][col] != 0){
            return true;
        }
        return false;
    }

    public void newGame(){
        board = new char[ROWS][COLS];
    }

    public boolean checkForWin(int row, int col){
        if(board[row][0] == board[row][1] && board[row][1] == board[row][2]){
            return true;
        }
        else if(board[0][col] == board[1][col] && board[1][col] == board[2][col]){
            return true;
        }
        else if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && isOccupied(2, 2) == true){
            return true;
        }
        else if(board[0][2] == board[1][1] && board[1][1] == board[2][0] && isOccupied(2, 0) == true){
            return true;
        }
        return false;
    }

}