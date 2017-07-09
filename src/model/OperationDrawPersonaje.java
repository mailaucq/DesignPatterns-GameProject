package model;

import javax.media.opengl.GL2;

import model.impl.GameCanvas;
import model.impl.Movements;

/**
 * Patron Bridge
 * -ImplementorConcreto
 * @author XD
 *
 */
public abstract class OperationDrawPersonaje extends OperationDraw  implements Movements {
	protected Personaje personaje;
	protected GameCanvas canvas;
	public OperationDrawPersonaje(Personaje personaje){
		this.personaje = personaje;
	}
	@Override
	public abstract void init(GL2 gl, GameCanvas canvas);
	@Override
	public abstract void draw(GL2 gl);
	public void setPersonajeObserver(Personaje personaje) {
		this.personaje = personaje;
	}
	public abstract void disparar();
}
