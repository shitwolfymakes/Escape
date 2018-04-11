package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

public class HighScoreController implements Initializable{

    @FXML
    private ListView<String> scoreView;
    
    @FXML
    private Button back;
    
    ArrayList<String> scoreTest = new ArrayList<String>();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Will fill ListView with data.
		scoreTest.add(String.format("%-10s %100d","ToddRogers", 999999));
		scoreTest.add(String.format("%-10s %100d","HonestJoe123", 1500));
		scoreTest.add(String.format("%-10s %100d","flaminIndo", 1250));
		scoreView.setItems(FXCollections.observableArrayList(scoreTest));
		
	}
	
	public void back() {
		try {
			// Load the FXML document (we created with SceneBuilder)
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation( MainMenuController.class.getResource("../../MainMenu.fxml") );

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
