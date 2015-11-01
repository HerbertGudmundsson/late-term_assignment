package is.hgod.tictac;

public class Engine{

    private static final int ROWS = 3; //POSSIBLY NOT STATIC ?
    private static final int COLS = 3;

    private int humanWins = 0, computerWins = 0, ties = 0, totalGames = 0;
    private int previousPlayer = 2;
    private int turns = 0;
    private char[][] board;

    private Human player1, player2;
    private Computer player3;

    Engine(int gameMode){
        newGame();
        if(gameMode == 1){
            player1 = new Human('X');
            player3 = new Computer('O');
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
        else if(previousPlayer == 1 && player2 != null && player2.getIAm() == 'h'){
            return 2;
        }
        return 3;
    }

    public int humanPlay(String input, int player){
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
        if(player == 1){
            return play(play.getRow(), play.getCol(), player1.getSymbol());
        }
        else if(player == 2){
            return play(play.getRow(), play.getCol(), player2.getSymbol());
        }
        return -2;
    }

    public int computerPlay(){
        Pair play = player3.nextPlay(board);
        return play(play.getRow(), play.getCol(), player3.getSymbol());
    }

    public int play(int row, int col, char symbol){
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

    public boolean isOccupied(int row, int col){
        if(board[row][col] != 0){
            return true;
        }
        return false;
    }

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

    public boolean checkForWin(int row, int col){
        if(board[row][0] == board[row][1] && board[row][1] == board[row][2]){
            return true;
        }
        else if(board[0][col] == board[1][col] && board[1][col] == board[2][col]){
            return true;
        }
        else if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && isOccupied(2, 2) ){
            return true;
        }
        else if(board[0][2] == board[1][1] && board[1][1] == board[2][0] && isOccupied(2, 0)){
            return true;
        }
        return false;
    }

    public void gameTie(){
        ties++;
        totalGames++;
    }

    public int getTies(){
        return ties;
    }

    public int getHumanWins(){
        return humanWins;
    }

    public int getComputerWins(){
        return computerWins;
    }

    public char[][] getBoard(){
        return board;
    }

    public int getTurn(){
        return turns;
    }
}