/**
 * 
 * @author wolfyCSA
 *
 */

package application.view;

import application.model.Level;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class LevelView extends GridPane{

	private Level model;
	private int imgSize;
	
	public LevelView( Level model ) {
		this.model = model;
	}
	
	// TODO: create the other getter methods 
	
	public ImageView chooseImage(char letter) {
		switch( letter ) {
			case 'c' : return getPlayerImage();
			default: return getDefaultImage();
		}
	}
	
	
	public ImageView getPlayerImage() {
		ImageView img = new ImageView("File:test_sprites/test_player.png");
		img.setFitHeight(imgSize);
		img.setFitWidth(imgSize);
		return img;
	}
	
	public ImageView getBulletImage() {
		ImageView img = new ImageView("File:test_sprites/test_bullet.png");
		img.setFitHeight(imgSize);
		img.setFitWidth(imgSize);
		return img;
	}
	
	public ImageView getEnemyImage() {
		ImageView img = new ImageView("File:test_sprites/test_enemy.png");
		img.setFitHeight(imgSize);
		img.setFitWidth(imgSize);
		return img;
	}
	
	public ImageView getDefaultImage() {
		ImageView img = new ImageView("File:test_sprites/default.png");
		img.setFitHeight(imgSize);
		img.setFitWidth(imgSize);
		return img;
	}
	
}
