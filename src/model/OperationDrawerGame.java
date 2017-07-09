package model;

import java.util.Iterator;

import javax.media.opengl.GL2;

import model.impl.GameCanvas;

public class OperationDrawerGame extends OperationDraw{
	private Game game;
	public OperationDrawerGame(Game game){
		this.game = game;
	}
	
	@Override
	public void init(GL2 gl, GameCanvas canvas) {
		game.getMaze().init(gl,canvas);
		game.getJugador().init(gl,canvas);
		for (Iterator<Personaje> iterator = game.getEnemigos().iterator(); iterator.hasNext();) {
			Personaje personajeObserver = iterator.next();
			personajeObserver.init(gl,canvas);
		}
		game.getBala().init(gl,canvas);
//		game.getMaze().init(gl);
	}
	@Override
	public void draw(GL2 gl) {
		game.getMaze().draw(gl);
//		game.getJugador().draw(gl);
//		for (Iterator<Personaje> iterator = game.getEnemigos().iterator(); iterator.hasNext();) {
//			Personaje personajeObserver = iterator.next();
//			personajeObserver.draw(gl);
//		}
//		game.getBala().draw(gl);
		for (Iterator iterator = game.observers.iterator(); iterator.hasNext();) {
			PersonajeObserver personaje = (PersonajeObserver) iterator.next();
			personaje.draw(gl);
		}
		
	}

}
