package dad.puzzlepic.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Dialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Modality;
import javafx.stage.Stage;
import dad.puzzlepic.controllers.MarcadorController;
import dad.puzzlepic.controllers.OpcionesPartidasController;
import dad.puzzlepic.controllers.MainController;
import dad.puzzlepic.views.PuzzlePicApp;

public class MenuController implements Initializable {

	@FXML
	private Button marcadorButton;

	@FXML
	private ImageView sonidoImage;

	@FXML
	private ImageView logoImage;

	@FXML
	private BorderPane view;

	@FXML
	private Button playButton, aboutButton, exitButton;

	@FXML
	private Button themeButton, soundButton;

	//

	private MainController mainController;

	private Stage primaryStage;

	public MenuController(MainController mainController) throws IOException {
		this.mainController = mainController;

		primaryStage = mainController.getPrimaryStage();

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/dad/puzzlepic/views/MenuView.fxml"));
		loader.setController(this);
		loader.load();
		
		initialize(null,null);

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		playButton.setOnAction(e -> onJugarButtonAction(e));
		themeButton.setOnAction(e -> onTemaButtonAction(e));
		marcadorButton.setOnAction(e -> onMarcadorButtonAction(e));
		aboutButton.setOnAction(e -> onAboutButtonAction(e));
		exitButton.setOnAction(e -> onSalirButtonAction(e));
		soundButton.setOnAction(e -> onSonidoButtonAction(e));

	}

	private void onJugarButtonAction(ActionEvent e) {
		mainController.getVista().setCenter(mainController.getControladorOpciones().getView());
	}

	private void onSonidoButtonAction(ActionEvent e) {
		compruebaSonido();

	}

	// PARAR O REPRODUCIR MUSICA
	private boolean compruebaSonido() {
		boolean sonido = true;
		if (mainController.getAudio().isPlaying()) {
			mainController.getAudio().stop();
			sonidoImage.setImage(new Image("/dad/puzzlepic/resources/sound_off.png"));
			sonido = false;
			System.out.println("No hay sonido");
			return sonido;

		} else {
			mainController.getAudio().play();
			sonidoImage.setImage(new Image("/dad/puzzlepic/resources/sound_on.png"));
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
		dialog.setContentText("Equipo de desarrollo:\n" + "Federico Lleó\n" + "Isaac Méndez\n" + "Domingo Rodríguez");
		dialog.setGraphic(new ImageView(getClass().getResource("/dad/puzzlepic/resources/team.png").toExternalForm()));
		ButtonType ok = new ButtonType("OK", ButtonData.CANCEL_CLOSE);
		dialog.getDialogPane().getButtonTypes().add(ok);
		dialog.showAndWait();

	}

	private void onMarcadorButtonAction(ActionEvent e) {
		mainController.getVista().setCenter(mainController.getControladorMarcador().getView());
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
			primaryStage.getScene().getStylesheets()
					.add(getClass().getResource("/dad/puzzlepic/resources/light.css").toExternalForm());
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
		default : break;
		}

	}

	public BorderPane getView() {
		return view;
	}

	public Button getMarcadorButton() {
		return marcadorButton;
	}

	public Button getPlayButton() {
		return playButton;
	}

	public Button getAboutButton() {
		return aboutButton;
	}

	public Button getExitButton() {
		return exitButton;
	}

	public Button getThemeButton() {
		return themeButton;
	}

	public Button getSoundButton() {
		return soundButton;
	}

	public ImageView getSonidoImage() {
		return sonidoImage;
	}

	public void setSonidoImage(ImageView sonidoImage) {
		this.sonidoImage = sonidoImage;
	}

	public ImageView getLogoImage() {
		return logoImage;
	}

	public void setLogoImage(ImageView logoImage) {
		this.logoImage = logoImage;
	}

}
