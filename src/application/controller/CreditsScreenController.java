/**
 * This controls the credits screen fxml
 * 
 * @author wolfyCSA
 */

package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class CreditsScreenController implements EventHandler<ActionEvent>, Initializable {

	@FXML
    private Text text1, text2, text3, text4, text5, text6, text7;

    @FXML
    private Button mainMenu;
	
	@Override
	public void handle(ActionEvent event) {
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
		}//end try/catch
		
	}//end handle()

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		text1.setFont(Font.loadFont("file:data/font/Pixeled.ttf", 36));
		text2.setFont(Font.loadFont("file:data/font/Pixeled.ttf", 24));
		text3.setFont(Font.loadFont("file:data/font/Pixeled.ttf", 24));
		text4.setFont(Font.loadFont("file:data/font/Pixeled.ttf", 24));
		text5.setFont(Font.loadFont("file:data/font/Pixeled.ttf", 24));
		text6.setFont(Font.loadFont("file:data/font/Pixeled.ttf", 24));
		text7.setFont(Font.loadFont("file:data/font/Pixeled.ttf", 28));
	}//end initialize
	
}//end class CreditsScreenController