package is.hgod.tictac;

/**
 * @author Hermann Ingi Ragnarsson hermannr14@ru.is
 * @version 0.1
 * @since 2015-10-30
 */
public class Pair{
	
	/**
    * Sole constructor, sets the pairs row and col values.
    *
    * @param row The row number of the pair corresponding to a 2-d plane.
    * @param col The column number of the pair corresponding to a 2-d plane
    */
	Pair(int row, int col){
		this.row = row;
		this.col = col;
	}
	
	/**
    * Holds the value of the row of this pair.
    */
	private int row;
	/**
    * Holds the value of the column of this pair.
    */
	private int col;
	
	/**
    * Returns the row value of this pair.
    * 
    * @return The row value of this pair.
    */	
	public int getRow(){
		return row;
	}

	/**
    * Returns the column value of this pair.
    * 
    * @return The column value of this pair.
    */	
	public int getCol(){
		return col;
	}

	/**
    * Compares two pairs and determines if they are equal or not.
    * 
    * @param p An instance of the pair class to be compared to this pair.
    * @return True if the pairs are equals but false otherwise.
    */	
	public boolean equals(Pair p){
		if(p.getRow() == this.getRow() && p.getCol() == this.getCol()){
			return true;
	}
		return false;
	}
}