package model;

import java.util.Queue;

import javax.media.opengl.GL2;

import model.impl.GameCanvas;
import utils.Point;
import utils.Vertice;
/**
 * Patron Observer
 * -ObserverConcrete
 * @author laura
 *
 */
public abstract class Personaje extends PersonajeObserver {
	protected Game game;
	protected Queue<Vertice> moves;
	protected boolean flagPlayer;// true es jugador, false es enemigo
	protected Point currentPosition;
	protected boolean horizontal;
	
	public void setCurrentPosition(Point currentPosition) {
		this.currentPosition = currentPosition;
	}

	public Queue<Vertice> getMoves() {
		return moves;
	}

	public void setMoves(Queue<Vertice> moves) {
		this.moves = moves;
	}
	/**
	 * Operation draw to Bridge
	 */
	protected OperationDrawPersonaje operationDrawPersonaje;
	public Personaje(Game game) {
		this.game = game;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public boolean isFlagPlayer() {
		return flagPlayer;
	}

	public void setFlagPlayer(boolean flagPlayer) {
		this.flagPlayer = flagPlayer;
	}

	public Point getCurrentPosition(){
		return currentPosition;
	}
	
	public boolean isHorizontal() {
		return horizontal;
	}

	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}

	/**
	 * Operation to Bridge
	 */
	@Override
	public void draw(GL2 gl){
		operationDrawPersonaje.draw(gl);		
	}

		
	/**
	 * States of Personaje
	 */
	public abstract void init();

	public abstract void move();
	
	public abstract void pause();

	public abstract void gameover();

	public abstract void levelComplete();

	public abstract void hurt();

	public abstract void visible();

	public abstract void invisible();
	
	public abstract void disparar();

	public void init(GL2 gl, GameCanvas canvas) {
		operationDrawPersonaje.init(gl, canvas);
	}
	/*
	 * (non-Javadoc)
	 * @see model.PersonajeObserver#updateMovesNotified()
	 */
	@Override
	public void updateMovesNotified() {
		System.out.println("actualizando ruta ...");
		GameStrategy myStrategy = game.getGameStrategy();
		if (!flagPlayer) {
			moves = myStrategy.getMoves(this, game.getMaze(), game.getJugador());
		}
	}
	/*
	 * (non-Javadoc)
	 * @see model.PersonajeObserver#initNotified()
	 */
	@Override
	public void initNotified() {
		init();
	}
	/*
	 * (non-Javadoc)
	 * @see model.PersonajeObserver#pauseNotified()
	 */
	@Override
	public void pauseNotified() {
		pause();
	}
	/*
	 * (non-Javadoc)
	 * @see model.PersonajeObserver#gameoverNotified()
	 */
	@Override
	public void gameoverNotified() {
		gameover();
	}
	/*
	 * (non-Javadoc)
	 * @see model.PersonajeObserver#levelCompleteNotified()
	 */
	@Override
	public void levelCompleteNotified() {
		levelComplete();
	}
	/*
	 * (non-Javadoc)
	 * @see model.PersonajeObserver#hurtNotified()
	 */
	@Override
	public void hurtNotified() {
		hurt();
	}
	/*
	 * (non-Javadoc)
	 * @see model.PersonajeObserver#visibleNotified()
	 */
	@Override
	public void visibleNotified() {
		visible();
	}
	/*
	 * (non-Javadoc)
	 * @see model.PersonajeObserver#invisibleNotified()
	 */
	@Override
	public void invisibleNotified() {
		invisible();
	}

	public void arriba() {
		operationDrawPersonaje.arriba();
	}

	public void abajo() {
		operationDrawPersonaje.abajo();
	}

	public void izquierda() {
		operationDrawPersonaje.izquierda();
	}

	public void derecha() {
		operationDrawPersonaje.derecha();
	}
}
