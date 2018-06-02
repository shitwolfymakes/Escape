/**
 * Program Purpose:
 * 		Escape! is the Boolean Boyz team project for the 
 * 		2018 Spring Semester of CS 3443.001
 * 
 * @author indomichael, icekold736, CaseyCannon423, wolfyCSA, Mpoznecki
 */

package application;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import application.controller.LevelController;
import application.model.BulletHandler;
import application.model.CollisionDetector;
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
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class Main extends Application {
	
	public static Stage stage;
	public static final Cortex cortex = new Cortex();  		  // hashmap object containing the data
													   		  // of everything in the game.
	
	public static PlayerProfile profile = new PlayerProfile();    // player profile
	public static PlayerShip 	player 	= new PlayerShip(-1, -1); // player ship
	public static Level 		model 	= new Level();		      // the model of the app
    public static LevelView 	view 	= new LevelView();		  // the view of the app
    
    public static List<EnemyShip> 	  enemies = new ArrayList<EnemyShip>();
    public static List<PlayerBullet> playerBullets; 
	
	public static BulletHandler bulletHandler = new BulletHandler();
	public static EnemyHandler  enemyHandler  = new EnemyHandler();
	public static CollisionDetector collisionDetector = new CollisionDetector();
	
	public static Media gameMusic;
	public static MediaPlayer gameMusicPlayer;
	public static MediaView gameMusicMediaView;
	
	public static AudioClip bulletSound;
	public static AudioClip explosionSound;
	
	@Override
	public void start(Stage primaryStage) {
		
		Main.profile = new PlayerProfile();
		Main.profile.setCurrentLevel(1);
		stage = primaryStage;
		try {
			
			// load the fxml file we need
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation( Main.class.getResource("../MainMenu.fxml") );
			
			AnchorPane layout = (AnchorPane) loader.load();
			
			// adds music, once for each audio file to be played
			gameMusic = new Media(new File("data/music/Kevin_MacLeod_-_Ouroboros_-_Full_Mix.wav").toURI().toString());
			bulletSound = new AudioClip(new File("data/music/Photon gun shot.wav").toURI().toString());
			explosionSound = new AudioClip(new File("data/music/Explosion+3.wav").toURI().toString());
			
			// creates players for all the media
			gameMusicPlayer = new MediaPlayer(gameMusic);
			
			//needs to be added as a view
			gameMusicMediaView = new MediaView(gameMusicPlayer);
			
			// add music to the layout
			layout.getChildren().add(gameMusicMediaView);
			
			Scene scene = new Scene( layout );
			
			// Sets the stage to the scene & shows stage to user
			primaryStage.setScene(scene);
			primaryStage.show();
			
			gameMusicPlayer.setCycleCount(MediaPlayer.INDEFINITE);
			startMusic();
		} catch(Exception e) {
			e.printStackTrace(); 
		}//end try/catch
		
	}//end start()
	
	public void startMusic() {
		gameMusicPlayer.play();
	}
	
	/**
	 * This method starts the level
	 */
	public static void startLevel() {
		Main.model = new Level(Main.profile.getCurrentLevel());
		//Main.model = new Level(1);
		Main.player.setCurrentLocation(3, 1);
		
		// could probably move this into Level.java
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
	
	/**
	 * @param b bullet to be added to the bullet list
	 */
	public static void addPlayerBullet(PlayerBullet b) {
		playerBullets.add(b);
		System.out.println(playerBullets);
	}
	
	/**
	 * @param b bullet to be removed from the bullet list
	 */
	public static void removePlayerBullet(PlayerBullet b) {
		playerBullets.remove(b);
		System.out.println(playerBullets);
	}
	
	/**
	 * @param e enemy to be removed from the enemy list
	 */
	public static void removeEnemy(EnemyShip e) {
		enemies.remove(e);
	}
	
	/**
	 * This method switches the view to Honest John's
	 */
	public static void startHonestJohn() {
		try {
			// Load the fxml file we need
			FXMLLoader loader = new FXMLLoader();
			
			// The ../ is important to get the location in the directory structure
			//  otherwise it throws IllegalStateException
			loader.setLocation( Main.class.getResource("../Market.fxml") );
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