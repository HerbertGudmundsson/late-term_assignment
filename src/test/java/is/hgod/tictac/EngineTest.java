package is.hgod.tictac;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class EngineTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.hgod.late-term_assignment.EngineTest");
    }

    Engine testEngine = new Engine(1);

    @Test
    public void testNewGame(){
    	testEngine.getPlay("7", 1);
    	testEngine.newGame();
    	assertEquals(0, testEngine.getBoard()[0][0]);
    }

    @Test
    public void testCheckForWinHorizontal(){
    	testEngine.newGame();
        testEngine.getPlay("3", 1);
        testEngine.getPlay("2", 1);
        testEngine.getPlay("7", 1);
        testEngine.getPlay("8", 1);
        assertEquals(1, testEngine.getPlay("9", 1));
    }

    @Test
    public void testCheckForWinVertical(){
    	testEngine.newGame();
        testEngine.getPlay("9", 1);
        testEngine.getPlay("8", 1);
        testEngine.getPlay("7", 1);
        testEngine.getPlay("4", 1);
        assertEquals(1, testEngine.getPlay("1", 1));
    }

    @Test
    public void testCheckForWinDiagonal(){
    	testEngine.newGame();
        testEngine.getPlay("9", 1);
        testEngine.getPlay("8", 1);
        testEngine.getPlay("7", 1);
        testEngine.getPlay("5", 1);
        assertEquals(1, testEngine.getPlay("3", 1));
        testEngine.newGame();
        testEngine.getPlay("7", 1);
        testEngine.getPlay("8", 1);
        testEngine.getPlay("9", 1);
        testEngine.getPlay("5", 1);
        assertEquals(1, testEngine.getPlay("1", 1));
    }

    @Test
    public void testGameTie(){
        Engine testEngine2 = new Engine(2);
        testEngine2.newGame();
        testEngine2.getPlay("7", 1);
        testEngine2.getPlay("8", 2);
        testEngine2.getPlay("9", 1);
        testEngine2.getPlay("4", 2);
        testEngine2.getPlay("5", 1);
        testEngine2.getPlay("6", 2);
        testEngine2.getPlay("3", 2);
        testEngine2.getPlay("2", 1);
        testEngine2.getPlay("1", 2);
    	assertEquals(1, testEngine2.getTies());
    }

    @Test
    public void testNextPlayer(){
        assertEquals(1, testEngine.nextPlayer()); 
    }

    @Test
    public void testGetBoard(){
        testEngine.newGame();
        testEngine.getPlay("7", 1);
        testEngine.getPlay("5", 1);
        testEngine.getPlay("6", 1);
        char[][] testBoard = new char[3][3];
        char[][] gameBoard = testEngine.getBoard();
        testBoard[0][0] = 'X';
        testBoard[1][1] = 'X';
        testBoard[1][2] = 'X';
        boolean isTrue = false;
        if(testBoard[0][0] == gameBoard[0][0] && testBoard[1][1] == gameBoard[1][1] && testBoard[1][2] == gameBoard[1][2]){
            isTrue = true;
        }
        assertEquals(true,  isTrue);
    }

    @Test
    public void testGetPlay(){
        testEngine.newGame();
        testEngine.getPlay("5", 1);
        testEngine.getPlay("1", 1);
        char[][] gameBoard = testEngine.getBoard();
        assertEquals('X', gameBoard[1][1]);
        assertEquals('X', gameBoard[2][0]);
        Engine testEngine2 = new Engine(2);
        testEngine2.getPlay("5", 1);
        gameBoard = testEngine2.getBoard();
        assertEquals('X', gameBoard[1][1]);
        assertEquals(-1, testEngine.getPlay("", 3));
        assertEquals(-2, testEngine2.getPlay("1337", 1));
        assertEquals(-3, testEngine2.getPlay("5", 1));
    }

    @Test
    public void testGetTies(){
        testEngine.newGame();
        assertEquals(0, testEngine.getTies());
    }

    @Test
    public void testGetHumanWins(){
        testEngine = new Engine(1);
        assertEquals(0, testEngine.getHumanWins(1));
        testEngine = new Engine(2);
        testEngine.getPlay("3", 1);
        testEngine.getPlay("5", 1);
        testEngine.getPlay("7", 2);
        testEngine.getPlay("8", 2);
        testEngine.getPlay("9", 2);
        assertEquals(1, testEngine.getHumanWins(2));
        testEngine.newGame();
        testEngine.getPlay("3", 1);
        testEngine.getPlay("5", 1);
        testEngine.getPlay("7", 2);
        testEngine.getPlay("8", 2);
        testEngine.getPlay("9", 2);
        assertEquals(2, testEngine.getHumanWins(2));
    }

    @Test
    public void testGetComputerWins(){
        testEngine.newGame();
        assertEquals(0, testEngine.getComputerWins());
        testEngine = new Engine(1);
        testEngine.newGame();
        testEngine.getPlay("", 3);
        testEngine.getPlay("", 3);
        testEngine.getPlay("", 3);
        testEngine.getPlay("", 3);
        testEngine.getPlay("", 3);
        assertEquals(1, testEngine.getComputerWins());
    }

    @Test
    public void testGetTurn(){
        testEngine.newGame();
        assertEquals(0, testEngine.getTurn());
        testEngine.getPlay("5", 1);
        assertEquals(1, testEngine.getTurn());
    }

    @Test 
    public void testGetGameMode(){
        testEngine = new Engine(1);
        assertEquals(1, testEngine.getGameMode());
        testEngine = new Engine(2);
        assertEquals(2, testEngine.getGameMode());
    }
}

