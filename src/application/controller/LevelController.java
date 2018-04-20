/**
 * 
 * 
 * @author wolfyCSA
 */

package application.controller;

import java.io.IOException;
import java.util.ArrayList;

import application.Main;
import application.model.EnemyShip;
import application.model.Level;
import application.view.LevelView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class LevelController implements EventHandler<KeyEvent> {

	

	@Override
	public void handle(KeyEvent event) {
		
		
		// get the user input
		char key = event.getCode().toString.charAt(0);
		//add move methods to the board.java, switch on key
		
		//TODO: move pacman based on input - MODEL
		Main.model.move( key );
		
		//TODO: update the view to show movement - VIEW
		
		
		//TODO: End game when reaches end - MODEL
		//		- switch level to Honest John's 
		boolean isOver = Main.model.isGameOver();
		
		// if is over, load next level(Honest John's)
		
	}//end handle()



	@FXML
	private GridPane gridPane;

	@FXML
	private ImageView g1x1;

	@FXML
	private ImageView g1x2;

	@FXML
	private ImageView g1x3;

	@FXML
	private ImageView g1x4;

	@FXML
	private ImageView g1x5;

	@FXML
	private ImageView g1x6;

	@FXML
	private ImageView g2x1;

	@FXML
	private ImageView g2x2;

	@FXML
	private ImageView g2x3;

	@FXML
	private ImageView g2x4;

	@FXML
	private ImageView g2x5;

	@FXML
	private ImageView g2x6;

	@FXML
	private ImageView g3x1;

	@FXML
	private ImageView g3x2;

	@FXML
	private ImageView g3x3;

	@FXML
	private ImageView g3x4;

	@FXML
	private ImageView g3x5;

	@FXML
	private ImageView g3x6;

	@FXML
	private ImageView g4x1;

	@FXML
	private ImageView g4x2;

	@FXML
	private ImageView g4x3;

	@FXML
	private ImageView g4x4;

	@FXML
	private ImageView g4x5;

	@FXML
	private ImageView g4x6;

	@FXML
	private ImageView g5x1;

	@FXML
	private ImageView g5x2;

	@FXML
	private ImageView g5x3;

	@FXML
	private ImageView g5x4;

	@FXML
	private ImageView g5x5;

	@FXML
	private ImageView g5x6;

	@FXML
	private ImageView g6x1;

	@FXML
	private ImageView g6x2;

	@FXML
	private ImageView g6x3;

	@FXML
	private ImageView g6x4;

	@FXML
	private ImageView g6x5;

	@FXML
	private ImageView g6x6;

	@FXML
	private ImageView g7x1;

	@FXML
	private ImageView g7x2;

	@FXML
	private ImageView g7x3;

	@FXML
	private ImageView g7x4;

	@FXML
	private ImageView g7x5;

	@FXML
	private ImageView g7x6;

	@FXML
	private ImageView g8x1;

	@FXML
	private ImageView g8x2;

	@FXML
	private ImageView g8x3;

	@FXML
	private ImageView g8x4;

	@FXML
	private ImageView g8x5;

	@FXML
	private ImageView g8x6;



}