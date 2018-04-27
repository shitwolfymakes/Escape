/**
 * 
 * @author wolfyCSA
 *
 */

package application.view;

import application.Main;
import application.model.EnemyShip;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class LevelView extends GridPane{
	
	
	private int imgSize;
	//private ImageView lastImg;
	//private Node lastNode;
	public LevelView() {
		imgSize = 100;
		
		//this.setUpView();
	}

	// TODO: create the other getter methods 
	// TODO: find a way to get this to update the view
	
	public void setUpView() {
		
		for( int r=0; r<Main.model.getRows(); r++ ) {
			for( int c=0; c<Main.model.getCols(); c++ ) {
				// board[r][c] 
				
				String code = Main.model.getLevelLocation(r,c);
				if (code.equals("p")) {
					Main.player.setCurrentLocation(r, c);
				}
				ImageView img = chooseImage( code );
				//System.out.println(""+r+","+c+code);
				this.add( img, c, r );
			}
		}
	}
	
	public void update( int currentRow, int currentCol, int previousRow, int previousCol ) {
		this.add( chooseImage("p"), currentCol, currentRow );
		this.add( chooseImage("d"), previousCol, previousRow );

	}
	
	public void removeEnemy(int currentRow, int currentCol) {
		this.add( chooseImage("j"), currentCol, currentRow );
	}
	
	
	public void updateBullet( int currentRow, int currentCol, int previousRow, int previousCol ) {
		this.add( chooseImage("s"), currentCol, currentRow );
		this.add( chooseImage("v"), previousCol, previousRow );
	}
	
	public void updateEnemy(int currentRow, int currentCol, int previousRow, int previousCol, EnemyShip e) {
		this.add( chooseEnemyImage(e), currentCol, currentRow );
		if (e.getSpriteLink().equals("data/Escape Sprites/level1enemy.png")) {
			this.add( chooseImage("j"), previousCol, previousRow );
		} else {
			this.add(chooseImage("m"), previousCol, previousRow);
		}
	}
	public void killEnemy(int currentRow, int currentCol) {
		this.add( chooseImage("k"), currentCol, currentRow );
	}
	
	public ImageView chooseImage(String code) {
		switch( code ) {
			case "p" : return getPlayerImage();
			case " " : return getDefaultImage();
			case "d" : return getBlackShipImage();
			case "b" : return getDefaultImage();
			case "s" : return getBulletImage();
			case "v" : return getBlackImage();
			case "j" : return getBlackEnemy1Image();
			case "k" : return getExplodinglvl1Image();
			case "m" : return getBlackEnemy2Image();
			default: return getDefaultImage();
		}//end switch
	}//end chooseImage()
	
	public ImageView chooseEnemyImage(EnemyShip eShip) {
		ImageView img = new ImageView("File:" + eShip.getSpriteLink());
		img.setFitHeight(imgSize);
		img.setFitWidth(imgSize);
		return img;
	}
	
	public ImageView getPlayerImage() {
		//TODO: update, to grab spriteLink from profile object
		ImageView img = new ImageView("File:data/Escape Sprites/playership.png");
		img.setFitHeight(imgSize);
		img.setFitWidth(imgSize);
		return img;
	}//end getPlayerImage()
	
	public ImageView getBulletImage() {
		//TODO: update, to grab spriteLink from cortex entry
		ImageView img = new ImageView("File:data/test_sprites/Yello_Dot.png");
		img.setFitHeight(imgSize);
		img.setFitWidth(imgSize);
		return img;
	}//end getBulletImage()
	
	public ImageView getBlackShipImage(){
		ImageView img = new ImageView("File:data/Escape Sprites/playership_black.png");
		img.setFitHeight(imgSize);
		img.setFitWidth(imgSize);
		return img;
	}
	
	public ImageView getDefaultImage() {
		//TODO: update, to grab spriteLink from cortex entry
		ImageView img = new ImageView("File:data/test_sprites/default.png");
		img.setFitHeight(imgSize);
		img.setFitWidth(imgSize);
		
		return img;
	}//end getDefaultImage()
	
	public ImageView getBlackImage() {
		//TODO: update, to grab spriteLink from cortex entry
		ImageView img = new ImageView("File:data/test_sprites/Black_Dot.png");
		img.setFitHeight(imgSize);
		img.setFitWidth(imgSize);
		
		return img;
	}//end getDefaultImage()
	
	public ImageView getBlackEnemy1Image() {
		//TODO: update, to grab spriteLink from cortex entry
		ImageView img = new ImageView("File:data/Escape Sprites/level1enemy_black.png");
		img.setFitHeight(imgSize);
		img.setFitWidth(imgSize);		
		return img;
	}//end getDefaultImage()
	
	public ImageView getBlackEnemy2Image() {
		//TODO: update, to grab spriteLink from cortex entry
		ImageView img = new ImageView("File:data/Escape Sprites/level2enemy_black.png");
		img.setFitHeight(imgSize);
		img.setFitWidth(imgSize);		
		return img;
	}//end getDefaultImage()
	
	public ImageView getExplodinglvl1Image() {
		//TODO: update, to grab spriteLink from cortex entry
		ImageView img = new ImageView("File:data/Escape Sprites/explodinglvl1enemy.png");
		img.setFitHeight(imgSize);
		img.setFitWidth(imgSize);		
		return img;
	}//end getDefaultImage()
	
	
}//end class LevelView