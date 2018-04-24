/**
 * 	This class governs the dynamically-rendered level
 * 
 * @author wolfyCSA
 */

package application.model;

import java.util.ArrayList;

import application.Main;

public class Level {

	private static final int numRows = 7;
	private static final int numCols = 10;
	private String[][] level;
	private int currentLevel;
	private int currentRow;
	private int currentCol;
	private int previousRow;
	private int previousCol;
	private ArrayList<EnemyShip> enemyShips = new ArrayList<EnemyShip>();
	
	public Level() {};
	
	public Level(int levelNum) {
		
		this.currentLevel = levelNum;
		this.level = parseLevel(this.currentLevel);
		this.currentRow = Main.player.getCurrentRow();
		this.currentCol = Main.player.getCurrentCol();
		
	}
	
	/** 
	 * 
	 * @return ArrayList of EnemyShips containing data on all the enemies in the level
	 */
	public ArrayList<EnemyShip> collectEnemies() {
		for (int r = 0; r < 7 ; r++) { 
	        for (int c = 0; c < 10; c++) {
	        	if ( level[r][c].equals("H1") )
	        		enemyShips.add( new EnemyShip("H1", r, c) );
	        	if ( level[r][c].equals("H2") )
	        		enemyShips.add( new EnemyShip("H2", r, c) );
	        }//end inner for
	    }//end outer for
		
		return enemyShips;
	}
	
	/**
	 * 
	 * @param eachRow ArrayList of strings containing all the level data
	 * @return int length of the longest row
	 */
	public int getLongestRow(ArrayList<String> eachRow) {
		int length = 0;
		for (int i = 1; i < 7; i++)
		{
			String line = eachRow.get(i-1).toString();
			String[] tokens = line.split(",");
			String line2 = eachRow.get(i).toString();
			String[] tokens2 = line2.split(",");
		
			length = Math.max(tokens.length, tokens2.length);
		}
		return length;
	}
	
	/**
	 * 
	 * @param levelNum number of the level to be loaded
	 * @return a 2D String array containing all objects in the level
	 */
	public String[][] parseLevel(int levelNum) {
		
		ArrayList<String> eachRow = new ArrayList<String>();
		eachRow = Main.cortex.getLevel().get("L_"+levelNum);
		int longestRow = getLongestRow(eachRow);
		
		String[][] matrix = new String[7][longestRow];
		
		for (int i = 0; i < 7; i++)
		{
			String line = eachRow.get(i).toString();
			String[] tokens = line.split(",");
			
			// fill the array
			for (int j = 0; j < tokens.length; j++)
				matrix[i][j] = tokens[j];
			for ( int j = tokens.length - 1; j < matrix[i].length; j++)
				if ( matrix[i][j] == null ) 
					 matrix[i][j] = String.valueOf(-1);
			
			//System.out.println();
		}//end outer for
		
		// print level array to console
		printLevel(levelNum);
//		System.out.println("");
//		System.out.println("Level Array: ");
//		for( int i = 0; i < 7; i++ ) {
//			for( int j = 0; j < matrix[i].length; j++ ) {
//				System.out.printf("%s,",matrix[i][j]);
//			}//end inner for
//			System.out.println("");
//		}//end outer for
//		System.out.println("");
//		
//		for( int r = 0; r < 7; r++ ) {
//			for( int c = 0; c < matrix[r].length; c++ ) {
//				String code = "";
//				code = matrix[r][c];
//				
//				if( code == null )
//					continue;
//				else if ( code.equals("p") )
//					updateCurrentLocation(r,c);
//			}//end inner for
//		}//end outer for
		
		return matrix;
	}//end parseLevel()
	
	
	public void printLevel(int levelNum) {
		ArrayList<String> eachRow = new ArrayList<String>();
		eachRow = Main.cortex.getLevel().get("L_"+levelNum);
		int longestRow = getLongestRow(eachRow);
		String[][] matrix = new String[7][longestRow];
		
		
		for (int i = 0; i < 7; i++)
		{
			String line = eachRow.get(i).toString();
			String[] tokens = line.split(",");
			
			// fill the array
			for (int j = 0; j < tokens.length; j++)
				matrix[i][j] = tokens[j];
			for ( int j = tokens.length - 1; j < matrix[i].length; j++)
				if ( matrix[i][j] == null ) 
					 matrix[i][j] = String.valueOf(-1);
			
			//System.out.println();
		}//end outer for
		System.out.println("");
		System.out.println("Level Array: ");
		for( int i = 0; i < 7; i++ ) {
			for( int j = 0; j < matrix[i].length; j++ ) {
				System.out.printf("%s,",matrix[i][j]);
			}//end inner for
			System.out.println("");
		}//end outer for
		System.out.println("");
		
		for( int r = 0; r < 7; r++ ) {
			for( int c = 0; c < matrix[r].length; c++ ) {
				String code = "";
				code = matrix[r][c];
				
				if( code == null )
					continue;
				else if ( code.equals("p") )
					updateCurrentLocation(r,c);
			}//end inner for
		}//end outer for
	}
	
