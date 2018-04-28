/**
 * Super class to Enemy.java and Player.java
 * 		defines shared data variables 
 * @author wolfyCSA
 * @author indomichael
 * @author IceKold736
 * @author Mpoznecki
 * @author caseycannon423
 */

package application.model;

import java.util.ArrayList;

public class Ship {
	
	protected int    			hullPoints;
	protected int	 			shieldPoints;
	protected String 			spriteLink;
	protected int 				numWeapons;
	protected ArrayList<String> weapons;
	
	/**
	 * @return the hullPoints
	 */
	public int getHullPoints() {
		return hullPoints;
	}
	/**
	 * @return the shieldPoints
	 */
	public int getShieldPoints() {
		return shieldPoints;
	}
	/**
	 * @return the spriteLink
	 */
	public String getSpriteLink() {
		return spriteLink;
	}
	/**
	 * @return the numWeapons
	 */
	public int getNumWeapons() {
		return numWeapons;
	}
	/**
	 * @return the weapons
	 */
	public ArrayList<String> getWeapons() {
		return weapons;
	}
	/**
	 * @param hullPoints the hullPoints to set
	 */
	public void setHullPoints(int hullPoints) {
		this.hullPoints = hullPoints;
	}
	/**
	 * @param shieldPoints the shieldPoints to set
	 */
	public void setShieldPoints(String shieldPoints) {
		this.shieldPoints = Integer.parseInt(shieldPoints);
	}
	/**
	 * @param spriteLink the spriteLink to set
	 */
	public void setSpriteLink(String spriteLink) {
		this.spriteLink = spriteLink;
	}
	/**
	 * @param numWeapons the numWeapons to set
	 */
	public void setNumWeapons(String numWeapons) {
		this.numWeapons = Integer.parseInt(numWeapons);
	}
	/**
	 * @param weapons the weapons to set
	 */
	public void addWeapons(String weaponID) {
		weapons.add(weaponID);
	}
	
	

}//end class Ship