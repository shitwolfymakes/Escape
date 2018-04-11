/**
 * Program Purpose:
 * 		Escape! is the Boolean Boyz team project for the 
 * 		2018 Spring Semester of CS 3443.001
 * 
 * 
 * @author wolfyCSA
 */

package application;

import application.model.Cortex;
import application.model.Level;
import application.model.PlayerProfile;
import application.view.LevelView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Main extends Application {
	
	public static final Cortex cortex = new Cortex();  		  // hashmap object containing the data
													   		  // of everything in the game.
	public static PlayerProfile player = new PlayerProfile(); // player profile
	public static Level model;		   		  				  // the model of the app
    public static LevelView view;					   		  // the view of the app
	public static Stage stage;

	@Override
	public void start(Stage primaryStage) {
		
		stage = primaryStage;
		try {
			
			// load the fxml file we need
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation( Main.class.getResource("../MainMenu.fxml") );
			
			AnchorPane layout = (AnchorPane) loader.load();
			Scene scene = new Scene( layout );
			
			// Sets the stage to the scene & shows stage to user
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace(); // TODO: handle this better!
		}//end try/catch
		
	}//end start()
	
	public static void main(String[] args) {
		launch(args);
	}//end main()
	
}//end class Main