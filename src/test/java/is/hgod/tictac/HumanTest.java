package is.hgod.tictac;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class HumanTest {

    public static void main(String args[]) {
        org.junit.runner.JUnitCore.main("is.hgod.late-term_assignment.PlayerTest");
    }

    Human h = new Human('X');

    @Test
    public void testNextPlay(){
        Pair play = h.nextPlay(4);
        assertEquals(true, play.equals(new Pair(1, 0)));
        play = h.nextPlay(9);
        assertEquals(true, play.equals(new Pair(0, 2)));
        play = h.nextPlay(1337);
        assertEquals(true, play.equals(new Pair(-1, -1)));
    }
}