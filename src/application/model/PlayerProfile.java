/**
 *	This class stores the data for the current player
 * @author indomichael
 * @author IceKold736
 * @author Mpoznecki
 * @author caseycannon423
 * @author wolfyCSA
 */

package application.model;

public class PlayerProfile {
	
	//private String username;
	//private int currentHull;
	//private int currentShields;
	private int currentLevel;
	//private int difficultyLevel;
	private int points;
	private int money;
	//private int numLevelsUnlocked;
	//private ArrayList<String> upgrades = new ArrayList<String>();
	
	//private Save s = new Save();
	/**
	 * Creates a new player profile
	 */
	public PlayerProfile() {
		//this.numLevelsUnlocked = -1;
		this.currentLevel 	   = 1;
		this.points		 	   = 0;
		this.money		 	   = 0;
		//this.upgrades          = null;
		//this.username	       = null;
	}//end empty constructor
	
	// run this on first time playing, then follow with initProfile()
	/**
	 * Creates a new profile for user
	 */
	public void createProfile()
	{
		// set new profile to default values
		PlayerProfile p = new PlayerProfile();
		//p.setDifficultyLevel(difficulty);
		p.setCurrentLevel(1);
		p.setPoints(0);
		p.setMoney(0);
		//p.setNumLevelsUnlocked(1);
		
		// save the newly made profile
		//s.updateSave(p);
	}

	/**
	 * @return the currentLevel
	 */
	public int getCurrentLevel() {
		return currentLevel;
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
	 * @param currentLevel the currentLevel to set
	 */
	public void setCurrentLevel(int currentLevel) {
		this.currentLevel = currentLevel;
	}

	/**
	 * @param points the points to set
	 */
	public void setPoints(int points) {
		this.points = points;
	}
	
	/**
	 * @param points to be added to points
	 */
	public void addPoints(int points) {
		this.points += points;
	}

	/**
	 * @param money the money to set
	 */
	public void setMoney(int money) {
		this.money = money;
	}
	
	

}//end PlayerProfile