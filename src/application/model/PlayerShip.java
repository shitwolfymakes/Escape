/**
 * 	Subclass of Ship.java. Governs the player ship object
 * 
 * @author wolfyCSA
 */

package application.model;

public class PlayerShip extends Ship {
	
	private int currentRow;
	private int currentCol;
	
	public PlayerShip() {} //end default constructor 
	
	public PlayerShip(int r, int c) {
		this.currentRow = r;
		this.currentCol = c;
		
		//super.setHullPoints(Main.profile.getCurrentHull())
		//super.setShieldPoints(Main.profile.getCurrentShield()); // Not using this in this version
		//super.setNumWeapons(Main.profile.getNumWeapons());
		super.setSpriteLink("data/Escape Sprites/playership.png");
		//super.addWeapons(Main.cortex.getWeapon("W_"+ Main.profile.getCurrentWeaponID()));
		
		//for (int i = 0; i < getNumWeapons(); i++)
		System.out.println(this.toString());
	}//end overloaded constructor

	public void setCurrentLocation(int row, int column) {
		this.currentRow = row;
		this.currentCol = column;
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
	
}//end class PlayerShip