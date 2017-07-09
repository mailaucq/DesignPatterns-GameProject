package model;

import java.awt.BorderLayout;

import javax.media.opengl.GL2;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLProfile;
import javax.swing.JFrame;

import model.impl.GameCanvas;
/**
 * Patron Bridge
 * -Implementor
 * @author XD
 *
 */
public abstract class OperationDraw {
	private GameCanvas canvas;
	/**
	 * Operation init
	 * @param gl
	 */
	public abstract void init(GL2 gl, GameCanvas canvas);
	/**
	 * Operation Draw
	 * @param gl
	 */
	public abstract void draw(GL2 gl);
	public void initCanvas(){
		GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = createGLCapabilities(profile);
        canvas = new GameCanvas(this, capabilities, 800, 500);
        JFrame frame = new JFrame("Juego 5");
        frame.getContentPane().add(canvas, BorderLayout.CENTER);
        frame.setSize(800, 500);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        canvas.requestFocus();
	}
	public static GLCapabilities createGLCapabilities(GLProfile profile) {
		GLCapabilities capabilities = new GLCapabilities(profile);
		capabilities.setRedBits(8);
		capabilities.setBlueBits(8);
		capabilities.setGreenBits(8);
		capabilities.setAlphaBits(8);
		return capabilities;

	}
}
