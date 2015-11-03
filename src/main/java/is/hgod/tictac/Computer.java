package is.hgod.tictac;

import java.util.Random;

/**
 * @author Jón Böðvarsson <jonbod12@ru.is>
 * @version 0.1
 * @since 2015-10-30
 */
public class Computer extends Player{

    /**
    * Sole constructor
    *
    * @param symbol The symbol that this player uses in the game.
    */
    Computer(char symbol){
        super(symbol);
        this.setIAm('c');
        if(symbol == 'X'){
            opponentSymbol = 'O';
        }
        else{
            opponentSymbol = 'X';
        }
    }
    /**
    * Holds the symbol of the opponent player
    */
    private char opponentSymbol;

    /**
    * Returns the value of the game board square to be played.
    *
    * @param board The game board with all of the game board sqare values.
    * @return The value of the game board square to be played.
    */
    public Pair nextPlay(char[][] board){
        Random rand = new Random();
        if(isEmpty(board)){
            return new Pair(rand.nextInt(board[0].length), rand.nextInt(board[0].length));
        }
        Pair play = checkForWin(board, getSymbol());
        if(play.getCol() != -1 && play.getRow() != -1){
            return play;
        }
        play = checkForWin(board, opponentSymbol);
        if(play.getCol() != -1 && play.getRow() != -1){
            return play;
        }
        while(true){
            play = new Pair(rand.nextInt(board[0].length), rand.nextInt(board[0].length));
            if(!isOccupied(play.getRow(), play.getCol(), board)){
                return play;
            }
        }
    }

    private boolean isEmpty(char[][] board){
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

    private Pair checkForWin(char [][] board, char symbol){
        for(int i = 0; i < board.length; i++){
            int col = checkLine(board[i], symbol);
            if(col != -1){
                return new Pair(i, col);
            }
        }
        char[] column = new char[3];
        for(int i = 0; i < board.length; i++){ //column
            for(int j = 0; j < board.length; j++){ //row
                column[j] = board[j][i];
                if(j == 2){
                    int row = checkLine(column, symbol);
                    if(row != -1){
                        return new Pair(row, i);
                    }
                }
            }
        }
        return checkDiagonal(board, symbol);
    }

    private int checkLine(char[] line, char symbol){
        int count = 0, result = -1;
        for(int i = 0; i < line.length; i++){
            if(line[i] == symbol){
                count++;
            }
            else if(line[i] == 0){
                result = i;
            }
        }
        if(count == 2){
            return result;
        }
        return -1;
    }

    private Pair checkDiagonal(char[][] board, char symbol){
        char[] line = new char[3];
        for(int i = 0; i < 3; i++){
            line[i] = board[i][i];
        }
        int result = checkLine(line, symbol);
        if(result != -1){
            return new Pair(result, result);
        }
        line = new char[3];
        for(int i = 0; i < 3; i++){
            line[i] = board[i][2-i];
        }
        result = checkLine(line, symbol);
        if(result != -1){
            return new Pair(result, 2 - result);
        }
        return new Pair(-1, -1);
    }

    private boolean isOccupied(int row, int col, char[][] board){
        if(board[row][col] != 0){
            return true;
        }
        return false;
    }
}
