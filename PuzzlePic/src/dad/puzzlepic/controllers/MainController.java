package dad.puzzlepic.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.ResourceBundle;

import dad.puzzlepic.views.PuzzlePicApp;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Dialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.AudioClip;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import dad.puzzlepic.controllers.MarcadorController;
import dad.puzzlepic.controllers.MenuController;
import dad.puzzlepic.controllers.OpcionesPartidasController;
import dad.puzzlepic.controllers.PuzzlePiecesController;
import dad.puzzlepic.models.Jugador;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainController implements Initializable {

	private BorderPane vista;

	private MenuController controladorMenu;
	private MarcadorController controladorMarcador;
	private OpcionesPartidasController controladorOpciones;
	private PuzzlePiecesController controladorPuzzlePieces;
	private MatchPuzzleController matchPuzzleController;
	private SlidingPuzzleController slidingPuzzleController;
	private AudioClip audio;
	private Jugador jugador = new Jugador();
	private Stage primaryStage;
	private File[] fotos = null;
	


	public MainController() throws IOException {

		primaryStage = PuzzlePicApp.getPrimaryStage();
		vista = new BorderPane();
		controladorMarcador = new MarcadorController();
		controladorMenu = new MenuController(this);
		controladorOpciones = new OpcionesPartidasController(this);
		controladorPuzzlePieces = new PuzzlePiecesController(this);
		matchPuzzleController = new MatchPuzzleController(this);
		slidingPuzzleController = new SlidingPuzzleController(this);
		

		initialize(null, null);

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		audio = new AudioClip(getClass().getResource("/dad/puzzlepic/resources/getlucky.mp3").toExternalForm());
		audio.play();

		vista.setCenter(controladorMenu.getView());

		controladorMarcador.getVolverButton().setOnAction(e -> onVolverMenuButtonAction(e));
		
	}

	

	private void onVolverMenuButtonAction(ActionEvent e) {
		vista.setCenter(controladorMenu.getView());
	}

	public File directorioChooser(String title, String initialDirectory) {
		DirectoryChooser fch = new DirectoryChooser();
		fch.setTitle(title);
		fch.setInitialDirectory(new File(initialDirectory));
		return fch.showDialog(primaryStage);
	}

	public File fileChooser(String title, String initialDirectory, String tipoDeFichero, String extension) {
		FileChooser fch = new FileChooser();
		fch.setTitle(title);
		fch.setInitialDirectory(new File(initialDirectory));
		fch.getExtensionFilters().addAll(new ExtensionFilter(tipoDeFichero, extension),
				new ExtensionFilter("Todos los archivos (*.*)", "*.*"));
		return fch.showOpenDialog(primaryStage);
	}

	public Optional<ButtonType> confirmacion(String string, String string2, String string3) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle(string);
		alert.setHeaderText(string2);
		alert.setContentText(string3);
		alert.initOwner(primaryStage);

		return alert.showAndWait();
	}

	public Optional<ButtonType> advertencia(String string, String string2, String string3) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle(string);
		alert.setHeaderText(string2);
		alert.setContentText(string3);
		alert.initOwner(primaryStage);

		return alert.showAndWait();
	}

	public void informacion(String string) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Agenda de contactos");
		alert.setHeaderText(string);
		alert.initOwner(primaryStage);
		alert.showAndWait();

	}

	public void error(String string, String string2, Exception e1) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(string);
		alert.setHeaderText(string2);
		// alert.setContentText(e1.getMessage());
		alert.initOwner(primaryStage);
		alert.showAndWait();

	}

	public MarcadorController getControladorMarcador() {
		return controladorMarcador;
	}

	public OpcionesPartidasController getControladorOpciones() {
		return controladorOpciones;
	}

	public PuzzlePiecesController getControladorPuzzlePieces() {
		return controladorPuzzlePieces;
	}
	
	

	public MatchPuzzleController getMatchPuzzleController() {
		return matchPuzzleController;
	}

	public SlidingPuzzleController getSlidingPuzzleController() {
		return slidingPuzzleController;
	}

	public AudioClip getAudio() {
		return audio;
	}



	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public MenuController getControladorMenu() {
		return controladorMenu;
	}

	public BorderPane getVista() {
		return vista;
	}

	public void setVista(BorderPane vista) {
		this.vista = vista;
	}

	public File[] getFotos() {
		return fotos;
	}

	public void setFotos(File[] fotos) {
		this.fotos = fotos;
	}

	

}
