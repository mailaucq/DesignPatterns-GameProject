package model;

import java.util.ArrayList;
import java.util.List;

import model.impl.Bala;
import model.impl.Car;

public class GameFactoryConcreto1 implements GameFactory{
	protected Laberinto laberinto;
	protected Car player;
	protected List<Personaje> enemigos;
	protected Bala bala;
	int numEnemigos = 4;
	@Override
	public Laberinto crearLaberinto() {
		return Laberinto.instance();
	}

	@Override
	public Personaje crearPlayer() {
		player  = new Car(Game.instance());
		player.setFlagPlayer(true);
		return player;
	}
	
	@Override
	public List<Personaje> crearEnemigos() {
		enemigos = new ArrayList<>();
		for(int i = 0; i<numEnemigos;i++){
			Car enemigo = new Car(Game.instance());
			enemigo.setFlagPlayer(false);
			enemigos.add(enemigo);
		}
		return enemigos;
	}

	@Override
	public Bala crearBala() {
		Bala bala = new Bala(Game.instance());
		return bala;
	}
}
