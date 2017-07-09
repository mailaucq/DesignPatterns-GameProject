package test;

import model.Game;
import model.Personaje;
import model.impl.Bala;
import model.impl.Car;
import model.impl.Pacman;

public class TestObserver {
	public static void main(String[] args) {
		Game game = Game.instance();
		Personaje car = new Car(game);
		Bala bala = new Bala(game);
		Personaje pacman = new Pacman(game);
		game.addObserver(car);
		game.addObserver(bala);
		game.addObserver(pacman);
		// game.change();
		game.initGame();
	}
}
