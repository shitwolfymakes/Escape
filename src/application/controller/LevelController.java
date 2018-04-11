/**
 * 
 * 
 * @author wolfyCSA
 */

package application.controller;

import java.io.IOException;
import java.util.ArrayList;

import application.Main;
import application.model.EnemyShip;
import application.model.Level;
import application.view.LevelView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class LevelController implements EventHandler<ActionEvent> {

	public ArrayList<EnemyShip> enemies = new ArrayList<EnemyShip>();

	@Override
	public void handle(ActionEvent event) {
		Main.model = new Level( Main.player.getCurrentLevel() );
		enemies = Main.model.collectEnemies();
		
		try {
			// load the fxml file we need
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation( Main.class.getResource("Level.fxml") );
			AnchorPane layout = (AnchorPane) loader.load();

			// Load the Level view
			//Main.view = new LevelView( Main.model );
			Main.view = new LevelView();
			layout.getChildren().add( Main.view );
			Scene scene = new Scene( layout );

			// Sets the scene to the stage & shows stage to the user
			Main.stage.setScene(scene);
		} catch(IOException e) {
			e.printStackTrace();
		}//end try/catch
		
		// move all enemies to the left once per second
		while (enemies.size() > 0)
		{
			try {
				Thread.sleep(1000);

				for ( EnemyShip e : enemies ) {
					// need an isTileOccupied()

					if (e.getCurrentCol() == 11) {
						// jumping the barrier
						Main.model.enemyJumpBarrier(e);
					} else if ( e.getCurrentCol() < 10 )
						continue;
					else Main.model.updateEnemyLocation(e);
				}//end for

			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}//end try/catch
			
		}//end while
		
	}//end handle()



	@FXML
	private GridPane gridPane;

	@FXML
	private ImageView g1x1;

	@FXML
	private ImageView g1x2;

	@FXML
	private ImageView g1x3;

	@FXML
	private ImageView g1x4;

	@FXML
	private ImageView g1x5;

	@FXML
	private ImageView g1x6;

	@FXML
	private ImageView g2x1;

	@FXML
	private ImageView g2x2;

	@FXML
	private ImageView g2x3;

	@FXML
	private ImageView g2x4;

	@FXML
	private ImageView g2x5;

	@FXML
	private ImageView g2x6;

	@FXML
	private ImageView g3x1;

	@FXML
	private ImageView g3x2;

	@FXML
	private ImageView g3x3;

	@FXML
	private ImageView g3x4;

	@FXML
	private ImageView g3x5;

	@FXML
	private ImageView g3x6;

	@FXML
	private ImageView g4x1;

	@FXML
	private ImageView g4x2;

	@FXML
	private ImageView g4x3;

	@FXML
	private ImageView g4x4;

	@FXML
	private ImageView g4x5;

	@FXML
	private ImageView g4x6;

	@FXML
	private ImageView g5x1;

	@FXML
	private ImageView g5x2;

	@FXML
	private ImageView g5x3;

	@FXML
	private ImageView g5x4;

	@FXML
	private ImageView g5x5;

	@FXML
	private ImageView g5x6;

	@FXML
	private ImageView g6x1;

	@FXML
	private ImageView g6x2;

	@FXML
	private ImageView g6x3;

	@FXML
	private ImageView g6x4;

	@FXML
	private ImageView g6x5;

	@FXML
	private ImageView g6x6;

	@FXML
	private ImageView g7x1;

	@FXML
	private ImageView g7x2;

	@FXML
	private ImageView g7x3;

	@FXML
	private ImageView g7x4;

	@FXML
	private ImageView g7x5;

	@FXML
	private ImageView g7x6;

	@FXML
	private ImageView g8x1;

	@FXML
	private ImageView g8x2;

	@FXML
	private ImageView g8x3;

	@FXML
	private ImageView g8x4;

	@FXML
	private ImageView g8x5;

	@FXML
	private ImageView g8x6;



}