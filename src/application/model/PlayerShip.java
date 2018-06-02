/**
 * 	Subclass of Ship.java. Governs the player ship object
 * 
 * @author wolfyCSA
 */
package application.model;

public class PlayerShip extends Ship {
	
	private int currentRow;
	private int currentCol;
	private int previousRow;
	private int previousCol;
	private boolean dead = false;
	
	/**
	 * Default constructor for PlayerShip object
	 */
	public PlayerShip() {} //end default constructor 
	
	/**
	 * Constructor for PlayerShip at certain coordinates
	 * 
	 * @param r starting row
	 * @param c starting column
	 */
	public PlayerShip(int r, int c) {
		this.currentRow = r;
		this.currentCol = c;
		
		//super.setHullPoints(Main.profile.getCurrentHull());
		//super.setShieldPoints(Main.profile.getCurrentShield()); // Not using this in this version
		//super.setNumWeapons(Main.profile.getNumWeapons());
		super.setSpriteLink("data/Escape Sprites/playership.png");
		//super.addWeapons(Main.cortex.getWeapon("W_"+ Main.profile.getCurrentWeaponID()));
		
		//for (int i = 0; i < getNumWeapons(); i++)
		//System.out.println(this.toString());
	}//end PlayerShip() overloaded constructor

	/**
	 * Sets a location of a PlayerShip based on given coordinates
	 * 
	 * @param row to be set
	 * @param column to be set
	 */
	public void setCurrentLocation(int row, int column) {
		this.currentRow = row;
		this.currentCol = column;
	}//end setCurrentLocation()
	
	/**
	 * Sets the previous location of a PlayerShip based on given 
	 * 	coordinates
	 * 
	 * @param row to be set
	 * @param column to be set
	 */
	public void setPreviousLocation(int row, int column) {
		this.previousRow = row;
		this.previousCol = column;
	}
	
	/**
	 * @return the currentRow
	 */
	public int getCurrentRow() {
		return currentRow;
	}
	/**
	 * @return the currentCol
	 */
	public int getCurrentCol() {
		return currentCol;
	}
	/**
	 * @return the currentRow
	 */
	public int getPreviousRow() {
		return previousRow;
	}
	/**
	 * @return the currentCol
	 */
	public int getPreviousCol() {
		return previousCol;
	}
	/**
	 * @return String info about the PlayerShip object
	 */
	public String toString() {
		return "Player Ship at: " + this.currentRow + "," + this.currentCol;
	}
	/**
	 * @return true if dead, false if not
	 */
	public boolean isDead() {
		return dead;
	}
	/**
	 * @param dead boolean that is true if dead or false if not
	 */
	public void setDead(boolean dead) {
		this.dead = dead;
	}
	
}//end class PlayerShip