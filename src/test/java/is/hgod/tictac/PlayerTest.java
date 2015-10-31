package is.hgod.tictac;

import static org.junit.Assert.assertEquals;
import static org.hamcrest.core.IsEqual.equalTo;
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
}