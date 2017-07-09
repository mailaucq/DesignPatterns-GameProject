package model;

import java.util.List;

/**
 * Patron Observer
 * -Subject
 * @author XD
 *
 */
public abstract class GameSubject {
	protected List<PersonajeObserver> observers;
	/**
	 * Avisa a todos los enemigos el movimiento del Jugador Principal
	 */
	public abstract void notifyEnemies();
	/**
	 * Avisa a todos los personajes el stado del juego
	 * @param gameState
	 */
	public abstract void notifyState(GameState gameState);	
	public abstract void addObserver(PersonajeObserver observer); 
}
