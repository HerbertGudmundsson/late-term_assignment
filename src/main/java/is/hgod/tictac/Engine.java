package is.hgod.tictac;

/**
 * @author Jón Böðvarsson <jonbod12@ru.is>
 * @version 0.1
 * @since 2015-10-30
 */
public class Engine{

    /**
    * Holds how many rows the game board has
    */
    private final int ROWS = 3;
    /**
    * Holds how many columns the game board has
    */
    private final int COLS = 3;

    /**
    * Holds how many games the computer player has won
    */
    private int computerWins = 0;
    /**
    * Holds how many games the human players have won
    */
    private int[] humanWins = {0, 0};
    /**
    * Holds how many games have ended in a draw
    */
    private int ties = 0;
    /**
    * Holds how many games have been played
    */
    private int totalGames = 0;
    /**
    * Holds the gamemode type
    */
    private int gameMode = 0;
    /**
    * Holds the value of the player that made the most recent play
    */
    private int previousPlayer = 2;
    /**
    * Holds the number of turns for this game
    */
    private int turns = 0;
    /**
    * The game board, and values for all game board sqares
    */
    private char[][] board;
    /**
    * Human players, only player one is used if the gamemode is player vs. computer
    */
    private Human player1, player2;
    /**
    * Computer player, only used for the gamemode player vs. computer
    */
    private Computer player3;

    /**
    * Sole constructor, sets the gamemode and creates the players.
    *
    * @param gameMode The gamemode type, used to set the game's mode
    */
    Engine(int gameMode){
        newGame();
        this.gameMode = gameMode;
        if(gameMode == 1){
            player1 = new Human('X');
            player3 = new Computer('O');
        }
        else if(gameMode == 2){
            player1 = new Human('X');
            player2 = new Human('O');
        }
    }
    /**
    * Determines which player has the next move
    *
    * @return The value of the player that has the next move
    */
    public int nextPlayer(){
        if(previousPlayer == 2 && player1.getIAm() == 'h'){
            return 1;
        }
        else if(previousPlayer == 1 && player2 != null && player2.getIAm() == 'h'){
            return 2;
        }
        return 3;
    }
    /**
    * Gets the next move for the next playe and determines if that move is a winning move or not.
    *
    * @return A value that says if the move was a winning move or not.
    */
    public int getPlay(String input, int player){
        if(input.equals("")){
            return computerPlay();
        }
        if(input.length() > 1 || input.charAt(0) < 49 || input.charAt(0) > 57){
            return -2;
        }
        int inp = Integer.parseInt(input);
        Pair play = player1.nextPlay(inp);
        if(play.equals(new Pair(-1, -1))){
            return -2;
        }
        if(isOccupied(play.getRow(), play.getCol())){
            return -3;
        }
        int result;
        if(player == 1){
            result = play(play.getRow(), play.getCol(), player1.getSymbol());
            if(result == 1){
                humanWin(player);
            }
            return result;
        }
        else if(player == 2){
            result = play(play.getRow(), play.getCol(), player2.getSymbol());
            if(result == 1){
                humanWin(player);
            }
            return result;
        }
        return -2;
    }
    /**
    * Gets the next move for the computer player.
    *
    * @return A value that says if the move was a winning move or not.
    */
    public int computerPlay(){
        Pair play = player3.nextPlay(board);
        int result = play(play.getRow(), play.getCol(), player3.getSymbol());
        if(result == 1){
            computerWin();
        }
        return result;
    }

    private int play(int row, int col, char symbol){
        if(!isOccupied(row, col)){
            board[row][col] = symbol;
            turns++;
            if(turns > 4 && checkForWin(row, col)){
                if(symbol == 'X'){

                }
                return 1;
            }
            if(turns == 9){
                gameTie();
                return 2;
            }
        }
        if(previousPlayer == 2){
            previousPlayer = 1;
        }
        else if(previousPlayer == 1){
            previousPlayer = 2;
        }
        return -1;
    }

    private boolean isOccupied(int row, int col){
        if(board[row][col] != 0){
            return true;
        }
        return false;
    }
    /**
    * Resets the game board and turn counter, and determines which player is to start the next game.
    */
    public void newGame(){
        board = new char[ROWS][COLS];
        turns = 0;
        if(totalGames % 2 == 0){
            previousPlayer = 2;
        }
        else{
            previousPlayer = 1;
        }
    }

    private boolean checkForWin(int row, int col){
        if(board[row][0] == board[row][1] && board[row][1] == board[row][2] && board[row][2] != 0){
            return true;
        }
        else if(board[0][col] == board[1][col] && board[1][col] == board[2][col] && board[2][col] != 0){
            return true;
        }
        else if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && isOccupied(2, 2) && board[2][2] != 0){
            return true;
        }
        else if(board[0][2] == board[1][1] && board[1][1] == board[2][0] && isOccupied(2, 0) && board[2][0] != 0){
            return true;
        }
        return false;
    }

    private void gameTie(){
        ties++;
        totalGames++;
    }

    private void computerWin(){
        computerWins++;
        totalGames++;
    }

    private void humanWin(int player){
        humanWins[player - 1]++;
        totalGames++;
    }
    /**
    * Returns the number of tied games.
    *
    * @return The number of tied games.
    */
    public int getTies(){
        return ties;
    }
    /**
    * Returns the number of games won by a human player.
    *
    * @param player The number of the player for whom to fetch the number of wins.
    * @return The number of human wins for either human player, as determined by the input parameter.
    */
    public int getHumanWins(int player){
        return humanWins[player - 1];
    }
    /**
    * Returns the number of games won by the computer player.
    *
    * @return The number of games won by the computer player.
    */
    public int getComputerWins(){
        return computerWins;
    }
    /**
    * Returns the game board.
    *
    * @return The games board.
    */
    public char[][] getBoard(){
        return board;
    }
    /**
    * Returns the number of turns played for this game.
    *
    * @return The number of turns played for this game.
    */
    public int getTurn(){
        return turns;
    }
    /**
    * Returns the game mode of this game.
    *
    * @return The game mode of this game.
    */
    public int getGameMode(){
        return gameMode;
    }

    public boolean isWon(){
        boolean result = false;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(checkForWin(i, j)){
                    result = true;
                }
            }
        }
        return result;
    }
}

