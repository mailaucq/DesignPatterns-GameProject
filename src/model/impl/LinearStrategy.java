package model.impl;

import java.util.List;
import java.util.Queue;

import model.GameStrategy;
import model.Laberinto;
import model.Personaje;
import utils.Vertice;
/**
 * Patron Strategy
 * -StrategyConcreto
 * @author XD
 *
 */
public class LinearStrategy implements GameStrategy{
	/*
	 * (non-Javadoc)
	 * @see model.GameStrategy#getMoves(model.Personaje, model.Laberinto, model.Personaje)
	 */
	@Override
	public Queue<Vertice> getMoves(Personaje enemigos, Laberinto maze,
			Personaje player) {
		System.out.println("Getting LinarStrategy");
		return null;
	}
	

}
