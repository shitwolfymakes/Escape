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

public class Level {

	private int numRows;
	private int numCols;
	private char [][] level;
	private int currentLevel;
	
	private int currentRow;
	private int currentCol;

	public Level( int rows, int cols ) {
		this.numRows = rows;
		this.numCols = cols;
	}
	
	// Method to read in the data from level files & create a Level object
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
	}
	
	public void updateCurrentLocation(int r, int c) {
		this.currentCol = c;
		this.currentRow = r;
	}
	
}
