package dad.puzzlepic.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.puzzlepic.views.PuzzlePicApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

public class PuzzlePiecesController implements Initializable {
	
	private PuzzlePicApp app;
	
	@FXML
	private BorderPane view;
	
	//
	
	private PuzzlePicController puzzlePicController;

	public PuzzlePiecesController(PuzzlePicController puzzlePicController) throws IOException {
		this.puzzlePicController = puzzlePicController;
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/dad/puzzlepic/views/PuzzlePiecesView.fxml"));
		loader.setController(this);
		loader.load();
		
		initialize(null,null);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
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
