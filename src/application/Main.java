/**
 * Program Purpose:
 * 		Escape! is the Boolean Boyz team project for the 
 * 		2018 Spring Semester of CS 3443.001
 * 
 * 
 * @author wolfyCSA
 */

package application;

import java.util.ArrayList;

import application.controller.LevelController;
import application.model.BulletHandler;
import application.model.Cortex;
import application.model.EnemyHandler;
import application.model.EnemyShip;
import application.model.Level;
import application.model.PlayerBullet;
import application.model.PlayerProfile;
import application.model.PlayerShip;
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
	
	public static Stage stage;
	public static final Cortex cortex = new Cortex(); // hashmap object containing the data
													  // of everything in the game.
	
	public static PlayerProfile profile 	  = new PlayerProfile();    // player profile
	public static Level 		model	      = new Level();		   	// the model of the app
    public static LevelView 	view 		  = new LevelView();		// the view of the app
	public static PlayerShip 	player 		  = new PlayerShip(-1, -1);
	public static BulletHandler bulletHandler = new BulletHandler();
	public static EnemyHandler 	enemyHandler  = new EnemyHandler();
	
	public static ArrayList<EnemyShip>    enemies       = new ArrayList<EnemyShip>();
    public static ArrayList<PlayerBullet> playerBullets;

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
		Main.player.setCurrentLocation(3, 1);
		
		enemies = Main.model.collectEnemies();
		System.out.println("");
		playerBullets = new ArrayList<PlayerBullet>();
		
		// all this should be moved to Main.startLevel()
		try {
			// load the fxml file we need
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation( Main.class.getResource("../Level.fxml") );
			AnchorPane layout = (AnchorPane) loader.load();

			// Load the Level view
			//Main.view = new LevelView( Main.model );
			Main.view = new LevelView();
			Main.view.setUpView();
			layout.getChildren().add( Main.view );
			Scene scene = new Scene( layout );
			
			// connects the controller
			scene.setOnKeyPressed( new LevelController() );

			// Sets the scene to the stage & shows stage to the user
			Main.stage.setScene(scene);
		} catch(Exception e) {
			e.printStackTrace();
		}//end try/catch
			
	}//end startLevel()
	
	public static void addPlayerBullet(PlayerBullet b) {
		playerBullets.add(b);
		System.out.println(playerBullets);
	}
	
	public static void removePlayerBullet(PlayerBullet b) {
		playerBullets.remove(b);
		System.out.println(playerBullets);
	}
	
	public static void removeEnemy(EnemyShip e) {
		enemies.remove(e);
	}
	
	public static void startHonestJohn() {
		try {
			// Load the fxml file we need
			FXMLLoader loader = new FXMLLoader();
			
			// The ../ is important to get the location in the directory structure
			//  otherwise it throws IllegalStateException
			loader.setLocation( Main.class.getResource("../HonestJohns.fxml") );
			AnchorPane layout = (AnchorPane) loader.load();
			Scene scene = new Scene( layout );

			// Sets the scene to the stage & shows stage to the user
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}//end startHonestJohn
	
	public static void main(String[] args) {
		launch(args);
	}//end main()
	
}//end class Main