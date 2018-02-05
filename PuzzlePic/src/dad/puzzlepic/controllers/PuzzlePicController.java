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
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PuzzlePicController implements Initializable {

	private BorderPane vista;

	private MenuController controladorMenu;
	private MarcadorController controladorMarcador;
	private OpcionesPartidasController controladorOpciones;
	private AudioClip audio;

	private Stage primaryStage;

	private String directorio = null;

	public PuzzlePicController() throws IOException {

		primaryStage = PuzzlePicApp.getPrimaryStage();
		vista = new BorderPane();
		controladorMarcador = new MarcadorController();
		controladorMenu = new MenuController();
		controladorOpciones = new OpcionesPartidasController();
		initialize(null, null);

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		audio = new AudioClip(getClass().getResource("/dad/puzzlepic/resources/getlucky.mp3").toExternalForm());
		audio.play();

		vista.setCenter(controladorMenu.getView());
		controladorMenu.getPlayButton().setOnAction(e -> onJugarButtonAction(e));
		controladorMenu.getThemeButton().setOnAction(e -> onTemaButtonAction(e));
		controladorMenu.getMarcadorButton().setOnAction(e -> onMarcadorButtonAction(e));
		controladorMenu.getAboutButton().setOnAction(e -> onAboutButtonAction(e));
		controladorMenu.getExitButton().setOnAction(e -> onSalirButtonAction(e));
		controladorMenu.getSoundButton().setOnAction(e -> onSonidoButtonAction(e));
		controladorMarcador.getVolverButton().setOnAction(e -> onVolverMenuButtonAction(e));
		controladorOpciones.getBackButton().setOnAction(e -> onVolverMenuButtonAction(e));
		controladorOpciones.getContinueButton().setOnAction(e -> onIniciarPartidaButtonAction(e));
		controladorOpciones.getOpenButton().setOnAction(e -> onAbrirButtonAction(e));

	}

	private void onAbrirButtonAction(ActionEvent e) {
		try {
			File selectedDirectory = directorioChooser("Selecciona carpeta de imagenes", ".");
			if (selectedDirectory.isDirectory()) {
				controladorOpciones.getDirectorioLabel().setText(selectedDirectory.getAbsolutePath());
				directorio = selectedDirectory.getAbsolutePath().toString();
			} else {
				error("Error de seleeción", "Has de seleccionar una carpeta.", null);
			}
		} catch (NullPointerException e1) {
			error("Error de seleeción", "No se puedo cargar la carpeta, de imagenes", e1);
		}
	}

	private void onIniciarPartidaButtonAction(ActionEvent e) {
		if (controladorOpciones.getPlayerField().getText().equals("")
				|| controladorOpciones.getPlayerField().getText() == null || directorio == null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error!!");
			alert.setHeaderText("Algo ha fallado...");
			alert.setContentText("Por favor, revise los campos.");
			alert.initModality(Modality.APPLICATION_MODAL);
			alert.initOwner(primaryStage);
			alert.showAndWait();

		} else {

			Properties archivoPropiedades = new Properties();
			OutputStream output = null;

			File file = new File("config.properties");

			try {
				if (file.exists()) {
					file.delete();

					output = new FileOutputStream("config.properties");
					crearArchivoProperties(archivoPropiedades, output);

				} else {
					output = new FileOutputStream("config.properties");
					crearArchivoProperties(archivoPropiedades, output);
				}
			} catch (IOException e1) {
				e1.printStackTrace();

			}

			switch (controladorOpciones.getLvlCombo().getValue()) {
			case FACIL:
				System.out.println("FACIL");

				switch (controladorOpciones.getComboGame().getValue()) {
				case PUZZLE_PIECES:
					System.out.println("PUZLE PIECES");

					break;
				case MATCH_PUZZLE:
					System.out.println("MATCH PUZZLE");
					break;

				case SLIDING_PUZZLE:
					System.out.println("SLIDING PUZZLE");
					break;

				default:
					break;
				}

				break;

			case MEDIA:
				System.out.println("MEDIA");
				switch (controladorOpciones.getComboGame().getValue()) {
				case PUZZLE_PIECES:
					System.out.println("PUZLE PIECES");

					break;
				case MATCH_PUZZLE:
					System.out.println("MATCH PUZZLE");
					break;

				case SLIDING_PUZZLE:
					System.out.println("SLIDING PUZZLE");
					break;

				default:
					break;
				}

				break;

			case DIFICIL:
				System.out.println("DIFICIL");
				switch (controladorOpciones.getComboGame().getValue()) {
				case PUZZLE_PIECES:
					System.out.println("PUZLE PIECES");

					break;
				case MATCH_PUZZLE:
					System.out.println("MATCH PUZZLE");
					break;

				case SLIDING_PUZZLE:
					System.out.println("SLIDING PUZZLE");
					break;

				default:
					break;
				}

				break;

			default:
				break;
			}

			if (controladorOpciones.getLvlCombo().getValue().equals(Dificultad.FACIL)) {

			} else if (controladorOpciones.getLvlCombo().getValue().equals(Dificultad.MEDIA)) {

			} else {

			}

		}

	}

	private void crearArchivoProperties(Properties archivoPropiedades, OutputStream output) throws IOException {
		archivoPropiedades.setProperty("nombre", controladorOpciones.getPlayerField().getText());
		archivoPropiedades.setProperty("tiempo", controladorOpciones.getTimeSpinner().getValue().toString());
		archivoPropiedades.setProperty("rondas", controladorOpciones.getnRoundCombo().getValue().toString());
		archivoPropiedades.setProperty("dificultad", controladorOpciones.getLvlCombo().getValue().toString());
		archivoPropiedades.setProperty("modo", controladorOpciones.getComboGame().getValue().toString());
		archivoPropiedades.setProperty("directorio", "falta especificar");
		archivoPropiedades.store(output, null);

	}

	private void onVolverMenuButtonAction(ActionEvent e) {
		vista.setCenter(controladorMenu.getView());
	}

	private void onSonidoButtonAction(ActionEvent e) {
		compruebaSonido();

	}

	// PARAR O REPRODUCIR MUSICA
	private boolean compruebaSonido() {
		boolean sonido = true;
		if (audio.isPlaying()) {
			audio.stop();
			controladorMenu.getSonidoImage().setImage(new Image("/dad/puzzlepic/resources/sound_off.png"));
			sonido = false;
			System.out.println("No hay sonido");
			return sonido;

		} else {
			audio.play();
			controladorMenu.getSonidoImage().setImage(new Image("/dad/puzzlepic/resources/sound_on.png"));
			sonido = true;
			System.out.println("hay sonido");
			return sonido;

		}

	}

	private void onSalirButtonAction(ActionEvent e) {
		Alert alertExit = new Alert(AlertType.CONFIRMATION);
		alertExit.setTitle("PuzzlePic");
		alertExit.setHeaderText("Saliendo de PuzzlePic");
		alertExit.initOwner(PuzzlePicApp.getPrimaryStage());
		alertExit.initModality(Modality.APPLICATION_MODAL);
		alertExit.setContentText("¿Seguro que quiere salir?");

		Optional<ButtonType> result = alertExit.showAndWait();
		if (result.get() == ButtonType.OK) {
			Platform.exit();
		}

	}

	private void onAboutButtonAction(ActionEvent e) {
		Dialog<Void> dialog = new Dialog<>();
		dialog.setTitle("About...");
		dialog.initOwner(primaryStage);
		dialog.setContentText("Equipo de desarrollo:\n" + "Federico Lleo\n" + "Isaac Mendez\n" + "Domingo Rodríguez");
		dialog.setGraphic(new ImageView(getClass().getResource("/dad/puzzlepic/resources/team.png").toExternalForm()));
		ButtonType ok = new ButtonType("OK", ButtonData.CANCEL_CLOSE);
		dialog.getDialogPane().getButtonTypes().add(ok);
		dialog.showAndWait();

	}

	private void onMarcadorButtonAction(ActionEvent e) {
		vista.setCenter(controladorMarcador.getView());
	}

	private void onTemaButtonAction(ActionEvent e) {

		List<String> choices = new ArrayList<String>();
		choices.add("DEFAULT");
		
		choices.add("LIGHT");
		choices.add("ORANGE");
		choices.add("DARK");

		ChoiceDialog<String> dialog = new ChoiceDialog<>("DEFAULT", choices);
		dialog.setTitle("Elige un tema");
		dialog.initOwner(primaryStage);
		dialog.initModality(Modality.APPLICATION_MODAL);
		dialog.setHeaderText("Cambia la apariencia");
		dialog.setContentText("Elige una skin:");
		Optional<String> result = dialog.showAndWait();

		switch (result.get()) {
		case "LIGHT":
			primaryStage.getScene().getStylesheets().clear();
			primaryStage.getScene().getStylesheets().
					add(getClass().getResource("/dad/puzzlepic/resources/light.css").toExternalForm());
			break;
		case "DARK":
			primaryStage.getScene().getStylesheets().clear();
			primaryStage.getScene().getStylesheets()
					.add(getClass().getResource("/dad/puzzlepic/resources/dark.css").toExternalForm());
			break;
		case "ORANGE":
			primaryStage.getScene().getStylesheets().clear();
			primaryStage.getScene().getStylesheets()
					.add(getClass().getResource("/dad/puzzlepic/resources/orange.css").toExternalForm());
			break;
		case "DEFAULT":
			primaryStage.getScene().getStylesheets().clear();
			primaryStage.getScene().getStylesheets()
					.add(getClass().getResource("/dad/puzzlepic/resources/default.css").toExternalForm());
			break;
		}

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

	private void onJugarButtonAction(ActionEvent e) {
		vista.setCenter(controladorOpciones.getView());
	}

	public BorderPane getVista() {
		return vista;
	}

	public void setVista(BorderPane vista) {
		this.vista = vista;
	}

}
