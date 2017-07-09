package model.impl;

import javax.media.opengl.GL2;

import utils.Point;
import model.Game;
import model.PersonajeObserver;

public class Bala extends PersonajeObserver{
	OperationDrawBala operationDrawBala;
	Point currentPosition;
	int direccion = 1;
	boolean horizontal = true;
	Game game;
	
	public Bala(Game game) {
		this.game = game;
	}
	
	public int getDireccion() {
		return direccion;
	}

	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}

	public boolean isHorizontal() {
		return horizontal;
	}



	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}



	public Point getCurrentPosition() {
		return currentPosition;
	}
	public void setCurrentPosition(Point point) {
		this.currentPosition = point;		
	}
	public void draw(GL2 gl){
		operationDrawBala.draw(gl);
	}
	
	public Game getGame() {
		return game;
	}
	
	public void init(GL2 gl, GameCanvas gameCanvas) {
		operationDrawBala.init(gl, gameCanvas);
		System.out.println("Init Bala");
	}

	public void init(){
		System.out.println("Init Car");
		this.operationDrawBala = new OperationDrawBala(this);
	}
	public void move() {
	}
	
	public void pause() {
		System.out.println("Pause Bala");
	}

	public void gameover() {
		System.out.println("GameOver Bala");
	}

	public void levelComplete() {
		System.out.println("Level Complete Bala");
	}

	public void hurt() {
		System.out.println("Hurt Bala");
	}

	public void visible() {
		System.out.println("Visible Bala");
	}

	public void invisible() {
		System.out.println("Invisible Bala");

	}

	@Override
	public void updateMovesNotified() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initNotified() {
		init();
	}

	@Override
	public void pauseNotified() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gameoverNotified() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void levelCompleteNotified() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hurtNotified() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visibleNotified() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void invisibleNotified() {
		// TODO Auto-generated method stub
		
	}
	
}
