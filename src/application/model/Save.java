/*
 * This class handles reading and writing to savefiles. This class should be used in profile.
 */

package application.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Save {

	// use in Profile.java: parseSave(getSaveName(), p);
	public void parseSave(String username, PlayerProfile p)
	{
		try {
			String filename = "../saves/"+ username + ".txt";
			Scanner save = new Scanner( new File(filename) );


			String line = save.nextLine();
			String[] tokens = line.split(",");
			// Line 1, username
			if (tokens[0].equals("username"))
				p.setUsername(tokens[1]);
			else System.out.println("Error: Corrupted save, missing username value");
			
			// Line 2, dificulty level
			line = save.nextLine();
			tokens = line.split(",");
			if (tokens[0].equals("difficultyLevel"))
				p.setDifficultyLevel(Integer.parseInt(tokens[1]));
			else System.out.println("Error: Corrupted save, missing difficultyLevel value");
			
			// Line 3, points
			line = save.nextLine();
			tokens = line.split(",");
			if (tokens[0].equals("points"))
				p.setPoints(Integer.parseInt(tokens[1]));
			else System.out.println("Error: Corrupted save, missing points value");
			
			// Line 4, money
			line = save.nextLine();
			tokens = line.split(",");
			if (tokens[0].equals("money"))
				p.setMoney(Integer.parseInt(tokens[1]));
			else System.out.println("Error: Corrupted save, missing money value");
			
			// Line 5, levels unlocked
			line = save.nextLine();
			tokens = line.split(",");
			if (tokens[0].equals("levels_unlocked"))
				p.setNumLevelsUnlocked(Integer.parseInt(tokens[1]));
			else System.out.println("Error: Corrupted save, missing levels_unlocked value");
			
			// Line 6, upgrades
			line = save.nextLine();
			tokens = line.split(",");
			if (tokens[0].equals("money")) 
			{
				for ( int i = 1; i < tokens.length; i++ )
				p.addUpgrades(tokens[i]);
			}
			else System.out.println("Error: Corrupted save, missing upgrade values");
			
			
			
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
