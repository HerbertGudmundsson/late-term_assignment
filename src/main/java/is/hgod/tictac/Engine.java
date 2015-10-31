package is.hgod.tictac;

import java.util.HashMap;
import java.util.ArrayList;

public class Engine{

	private static final int ROWS = 3;
    private static final int COLS = 3;

    private static char[][] board = new char[ROWS][COLS];

    public static void play(int row, int col, char symbol){
        if(!isOccupied(row, col)){
            board[row][col] = symbol;
        }
    }

    public static boolean isOccupied(int row, int col){
        if(board[row][col] != 0){
            return true;
        }
        return false;
    }

    public static void newGame(){
        board = new char[ROWS][COLS];
    }

}