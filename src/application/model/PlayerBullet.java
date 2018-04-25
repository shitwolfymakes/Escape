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
	   public boolean missileActive;
	   public double missilePositionX;
	   public double missilePositionY;
	   public double oldMissilePositionX;
	   public double oldMissilePositionY;
	   private String spriteLink = "data/test_sprites/Yello_Dot.png";
	   
	   public PlayerBullet() {
		   missileActive = true;
		   missilePositionX = Main.player.getCurrentRow()+1;
		   missilePositionY = Main.player.getCurrentCol();
		   //missile position will be updated during first move
		   oldMissilePositionX = 0;
		   oldMissilePositionY = 0;
	   }
	   
	   
}
