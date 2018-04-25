/**
 * 
 * @author wolfyCSA
 *
 */

package application.view;

import application.Main;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class LevelView extends GridPane{
	
	private int imgSize;
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
		this.add( chooseImage(" "), previousCol, previousRow );
	}
	
	public ImageView chooseImage(String code) {
		switch( code ) {
			case "p" : return getPlayerImage();
			case " " : return getDefaultImage();
			case "b" : return getDefaultImage();
			case "s" : return getBulletImage();
			case "e" : return getEnemyImage();
			default: return getDefaultImage();
		}//end switch
	}//end chooseImage()
	
	
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
	
	public ImageView getEnemyImage() {
		//TODO: update, to grab spriteLink from cortex entry
		ImageView img = new ImageView("File:test_sprites/test_enemy.png");
		img.setFitHeight(imgSize);
		img.setFitWidth(imgSize);
		return img;
	}//end getEnemyImage()
	
	public ImageView getDefaultImage() {
		//TODO: update, to grab spriteLink from cortex entry
		ImageView img = new ImageView("File:test_sprites/default.png");
		img.setFitHeight(imgSize);
		img.setFitWidth(imgSize);
		
		return img;
	}//end getDefaultImage()
	
}//end class LevelView