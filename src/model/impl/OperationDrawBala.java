package model.impl;

import java.util.Iterator;
import java.util.List;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;

import model.Game;
import model.OperationDraw;
import model.Personaje;
import utils.Point;

public class OperationDrawBala extends OperationDraw{
	Bala bala = null;
	protected GameCanvas canvas;
	int textureBalaFront = 2;
	int textureBalaLeft = 3;
	int textureBalaAbove = 4;
	int textureBalaBack = 5;
	public float H = 0.1f;
	public float W = 0.3f;
	float grosor = 0.1f;
	float num = 0.f;
	float numz = 0.f;
	float xOrigin = 0f;
	float zOrigin = 0f;
	Point position;
	int [][] maze = null;
	float x= 0;
	float z= 0;
	boolean horizontal = true;
	int direccion = 1;
	float step = 0.1f;
	public OperationDrawBala(Bala bala) {
		this.bala = bala;
		Personaje jugador = Game.instance().getJugador();
		bala.setCurrentPosition(new Point(jugador.getCurrentPosition().x, jugador.getCurrentPosition().y));
		maze = bala.getGame().getMaze().getMatriz();
		xOrigin = bala.currentPosition.x;
		zOrigin = bala.currentPosition.y;
		horizontal = bala.isHorizontal();
		direccion = bala.getDireccion();
	}
	
	@Override
	public void init(GL2 gl, GameCanvas canvas) {
		textureBalaAbove = canvas.loadTexture("shoot_back.png", gl);
		textureBalaBack = canvas.loadTexture("shoot_above.png", gl);
		textureBalaFront = canvas.loadTexture("shoot_front.png", gl);
		textureBalaLeft = canvas.loadTexture("shoot_left.png", gl);
		this.canvas = canvas;
		
	}
	
//	public void draw(GL2 gl) {
//		Personaje player = bala.getGame().getJugador();
//		Point point1 = player.getCurrentPosition();
//	    float xOrigin = (float)point1.x * 2f - 1f; //a posicion -1 del carro
//	    float zOrigin = (float)point1.y * 2f;
////	    bala.setCurrentPosition(point1);
//	    drawOne(gl, xOrigin , zOrigin);
//		List<Personaje> enemigos = bala.getGame().getEnemigos();
//		for (Iterator<Personaje> iterator = enemigos.iterator(); iterator.hasNext();) {
//			Personaje personaje2 = (Personaje) iterator.next();
//			Point point = personaje2.getCurrentPosition();
//		    float xOrigin1 = (float)point.x * 2f - 1f; //a posicion -1 del carro
//		    float zOrigin1 = (float)point.y * 2f;
////		    bala.setCurrentPosition(point);
//		    drawOne(gl, xOrigin1 , zOrigin1);
////		    System.out.println(bala.getCurrentPosition());
//		}
//	}
	

	@Override
	public void draw(GL2 gl) {
	    if(horizontal)
	    	xOrigin+=direccion*step;
	    else
	    	zOrigin+=direccion*step;
		
		drawOne(gl);
	}

	
	
	private void drawOne(GL2 gl){
	    //pared1
		gl.glBegin(GL2.GL_QUADS);
		gl.glVertex3f(-W + xOrigin, -grosor, -H - zOrigin);
		gl.glVertex3f(-W + xOrigin, -grosor, H - zOrigin);
		gl.glVertex3f(-W + xOrigin, grosor, H - zOrigin);
		gl.glVertex3f(-W + xOrigin, grosor, -H - zOrigin);
		gl.glEnd();
		//pared2
		gl.glBegin(GL2.GL_QUADS);
		gl.glVertex3f(-W + xOrigin, -grosor, H - zOrigin);
		gl.glVertex3f(W + xOrigin, -grosor, H - zOrigin);
		gl.glVertex3f(W + xOrigin, grosor, H - zOrigin);
		gl.glVertex3f(-W + xOrigin, grosor, H - zOrigin);
		gl.glEnd();
		
		//pared3
		gl.glBegin(GL2.GL_QUADS);
		gl.glVertex3f(W + xOrigin, -grosor, H - zOrigin);
		gl.glVertex3f(W + xOrigin, -grosor, -H - zOrigin);
		gl.glVertex3f(W + xOrigin, grosor, -H - zOrigin);
		gl.glVertex3f(W + xOrigin, grosor, H - zOrigin);
		gl.glEnd();

		//pared4
		gl.glBegin(GL2.GL_QUADS);
		gl.glVertex3f(W + xOrigin, -grosor, -H - zOrigin);
		gl.glVertex3f(-W + xOrigin, -grosor, -H - zOrigin);
		gl.glVertex3f(-W + xOrigin, grosor, -H - zOrigin);
		gl.glVertex3f(W + xOrigin, grosor, -H - zOrigin);
		gl.glEnd();

		//techo
		gl.glBindTexture(GL.GL_TEXTURE_2D, textureBalaAbove);
		gl.glBegin(GL2.GL_QUADS);
		gl.glTexCoord2f(0.0f, 1.0f);
		gl.glVertex3f(-W + xOrigin, grosor, H - zOrigin);
		gl.glTexCoord2f(1.0f, 1.0f);
		gl.glVertex3f(W + xOrigin, grosor, H - zOrigin);
		gl.glTexCoord2f(1.0f, 0.0f);
		gl.glVertex3f(W + xOrigin, grosor, -H - zOrigin);
		gl.glTexCoord2f(0.0f, 0.0f);
		gl.glVertex3f(-W + xOrigin, grosor, -H - zOrigin);
		gl.glEnd();
	}
	public float getNum() {
		return num;
	}
	public void setNum(float num) {
		this.num = num;
	}
	public float getNumz() {
		return numz;
	}
	public void setNumz(float numz) {
		this.numz = numz;
	}
}