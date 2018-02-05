package dad.puzzlepic.controllers;

import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;

import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;



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
	private Button  themeButton,soundButton;



	public MenuController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/dad/puzzlepic/views/MenuView.fxml"));
		loader.setController(this);
		loader.load();

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {


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
