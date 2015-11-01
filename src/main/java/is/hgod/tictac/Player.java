package is.hgod.tictac;

public class Player{
	private char symbol;
	private char iAm;

	Player(char symbol){
		this.symbol = symbol;
		iAm = 'p';
	}
		
	public char getSymbol(){
		return symbol;
	}

	public void setIAm(char iAm){
		this.iAm = iAm;
	}

	public char getIAm(){
		return iAm;
	}

	public Pair nextPlay(){
		return new Pair(0,1);
	}
}