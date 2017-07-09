package model.impl;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.IOException;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GL2ES1;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.gl2.GLUgl2;

import model.Game;
import model.OperationDraw;
import ui.TextureReader;

import com.jogamp.opengl.util.Animator;
import com.jogamp.opengl.util.gl2.GLUT;

public class GameCanvas extends GLCanvas implements GLEventListener,
		KeyListener, MouseWheelListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OperationDraw drawerGame;
	private GLU glu;
	private Animator animator;
	public float camx = -5.0f;
	public float camz = -10.0f;
	public float camy = -5.0f;
	float X_AXIS = 90.0f;
	float Y_AXIS = 0.0f;
	float Z_AXIS = 0.0f;
	public float x = 0;
	public float z = 0;
	public float step = 0.1f;
	public float sumStepsX = 0.0f;
	public float sumStepsZ = 0.0f;
	boolean move = false;
	int angle = 0;
	int texture = -1;
    public GLUT glut = null;
    
	public GameCanvas(OperationDraw operationDraw, GLCapabilities capabilities,
			int width, int height) {
		this.addGLEventListener(this);
		this.addKeyListener(this);
		this.addMouseWheelListener(this);
		this.drawerGame = operationDraw;
	}

	@Override
	public void init(GLAutoDrawable glDrawable) {
		glu = new GLU();
		glut = new GLUT();
		final GL2 gl = glDrawable.getGL().getGL2();
		// Configuraciones Globales
		gl.glShadeModel(GL2.GL_SMOOTH);
		gl.glClearColor(0.0f, 0.0f, 0.0f, 0.5f);
		gl.glClearDepth(1.0f);
		gl.glEnable(GL.GL_DEPTH_TEST);
		gl.glDepthFunc(GL.GL_LEQUAL);
		gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL.GL_NICEST);
		//
		gl.glEnable(GL2.GL_TEXTURE_2D);
		gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		gl.glClearDepth(1.0);
		gl.glDepthFunc(GL.GL_LESS);
		gl.glEnable(GL.GL_DEPTH_TEST);
		gl.glShadeModel(GL2ES1.GL_SMOOTH);
		gl.glMatrixMode(GL2ES1.GL_PROJECTION);
		gl.glLoadIdentity();
		glu.gluPerspective(45.0, (float) 640 / 480, 0.1, 100.0);
		gl.glMatrixMode(GL2ES1.GL_MODELVIEW);

		// initialize texture mapping
		gl.glEnable(GL.GL_TEXTURE_2D);
		gl.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER,
				GL.GL_NEAREST);
		gl.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER,
				GL.GL_NEAREST);
		gl.glTexEnvf(GL2ES1.GL_TEXTURE_ENV, GL2ES1.GL_TEXTURE_ENV_MODE,
				GL2ES1.GL_DECAL);

		// Inicia Configuracion de dibujo de Juego
		drawerGame.init(gl, this);
		// Inicia animator
		animator = new Animator(this);
		animator.start();
	}

	@Override
	public void reshape(GLAutoDrawable glDrawable, int x, int y, int width,
			int height) {
		final GL2 gl = glDrawable.getGL().getGL2();
		gl.glViewport(0, 0, width, height);
		if (height <= 0)
			height = 1;
		final float h = (float) width / (float) height;
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		glu.gluPerspective(45.0f, h, 1.0, 1000.0);
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();
	}

	@Override
	public void display(GLAutoDrawable drawable) {
		if (!animator.isAnimating()) {
			return;
		}
		final GL2 gl = drawable.getGL().getGL2();
		// Limpia pantalla
		gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
		// Posicion Camera
		setCamera(gl, glu, 100);
		// Dibuja Juego
		gl.glPushMatrix();
		drawerGame.draw(gl);
		gl.glPopMatrix();
		gl.glFlush();
	}

	@Override
	public void dispose(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
	}

	private void setCamera(GL2 gl, GLU glu, float distance) {
		gl.glLoadIdentity();
		gl.glTranslatef(0.0f + camx, 0.0f + camy, -10.0f + camz);
		// gl.glTranslatef(0.0f - camx, 0.0f, 0.0f - camz);
		// X_AXIS = 90;
		gl.glRotatef(X_AXIS, 1.0f, 0.0f, 0.0f);
		gl.glRotatef(Y_AXIS, 0.0f, 1.0f, 0.0f);
		gl.glRotatef(Z_AXIS, 0.0f, 0.0f, 1.0f);
		// gl.glTranslatef(0.0f + camx, -1.0f, 0.0f + camz);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyChar());
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
		if (e.getKeyChar() == 'a') {
			camx += 1;
		}

		if (e.getKeyChar() == 'd') {
			camx -= 1;
		}

		if (e.getKeyChar() == 'w') {
			camy -= 1;
		}
		if (e.getKeyChar() == 's') {
			camy += 1;

		}

		if (e.getKeyChar() == 'o') {
			X_AXIS -= 10;
		}
		if (e.getKeyChar() == 'l') {
			X_AXIS += 10;

		}

		int keyCode = e.getKeyCode();
		switch (keyCode) {
		case KeyEvent.VK_UP:
			Game.instance().getJugador().arriba();
			break;
		case KeyEvent.VK_DOWN:
			Game.instance().getJugador().abajo();
			break;
		case KeyEvent.VK_LEFT:
			Game.instance().getJugador().izquierda();
			break;
		case KeyEvent.VK_RIGHT:
			Game.instance().getJugador().derecha();
			break;
		case KeyEvent.VK_SPACE:
			Game.instance().getJugador().disparar();
			break;
		}
		
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		int rotacion = e.getWheelRotation();
		camz += rotacion;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public int loadTexture(String fileName, GL2 gl) {
		texture++;
		GLUgl2 glu = new GLUgl2();
		TextureReader.Texture image = null;
		try {
			image = TextureReader.readTexture(fileName);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		int width = image.getWidth();
		int height = image.getHeight();
		gl.glBindTexture(GL.GL_TEXTURE_2D, texture);
		gl.glPixelStorei(GL.GL_UNPACK_ALIGNMENT, 1);
		gl.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_REPEAT);
		gl.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_REPEAT);
		gl.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER,
				GL.GL_LINEAR);
		gl.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER,
				GL.GL_LINEAR_MIPMAP_LINEAR);
		glu.gluBuild2DMipmaps(GL.GL_TEXTURE_2D, GL.GL_RGB8, width, height,
				GL.GL_RGB, GL.GL_UNSIGNED_BYTE, image.getPixels());
		return texture;
	}
}
