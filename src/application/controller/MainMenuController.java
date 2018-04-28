/**
 * This controls the main menu
 * 
 * @author wolfyCSA
 */

package application.controller;

import java.io.IOException;

import application.Main;
import application.model.Level;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class MainMenuController implements EventHandler<Event>{

    @FXML private Button startButton, creditsButton, highScoreButton;
    
    /**
     * this loads a new level. starts the Level thread, bulletHandler thread, enemyHandler thread,
     * and collisionDetector.
     * 
     * @param event
     */
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
    /**
     * 
     * 
     * 
     * @event
     * 
     * loads the credits.fxml
     */
    @Override
	public void handle(Event event) {
    	try {
			// Load the FXML document (we created with SceneBuilder)
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation( HighScoreController.class.getResource("../../CreditsScreen.fxml") );

			// Load the layout from the FXML and add it to the scene
			AnchorPane layout = (AnchorPane) loader.load();				
			Scene scene = new Scene( layout );
						
			// Set the scene to stage and show the stage to the user
			Main.stage.setScene(scene);
		}catch( IOException e ) {
			e.printStackTrace();
		}
    }
    /**
     * loads the highschores.fxml
     * 
     * @param event
     */
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
