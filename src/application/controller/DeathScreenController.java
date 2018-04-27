package application.controller;

import java.io.IOException;

import application.Main;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class DeathScreenController implements EventHandler<Event>{

    @FXML
    private Button highScores;


    @Override
    public void handle(Event event) {
    	try {
			// Load the FXML document (we created with SceneBuilder)
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(DeathScreenController.class.getResource("../../HighScores.fxml") );

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

