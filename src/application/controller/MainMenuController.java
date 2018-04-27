/**
 * 
 * 
 * @author wolfyCSA
 */

package application.controller;


import java.io.IOException;

import application.Main;
import application.model.BulletHandler;
import application.model.Level;
import application.model.PlayerBullet;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class MainMenuController implements EventHandler<Event>{

    @FXML
    private Button startButton;

    @FXML
    private Button loadButton;

    @FXML
    private Button highScoreButton;

    @FXML
    public void start(Event event) {

    	Main.model = new Level(1);
    	Main.startLevel();
    	//starts bullet controller thread
    	Main.bulletHandler.start();
    	Main.enemyHandler.start();
    	Main.collisionDetector.start();
    	
    	//memory overloads because I don't know how to kill the thread still :/
    }

    @Override
	public void handle(Event event) {
    	System.out.print("dink");
    }

    @FXML
    public void highScore(Event event) {
    	try {
			// Load the FXML document (we created with SceneBuilder)
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation( HighScoreController.class.getResource("../../HighScore.fxml") );

			// Load the layout from the FXML and add it to the scene
			AnchorPane layout = (AnchorPane) loader.load();				
			Scene scene = new Scene( layout );
						
			// Set the scene to stage and show the stage to the user
			Main.stage.setScene(scene);
		}catch( IOException e ) {
			e.printStackTrace();
		}
    }



}
