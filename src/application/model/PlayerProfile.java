/*
 *	This class stores the data for the current player
 */

package application.model;

import java.util.ArrayList;

public class PlayerProfile {
	
	private String username;
	private int difficultyLevel;
	private int points;
	private int money;
	private int numLevelsUnlocked;
	private ArrayList<String> upgrades = new ArrayList<String>();
	
	public PlayerProfile() {}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
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
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
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
	 * @param upgrades the upgrades to add
	 */
	public void addUpgrades(String upgrade) {
		upgrades.add(upgrade);
	}
	
	

}
