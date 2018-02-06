package dad.puzzlepic.views;

import dad.puzzlepic.controllers.PuzzlePicController;
import dad.puzzlepic.controllers.PuzzlePiecesFacilController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PuzzlePicApp extends Application {


	public PuzzlePiecesFacilController tableroFacilController;
	public static Scene scene;
	private PuzzlePicController controlador;
	private static Stage primaryStage;
	
//hola
	@Override
	public void start(Stage primaryStage) throws Exception {

		PuzzlePicApp.primaryStage = primaryStage;
		controlador = new PuzzlePicController();


		scene = new Scene(controlador.getVista(), 720, 720);
		scene.getStylesheets().add(getClass().getResource("/dad/puzzlepic/resources/default.css").toExternalForm());

		primaryStage.setTitle("PuzzlEpic");
		primaryStage.getIcons().add(new Image("/dad/puzzlepic/resources/logo.png"));
		primaryStage.setScene(scene);
		primaryStage.initStyle(StageStyle.UTILITY);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}


	public static Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void setPrimaryStage(Stage primaryStage) {
		PuzzlePicApp.primaryStage = primaryStage;
	}
	
	

}
