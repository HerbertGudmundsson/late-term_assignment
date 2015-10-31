package is.hgod.tictac;

public class Human extends Player{

	Human(char symbol){
		super(symbol);
		this.setIAm('h');
	}

	public Pair nextPlay(int input){
		switch(input){
			case 1: return new Pair(0, 0);
			case 2: return new Pair(0, 1);
			case 3: return new Pair(0, 2);
			case 4: return new Pair(1, 0);
			case 5: return new Pair(1, 1);
			case 6: return new Pair(1, 2);
			case 7: return new Pair(2, 0);
			case 8: return new Pair(2, 1);
			case 9: return new Pair(2, 2);
			default: return new Pair(-1, -1);
		}
	}
}