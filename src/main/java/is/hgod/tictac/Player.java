package is.hgod.tictac;

public class Player{
	private char symbol;

	Player(char symbol){
		this.symbol = symbol;
	}
		
	public char getSymbol(){
		return symbol;
	}

	public Pair nextPlay(){
		return new Pair(0,1);
	}
}