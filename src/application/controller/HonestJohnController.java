/**
 * 
 * 
 * @author wolfyCSA
 */

package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.model.Level;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class HonestJohnController implements EventHandler<Event>, Initializable{
	
    int cashAmount = 3500;
	String cashString = "$";
	@FXML
    private Text money;

    @FXML
    private Button buyBeer;

    @FXML
    private Text price;

    @FXML
    private Text dialogue;

    @FXML
    private Button startLevel;

    @FXML
    private Text menu;

	@Override
	public void handle(Event event) {
		if(((Button)event.getSource()).equals(buyBeer)) {
			cashAmount -= 3;
			cashString += String.valueOf(cashAmount);
		    money.setText(cashString);
		    cashString = "$";
		}
		if(((Button)event.getSource()).equals(startLevel)) {
			
			Main.model = new Level(Main.profile.getCurrentLevel());
	    	Main.startLevel();
	    	//starts bullet controller thread
	    	Main.bulletHandler.start();
	    	Main.enemyHandler.start();
	    	Main.collisionDetector.start();
			
		}
		
		
	
	}

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
	    
		
	}
	

}
