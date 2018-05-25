/**
 * The Cortex is created at the beginning of the game. It compiles a hashmap 
 * 		of EVERY weapon, enemy, level, etc, and reads any additions in from a 
 * 		mods folder(eventually). Before the Cortex is compiled, each data file
 * 		should have the data contained therein validated. This object shall be
 * 		created once, and exist for the duration of the game. This would 
 * 		probably be easiest if it was set as a global field in Main.java.
 * 
 * 		In each Cortex entry hashmap, there shall be a standard structure of prefixes:
 * 		
 * 		L_<ID> - level
 * 		W_<ID> - weapon
 * 		E_<ID> - enemy
 * 		U_<ID> - ship upgrade
 * 		M_<First letter of every word in the mod name>_<ID> - mod object
 * 
 * @author wolfyCSA
 */

package application.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import application.Main;

public class Cortex {

	public Map< String,HashMap<String, ArrayList<String>> > cortex = new HashMap< String,HashMap<String, ArrayList<String>> >();
	public Map< String, ArrayList<String> >					level    = new HashMap< String, ArrayList<String> >();
	public Map< String, ArrayList<String> >       			weapon   = new HashMap< String, ArrayList<String> >();
	public Map< String, ArrayList<String> >       			enemy    = new HashMap< String, ArrayList<String> >();
	public Map< String, ArrayList<String> >       			upgrade  = new HashMap< String, ArrayList<String> >();
	
	public Cortex() {
		initCortex();
	}//end constructor

	/**
	 * Initializes the Cortex HashMap, filling it with data
	 */
	public void initCortex() {
		loadLevels();
		System.out.println("Levels loaded!");
		System.out.println("");
		loadWeapons();
		System.out.println("Weapons hot!");
		System.out.println("");
		loadEnemies();
		System.out.println("Enemies spotted!");
		System.out.println("");
		loadUpgrades();
		System.out.println("Upgrades developed!");
		System.out.println("");
		//loadMods();
		//System.out.println("Mods are asleep, upvote trebuchet!");
		//System.out.println("");
		System.out.println("Cortex compiled!");
	}//end initCortex()

	/**
	 * Loads levels into the level HashMap
	 */
	public void loadLevels() {
		int i = 1;

		while(true)
		{
			//Reader paramReader = new InputStreamReader(getClass().getResourceAsStream("com/resources/data/levels/level"+i+"csv.txt"));
			//InputStream is = Main.class.getResourceAsStream("resources/data/levels/level"+i+"csv.txt");
			InputStream is = getClass().getResourceAsStream("data/levels/level"+i+"csv.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			//String line;
			try {
				System.out.printf("%s\n", br.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			File levelFile = new File("resources/data/levels/level"+i+"csv.txt");

			if ( ((File) levelFile).exists() ) {
				System.out.println(levelFile + " exists");
				level.put( "L_"+ i, (ArrayList<String>) parseLevel(levelFile) );
				i++;
			} else break;
		}//end while
		
	}//end loadLevels()

	/**
	 * 
	 * @param f the File to be parsed
	 * @return a String List containing the level data
	 */
	public List<String> parseLevel(File f)
	{
		List<String> fullLevel = new ArrayList<String>();
		
		try {
			Scanner scan = new Scanner( f );
			System.out.println( f.getName() + ":");
			while(scan.hasNextLine())
			{
				String levelLine = scan.nextLine();
				fullLevel.add( levelLine );
				System.out.println(levelLine);
			}//end while
			
			scan.close();	// close the file!
		}catch(FileNotFoundException ex) {
			System.out.println( "Level " + f + " file not found" );
		}//end try/catch
		
		return fullLevel;
	}//end parseLevel()

	/**
	 * Loads weapons into the weapons HashMap
	 */
	public void loadWeapons() {
		try {
			Scanner scan = new Scanner( new File("resources/data/weapons/weapons.txt") );
			
			while(scan.hasNextLine())
			{
				String line = scan.nextLine();
				String[] tokens = line.split(",");
				
				List<String> weapons = new ArrayList<String>( Arrays.asList(tokens) );
				//add to HashMap
				weapon.put("W_"+ tokens[1], (ArrayList<String>) weapons);
				System.out.println(weapons.toString());
			}//end while
			
			scan.close();	// close the file!
		}catch(FileNotFoundException ex) {
			System.out.println( "Weapons file not found" );
		}//end try/catch
		
	}//end loadWeapons()

	/**
	 * Loads enemies into the enemies HashMap
	 */
	public void loadEnemies() {
		try {
			Scanner scan = new Scanner( new File("resources/data/enemies/enemies.txt") );
			
			while(scan.hasNextLine())
			{
				String line = scan.nextLine();
				String[] tokens = line.split(",");
				List<String> enemies = new ArrayList<String>( Arrays.asList(tokens) );
				//add to HashMap
				enemy.put("E_"+ tokens[1], (ArrayList<String>) enemies);
				System.out.println(enemies.toString());
			}//end while
			
			scan.close();	// close the file!
		}catch(FileNotFoundException ex) {
			System.out.println( "resources/Enemies file not found" );
		}//end try/catch
		
	}//end loadEnemies()

	/**
	 * Loads upgrades into the upgrades HashMap
	 */
	public void loadUpgrades() {
		try {
			Scanner scan = new Scanner( new File("resources/data/upgrades/upgrades.txt") );
			
			while(scan.hasNextLine())
			{
				String line = scan.nextLine();
				String[] tokens = line.split(",");
				
				List<String> upgrades = new ArrayList<String>( Arrays.asList(tokens) );
				//add to HashMap
				upgrade.put("U_"+ tokens[1], (ArrayList<String>) upgrades);
				System.out.println(upgrades.toString());
			}//end while
			
			scan.close();	// close the file!
		}catch(FileNotFoundException ex) {
			System.out.println( "Upgrades file not found" );
		}//end try/catch
		
	}//end loadLevels()

	/**
	 * @return the cortex HashMap
	 */
	public Map<String, HashMap<String, ArrayList<String>>> getCortex() {
		return cortex;
	}
	/**
	 * @return the level HashMap
	 */
	public Map<String, ArrayList<String>> getLevel() {
		return level;
	}
	/**
	 * @return the weapon HashMap
	 */
	public Map<String, ArrayList<String>> getWeapon() {
		return weapon;
	}
	/**
	 * @return the enemy HashMap
	 */
	public Map<String, ArrayList<String>> getEnemy() {
		return enemy;
	}
	/**
	 * @return the upgrade HashMap
	 */
	public Map<String, ArrayList<String>> getUpgrade() {
		return upgrade;
	}

}//end class Cortex