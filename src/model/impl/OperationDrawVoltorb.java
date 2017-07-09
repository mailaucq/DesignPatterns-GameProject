package model.impl;

import javax.media.opengl.GL2;

import model.OperationDrawPersonaje;
import model.Personaje;

public class OperationDrawVoltorb extends OperationDrawPersonaje{
	public OperationDrawVoltorb(Personaje personaje) {
		super(personaje);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(GL2 gl,GameCanvas gameCanvas) {
		// TODO Auto-generated method stub
		this.canvas = gameCanvas;
	}

	@Override
	public void draw(GL2 gl) {
		System.out.println("Dibujar Voltorb");
	}

	@Override
	public void arriba() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void abajo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void derecha() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void izquierda() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disparar() {
		// TODO Auto-generated method stub
		
	}
}
