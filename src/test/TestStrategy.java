package test;

import model.Game;
import model.Personaje;
import model.PersonajeObserver;
import model.impl.Bala;
import model.impl.Car;
import model.impl.Pacman;

public class TestStrategy {

	public static void main(String[] args) {
		Game game = Game.instance();
		Personaje car = new Car(game);
		PersonajeObserver bala = new Bala(game);
		Personaje pacman = new Pacman(game);
		car.setFlagPlayer(false);
//		bala.setFlagPlayer(false);
		pacman.setFlagPlayer(true);
		game.addObserver(car);
		game.addObserver(bala);
		game.addObserver(pacman);
		game.setNivel(1);
		game.initGame();
		pacman.move();
		game.setNivel(2);
		pacman.move();
	}

}
