package dad.puzzlepic.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Partida {

	private IntegerProperty puntuacion;
	private IntegerProperty tiempoRestante;
	
	public Partida() {
		puntuacion = new SimpleIntegerProperty(this, "puntuacion", 0);
		tiempoRestante = new SimpleIntegerProperty(this, "tiempoRestante");
	}

	public final IntegerProperty puntuacionProperty() {
		return this.puntuacion;
	}
	

	public final int getPuntuacion() {
		return this.puntuacionProperty().get();
	}
	

	public final void setPuntuacion(final int puntuacion) {
		this.puntuacionProperty().set(puntuacion);
	}
	

	public final IntegerProperty tiempoRestanteProperty() {
		return this.tiempoRestante;
	}
	

	public final int getTiempoRestante() {
		return this.tiempoRestanteProperty().get();
	}
	

	public final void setTiempoRestante(final int tiempoRestante) {
		this.tiempoRestanteProperty().set(tiempoRestante);
	}
	
	
	
}