	public void move( char letter ) {
		switch( letter ) {
			case 'W': moveUp(); break;
			case 'A': moveLeft(); break;
			case 'S': moveDown(); break;
			case 'D': moveRight(); break;

		}//end switch
	}//end move()
	
	public void moveUp() {
		// check if the row above is a wall
		if( !(this.level[this.currentRow-1][this.currentCol].equals("b")) ) {
			System.out.println("player moved to: " + (this.currentRow-1) + "," + this.currentCol);
			this.updateCurrentLocation( this.currentRow-1, this.currentCol );
		}
	}//end moveUp()
	
	public void moveDown() {
		// check if the row below is a wall
		if( !(this.level[this.currentRow+1][this.currentCol].equals("b")) ) {
			System.out.println("player moved to: " + (this.currentRow+1) + "," + this.currentCol);
			this.updateCurrentLocation( this.currentRow+1, this.currentCol );
			}
	}//end moveDown()
	
	public void moveRight() {
		// check if the column to right is a wall
		if( !(this.level[this.currentRow][this.currentCol+1].equals("b")) ) {
			System.out.println("player moved to: " + this.currentRow + "," + (this.currentCol+1));
			this.updateCurrentLocation( this.currentRow, this.currentCol+1 );
		}
	}//end moveRight()
	
	public void moveLeft() {
		// check if the column to left is a wall
		if( !(this.level[this.currentRow][this.currentCol-1].equals("b")) ) {
			System.out.println("player moved to: " + this.currentRow + "," + (this.currentCol-1));
			this.updateCurrentLocation( this.currentRow, this.currentCol-1 );
		}
	}//end moveLeft()
	
	public void updateCurrentLocation(int r, int c) {	
		Main.model.previousCol = Main.model.currentCol;
		Main.model.previousRow = Main.model.currentRow;
		
		Main.model.currentCol = c;
		Main.model.currentRow = r;
		Main.player.setPreviousLocation(Main.model.previousRow, Main.model.previousCol);
		Main.player.setCurrentLocation(Main.model.currentRow, Main.model.currentCol);
		
	}//end updateCurrentLocation()
	
	public void updateEnemyLocation(EnemyShip e) {
		this.currentCol = e.getCurrentCol() - 1;
		System.out.println(e.getName() + " moved to: " + e.getCurrentRow() + ", " + e.getCurrentCol());
	}//end updateEnemyLocation()
	
	public void enemyJumpBarrier(EnemyShip e) {
		this.currentCol = e.getCurrentCol() - 2;
		System.out.println(e.getName() + " jumped the barrier to: " + e.getCurrentRow() + ", " + e.getCurrentCol());
	}//end enemyJumpBarrier()
	
	public boolean isLevelOver() {
		if (Main.enemies.size() == 0) {
			//System.out.println("Level complete!");
			return true;
		}
		return false;
	}//end isLevelOver()
	
	public int getPreviousRow() {
		return Main.model.previousRow;
	}
	
	public int getPreviousColumn() {
		return Main.model.previousCol;
	}
	
	public int getCurrentRow() {
		return Main.model.currentRow;
	}
	
	public int getCurrentColumn() {
		return Main.model.currentCol;
	}
	
	
	public int getRows() {
		return numRows;
	}
	
	public int getCols() {
		return numCols;
	}
	
	public String getLevelLocation( int row, int col ) {
		return this.level[row][col];
	}
	
}//end class Level