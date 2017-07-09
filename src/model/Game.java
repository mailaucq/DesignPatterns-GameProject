package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.impl.Bala;
import model.impl.DijkstraStrategy;
import model.impl.GameOverState;
import model.impl.InitGameState;
import model.impl.LevelCompleteState;
import model.impl.LinearStrategy;
import model.impl.PauseState;
/**
 * Patron Observer
 * -SubjectConcrete
 * Patron State
 * -Context
 * Patron Strategy
 * -Context
 * @author XD
 *
 */
public class Game extends GameSubject{
	private GameState gameState;
	private int nivel;
	private GameStrategy gameStrategy;
	private Laberinto laberinto;
	private Personaje player;
	private List<Personaje> enemigos;
	private Bala bala;
	private OperationDraw drawerGame;
	private static Game game = null;
	private GameFactory gameFactory;
	private Game() {
		observers = new ArrayList<PersonajeObserver>();
		drawerGame = new OperationDrawerGame(this);
	}

	public static Game instance() {
		if (game == null) {
			game = new Game();
		}
		return game;
	}
	public Personaje getJugador() {
		return player;
	}

	public void setJugador(Personaje jugador) {
		this.player = jugador;
	}

	public List<Personaje> getEnemigos() {
		return enemigos;
	}
	
	public Bala getBala() {
		return bala;
	}

	public void setBala(Bala bala) {
		this.bala = bala;
	}

	public Laberinto getMaze() {
		return laberinto;
	}

	public GameFactory getGameFactory() {
		return gameFactory;
	}

	public void setGameFactory(GameFactory gameFactory) {
		this.gameFactory = gameFactory;
	}
	
	/**Strategias del Juego
	 * De acuerdo al nivel se setea una nueva estrategia
	 * @param nuevoNivel
	 */
	public void setNivel(int nuevoNivel){
		this.nivel = nuevoNivel;
		if(nivel == 1 ) gameStrategy = new LinearStrategy();
		else if (nivel == 2 ) gameStrategy = new DijkstraStrategy();
	}
	public int getNivel() {
		return nivel;
	}
	public GameStrategy getGameStrategy() {
		return gameStrategy;
	}
	
	/**
	 * States of Game
	 */
	public void initGame() {
		laberinto = game.getGameFactory().crearLaberinto();
        player = game.getGameFactory().crearPlayer();
        enemigos = game.getGameFactory().crearEnemigos();
        bala = game.getGameFactory().crearBala();
		drawerGame.initCanvas();
		addObserver(player);
		for (Iterator<Personaje> iterator = enemigos.iterator(); iterator.hasNext();) {
			Personaje enemigo = iterator.next();
			addObserver(enemigo);
		}
		addObserver(bala);
		notifyState(new InitGameState());
	}

	public void pauseGame() {
		notifyState(new PauseState());
	}

	public void gameOver() {
		notifyState(new GameOverState());
	}

	public void levelCompleteGame() {
		notifyState(new LevelCompleteState());
	}
	/**
	 * Observers del Juego
	 */
	/*
	 * (non-Javadoc)
	 * @see model.GameSubject#addObserver(model.Personaje)
	 */
	@Override
	public void addObserver(PersonajeObserver observer) {
		this.observers.add(observer);
	}
	
	/*
	 * (non-Javadoc)
	 * @see model.GameSubject#notifyEnemies()
	 */
	@Override
	public void notifyEnemies(){
		for (Iterator<Personaje> iterator = enemigos.iterator(); iterator.hasNext();) {
			PersonajeObserver personajeObsFly = iterator.next();
			personajeObsFly.updateMovesNotified();
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see model.GameSubject#notifyState(model.GameState)
	 */
	@Override
	public void notifyState(GameState gameState) {
		this.gameState = gameState;
		this.gameState.controlGameNotify(observers);
	}
}
