/**
 * 
 * 
 * @author wolfyCSA
 */

package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class HonestJohnController implements EventHandler<Event>, Initializable{
	
    int cashAmount = 3500;
	String cashString = "$";
	@FXML
	Button buyBeer;
	
	@FXML
	Text money;

	@Override
	public void handle(Event event) {
		if(((Button)event.getSource()).equals(buyBeer)) {
			cashAmount -= 3;
			cashString += String.valueOf(cashAmount);
		    money.setText(cashString);
		    cashString = "$";
	}
		
	
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		cashString += String.valueOf(cashAmount);
	    money.setText(cashString);
	    cashString = "$";
		
	}
	

}
