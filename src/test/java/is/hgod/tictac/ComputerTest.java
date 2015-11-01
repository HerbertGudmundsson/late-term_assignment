package is.hgod.tictac;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ComputerTest {

	public static void main(String args[]) {
        org.junit.runner.JUnitCore.main("is.hgod.late-term_assignment.PlayerTest");
    }

    Computer c = new Computer('O');

    @Test
    public void testNextPlayForEmptyBoard(){
        Pair[] possibilities = new Pair[9];
        int count = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                possibilities[count] = new Pair(i, j);
                count++;
            }
        }
        boolean contains = false;
        char[][] board = new char[3][3];
        Pair play = c.nextPlay(board);
        for(Pair p : possibilities){
            if(p.equals(play)){
                contains = true;
            }
        }
        assertEquals(true, contains);
    }

    @Test
    public void testCheckOpponentWinHorizontal(){
        char[][] board = new char[3][3];
        board[0][0] = 'X';
        board[0][1] = 'X';
        Pair play = c.nextPlay(board);
        assertEquals(true, play.equals(new Pair(0, 2)));
        board = new char[3][3];
        board[2][1] = 'X';
        board[2][2] = 'X';
        play = c.nextPlay(board);
        assertEquals(true, play.equals(new Pair(2, 0)));
    }

    @Test
    public void testCheckOpponentWinVertical(){
        char[][] board = new char[3][3];
        board[0][0] = 'X';
        board[1][0] = 'X';
        Pair play = c.nextPlay(board);
        assertEquals(true, play.equals(new Pair(2, 0)));
        board = new char[3][3];
        board[0][2] = 'X';
        board[1][2] = 'X';
        play = c.nextPlay(board);
        assertEquals(true, play.equals(new Pair(2, 2)));
    }

    @Test
    public void testCheckOpponentWinDiagonal(){
        char[][] board = new char[3][3];
        board[0][0] = 'X';
        board[1][1] = 'X';
        Pair play = c.nextPlay(board);
        assertEquals(true, play.equals(new Pair(2, 2)));
        board = new char[3][3];
        board[2][2] = 'X';
        board[0][0] = 'X';
        play = c.nextPlay(board);
        assertEquals(true, play.equals(new Pair(1, 1)));
    }

    @Test
    public void testCheckForWin(){
        char[][] board = new char[3][3];
        board[0][0] = 'O';
        board[1][1] = 'O';
        Pair play = c.nextPlay(board);
        assertEquals(true, play.equals(new Pair(2, 2)));
        board = new char[3][3];
        board[0][2] = 'O';
        board[1][2] = 'O';
        play = c.nextPlay(board);
        assertEquals(true, play.equals(new Pair(2, 2)));
        board = new char[3][3];
        board[2][1] = 'O';
        board[2][2] = 'O';
        play = c.nextPlay(board);
        assertEquals(true, play.equals(new Pair(2, 0)));
    }

    @Test
    public void testNextPlayLastResort(){
        boolean contains = false;
        char[][] board = new char[3][3];
        board[0][0] = 'X';
        Pair play = c.nextPlay(board);
        if((play.getRow() > -1 && play.getRow() < 3) && (play.getCol() > -1 && play.getCol() < 3)){
            contains = true;
        }
        assertEquals(true, contains);
        board = new char[3][3];
        board[0][0] = 'X';
        board[0][1] = 'X';
        board[0][2] = 'X';
        board[1][0] = 'O';
        board[1][2] = 'O';
        board[2][0] = 'X';
        board[2][1] = 'O';
        board[2][2] = 'X';
        play = c.nextPlay(board);
        assertEquals(true, play.equals(new Pair(1, 1)));
    }
}