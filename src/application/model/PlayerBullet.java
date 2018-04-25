/**
 * 	When the player presses the fire button, a PlayerBullet object
 *  		is created. This Object stores the data on the bullet.
 *  
 * @author wolfyCSA
 */

package application.model;

import application.Main;

public class PlayerBullet {
	   public final int MAX_MISSILES = 10;
	   private boolean missileActive;

	private int currentRow;
	   private int currentCol;
	   private int prevRow;
	   private int prevCol;
	   private String spriteLink = "data/test_sprites/Yello_Dot.png";
	   
	   public PlayerBullet() {
		   missileActive = true;
		   currentRow = Main.player.getCurrentRow();
		   currentCol = Main.player.getCurrentCol()+1;
		   //missile position will be updated during first move
		   prevRow = currentRow;
		   prevCol = currentCol;
	   }
	   
	   /**
	    * The update method in PlayerBullet first checks if the position of the 
	    * bullet outside of boundaries, and deactivates bullet in this case.
	    * It then removes a bullet if it is not active. If bullet is not removed,
	    * it moves one to the right.
	    */
	   public void update() {
		   if (this.getCurrentCol() > Main.model.getCols()){
			   this.setMissileActive(false);
		   }
		   if (this.isMissileActive() == false) {
			   Main.removePlayerBullet(this);
		   }
		   this.prevCol = currentCol;
		   this.currentCol = currentCol+1;
		   //Main.view.updateBullet(this.currentRow, this.currentCol, this.prevRow, this.prevCol);
	   }
	   /**
	 * @return the missileActive
	 */
	
	
	public boolean isMissileActive() {
		return missileActive;
	}
	/**
	 * @param missileActive the missileActive to set
	 */
	public void setMissileActive(boolean missileActive) {
		this.missileActive = missileActive;
	}

	/**
	 * @return the currentRow
	 */
	public int getCurrentRow() {
		return currentRow;
	}

	/**
	 * @param currentRow the currentRow to set
	 */
	public void setCurrentRow(int currentRow) {
		this.currentRow = currentRow;
	}

	/**
	 * @return the currentCol
	 */
	public int getCurrentCol() {
		return currentCol;
	}

	/**
	 * @param currentCol the currentCol to set
	 */
	public void setCurrentCol(int currentCol) {
		this.currentCol = currentCol;
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
	 * @return the spriteLink
	 */
	public String getSpriteLink() {
		return spriteLink;
	}

	/**
	 * @param spriteLink the spriteLink to set
	 */
	public void setSpriteLink(String spriteLink) {
		this.spriteLink = spriteLink;
	}
	   
}
