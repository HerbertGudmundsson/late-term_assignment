package is.hgod.tictac;

public class Pair{
	
	Pair(int row, int col){
		this.row = row;
		this.col = col;
	}
	
	private int row;
	private int col;
	
	public int getRow(){
		return row;
	}

	public int getCol(){
		return col;
	}
}