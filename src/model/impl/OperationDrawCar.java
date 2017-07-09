package model.impl;
import java.util.Queue;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;

import model.Game;
import model.OperationDrawPersonaje;
import model.Personaje;
import utils.Point;
import utils.Vertice;

public class OperationDrawCar extends OperationDrawPersonaje {

	int textureCarFront = 2;
	int textureCarLeft = 3;
	int textureCarAbove = 4;
	int textureCarBack = 5;
	public float H = 0.2f;
	public float W = 0.5f;
	public float step = 0.1f;
	float grosor = 0.2f;
	float num = 0.f;
	float numz = 0.f;
	float xOrigin = 0;
	float zOrigin = 0;
	float lastPosX = 0f;
	float lastPosZ = 0f;
	Point position;
	int[][] maze = null;
	float x = 0;
	float z = 0;
	boolean horizontal = true;
	int direccion = -1;
	public OperationDrawCar(Personaje personaje) {
		super(personaje);
		position = personaje.getCurrentPosition();
		maze = personaje.getGame().getMaze().getMatriz();
		lastPosX = position.x;
		lastPosZ = position.y;
		xOrigin = (float) position.x * 2f;
		zOrigin = (float) position.y * 2f;

		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				System.out.print(maze[i][j] + " ");
				if (i % maze.length == 0)
					System.out.println("\n");
			}
		}

	}

	@Override
	public void init(GL2 gl, GameCanvas canvas) {
		textureCarAbove = canvas.loadTexture("car_above.png", gl);
		textureCarBack = canvas.loadTexture("car_back.png", gl);
		textureCarFront = canvas.loadTexture("car_front.png", gl);
		textureCarLeft = canvas.loadTexture("car_left.png", gl);
		this.canvas = canvas;
//		canvas.moves = this;
	}

	@Override
	public void draw(GL2 gl) {

		if (!personaje.isFlagPlayer()) {			
			Queue<Vertice> moves = personaje.getMoves();
			//System.out.println("Enemigo moves "+moves.size());
			if (moves != null && moves.size() > 0) {
				System.err.println(moves);
				Vertice vertice = moves.peek();
				Point point = vertice.getPoint();
				System.err.println("*********" + vertice);
				Point ini = personaje.getCurrentPosition();
				float stepX = (point.x - ini.x);
				float stepY = (point.y - ini.y);
				if(stepX > 0 ){
					if((2*point.x - xOrigin)!=0)
						xOrigin+=step;
				}
				if(stepX < 0 ){
					if((2*point.x - xOrigin)!=0)
						xOrigin-=step;
				}
				if(stepY < 0 ){
					if((2*point.y - zOrigin)!=0)
						xOrigin-=step;
				}
				if(stepY > 0 ){
					if((2*point.y - zOrigin)!=0)
						xOrigin+=step;
				}
				if((2*point.y - zOrigin)==0 && (2*point.x - xOrigin) == 0)
				{	personaje.setCurrentPosition(point);
					moves.poll();
				}
				
				z = point.y;
				x = point.x;
				xOrigin = (float) x * 2f;
				zOrigin = (float) z * 2f;
				
				
				System.out.println(personaje.getCurrentPosition());
			}
		}
		// pared1
		// gl.glBindTexture(GL.GL_TEXTURE_2D, textureCarAbove);
		gl.glBegin(GL2.GL_QUADS);
		// gl.glTexCoord2f(0.5f, 0.5f);
		gl.glVertex3f(-W + xOrigin, -grosor, -H - zOrigin);
		gl.glVertex3f(-W + xOrigin, -grosor, H - zOrigin);

		// gl.glTexCoord2f(0.0f, 0.5f);
		gl.glVertex3f(-W + xOrigin, grosor, H - zOrigin);
		// gl.glTexCoord2f(0.0f, 0.0f);
		// gl.glTexCoord2f(0.5f, 0.0f);
		gl.glVertex3f(-W + xOrigin, grosor, -H - zOrigin);

		gl.glEnd();

		// pared2
		// gl.glBindTexture(GL.GL_TEXTURE_2D, textureCarAbove);
		gl.glBegin(GL2.GL_QUADS);
		// gl.glTexCoord2f(0.5f, 0.5f);
		gl.glVertex3f(-W + xOrigin, -grosor, H - zOrigin);
		gl.glVertex3f(W + xOrigin, -grosor, H - zOrigin);

		// gl.glTexCoord2f(0.0f, 0.5f);
		gl.glVertex3f(W + xOrigin, grosor, H - zOrigin);
		// gl.glTexCoord2f(0.0f, 0.0f);
		// gl.glTexCoord2f(0.5f, 0.0f);
		gl.glVertex3f(-W + xOrigin, grosor, H - zOrigin);

		gl.glEnd();

		// pared3
		// gl.glBindTexture(GL.GL_TEXTURE_2D, textureCarAbove);
		gl.glBegin(GL2.GL_QUADS);
		// gl.glTexCoord2f(0.0f, 1.0f);
		gl.glVertex3f(W + xOrigin, -grosor, H - zOrigin);
		// gl.glTexCoord2f(1.0f, 0.0f);
		gl.glVertex3f(W + xOrigin, -grosor, -H - zOrigin);
		// gl.glTexCoord2f(1.0f, 0.0f);
		gl.glVertex3f(W + xOrigin, grosor, -H - zOrigin);
		// gl.glTexCoord2f(0.0f, 0.0f);
		gl.glVertex3f(W + xOrigin, grosor, H - zOrigin);
		gl.glEnd();

		// pared4
		// gl.glBindTexture(GL.GL_TEXTURE_2D, textureCarAbove);
		gl.glBegin(GL2.GL_QUADS);
		// gl.glTexCoord2f(0.0f, 1.0f);
		gl.glVertex3f(W + xOrigin, -grosor, -H - zOrigin);
		// gl.glTexCoord2f(1.0f, 0.0f);
		gl.glVertex3f(-W + xOrigin, -grosor, -H - zOrigin);
		// gl.glTexCoord2f(1.0f, 0.0f);
		gl.glVertex3f(-W + xOrigin, grosor, -H - zOrigin);
		// gl.glTexCoord2f(0.0f, 0.0f);
		gl.glVertex3f(W + xOrigin, grosor, -H - zOrigin);

		gl.glEnd();

		// techo
		gl.glBindTexture(GL.GL_TEXTURE_2D, textureCarAbove);
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

	@Override
	public void arriba() {
		if(personaje.isFlagPlayer()){
			System.out.println("zOrigin: " + zOrigin);
			System.out.println("Position y: " + position.y);
			if (zOrigin + step + H > 2 * position.y + 1) {
				if (maze[position.x][position.y + 1] != 0) {
					zOrigin += step;
					position.y++;
					personaje.setCurrentPosition(position);
					personaje.move();
				} else {
					System.out.println("Colision!!!");
				}
			} else {
				zOrigin += step;
			}
		}
	}

	@Override
	public void abajo() {
		if(personaje.isFlagPlayer()){
			System.out.println("zOrigin: " + zOrigin);
			System.out.println("Position y: " + position.y);
			if (zOrigin - step - H < 2 * position.y - 1) {
				if (maze[position.x][position.y - 1] != 0) {
					zOrigin -= step;
					position.y--;
				} else {
					System.out.println("Colision!!!");
				}
			} else {
				zOrigin -= step;
			}
			personaje.setCurrentPosition(position);
			personaje.move();
		}
	}

	@Override
	public void derecha() {
		if(personaje.isFlagPlayer()){
			System.out.println("xOrigin: " + xOrigin);
			System.out.println("Position x: " + position.x);
			if (xOrigin + step + W > 2 * position.x + 1) {
				if (maze[position.x + 1][position.y] != 0) {
					xOrigin += step;
					position.x++;
				} else {
					System.out.println("Colision!!!");
				}
			} else {
				xOrigin += step;
			}
			personaje.setCurrentPosition(position);
			personaje.move();
		}
	}

	@Override
	public void izquierda() {
		if(personaje.isFlagPlayer()){
			System.out.println("xOrigin: " + xOrigin);
			System.out.println("Position x: " + position.x);
			if (xOrigin - step - W < 2 * position.x - 1) {
				if (maze[position.x - 1][position.y] != 0) {
					xOrigin -= step;
					position.x--;
				} else {
					System.out.println("Colision!!!");
				}
			} else {
				xOrigin -= step;
			}
			personaje.setCurrentPosition(position);
			personaje.move();
		}
	}
	
	@Override
	public void disparar(){
		System.out.println("disparar");
		Bala bala = Game.instance().getGameFactory().crearBala();
//		bala.setCurrentPosition(position);
//		bala.setDireccion(direccion);
//		bala.setHorizontal(horizontal);
		bala.init();
//		System.out.println("Bala Position "+position.x+" "+position.y);
		
		Game.instance().addObserver(bala);
		
	}

}

