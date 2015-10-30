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
    

}