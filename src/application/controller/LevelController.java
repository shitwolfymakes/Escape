/**
 * 
 * 
 * @author wolfyCSA
 */

package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

public class LevelController implements EventHandler<KeyEvent>, Initializable {
	
	private int BACKGROUND_WIDTH = 2000;
	public ParallelTransition parallelTransition;
	
	@FXML ImageView background1, background2;
	

	
	@Override
	public void handle(KeyEvent event) {
		
		// TODO: add logic to check if key pressed is a function key
		
		// get the user input
		char key = event.getCode().toString().charAt(0);
		//add move methods to the board.java, switch on key
		
		//TODO: move pacman based on input - MODEL
		if (event.getCode() != KeyCode.SPACE)	{
			Main.model.move( key );
			Main.view.update(Main.model.getCurrentRow(), Main.model.getCurrentColumn(), Main.model.getPreviousRow(), Main.model.getPreviousColumn());
			//System.out.println(""+key);
		}
		//else fire bullet
		
		
		//TODO: update the view to show movement - VIEW
			
		
		//TODO: End game when reaches end - MODEL
		//		- switch level to Honest John's 
		boolean isOver = Main.model.isLevelOver();
		if (isOver)
			Main.startHonestJohn();
		
		// if is over, load next level(Honest John's)
		
	}//end handle()
	
	
	/*
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
	

	 };


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		initializeBackground();		
	}

}//end class LevelController