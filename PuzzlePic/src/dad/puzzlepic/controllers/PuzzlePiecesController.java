package dad.puzzlepic.controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.ResourceBundle;

import dad.puzzlepic.views.PuzzlePicApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class PuzzlePiecesController implements Initializable {

	private PuzzlePicApp app;

	@FXML
	private BorderPane view;
	
	@FXML
    private ImageView mezcla1;

    @FXML
    private ImageView mezcla2;

    @FXML
    private ImageView mezcla7;

    @FXML
    private ImageView mezcla6;

    @FXML
    private ImageView mezcla5;

    @FXML
    private ImageView mezcla4;

    @FXML
    private ImageView mezcla3;

    @FXML
    private ImageView mezcla8;

    @FXML
    private ImageView mezcla0;

    @FXML
    private ImageView mifoto1;

    @FXML
    private ImageView mifoto2;

    @FXML
    private ImageView mifoto7;

    @FXML
    private ImageView mifoto6;

    @FXML
    private ImageView mifoto5;

    @FXML
    private ImageView mifoto4;

    @FXML
    private ImageView mifoto3;

    @FXML
    private ImageView mifoto0;

    @FXML
    private ImageView mifoto8;


	//

	private MainController mainController;
	private ArrayList<File> mifotos = new ArrayList<>();
	private ArrayList<File> mezcla = new ArrayList<>();
	private File[] fotos;

	public PuzzlePiecesController(MainController mainController) throws IOException {
		this.mainController = mainController;		
		this.fotos = mainController.getFotos();
		

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/dad/puzzlepic/views/PuzzlePiecesView.fxml"));
		loader.setController(this);
		loader.load();

		initialize(null, null);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// Hacemos la mezcla
		if(fotos!=null) {
		while (mezcla.size() < 10){
			int n = (int) (Math.random()*9+0);
			if(!mezcla.contains(fotos[n])) {
				mezcla.add(fotos[n]);
				System.out.println(fotos[n].getAbsolutePath());
			}
		}
		mezcla.get(0).getAbsolutePath();
		// Bindeos
		mezcla1.imageProperty().set(new Image(mezcla.get(0).getAbsolutePath()));
		}
	}

	@FXML
	void abandonarOnAction(ActionEvent event) {
		mainController.getVista().setCenter(mainController.getControladorMenu().getView());
		
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
