/**
 * 	This class governs the dynamically-rendered level
 * 
 * @author wolfyCSA
 */

package application.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import application.Main;

public class Level {

	private static final int numRows = 7;
	private static final int numCols = 10;
	private String [][] level;
	private int currentLevel;
	private int currentRow;
	private int currentCol;
	private ArrayList<EnemyShip> enemyShips = new ArrayList<EnemyShip>();
	
	public Level(int levelNum) {
		
		this.currentLevel = levelNum;
		this.currentRow = 4;
		this.currentCol = 1;
	}
	
	public ArrayList<EnemyShip> collectEnemies() {
		
		for (int r = 0; r < level.length ; r++) 
	    { 
	        for (int c = 0; c < level[c].length; c++)
	        {
	        	if ( level[r][c].equals("H1") )
	        		enemyShips.add( new EnemyShip("H1", r, c) );
	        		
	        	if ( level[r][c].equals("H2") )
	        		enemyShips.add( new EnemyShip("H2", r, c) );
	        }//end inner for
	    }//end outer for
		
		return enemyShips;
	}
	
	// deprecated, level data is already stored in the cortex entry
	/*
	public static Level parseLevel( String fileName ) {
		
		// open the file
		Scanner scan = null;
		Level l = null;
		ArrayList<String> eachRow = new ArrayList<String>();
		
		//TODO: refactor this to work with arrays parsed from txt file
		try {
			// do the reading
			scan = new Scanner( new File( fileName ) );
			while( scan.hasNextLine() ) {
				eachRow.add( scan.nextLine() );
			}
			
			int numberOfRows = eachRow.size();
			int numberOfCols = eachRow.get(0).length();
			
			l = new Level( numberOfRows, numberOfCols );
			// copy the file contents to the Level model object
			for( int r=0; r<numberOfRows; r++ ) {
				for( int c=0; c<numberOfCols; c++ ) {
					char letter = eachRow.get(r).charAt(c);
					l.level[r][c] = letter;
					
					if( letter=='c' )
						l.updateCurrentLocation(r,c);
				}
			}
			
		}catch(IOException e) {
			//TODO: handle this exception!
			e.printStackTrace();
		}finally {
			if( scan!=null )
				scan.close();
		}
			
		return l;
	}//end parseLevel()
	*/
	
	public void updateCurrentLocation(int r, int c) {
		this.currentCol = c;
		this.currentRow = r;
	}
	public void updateEnemyLocation(EnemyShip e) {
		this.currentCol = e.getCurrentCol() - 1;
	}
	public void enemyJumpBarrier(EnemyShip e) {
		this.currentCol = e.getCurrentCol() - 2;
	}
	
}
