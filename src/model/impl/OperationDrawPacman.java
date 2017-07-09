package model.impl;

import javax.media.opengl.GL2;

import com.jogamp.opengl.util.gl2.GLUT;

import utils.Point;
import model.OperationDrawPersonaje;
import model.Personaje;

public class OperationDrawPacman extends OperationDrawPersonaje{
	public float H = 0.5f;
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
	GLUT glut = null;
	
	
	public OperationDrawPacman(Personaje personaje) {
		super(personaje);
		position = personaje.getCurrentPosition();
		maze = personaje.getGame().getMaze().getMatriz();
		lastPosX = position.x;
		lastPosZ = position.y;
		xOrigin = (float) position.x * 2f;
		zOrigin = (float) position.y * 2f;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(GL2 gl,GameCanvas gameCanvas) {
		// TODO Auto-generated method stub
		this.canvas = gameCanvas;
		
		glut = canvas.glut;
	}

	@Override
	public void draw(GL2 gl) {
		System.out.println("Dibujar Pacman");
		// TODO Auto-generated method stub
        //gl.glClear(gl.GL_COLOR_BUFFER_BIT);
        gl.glColor3f(1.0f, 1.0f, 1.0f);
        gl.glPushMatrix();
        gl.glTranslatef(position.x*2, position.y*2, 0.0f);
        glut.glutWireSphere(H, 10, 10);
        gl.glPopMatrix();
        gl.glFlush();
		
	}

	@Override
	public void arriba() {
		System.out.println("zOrigin: " + zOrigin);
		System.out.println("Position y: " + position.y);
		if (zOrigin + step + H > 2 * position.y + 1) {
			if (maze[position.x][position.y + 1] != 0) {
				zOrigin += step;
				position.y++;
			} else {
				System.out.println("Colision!!!");
			}
		} else {
			zOrigin += step;
		}
		personaje.setCurrentPosition(position);
		personaje.move();
	}

	@Override
	public void abajo() {
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

	@Override
	public void derecha() {
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

	@Override
	public void izquierda() {
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

	@Override
	public void disparar() {
		// TODO Auto-generated method stub
		
	}
}
