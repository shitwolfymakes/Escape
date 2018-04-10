/**
 * 
 * 
 * @author wolfyCSA
 */

package application.controller;


import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainMenuController implements EventHandler<Event>{

    @FXML
    private Button startButton;

    @FXML
    private Button loadButton;

    @FXML
    private Button highScoreButton;

    @FXML
    public void start(Event event) {
    	System.out.print("butt");
    }

    @Override
	public void handle(Event event) {
    	System.out.print("dink");
    }

    @FXML
    public void highScore(Event event) {
    	System.out.print("stink");
    }



}
