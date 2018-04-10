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
		loadWeapons();
		loadEnemies();
		loadUpgrades();
		System.out.println(cortex.toString());
	}//end initCortex()

	public void loadLevels() {
		int i = 0;

		while(true)
		{
			File levels = new File("../levels/level"+i+"csv.txt");

			if ( ((File) level).exists() ) {
				level.put( "L_"+ i, parseLevel(levels) );
				i++;
			} else break;
		}//end while

	}//end loadLevels()

	public List<ArrayList<String>> parseLevel(File f)
	{
		List<ArrayList<String>> fullLevel = new ArrayList< ArrayList<String> >();
		Scanner    scan  = null;
		
		try {
			scan = new Scanner( f );
			
			while(scan.hasNextLine())
			{
				String line = scan.nextLine();
				String[] tokens = line.split(",");
				
				ArrayList<String> levelLine = new ArrayList<String>();
				levelLine = (ArrayList<String>) Arrays.asList(tokens);
				
				fullLevel.add(levelLine);
				System.out.println(fullLevel.toString());
			}//end while
		}catch(FileNotFoundException ex) {
			System.out.println( "File Not Found" );
		} finally {
			scan.close();	// close the file!
		}//end try/catch/finally
		
		return fullLevel;
	}//end parseLevel()

	public void loadWeapons() {
		
		File 	f 	 = new File("../weapons/weapons.txt");
		Scanner scan = null;
		int		i	 = 0;
		
		try {
			scan = new Scanner( f );
			
			while(scan.hasNextLine())
			{
				ArrayList<String> weapons = new ArrayList<String>();
				
				String line = scan.nextLine();
				String[] tokens = line.split(",");
				
				weapons = (ArrayList<String>) Arrays.asList(tokens);
				//add to HashMap
				weapon.put("W_"+ i, weapons);
				i++;
				System.out.println(weapons.toString());
			}//end while
		}catch(FileNotFoundException ex) {
			System.out.println( "File Not Found" );
		}finally {
			scan.close();	// close the file!
		}//end try/catch/finally
		
	}//end loadWeapons()

	public void loadEnemies() {
		File 	f 	 = new File("../enemies/enemies.txt");
		Scanner scan = null;
		int		i	 = 0;
		
		try {
			scan = new Scanner( f );
			
			while(scan.hasNextLine())
			{
				ArrayList<String> enemies = new ArrayList<String>();
				
				String line = scan.nextLine();
				String[] tokens = line.split(",");
				
				enemies = (ArrayList<String>) Arrays.asList(tokens);
				//add to HashMap
				enemy.put("E_"+ i, enemies);
				i++;
				System.out.println(enemies.toString());
			}//end while
		}catch(FileNotFoundException ex) {
			System.out.println( "File Not Found" );
		}finally {
			scan.close();	// close the file!
		}//end try/catch/finally
		
	}//end loadEnemies()

	public void loadUpgrades() {
		File 	f 	 = new File("../upgrades/upgrades.txt");
		Scanner scan = null;
		int		i	 = 0;
		
		try {
			scan = new Scanner( f );
			
			while(scan.hasNextLine())
			{
				ArrayList<String> upgrades = new ArrayList<String>();
				
				String line = scan.nextLine();
				String[] tokens = line.split(",");
				
				upgrades = (ArrayList<String>) Arrays.asList(tokens);
				//add to HashMap
				upgrade.put("U_"+ i, upgrades);
				i++;
				System.out.println(upgrades.toString());
			}//end while
		}catch(FileNotFoundException ex) {
			System.out.println( "File Not Found" );
		}finally {
			scan.close();	// close the file!
		}//end try/catch/finally
		
	}//end loadLevels()

}//end class Cortex