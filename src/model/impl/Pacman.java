package model.impl;

import java.util.Random;

import model.Game;
import model.Personaje;
import utils.Grafo;

public class Pacman extends Personaje {

	public Pacman(Game game) {
		super(game);
	}

	@Override
	public void init() {
		System.out.println("Init Pacman");
		Grafo grafo = game.getMaze().getGrafo();
		if(isFlagPlayer()){
			currentPosition = grafo.getVertices().get(0).getPoint();
		} else {
			int max = grafo.getVertices().size();
			int min = 3;
			Random rand = new Random();
		    int randomNum = rand.nextInt((max - min)) + min;
			currentPosition = grafo.getVertices().get(randomNum).getPoint();
		}
		operationDrawPersonaje = new OperationDrawPacman(this);
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
		System.out.println("Pause Pacman");
	}

	@Override
	public void gameover() {
		System.out.println("Gameover Pacman");
	}

	@Override
	public void levelComplete() {
		System.out.println("Level Complete Pacman");
	}

	@Override
	public void hurt() {
		System.out.println("Hurt Pacman");
	}

	@Override
	public void visible() {
		System.out.println("Visible Pacman");
	}

	@Override
	public void invisible() {
		System.out.println("Invisible Pacman");
	}

	@Override
	public void disparar() {
		operationDrawPersonaje.disparar();
		
	}
}
