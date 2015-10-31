package is.hgod.tictac;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TicTacTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.hgod.late-term_assignment.TicTacTest");
    }

    @Test
    public void return3(){
    	assertEquals(3, TicTac.return3());
    }

    @Test
    public void return2(){
    	assertEquals(2, TicTac.return2());
    }

    @Test
    public void return1(){
    	assertEquals(1, TicTac.return1());
    }
}