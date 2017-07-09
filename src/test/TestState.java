package test;

import model.Game;
import model.Personaje;
import model.PersonajeObserver;
import model.impl.Bala;
import model.impl.Car;
import model.impl.Pacman;

public class TestState {
	public static void main(String[] arg) {
		Game game = Game.instance();
		PersonajeObserver bala = new Bala(game);
		Personaje car = new Car(game);
		Personaje pacman = new Pacman(game);
		game.addObserver(car);
		game.addObserver(bala);
		game.addObserver(pacman);
		game.initGame();
		game.pauseGame();
		game.levelCompleteGame();
	}
}
