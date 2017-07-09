package model;

import java.util.ArrayList;
import java.util.List;

import model.impl.Bala;
import model.impl.Pacman;

public class GameFactoryContreto2 implements GameFactory{
	private Laberinto laberinto;
	private Pacman player;
	private List<Personaje> enemigos;
	private Bala bala;
	int numEnemigos = 1;
	@Override
	public Laberinto crearLaberinto() {
		laberinto = Laberinto.instance();
		return laberinto;
	}

	@Override
	public Personaje crearPlayer() {
		player  = new Pacman(Game.instance());
		player.setFlagPlayer(true);
		return player;
	}
	
	@Override
	public List<Personaje> crearEnemigos() {
		enemigos = new ArrayList<>();
		for(int i = 0; i<numEnemigos;i++){
			Pacman enemigo = new Pacman(Game.instance());
			enemigo.setFlagPlayer(false);
			enemigos.add(enemigo);
		}
		return enemigos;
	}

	@Override
	public Bala crearBala() {
		bala = new Bala(Game.instance());
		return bala;
	}
	
}
