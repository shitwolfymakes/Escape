/**
 * This class is the controller for Honest John's. It lets the user purchase libations for his/her
 * journey through space. It also loads the next level. 
 * 
 * @author wolfyCSA, indomichael
 */
package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class HonestJohnController implements EventHandler<Event>, Initializable{
	
    int cashAmount = 3500;
	String cashString = "$";
	
	@FXML
    private Text money, price, dialogue, menu;

    @FXML
    private Button buyBeer, startLevel;

    /**
     * checks what button the user presses, and either buys beer or starts the next level
     * 
     * @param event
     */
	@Override
	public void handle(Event event) {
		if ( ((Button)event.getSource()).equals(buyBeer) ) {
			cashAmount -= 3;
			cashString += String.valueOf(cashAmount);
		    money.setText(cashString);
		    cashString = "$";
		}//end if
		
		if ( ((Button)event.getSource()).equals(startLevel) ) {
	    	Main.startLevel();
	    	// Start the threads
	    	Main.bulletHandler.start();
	    	Main.enemyHandler.start();
	    	Main.collisionDetector.start();
		}//end if
		
	}//end handle()
	
    /**
     * Loads the cash amount and updates the font style for the fxml
     * 
     * @param location the default paramater
     * @param resources default paramater
     */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cashString += String.valueOf(cashAmount);
		money.setFont(Font.loadFont("file:data/font/Pixeled.ttf", 15));
		dialogue.setFont(Font.loadFont("file:data/font/Pixeled.ttf", 15));
		price.setFont(Font.loadFont("file:data/font/Pixeled.ttf", 15));
		menu.setFont(Font.loadFont("file:data/font/Pixeled.ttf", 15));
		buyBeer.setFont(Font.loadFont("file:data/font/Pixeled.ttf", 15));
		startLevel.setFont(Font.loadFont("file:data/font/Pixeled.ttf", 15));
	    money.setText(cashString);
	    cashString = "$";
	}//end initialize()
	
}//end class HonestJohnController