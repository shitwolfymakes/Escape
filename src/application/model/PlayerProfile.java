/**
 *	This class stores the data for the current player
 *
 * @author wolfyCSA
 */

package application.model;

import java.util.ArrayList;

public class PlayerProfile {
	
	private String username;
	private int currentLevel;
	private int difficultyLevel;
	private int points;
	private int money;
	private int numLevelsUnlocked;
	private ArrayList<String> upgrades = new ArrayList<String>();
	
	private Save s = new Save();
	
	public PlayerProfile(String username) 
	{
		this.username = username;
	}
	
	// run this on first time playing, then follow with initProfile()
	public void createProfile(String username, int difficulty)
	{
		// set new profile to default values
		PlayerProfile p = new PlayerProfile(username);
		p.setDifficultyLevel(difficulty);
		p.setPoints(0);
		p.setMoney(0);
		p.setNumLevelsUnlocked(1);
		
		// save the newly made profile
		s.updateSave(p);
	}
	
	public PlayerProfile initProfile(String username)
	{
		// create the current profile, and populate it with
		//    the data stored in the save file
		PlayerProfile p = new PlayerProfile(username);
		s.parseSave(getUsername(), p);
		
		return p;
	}//end initProfile()
	
	public void saveProfile(PlayerProfile p)
	{
		s.updateSave(p);
	}//end saveProfile

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return the currentLevel
	 */
	public int getCurrentLevel() {
		return currentLevel;
	}

	/**
	 * @return the difficultyLevel
	 */
	public int getDifficultyLevel() {
		return difficultyLevel;
	}

	/**
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * @return the money
	 */
	public int getMoney() {
		return money;
	}

	/**
	 * @return the numLevelsUnlocked
	 */
	public int getNumLevelsUnlocked() {
		return numLevelsUnlocked;
	}

	/**
	 * @return the upgrades
	 */
	public ArrayList<String> getUpgrades() {
		return upgrades;
	}

	/**
	 * @return the s
	 */
	public Save getS() {
		return s;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @param currentLevel the currentLevel to set
	 */
	public void setCurrentLevel(int currentLevel) {
		this.currentLevel = currentLevel;
	}

	/**
	 * @param difficultyLevel the difficultyLevel to set
	 */
	public void setDifficultyLevel(int difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	/**
	 * @param points the points to set
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	/**
	 * @param money the money to set
	 */
	public void setMoney(int money) {
		this.money = money;
	}

	/**
	 * @param numLevelsUnlocked the numLevelsUnlocked to set
	 */
	public void setNumLevelsUnlocked(int numLevelsUnlocked) {
		this.numLevelsUnlocked = numLevelsUnlocked;
	}

	/**
	 * @param s the s to set
	 */
	public void setS(Save s) {
		this.s = s;
	}

	/**
	 * @param upgrades the upgrades to add
	 */
	public void addUpgrades(String upgrade) {
		upgrades.add(upgrade);
	}

}//end PlayerProfile