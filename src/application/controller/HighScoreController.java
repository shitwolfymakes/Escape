/**
 * This controls the high score screen fxml
 * 
 * @author wolfyCSA
 */
package application.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.Scanner;

import application.Main;
import application.model.PlayerProfile;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class HighScoreController implements Initializable {

	@FXML private ListView<String> scoreView;
	@FXML private Button 		   back, nameEnter;
	@FXML private TextField 	   name;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) { 
		displayHighScores();
	}//end initialize()
	
	/**
	 * Displays the high scores
	 */
	public void displayHighScores() {
		try {
			// Fill ListView with data.
			ObservableList<String> items = FXCollections.observableArrayList ();
			Scanner 			   scan  = new Scanner(new File("./data/highscores.txt"));
			
			while(scan.hasNextLine())
			{
				String line = scan.nextLine();
				String[] tokens = line.split(",");

				items.add(String.format("%-70s \t%s", tokens[0], tokens[1]));
				Collections.sort(items);
				Collections.reverse(items);
				scoreView.setItems(items);
			}//end while
			
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}//end try/catch
		
	}//end displayHighScores()

	/**
	 * Takes the player back to the main menu and loads a new player profile 
	 */
	public void back() {
		Main.profile = new PlayerProfile();
		Main.profile.setCurrentLevel(1);
		try {
			// Load the FXML document (we created with SceneBuilder)
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation( Main.class.getResource("../src/MainMenu.fxml") );

			// Load the layout from the FXML and add it to the scene
			AnchorPane layout = (AnchorPane) loader.load();				
			Scene scene = new Scene( layout );

			// Set the scene to stage and show the stage to the user
			Main.stage.setScene(scene);
		}catch( IOException e ) {
			e.printStackTrace();
		}//end try/catch
		
	}//end back()
	
    /**
     * loads information from highscores.txt. also adds the players high score to the listview
     */
	public void addName() {
		String str = String.format( "\n%d,%s", Main.profile.getPoints(), name.getText() );
		name.setText("");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("./data/highscores.txt", true));
			bw.write(str);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}//end try/catch
		
		displayHighScores();
	}//end addName()

}//end class highScoreController