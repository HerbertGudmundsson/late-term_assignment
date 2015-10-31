package is.hgod.tictac;

import java.util.HashMap;
import java.util.ArrayList;

public class Engine{

	private static final int ROWS = 3; //POSSIBLY NOT STATIC ?
    private static final int COLS = 3;

    private int humanWins = 0, computerWins = 0, ties = 0, totalGames = 0;
    private int previousPlayer = 2;
    private int turns = 0;
    private char[][] board = new char[ROWS][COLS];

    private Player player1, player2;

    Engine(int gameMode){
        if(gameMode == 1){
            player1 = new Human('X');
            player2 = new Computer('O');
        }
        else if(gameMode == 2){
            player1 = new Human('X');
            player2 = new Human('O');
        }
    }

    public int nextPlayer(){
        if(previousPlayer == 2 && player1.getIAm() == 'h'){
            return 1;
        }
        else if(previousPlayer == 1 && player2.getIAm() == 'h'){
            return 2;
        }
        return 3;
    }

    public void play(int row, int col, char symbol){
        if(!isOccupied(row, col)){
            board[row][col] = symbol;
            turns++;
            if(turns > 4 && checkForWin(row, col)){
                //TODO: declare winner
            }
            if(turns == 9){
                gameTie();
            }
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
        if(totalGames % 2 == 0){
            previousPlayer = 2;
        }
        else{
            previousPlayer = 1;
        }
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

    public void gameTie(){
        newGame();
        ties++;
        totalGames++;
    }

    public int getTies(){
        return ties;
    }

    public int gethumanWins(){
        return humanWins;
    }

    public int getComputerWins(){
        return computerWins;
    }

}