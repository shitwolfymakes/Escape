/**
 * The Cortex is created at the beginning of the game. It compiles a hashmap 
 * 		of EVERY weapon, enemy, level, etc, and reads any additions in from a 
 * 		mods folder(eventually). Before the Cortex is compiled, each data file
 * 		should have the data contained therein validated. This object shall be
 * 		created once, and exist for the duration of the game. This would 
 * 		probably be easiet if it was set as a global field in Main.java.
 * 
 * 		In each data file, there shall be a standard structure of prefixes:
 * 		
 * 		L_<ID> - level
 * 		W_<ID> - weapon
 * 		E_<ID> - enemy ship
 * 		U_<ID> - ship upgrade
 * 		M_<First letter of every word in the mod name>_<ID> - mod object
 * 
 * @author wolfyCSA
 */

package application.model;

public class Cortex {

}
