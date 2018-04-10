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
import application.view.LevelView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Main extends Application {
	
	public static final Cortex cortex = new Cortex();  // hashmap object containing the data
													   // of everything in the game.
	public static Level model;						   // the model of the app
    public static LevelView view;					   // the view of the app

	@Override
	public void start(Stage primaryStage) {

		try {
			// load the fxml file we need
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation( Main.class.getResource("../MainMenu.fxml") );
			AnchorPane layout = (AnchorPane) loader.load();
							
			// Load the Board model 
			model = Level.parseLevel("File:levels/level1.txt");
			
			// Load the Level view
			view = new LevelView( model );
			layout.getChildren().add( view );
			Scene scene = new Scene( layout );
			
			// TODO: connect the controller!
			
			// Sets the scene to the stage & shows stage to user
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace(); // TODO: handle this better!
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
