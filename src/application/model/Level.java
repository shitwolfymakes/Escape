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
	private ArrayList<EnemyShip> enemyShips = new ArrayList<EnemyShip>();
	
	public Level() {};
	
	public Level(int levelNum) {
		
		this.currentLevel = levelNum;
		this.currentRow = 4;
		this.currentCol = 1;
		this.level = parseLevel(this.currentLevel);
		
	}
	
	public ArrayList<EnemyShip> collectEnemies() {
		
		for (int r = 0; r < 7 ; r++) 
	    { 
	        for (int c = 0; c < 10; c++)
	        {
	        	if ( level[r][c].equals("H1") )
	        		enemyShips.add( new EnemyShip("H1", r, c) );
	        	if ( level[r][c].equals("H2") )
	        		enemyShips.add( new EnemyShip("H2", r, c) );
	        	
	        }//end inner for
	    }//end outer for
		
		return enemyShips;
	}
	
	public int getLongestRow(ArrayList<String> eachRow) {
		int tmp = 0;
		for (int i = 1; i < 7; i++)
		{
			String line = eachRow.get(i-1).toString();
			String[] tokens = line.split(",");
			String line2 = eachRow.get(i).toString();
			String[] tokens2 = line2.split(",");
		
			tmp = Math.max(tokens.length, tokens2.length);
		}
		return tmp;
	}
	
	public String[][] parseLevel(int levelNum) {
		
		ArrayList<String> eachRow = Main.cortex.getLevel().get("L_"+levelNum);
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
		}//end outer for
		
		for( int i = 0; i < 7; i++ ) {
			for( int j = 0; j < matrix[i].length; j++ ) {
				System.out.printf("%s,",matrix[i][j]);
			}//end inner for
			System.out.println("");
		}//end outer for
		
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
		
		return matrix;
	}//end parseLevel()
	
	public void updateCurrentLocation(int r, int c) {
		this.currentCol = c;
		this.currentRow = r;
		System.out.println("player location updated!");
	}//end updateCurrentLocation()
	
	public void updateEnemyLocation(EnemyShip e) {
		this.currentCol = e.getCurrentCol() - 1;
	}//end updateEnemyLocation()
	
	public void enemyJumpBarrier(EnemyShip e) {
		this.currentCol = e.getCurrentCol() - 2;
	}//end enemyJumpBarrier()
	
}//end class Level