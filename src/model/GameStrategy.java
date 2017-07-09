package model;

import java.util.List;
import java.util.Queue;

import utils.Vertice;
/**
 * Patron Strategy
 * -Strategy
 * @author XD
 *
 */
public interface GameStrategy {
	/**
	 * Algoritmo para el movimiento de los personajes enemigos
	 * input: pos_personaje, mapa, el pos_observado
	 * @param observer
	 * @param maze
	 * @param player
	 * @return
	 */
	public Queue<Vertice> getMoves(Personaje enemigos,Laberinto maze,Personaje player );
}
