package is.hgod.tictac;

import static org.junit.Assert.assertEquals;
import static org.hamcrest.core.IsEqual.equalTo;
import org.junit.Test;

public class EngineTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.hgod.late-term_assignment.EngineTest");
    }

    Engine testEngine = new Engine();

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
}