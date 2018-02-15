package dad.puzzlepic.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.puzzlepic.views.PuzzlePicApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class SlidingPuzzleController implements Initializable {
	
	private PuzzlePicApp app;
	
	@FXML
	private BorderPane view;
	
  
	
	//
	
	private MainController mainController;

	public SlidingPuzzleController(MainController mainController) throws IOException {
		this.mainController = mainController;
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/dad/puzzlepic/views/SlidingPuzzleView.fxml"));
		loader.setController(this);
		loader.load();
		
		initialize(null,null);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}
	
	
    @FXML
    void abandonarOnAction(ActionEvent event) {
    	mainController.getVista().setCenter(mainController.getControladorMenu().getView());
    	System.out.println("Holaa");
    }
	

	public BorderPane getView() {
		return view;
	}

	public PuzzlePicApp getApp() {
		return app;
	}

	public void setApp(PuzzlePicApp app) {
		this.app = app;
	}
	
}
