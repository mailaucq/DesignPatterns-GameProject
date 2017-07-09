package model.impl;

import java.util.Iterator;
import java.util.List;

import model.GameState;
import model.PersonajeObserver;
/**
 * Patron State
 * -StateConcreto
 * @author XD
 *
 */
public class PauseState implements GameState{
	/*
	 * (non-Javadoc)
	 * @see model.GameState#controlGameNotify(java.util.List)
	 */
	@Override
	public void controlGameNotify(List<PersonajeObserver> observers) {
		for (Iterator<PersonajeObserver> iterator = observers.iterator(); iterator.hasNext();) {
			PersonajeObserver personajeObsFly = iterator.next();
			personajeObsFly.pauseNotified();
		}
		System.out.println("Juego Pausado");
	}

}
