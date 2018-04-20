/**
 * Program Purpose:
 * 		Escape! is the Boolean Boyz team project for the 
 * 		2018 Spring Semester of CS 3443.001
 * 
 * 
 * @author wolfyCSA
 */

package application;

import java.io.File;
import java.util.ArrayList;

import application.controller.LevelController;
import application.model.Cortex;
import application.model.EnemyShip;
import application.model.Level;
import application.model.PlayerProfile;
import application.view.LevelView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class Main extends Application {
	
	public static final Cortex cortex = new Cortex();  		  // hashmap object containing the data
													   		  // of everything in the game.
	public static PlayerProfile player = new PlayerProfile(); // player profile
	public static Level model;		   		  				  // the model of the app
    public static LevelView view = new LevelView();			  // the view of the app
    public static ArrayList<EnemyShip> enemies = new ArrayList<EnemyShip>();
	public static Stage stage;

	@Override
	public void start(Stage primaryStage) {
		
		stage = primaryStage;
		try {
			
			// load the fxml file we need
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation( Main.class.getResource("../MainMenu.fxml") );
			
			AnchorPane layout = (AnchorPane) loader.load();
			
			// adds music, once for each audio file to be played
			//Media media = new Media(new File("<theme song>").toURI().toString());
			//MediaPlayer player = new MediaPlayer(media);
			//needs to be added as a view
			//MediaView mediaView = new MediaView(player);
			//layout.getChildren().add(mediaView);
			
			Scene scene = new Scene( layout );
			
			
			
			// Sets the stage to the scene & shows stage to user
			primaryStage.setScene(scene);
			primaryStage.show();
			
			//player.play();
			
			
		} catch(Exception e) {
			e.printStackTrace(); // TODO: handle this better!
		}//end try/catch
		
	}//end start()
	
	public static void startLevel() {
		// could probably move this into Level.java
		Main.model = new Level( Main.player.getCurrentLevel() );
		enemies = Main.model.collectEnemies();
		
		// all this should be moved to Main.startLevel()
		try {
			// load the fxml file we need
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation( Main.class.getResource("Level.fxml") );
			AnchorPane layout = (AnchorPane) loader.load();

			// Load the Level view
			//Main.view = new LevelView( Main.model );
			Main.view = new LevelView();
			layout.getChildren().add( Main.view );
			Scene scene = new Scene( layout );
			
			// connects the controller
			scene.setOnKeyPressed( new LevelController() );

			// Sets the scene to the stage & shows stage to the user
			Main.stage.setScene(scene);
		} catch(Exception e) {
			e.printStackTrace();
		}//end try/catch
		
		// move all enemies to the left once per second
		while (enemies.size() > 0)
		{
			try {
				Thread.sleep(1000);

				for ( EnemyShip e : enemies ) {
					// need an isTileOccupied()

					if (e.getCurrentCol() == 11) {
						// jumping the barrier
						Main.model.enemyJumpBarrier(e);
					} else if ( e.getCurrentCol() < 10 )
						continue;
					else Main.model.updateEnemyLocation(e);
				}//end for

			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}//end try/catch
			
		}//end while
		
	}//end startLevel()
	
	public static void startHonestJohn() {
		
	}//end startHonestJohn
	
	public static void main(String[] args) {
		launch(args);
	}//end main()
	
}//end class Main