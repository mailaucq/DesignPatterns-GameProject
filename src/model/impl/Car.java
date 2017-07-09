package model.impl;

import java.util.Random;

import model.Game;
import model.Personaje;
import utils.Grafo;

public class Car extends Personaje{

	public Car(Game game) {
		super(game);
	}

	@Override
	public void init() {
		System.out.println("Init Car");
		Grafo grafo = game.getMaze().getGrafo();
		horizontal = true;
		if(isFlagPlayer()){
			currentPosition = grafo.getVertices().get(0).getPoint();
		} else {
			int max = grafo.getVertices().size();
			int min = 3;
			Random rand = new Random();
		    int randomNum = rand.nextInt((max - min)) + min;
			currentPosition = grafo.getVertices().get(randomNum).getPoint();
			System.out.println(currentPosition);
		}
		operationDrawPersonaje = new OperationDrawCar(this);
//		draw();
	}
	

	@Override
	public void move() {
//		draw();
		if (flagPlayer) {
			game.notifyEnemies();
		}
	}

	@Override
	public void pause() {
		System.out.println("Pause Car");
	}

	@Override
	public void gameover() {
		System.out.println("GameOver Car");
	}

	@Override
	public void levelComplete() {
		System.out.println("Level Complete Car");
	}

	@Override
	public void hurt() {
		System.out.println("Hurt Car");
	}

	@Override
	public void visible() {
		System.out.println("Visible Car");
	}

	@Override
	public void invisible() {
		System.out.println("Invisible Car");
	}

	@Override
	public void disparar() {
		operationDrawPersonaje.disparar();
	}
}
