package is.hgod.tictac;

import static org.junit.Assert.assertEquals;
import static org.hamcrest.core.IsEqual.equalTo;
import org.junit.Test;

public class EngineTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.hgod.late-term_assignment.EngineTest");
    }

    @Test
    public void testPlay(){
        Engine.play(1,1,'X');
        assertEquals(true, Engine.isOccupied(1,1));
    }

    @Test
    public void testNewGame(){
    	Engine.play(0,0,'O');
    	Engine.newGame();
    	assertEquals(false, Engine.isOccupied(0,0));
    }

    @Test
    public void testCheckForWinHorizontal(){
    	Engine.newGame();
        Engine.play(0,0,'X');
        Engine.play(0,1,'X');
        Engine.play(0,2,'X');
        assertEquals(true, Engine.checkForWin(0,2));
    }
}