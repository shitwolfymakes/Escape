package application.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.Scanner;

import application.Main;
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

public class HighScoreController implements Initializable{

    @FXML
    private ListView<String> scoreView;
    
    @FXML
    private Button back;
    
    @FXML
    private TextField name;
    
    ArrayList<String> scoreTest = new ArrayList<String>();
    
	Scanner scan;
    
    
    
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) { 
		
		
		
		
		// TODO Will fill ListView with data.
		ObservableList<String> items =FXCollections.observableArrayList ();
		try 
		{
			scan = new Scanner(new File("data/highscores.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(scan.hasNextLine())
		{
			String line = scan.nextLine();
			String[] tokens = line.split(",");
			
			
			
			items.add(String.format("%-70s \t%s", tokens[0], tokens[1]));
			Collections.sort(items);
			Collections.reverse(items);
			scoreView.setItems(items);
		}
				
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
