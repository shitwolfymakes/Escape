/**
 * 
 * 
 * @author wolfyCSA
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
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
	//Thread th;

	@FXML ImageView background1, background2;

	/**
	 * The handle function in LevelController effectively acts as a listener for 
	 * key presses.
	 * @param event
	 */
	@Override
	public void handle(KeyEvent event) {

		// TODO: add logic to check if key pressed is a function key

		// get the user input
		char key = event.getCode().toString().charAt(0);
		System.out.println(key);

		// move player based on input - MODEL
		if (event.getCode() != KeyCode.SPACE)	{
			Main.model.move( key );
			// update the view to show movement - VIEW
			Main.view.update(Main.model.getCurrentRow(), Main.model.getCurrentColumn(), Main.model.getPreviousRow(), Main.model.getPreviousColumn());
			//System.out.println(""+key);
		} else if (event.getCode() == KeyCode.SPACE) {
			PlayerBullet b = new PlayerBullet();
			if (Main.playerBullets.size() < 10) {
				Main.addPlayerBullet(b);	
			}
			
		}
		//else fire bullet

		//TODO: End game when reaches end - MODEL
		//		- switch level to Honest John's 
		boolean isOver = Main.model.isLevelOver();
		if (isOver)
			Main.startHonestJohn();

	}//end handle()

	@Override
	public void initialize(URL url, ResourceBundle resources) {
		if (runNum == 0) {
			running = true;
			runUpdates();
			initializeBackground();	
		}
		runNum++;
	}//end initialize()

	/**
	 * @param none
	 * @return none
	 * 
	 * this method sets up the scrolling background for the level
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

	public void runUpdates() {
		//seconds = 30;

		Thread th = new Thread( new Task<Object>() {                // put the task in its own thread

			@Override
			protected String call() throws Exception {
				String score = "";	
				String hull = "";
				//String status3 = "";
				//PlayerBullet bullet;
				//Image image = new Image("File:" + bullet.getSpriteLink());
				while (running) {	
					score =  "Score:"+(Main.profile.getPoints()) ;
					hull = "Hull Points Remaining:"+(Main.player.getHullPoints());

					final String fscore = score;
					final String fhull = hull;
					//final String fstat3 = status3;
					//final Image istat = image;
					
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
									//Main.view.killEnemy(e.getCurrentRow(), e.getCurrentCol());	
									Main.view.removeEnemy(e.getCurrentRow(), e.getCurrentCol());
									Main.removeEnemy(e);
								}//end if
								if (e.isDead()){	 
									Main.view.killEnemy(e.getCurrentRow(), e.getCurrentCol());	
									//Main.view.removeEnemy(e.getCurrentRow(), e.getCurrentCol());
									Main.removeEnemy(e);
								}//end if
							}//end for

							hullLabel.setText("TEST");
							scoreLabel.setText(fscore);
							if(Main.model.isLevelOver()) {
								running = false;
								Main.profile.setCurrentLevel(Main.profile.getCurrentLevel() +1);
									try {

										FXMLLoader loader = new FXMLLoader();
										loader.setLocation( HighScoreController.class.getResource("../../HonestJohns.fxml"));

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
									loader.setLocation( HighScoreController.class.getResource("../../DeathScreen.fxml"));

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