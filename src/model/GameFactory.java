package model;

import java.util.List;

import model.impl.Bala;
/**
 * Patron AbstractFactory
 * -AbstractFactory
 * @author XD
 *
 */
public interface GameFactory {
	/**
	 * Create Producto Laberinto
	 * @return
	 */
	public Laberinto crearLaberinto();
	/**
	 * Create Producto Player
	 * @return
	 */
	public Personaje crearPlayer();
	/**
	 * Create Producto Enemigos
	 * @return
	 */
	public List<Personaje>  crearEnemigos();
	/**
	 * Create Producto Bala
	 */
	public Bala crearBala();
}
