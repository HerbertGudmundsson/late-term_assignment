package is.hgod.tictac;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PlayerTest {

	public static void main(String args[]) {
        org.junit.runner.JUnitCore.main("is.hgod.late-term_assignment.PlayerTest");
    }

    Player p = new Player('X');

    @Test
    public void testConstructor(){
        assertEquals('X', p.getSymbol());
    }
    
    @Test
    public void testPairClass(){
        Pair pair = new Pair(1,2);
        assertEquals(1, pair.getRow());
        assertEquals(2, pair.getCol());
    }
}