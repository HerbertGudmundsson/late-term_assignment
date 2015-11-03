package is.hgod.tictac;

/**
 * @author Jón Böðvarsson jonbod12@ru.is
 * @version 0.1
 * @since 2015-10-30
 */
public class Player{
	private char symbol;
	private char iAm;

    /**
     * Sole constructor, sets the players symbol and the player type to p for player.
     *
     * @param symbol The symbol that this player uses in the game.
     */
	Player(char symbol){
		this.symbol = symbol;
		iAm = 'p';
	}
	
    /**
     * Returns the symbol of this player.
     * 
     * @return The symbol of this player.
     */	
	public char getSymbol(){
		return symbol;
	}

    /**
     * Sets the type of this player.
     * 
     * @param iAm An input to set the type of this player.
     */	
	public void setIAm(char iAm){
		this.iAm = iAm;
	}

    /**
     * Returns the type of this player.
     * 
     * @return The type of this player.
     */	
	public char getIAm(){
		return iAm;
	}
}