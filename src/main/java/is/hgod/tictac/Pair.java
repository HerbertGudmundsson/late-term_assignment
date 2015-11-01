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

	public boolean equals(Pair p){
		if(p.getRow() == this.getRow() && p.getCol() == this.getCol()){
			return true;
	}
		return false;
	}
}