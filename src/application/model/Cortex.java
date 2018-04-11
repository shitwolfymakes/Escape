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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Cortex {

	public Map< String,HashMap<String, ArrayList<String>> > cortex = new HashMap< String,HashMap<String, ArrayList<String>> >();
	public Map< String, List<ArrayList<String>> > 			level    = new HashMap< String, List<ArrayList<String>> >();
	public Map< String, ArrayList<String> >       			weapon   = new HashMap< String, ArrayList<String> >();
	public Map< String, ArrayList<String> >       			enemy    = new HashMap< String, ArrayList<String> >();
	public Map< String, ArrayList<String> >       			upgrade  = new HashMap< String, ArrayList<String> >();
	
	
	public Cortex() {
		initCortex();
	}//end constructor

	public void initCortex() {
		loadLevels();
		System.out.println("Levels loaded");
		loadWeapons();
		System.out.println("Weapons hot");
		loadEnemies();
		System.out.println("Enemies spotted");
		loadUpgrades();
		System.out.println("Upgrades developed");
		//loadMods();
		//System.out.println("Mods are asleep, upvote trebuchet");
		System.out.println(cortex.toString());
	}//end initCortex()

	public void loadLevels() {
		int i = 1;

		while(true)
		{
			File levelFile = new File("data/levels/level"+i+"csv.txt");

			if ( ((File) levelFile).exists() ) {
				System.out.println(levelFile + " exists");
				//level.put( "L_"+ i, parseLevel(levelFile) );
				//System.out.println(level.get("L_"+i));
				i++;
			} else break;
		}//end while
		
	}//end loadLevels()

	public List<ArrayList<String>> parseLevel(File f)
	{
		List<ArrayList<String>> fullLevel = new ArrayList< ArrayList<String> >();
		
		try {
			Scanner scan = new Scanner( f );
			
			while(scan.hasNextLine())
			{
				String line = scan.nextLine();
				String[] tokens = line.split(",");
				
				List<String> levelLine = new ArrayList<String>( Arrays.asList(tokens) );
				
				fullLevel.add((ArrayList<String>) levelLine);
				System.out.println(fullLevel.toString());
			}//end while
			
			scan.close();	// close the file!
		}catch(FileNotFoundException ex) {
			System.out.println( "Level " + f + " file not found" );
		}//end try/catch
		
		return fullLevel;
	}//end parseLevel()

	public void loadWeapons() {
		int	i = 0;
		
		try {
			Scanner scan = new Scanner( new File("data/weapons/weapons.txt") );
			
			while(scan.hasNextLine())
			{
				String line = scan.nextLine();
				String[] tokens = line.split(",");
				
				List<String> weapons = new ArrayList<String>( Arrays.asList(tokens) );
				//add to HashMap
				weapon.put("W_"+ i, (ArrayList<String>) weapons);
				i++;
				System.out.println(weapons.toString());
			}//end while
			
			scan.close();	// close the file!
		}catch(FileNotFoundException ex) {
			System.out.println( "Weapons file not found" );
		}//end try/catch
		
	}//end loadWeapons()

	public void loadEnemies() {
		int	i = 0;
		
		try {
			Scanner scan = new Scanner( new File("data/enemies/enemies.txt") );
			
			while(scan.hasNextLine())
			{
				String line = scan.nextLine();
				String[] tokens = line.split(",");
				List<String> enemies = new ArrayList<String>( Arrays.asList(tokens) );
				//add to HashMap
				enemy.put("E_"+ i, (ArrayList<String>) enemies);
				i++;
				System.out.println(enemies.toString());
			}//end while
			
			scan.close();	// close the file!
		}catch(FileNotFoundException ex) {
			System.out.println( "Enemies file not found" );
		}//end try/catch
		
	}//end loadEnemies()

	public void loadUpgrades() {
		int	i = 0;
		
		try {
			Scanner scan = new Scanner( new File("data/upgrades/upgrades.txt") );
			
			while(scan.hasNextLine())
			{
				String line = scan.nextLine();
				String[] tokens = line.split(",");
				
				List<String> upgrades = new ArrayList<String>( Arrays.asList(tokens) );
				//add to HashMap
				upgrade.put("U_"+ i, (ArrayList<String>) upgrades);
				i++;
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
	public Map<String, List<ArrayList<String>>> getLevel() {
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