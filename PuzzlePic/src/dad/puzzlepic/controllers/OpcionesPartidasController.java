package dad.puzzlepic.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;

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
	
	//
	
	private MainController mainController;

	public OpcionesPartidasController(MainController mainController) throws IOException {
		this.mainController = mainController;
		
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
		nRoundCombo.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		nRoundCombo.setValue(1);

		// Acciones
		backButton.setOnAction(e -> onVolverMenuButtonAction(e));
		continueButton.setOnAction(e -> onIniciarPartidaButtonAction(e));
		openButton.setOnAction(e -> onAbrirButtonAction(e));

	}
	
	private void onVolverMenuButtonAction(ActionEvent e) {
		mainController.getVista().setCenter(mainController.getControladorMenu().getView());
	}


	private void onAbrirButtonAction(ActionEvent e) {
		try {
			File selectedDirectory = mainController.directorioChooser("Selecciona carpeta de imagenes", ".");
			if (selectedDirectory.isDirectory()) {
				mainController.getControladorOpciones().getDirectorioLabel().setText(selectedDirectory.getAbsolutePath());
				mainController.setDirectorio(selectedDirectory.getAbsolutePath().toString());
			} else {
				mainController.error("Error de seleeción", "Has de seleccionar una carpeta.", null);
			}
		} catch (NullPointerException e1) {
			mainController.error("Error de seleeción", "No se puedo cargar la carpeta, de imagenes", e1);
		}
	}

	private void onIniciarPartidaButtonAction(ActionEvent e) {
		if (mainController.getControladorOpciones().getPlayerField().getText().equals("")
				|| mainController.getControladorOpciones().getPlayerField().getText() == null || mainController.getControladorOpciones() == null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error!!");
			alert.setHeaderText("Algo ha fallado...");
			alert.setContentText("Por favor, revise los campos.");
			alert.initModality(Modality.APPLICATION_MODAL);
			alert.initOwner(mainController.getPrimaryStage());
			alert.showAndWait();

		} else {

			Properties archivoPropiedades = new Properties();
			OutputStream output = null;

			File file = new File("config.properties");

			try {
				if (file.exists())
					file.delete();

				output = new FileOutputStream("config.properties");
				

			} catch (IOException e1) {
				e1.printStackTrace();
			}

			switch (mainController.getControladorOpciones().getLvlCombo().getValue()) {
			case FACIL:
				System.out.println("FACIL");
				mainController.setDificultad("FACIL");
				break;
			case MEDIA:
				System.out.println("MEDIA");
				mainController.setDificultad("MEDIA");
				break;

			case DIFICIL:
				System.out.println("DIFICIL");
				mainController.setDificultad("DIFICIL");
				break;

			default:
				break;
			}

			switch (mainController.getControladorOpciones().getComboGame().getValue()) {
			case PUZZLE_PIECES:
				System.out.println("PUZLE PIECES");
				mainController.getVista().setCenter(mainController.getControladorPuzzlePieces().getView());
				break;
			case MATCH_PUZZLE:
				System.out.println("MATCH PUZZLE");
				mainController.getVista().setCenter(mainController.getMatchPuzzleController().getView());
				break;

			case SLIDING_PUZZLE:
				System.out.println("SLIDING PUZZLE");
				mainController.getVista().setCenter(mainController.getSlidingPuzzleController().getView());
				break;

			default:
				break;
			}

		}

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
