package dad.puzzlepic.controllers;


import java.io.IOException;

import java.net.URL;

import java.util.ResourceBundle;



import javafx.collections.FXCollections;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;


public class OpcionesPartidasController implements Initializable {


	

	@FXML
	private BorderPane view;

	@FXML
	private Spinner<Integer> timeSpinner;

	@FXML
	private ComboBox<Integer> nRoundCombo;

	@FXML
	private ComboBox<Dificultad> lvlCombo;

	@FXML
	private Button openButton;

	@FXML
	private Button backButton;

	@FXML
	private Button continueButton;

	@FXML
	private TextField playerField;
	
    @FXML
    private Label directorioLabel;
    
    @FXML
    private ComboBox<Modo> comboGame;
    


   

	public OpcionesPartidasController() throws IOException {	
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/dad/puzzlepic/views/OpcionesPartidasView.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lvlCombo.getItems().setAll(Dificultad.values());
		SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(30, 180, 30);
		timeSpinner.setValueFactory(valueFactory);
		lvlCombo.setValue(Dificultad.FACIL);
		comboGame.getItems().setAll(Modo.values());
		comboGame.setValue(Modo.PUZZLE_PIECES);
		nRoundCombo.setItems(FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10));
		nRoundCombo.setValue(1);
	
	}







	public BorderPane getView() {
		return view;
	}

	public void setView(BorderPane view) {
		this.view = view;
	}

	public Spinner<Integer> getTimeSpinner() {
		return timeSpinner;
	}

	public ComboBox<Integer> getnRoundCombo() {
		return nRoundCombo;
	}

	public ComboBox<Dificultad> getLvlCombo() {
		return lvlCombo;
	}

	public Button getOpenButton() {
		return openButton;
	}

	public Button getBackButton() {
		return backButton;
	}

	public Button getContinueButton() {
		return continueButton;
	}

	public TextField getPlayerField() {
		return playerField;
	}

	public ComboBox<Modo> getComboGame() {
		return comboGame;
	}

	public Label getDirectorioLabel() {
		return directorioLabel;
	}
	
	

}
