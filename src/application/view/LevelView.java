/**
 * The view places the sprites onto the GridPane and moves them around the map
 * 
 * @author indomichael, icekold736, CaseyCannon423, wolfyCSA, Mpoznecki
 *
 */

package application.view;

import application.Main;
import application.model.EnemyShip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class LevelView extends GridPane{
	
	private int imgSize;
	
	public LevelView() {
		imgSize = 100;
	}//end LevelView() 

	/**
	 * Populates the GridPane with ImageViews
	 */
	public void setUpView() {
		
		for( int r=0; r<Main.model.getRows(); r++ ) {
			for( int c=0; c<Main.model.getCols(); c++ ) {
				String code = Main.model.getLevelLocation(r,c);
				
				if (code.equals("p"))
					Main.player.setCurrentLocation(r, c);
				
				ImageView img = chooseImage( code );
				
				this.add( img, c, r );
			}//end inner for
		}//end outer for
	}//end setUpView()
	
	/**
	 * Moves the player ship to the new coordinates given as parameters. 
	 * 	Replaces the previous sprite with a black shadow 
	 * 
	 * @param currentRow player current row
	 * @param currentCol player current column
	 * @param previousRow player previous row
	 * @param previousCol player previous col
	 */
	public void update( int currentRow, int currentCol, int previousRow, int previousCol ) {
		this.add( chooseImage("p"), currentCol, currentRow );
		this.add( chooseImage("d"), previousCol, previousRow );
	}//end update()
	
	/**
	 * Removes the enemy from the GridPane by replacing the ship with a black shadow
	 * 
	 * @param currentRow enemy current row
	 * @param currentCol enemy current column
	 */
	public void removeEnemy(int currentRow, int currentCol) {
		this.add( chooseImage("j"), currentCol, currentRow );
	}//end removeEnemy()
	
	/**
	 * Moves the bullets one GridPane. replaces previous bullet with a black shadow
	 * 
	 * @param currentRow bullet current row
	 * @param currentCol bullet current column
	 * @param previousRow bullet previous row
	 * @param previousCol bullet previous column
	 */
	public void updateBullet( int currentRow, int currentCol, int previousRow, int previousCol ) {
		this.add( chooseImage("s"), currentCol, currentRow );
		this.add( chooseImage("v"), previousCol, previousRow );
	}//end updateBullet()
	
	/**
	 * Moves the enemy one GridPane. replaces the image with a black ship.
	 * 
	 * @param currentRow enemy current row
	 * @param currentCol enemy current column
	 * @param previousRow enemy previous row
	 * @param previousCol enemy previous column
	 * @param e the enemy
	 */
	public void updateEnemy(int currentRow, int currentCol, int previousRow, int previousCol, EnemyShip e) {
		this.add( chooseEnemyImage(e), currentCol, currentRow );
		
		if (e.getSpriteLink().equals("data/Escape Sprites/level1enemy.png"))
			this.add( chooseImage("j"), previousCol, previousRow );
		else this.add( chooseImage("m"), previousCol, previousRow );
	}//end updateEnemy()
	
	/**
	 * Replaces the enemy sprite with an exploding ship
	 * 
	 * @param currentRow enemy current row
	 * @param currentCol enemy current column
	 * @param e the enemy
	 */
	public void killEnemy(int currentRow, int currentCol, EnemyShip e) {
		if (e.getSpriteLink().equals("data/Escape Sprites/level1enemy.png"))
			this.add( chooseImage("k"), currentCol, currentRow );
		else this.add( chooseImage("u"), currentCol, currentRow );
	}//end killEnemy()
	
	/**
	 * picks an image based on the code passed as an arg 
	 * @param code the string at the grid location
	 * @return ImageView the image chosen
	 *
	 */
	public ImageView chooseImage(String code) {
		switch( code ) {
			case "p" : return getPlayerImage();
			case " " : return getDefaultImage();
			case "d" : return getBlackShipImage();
			case "b" : return getDefaultImage();
			case "s" : return getBulletImage();
			case "v" : return getBlackImage();
			case "j" : return getBlackEnemy1Image();
			case "k" : return getExplodingEnemy1Image();
			case "u" : return getExplodingEnemy2Image();
			case "m" : return getBlackEnemy2Image();
			default: return getDefaultImage();
		}//end switch
	}//end chooseImage()
	
	/**
	 * Picks the enemy ship to spawn
	 * 
	 * @param eShip the enemy ship
	 * @return the image view we need
	 */
	public ImageView chooseEnemyImage(EnemyShip eShip) {
		ImageView img = new ImageView("File:" + eShip.getSpriteLink());
		img.setFitHeight(imgSize);
		img.setFitWidth(imgSize);
		return img;
	}//end chooseEnemyImage()
	
	/**
	 * Grabs the image of the player
	 * 
	 * @return ImageView
	 */
	public ImageView getPlayerImage() {
		ImageView img = new ImageView("File:data/Escape Sprites/playership.png");
		img.setFitHeight(imgSize);
		img.setFitWidth(imgSize);
		return img;
	}//end getPlayerImage()
	
	/**
	 * Gets the bullet image
	 * 
	 * @return ImageView
	 */
	public ImageView getBulletImage() {
		ImageView img = new ImageView("File:data/test_sprites/Yello_Dot.png");
		img.setFitHeight(imgSize);
		img.setFitWidth(imgSize);
		return img;
	}//end getBulletImage()
	
	/**
	 * Gets the shadow of the players ship
	 * 
	 * @return ImageView
	 */
	public ImageView getBlackShipImage(){
		ImageView img = new ImageView("File:data/Escape Sprites/playership_black.png");
		img.setFitHeight(imgSize);
		img.setFitWidth(imgSize);
		return img;
	}//end getBlackShipImage()
	
	/**
	 * Gets the default image
	 * 
	 * @return  ImageView
	 */
	public ImageView getDefaultImage() {
		ImageView img = new ImageView("File:data/test_sprites/default.png");
		img.setFitHeight(imgSize);
		img.setFitWidth(imgSize);
		return img;
	}//end getDefaultImage()
	
	/**
	 * Gets the shadow of the bullet
	 * 
	 * @return ImageView
	 */
	public ImageView getBlackImage() {
		ImageView img = new ImageView("File:data/test_sprites/Black_Dot.png");
		img.setFitHeight(imgSize);
		img.setFitWidth(imgSize);
		return img;
	}//end getBlackImage()
	
	/**
	 * Gets the shadow of the level1 enemy1 ship
	 * 
	 * @return ImageView
	 */
	public ImageView getBlackEnemy1Image() {
		ImageView img = new ImageView("File:data/Escape Sprites/level1enemy_black.png");
		img.setFitHeight(imgSize);
		img.setFitWidth(imgSize);		
		return img;
	}//end getBlackEnemy1Image()
	
	/**
	 * Gets the shadow of the enemy2 ship
	 * 
	 * @return the ImageView
	 */
	public ImageView getBlackEnemy2Image() {
		ImageView img = new ImageView("File:data/Escape Sprites/level2enemy_black.png");
		img.setFitHeight(imgSize);
		img.setFitWidth(imgSize);		
		return img;
	}//end getBlackEnemy2Image()
	
	/**
	 * Gets the image of the exploding level one ship
	 * 
	 * @return ImageView
	 */
	public ImageView getExplodingEnemy1Image() {
		ImageView img = new ImageView("File:data/Escape Sprites/explodinglvl1enemy.png");
		img.setFitHeight(imgSize);
		img.setFitWidth(imgSize);		
		return img;
	}//end getExplodingEnemy1Image()
	
	/**
	 * Gets the image of the exploding level 2 ship
	 * 
	 * @return ImageView
	 */
	public ImageView getExplodingEnemy2Image() {
		ImageView img = new ImageView("File:data/Escape Sprites/explodinglevel2enemy.png");
		img.setFitHeight(imgSize);
		img.setFitWidth(imgSize);		
		return img;
	}//end getExplodingEnemy2Image()

}//end class LevelView