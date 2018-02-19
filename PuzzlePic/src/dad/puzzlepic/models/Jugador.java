package dad.puzzlepic.models;

import java.io.File;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Jugador {

	private StringProperty nombre;
	private ObjectProperty<Dificultad> dificultad;
	private ObjectProperty<File> directorio;
	private ObjectProperty<Modo> modo;
	private IntegerProperty tiempo;
	private IntegerProperty rondas;

	public Jugador() {
		nombre = new SimpleStringProperty();
		dificultad = new SimpleObjectProperty<>();
		directorio = new SimpleObjectProperty<>();
		modo = new SimpleObjectProperty<>();
		tiempo = new SimpleIntegerProperty();
		rondas = new SimpleIntegerProperty();
	}

	public final StringProperty nombreProperty() {
		return this.nombre;
	}
	

	public final String getNombre() {
		return this.nombreProperty().get();
	}
	

	public final void setNombre(final String nombre) {
		this.nombreProperty().set(nombre);
	}
	

	public final ObjectProperty<Dificultad> dificultadProperty() {
		return this.dificultad;
	}
	

	public final Dificultad getDificultad() {
		return this.dificultadProperty().get();
	}
	

	public final void setDificultad(final Dificultad dificultad) {
		this.dificultadProperty().set(dificultad);
	}
	

	public final ObjectProperty<File> directorioProperty() {
		return this.directorio;
	}
	

	public final File getDirectorio() {
		return this.directorioProperty().get();
	}
	

	public final void setDirectorio(final File directorio) {
		this.directorioProperty().set(directorio);
	}
	

	public final ObjectProperty<Modo> modoProperty() {
		return this.modo;
	}
	

	public final Modo getModo() {
		return this.modoProperty().get();
	}
	

	public final void setModo(final Modo modo) {
		this.modoProperty().set(modo);
	}
	

	public final IntegerProperty tiempoProperty() {
		return this.tiempo;
	}
	

	public final int getTiempo() {
		return this.tiempoProperty().get();
	}
	

	public final void setTiempo(final int tiempo) {
		this.tiempoProperty().set(tiempo);
	}
	

	public final IntegerProperty rondasProperty() {
		return this.rondas;
	}
	

	public final int getRondas() {
		return this.rondasProperty().get();
	}
	

	public final void setRondas(final int rondas) {
		this.rondasProperty().set(rondas);
	}
	

	

}
