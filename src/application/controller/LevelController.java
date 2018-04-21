/**
 * 
 * 
 * @author wolfyCSA
 */

package application.controller;

import application.Main;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class LevelController implements EventHandler<KeyEvent> {
	
	@Override
	public void handle(KeyEvent event) {
		
		// get the user input
		char key = event.getCode().toString().charAt(0);
		//add move methods to the board.java, switch on key
		
		//TODO: move pacman based on input - MODEL
		if (event.getCode() != KeyCode.SPACE)	
			Main.model.move( key );
		//else fire bullet
		
		//TODO: update the view to show movement - VIEW
		
		//TODO: End game when reaches end - MODEL
		//		- switch level to Honest John's 
		boolean isOver = Main.model.isLevelOver();
		if (isOver)
			Main.startHonestJohn();
		
		// if is over, load next level(Honest John's)
		
	}//end handle()

}//end class LevelController