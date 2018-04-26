/**
 * 	Subclass of Ship.java. Governs the enemy ship object
 * 
 * @author wolfyCSA
 */

package application.model;

import java.util.ArrayList;

import application.Main;

public class EnemyShip extends Ship {

	private int pointValue;
	private int moneyValue;
	private String name;
	private String enemyID;
	private int currentRow;
	private int currentCol;
	private int prevCol;
	private int prevRow;
	private int numWeapons;
	private boolean active = true;
	private boolean dead = false;
	
	public EnemyShip(String enemyID, int r, int c) {
		this.currentRow = r;
		this.currentCol = c;
		this.prevRow = currentRow;
		this.prevCol = currentCol;
		ArrayList<String> enemyShipData = new ArrayList<String>();
		// store data grabbed from the Cortex entry
		enemyShipData = Main.cortex.getEnemy().get("E_"+ enemyID);
		
		setEnemyID(enemyShipData.get(0));
		setName(enemyShipData.get(1));
		super.setHullPoints(Integer.parseInt(enemyShipData.get(2)));
		//super.setShieldPoints(enemyShipData.get(3)); // Not using this in this version
		setPointValue(enemyShipData.get(4));
		setMoneyValue(enemyShipData.get(5));
		super.setSpriteLink(enemyShipData.get(6));
		super.setNumWeapons(enemyShipData.get(7));
		
		for (int i = 1; i <= getNumWeapons(); i++)
			super.addWeapons(enemyShipData.get(7+i));
		
		System.out.println(getEnemyID() + " spawned at " + this.currentRow + ", " + this.currentCol );
	}
	
	public void update1()
	{
		if(Main.model.crash(this.getCurrentRow(), this.getCurrentCol()) && this.getCurrentCol() < 10)
		   {
			   this.setDead(true);
		   }
		   if(Main.model.shot(this.getCurrentRow(), this.getCurrentCol()) && this.getCurrentCol() < 10)
		   {
			   this.setDead(true);
		   }
	}

	public void update() {
		
	   if (this.getCurrentCol() < 2){
		   this.setActive(false);
		   //collision set to false
	   }
	   if (this.isActive()){
		   this.prevCol = currentCol;
		   this.currentCol = currentCol-1;
		   System.out.println("Enemies left:" + Main.enemies.size());
		   System.out.println("Ship at:" +this.currentCol);
	   }
   }
	/**
	 * @return the pointValue
	 */
	public int getPointValue() {
		return pointValue;
	}
	/**
	 * @return the moneyValue
	 */
	public int getMoneyValue() {
		return moneyValue;
	}
	/**
	 * @return the numWeapons
	 */
	public int getNumWeapons() {
		return numWeapons;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the enemyID
	 */
	public String getEnemyID() {
		return enemyID;
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
	 * @param pointValue the pointValue to set
	 */
	public void setPointValue(int pointValue) {
		this.pointValue = pointValue;
	}
	/**
	 * @param moneyValue the moneyValue to set
	 */
	public void setMoneyValue(int moneyValue) {
		this.moneyValue = moneyValue;
	}
	/**
	 * @param currentRow the currentRow to set
	 */
	public void setCurrentRow(int currentRow) {
		this.currentRow = currentRow;
	}
	/**
	 * @param currentCol the currentCol to set
	 */
	public void setCurrentCol(int currentCol) {
		this.currentCol = currentCol;
	}
	/**
	 * @param pointValue the pointValue to set
	 */
	public void setPointValue(String pointValue) {
		this.pointValue = Integer.parseInt(pointValue);
	}
	/**
	 * @param moneyValue the moneyValue to set
	 */
	public void setMoneyValue(String moneyValue) {
		this.moneyValue = Integer.parseInt(moneyValue);
	}
	/**
	 * @param numWeapons the numWeapons to set
	 */
	public void setNumWeapons(String numWeapons) {
		this.numWeapons = Integer.parseInt(numWeapons);
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param enemyID the enemyID to set
	 */
	public void setEnemyID(String enemyID) {
		this.enemyID = enemyID;
	}
	/**
	 * @return the prevCol
	 */
	public int getPrevCol() {
		return prevCol;
	}

	/**
	 * @param prevCol the prevCol to set
	 */
	public void setPrevCol(int prevCol) {
		this.prevCol = prevCol;
	}

	/**
	 * @return the prevRow
	 */
	public int getPrevRow() {
		return prevRow;
	}

	/**
	 * @param prevRow the prevRow to set
	 */
	public void setPrevRow(int prevRow) {
		this.prevRow = prevRow;
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public boolean isDead() {
		return dead;
	}

	/**
	 * @param active the active to set
	 */
	public void setDead(boolean dead) {
		this.dead = dead;
	}
	
	
}//end class EnemyShip