package is.hgod.tictac;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class EngineTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.hgod.late-term_assignment.EngineTest");
    }

    Engine testEngine = new Engine(1);

    @Test
    public void testPlay(){
        testEngine.play(1,1,'X');
        assertEquals(true, testEngine.isOccupied(1,1));
    }

    @Test
    public void testNewGame(){
    	testEngine.play(0,0,'O');
    	testEngine.newGame();
    	assertEquals(false, testEngine.isOccupied(0,0));
    }

    @Test
    public void testCheckForWinHorizontal(){
    	testEngine.newGame();
        testEngine.play(0,0,'X');
        testEngine.play(0,1,'X');
        testEngine.play(0,2,'X');
        assertEquals(true, testEngine.checkForWin(0,2));
    }

    @Test
    public void testCheckForWinVertical(){
    	testEngine.newGame();
    	testEngine.play(0,0,'O');
    	testEngine.play(1,0,'O');
    	testEngine.play(2,0,'O');
    	assertEquals(true, testEngine.checkForWin(2,0));
    }

    @Test
    public void testCheckForWinDiagonal(){
    	testEngine.newGame();
    	testEngine.play(0,0,'O');
    	testEngine.play(1,1,'O');
    	testEngine.play(2,2,'O');
    	assertEquals(true, testEngine.checkForWin(0,0));
    	testEngine.play(0,2,'O');
    	testEngine.play(1,1,'O');
    	testEngine.play(2,0,'O');
    	assertEquals(true, testEngine.checkForWin(0,2));
    }

    @Test
    public void testGameTie(){
    	testEngine.gameTie();
    	testEngine.gameTie();
    	testEngine.gameTie();
    	assertEquals(3, testEngine.getTies());
    }

    @Test
    public void testNextPlayer(){
        assertEquals(1, testEngine.nextPlayer()); 
    }

    @Test
    public void testGetBoard(){
        testEngine.newGame();
        testEngine.play(0,0,'X');
        testEngine.play(1,1,'X');
        testEngine.play(1,2,'X');
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
        testEngine.play(2, 2, 'X');
        testEngine.play(1, 1, 'X');
        testEngine.play(0, 0, 'O');
        testEngine.play(0, 1, 'O');
        testEngine.getPlay("9", 2);
        assertEquals(1, testEngine.getHumanWins(2));
        testEngine.humanWin(2);
        testEngine.humanWin(2);
        testEngine.humanWin(2);
        testEngine.humanWin(2);
        testEngine.humanWin(2);
        testEngine.humanWin(1);
        testEngine.humanWin(1);
        testEngine.humanWin(1);
        assertEquals(6, testEngine.getHumanWins(2));
        assertEquals(3, testEngine.getHumanWins(1));
    }

    @Test
    public void testGetComputerWins(){
        testEngine.newGame();
        assertEquals(0, testEngine.getComputerWins());
        testEngine = new Engine(1);
        testEngine.play(2, 2, 'X');
        testEngine.play(1, 1, 'X');
        testEngine.play(0, 0, 'O');
        testEngine.play(0, 1, 'O');
        testEngine.getPlay("", 3);
        assertEquals(1, testEngine.getComputerWins());
        testEngine.newGame();
        testEngine.play(2, 2, 'X');
        testEngine.play(1, 1, 'X');
        testEngine.play(0, 0, 'O');
        testEngine.play(0, 1, 'O');
        testEngine.getPlay("", 3);
        assertEquals(2, testEngine.getComputerWins());
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

