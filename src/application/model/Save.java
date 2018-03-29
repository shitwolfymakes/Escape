/*
 * This class handles reading and writing to savefiles. This class should be used in profile.
 */

package application.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Save {

	// use in Profile.java: parseSave(getSaveName());
	public void parseSave(String username)
	{
		try {
			String filename = "../saves/"+ username + ".txt";
			Scanner save = new Scanner( new File(filename) );

			while( save.hasNextLine() )
			{
				String line = save.nextLine();
				String[] tokens = line.split(",");
				
				//TODO: validate each line, then store the data
				//			see /saves/readme.txt for the save file structure
				
				
			}//end while
			
			save.close();	// close the file!
		}catch(FileNotFoundException ex) {
			System.out.println( "No Savegame with that name!" );
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		
	}//end parseSave()
	
	public void updateSave(PlayerProfile p)
	{
		//TODO: Take in the current PlayerProfile, and write all it's data into a new 
		//			save file. See /saves/readme.txt for the save file structure
	}//end updateSave()
	
	
}
