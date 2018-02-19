package dad.puzzlepic.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.puzzlepic.models.Dificultad;
import dad.puzzlepic.models.Modo;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;


public class MarcadorController implements Initializable {
	@FXML
    private BorderPane view;

    @FXML
    private ComboBox<Dificultad> lvlCombo;

    @FXML
    private ComboBox<Modo> comboGame;

    @FXML
    private Button consultarButton;

    @FXML
    private Button volverButton;

    @FXML
    private TableView<?> tableScores;

    @FXML
    private TableColumn<?, ?> puestoColumn;

    @FXML
    private TableColumn<?, ?> idColumn;

    @FXML
    private TableColumn<?, ?> nombreColumn;

    @FXML
    private TableColumn<?, ?> modoColumn;

    @FXML
    private TableColumn<?, ?> tiempoColumn;

    @FXML
    private TableColumn<?, ?> puntuacionColumn;
    
   
    

	 

	public MarcadorController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/dad/puzzlepic/views/MarcadorView.fxml"));
		loader.setController(this);
		loader.load();
	
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {


	}

	

	public BorderPane getView() {
		return view;
	}

	public void setView(BorderPane view) {
		this.view = view;
	}

	public Button getConsultarButton() {
		return consultarButton;
	}

	public Button getVolverButton() {
		return volverButton;
	}
	
	
	

	
}
