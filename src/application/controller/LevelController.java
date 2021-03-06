/**
 * This class is the controller for level. It produces the main javafx thread.
 * It also loads the scrolling background for the game.
 * 
 * @author indomichael, icekold736, CaseyCannon423, wolfyCSA, Mpoznecki
 *
 */

package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.model.EnemyShip;
import application.model.PlayerBullet;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class LevelController implements EventHandler<KeyEvent>, Initializable {

	private boolean running = true;
	private int BACKGROUND_WIDTH = 2000;
	private int runNum = 0;
	public ParallelTransition parallelTransition;

	@FXML
	private Label hullLabel;

	@FXML
	private Label scoreLabel;	

	@FXML ImageView background1, background2;

	/**
	 * The handle function in LevelController effectively acts as a listener for 
	 * key presses.
	 * 
	 * @param event the event to be handled
	 */
	@Override
	public void handle(KeyEvent event) {
		// get the user input
		char key = event.getCode().toString().charAt(0);
		System.out.println(key);

		// move player based on input - MODEL
		if (event.getCode() != KeyCode.SPACE)	{
			Main.model.move( key );
			// update the view to show movement - VIEW
			Main.view.update(Main.model.getCurrentRow(), 
							 Main.model.getCurrentColumn(), 
							 Main.model.getPreviousRow(), 
							 Main.model.getPreviousColumn());
		} else if (event.getCode() == KeyCode.SPACE) {
			PlayerBullet b = new PlayerBullet();
			Main.bulletSound.play();
			if (Main.playerBullets.size() < 10) {
				Main.addPlayerBullet(b);	
			}
			
		}// end if

		// End game when reaches end - MODEL
		//		- switch level to Honest John's 
		boolean isOver = Main.model.isLevelOver();
		if (isOver) {
			if (Main.profile.getCurrentLevel() == 10)
			{
				try {
					// Load the fxml file we need
					FXMLLoader loader = new FXMLLoader();
					
					// The ../ is important to get the location in the directory structure
					//  otherwise it throws IllegalStateException
					loader.setLocation( Main.class.getResource("../src/HighScores.fxml") );
					AnchorPane layout = (AnchorPane) loader.load();
					Scene scene = new Scene( layout );

					// Sets the scene to the stage & shows stage to the user
					Main.stage.setScene(scene);
					Main.stage.show();
				} catch(Exception e) {
					e.printStackTrace();
				}//end try/catch
				
			}//end inner if
			Main.startHonestJohn();
		}//end outer if
	}//end handle()
	
	/**
	 * This method loads the thread and the scrolling background.
	 * 
	 * @param url, resources
	 */
	@Override
	public void initialize(URL url, ResourceBundle resources) {
		hullLabel.setFont(Font.loadFont("file:data/font/Pixeled.ttf", 15));
		scoreLabel.setFont(Font.loadFont("file:data/font/Pixeled.ttf", 15));
		if (runNum == 0) {
			running = true;
			runUpdates();
			initializeBackground();	
		}
		runNum++;
	}//end initialize()

	/**
	 * This method sets up the scrolling background for the level
	 */
	public void initializeBackground() {

		TranslateTransition translateTransition =
				new TranslateTransition(Duration.millis(10000), background1);

		translateTransition.setFromX(0);
		translateTransition.setToX(-1 * BACKGROUND_WIDTH);
		translateTransition.setInterpolator(Interpolator.LINEAR);

		TranslateTransition translateTransition2 =
				new TranslateTransition(Duration.millis(10000), background2);

		translateTransition2.setFromX(0);
		translateTransition2.setToX(-1 * BACKGROUND_WIDTH);
		translateTransition2.setInterpolator(Interpolator.LINEAR);

		parallelTransition =  
				new ParallelTransition(translateTransition, translateTransition2);

		parallelTransition.setCycleCount(Animation.INDEFINITE);
		parallelTransition.play();
	}//end initializeBackground()
	
	/**
	 * runUpdates() is the main thread that updates the javaFX document
	 */
	public void runUpdates() {

		// put the task in its own thread
		Thread th = new Thread( new Task<Object>() {

			@Override
			protected String call() throws Exception {
				String score = "";
				while (running) {	
					score =  "Score:"+(Main.profile.getPoints()) ;

					final String fscore = score;
					
					// update the label on the JavaFx Application Thread!
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							for (PlayerBullet b : Main.playerBullets.toArray(new PlayerBullet[Main.playerBullets.size()])) {
								Main.view.updateBullet(b.getCurrentRow(), b.getCurrentCol(), b.getPrevRow(), b.getPrevCol());
							}//end for
							for (EnemyShip e : Main.enemies.toArray(new EnemyShip[Main.enemies.size()])) {

								if (e.getCurrentCol()<10)
								{
									Main.view.updateEnemy(e.getCurrentRow(), e.getCurrentCol(), e.getPrevRow(), e.getPrevCol(), e);
								}//end if
								if (!e.isActive()){	 	
									Main.view.removeEnemy(e.getCurrentRow(), e.getCurrentCol());
									Main.removeEnemy(e);
								}//end if
								if (e.isDead()){
									
									Main.view.killEnemy(e.getCurrentRow(), e.getCurrentCol(), e);	
									Main.explosionSound.play();
									Main.removeEnemy(e);
								}//end if
							}//end for
							String levelNum = String.format("Level: %d", Main.profile.getCurrentLevel());
							hullLabel.setText(levelNum);
							scoreLabel.setText(fscore);
							if(Main.model.isLevelOver()) {
								running = false;
								Main.profile.setCurrentLevel(Main.profile.getCurrentLevel() +1);
									try {

										FXMLLoader loader = new FXMLLoader();
										loader.setLocation(Main.class.getResource("../src/HonestJohns.fxml"));

										AnchorPane layout = (AnchorPane) loader.load();				
										Scene scene = new Scene( layout );

										Main.stage.setScene(scene);
									}catch( IOException e ) {
										e.printStackTrace();
									}//end try/catch
								
							}
							if(Main.player.isDead()==true) {
								try {
									running = false;
									Main.enemies.clear();
									FXMLLoader loader = new FXMLLoader();
									loader.setLocation(Main.class.getResource("../src/DeathScreen.fxml"));

									AnchorPane layout = (AnchorPane) loader.load();				
									Scene scene = new Scene( layout );

									Main.stage.setScene(scene);
								}catch( IOException e ) {
									e.printStackTrace();
								}//end try/catch
							}

						}//end run()
					});
					Thread.sleep(100);

				}//end while(running)
				return null;
			}//end call()

		});
		th.setDaemon(true);									
		th.start();

	}//end runUpdates()

}//end class LevelController