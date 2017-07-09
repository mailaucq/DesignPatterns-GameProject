package model;

import java.util.List;
/**
 * Patron State
 * -State
 * @author XD
 *
 */
public interface GameState {
	/*
	 * Metodo handle
	 */
	public void controlGameNotify(List<PersonajeObserver> observers);

}
