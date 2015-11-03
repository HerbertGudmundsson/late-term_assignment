package is.hgod.tictac;

/**
 * @author Jón Böðvarsson jonbod12@ru.is
 * @version 0.1
 * @since 2015-10-30
 */
public class Human extends Player{

    /**
    * Sole constructor, sets the players symbol and the type of player to h for human.
    *
    * @param symbol The symbol that this player uses in the game.
    */
    Human(char symbol){
        super(symbol);
        this.setIAm('h');
    }
    /**
    * Takes an input from the UI and returns the value of the game board square to be played.
    * 
    * @param input The user input from the UI.
    * @return The value of the game boards square to be played.
    */
    public Pair nextPlay(int input){
        switch(input){
            case 1: return new Pair(2, 0);
            case 2: return new Pair(2, 1);
            case 3: return new Pair(2, 2);
            case 4: return new Pair(1, 0);
            case 5: return new Pair(1, 1);
            case 6: return new Pair(1, 2);
            case 7: return new Pair(0, 0);
            case 8: return new Pair(0, 1);
            case 9: return new Pair(0, 2);
            default: return new Pair(-1, -1);
        }
    }
}
