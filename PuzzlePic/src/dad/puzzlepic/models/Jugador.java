package dad.puzzlepic.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Jugador {

	private StringProperty nombre;
	private StringProperty dificultad;
	private StringProperty directorio;
	private StringProperty modo;
	private IntegerProperty tiempo;
	private IntegerProperty rondas;

	public Jugador() {
		nombre = new SimpleStringProperty();
		dificultad = new SimpleStringProperty();
		directorio = new SimpleStringProperty();
		modo = new SimpleStringProperty();
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
	

	public final StringProperty dificultadProperty() {
		return this.dificultad;
	}
	

	public final String getDificultad() {
		return this.dificultadProperty().get();
	}
	

	public final void setDificultad(final String dificultad) {
		this.dificultadProperty().set(dificultad);
	}
	

	public final StringProperty directorioProperty() {
		return this.directorio;
	}
	

	public final String getDirectorio() {
		return this.directorioProperty().get();
	}
	

	public final void setDirectorio(final String directorio) {
		this.directorioProperty().set(directorio);
	}
	

	public final StringProperty modoProperty() {
		return this.modo;
	}
	

	public final String getModo() {
		return this.modoProperty().get();
	}
	

	public final void setModo(final String modo) {
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
