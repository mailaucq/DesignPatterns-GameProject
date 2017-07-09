package model;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;

import model.impl.GameCanvas;

public class OperationDrawLaberinto extends OperationDraw{
	private Laberinto laberinto;
	int texture;
	int textureWall;
	public OperationDrawLaberinto(Laberinto laberinto){
		this.laberinto = laberinto;
	}
	@Override
	public void init(GL2 gl, GameCanvas canvas){
		textureWall = canvas.loadTexture("wall3.png", gl);
		texture = canvas.loadTexture("floor3.png", gl);
	}
	@Override
	public void draw(GL2 gl){
		//System.out.println("Dibujar Laberinto");
        int [][]matrix = laberinto.getMatriz();
        for (int numz = 0; numz < laberinto.columnas; numz++) {
			for (int num =  0;num < laberinto.filas ; num++) {
				gl.glBindTexture(GL.GL_TEXTURE_2D, texture);	
				// floor
				gl.glBegin(GL2.GL_QUADS);
				gl.glTexCoord2f(1.0f, 1.0f);
				gl.glVertex3f(-1.0f + num * 2f, -1.0f, -1.0f - numz * 2f);
				gl.glTexCoord2f(0.0f, 1.0f);
				gl.glVertex3f(1.0f + num * 2f, -1.0f, -1.0f - numz * 2f);
				gl.glTexCoord2f(0.0f, 0.0f);
				gl.glVertex3f(1.0f + num * 2f, -1.0f, 1.0f - numz * 2f);
				gl.glTexCoord2f(1.0f, 0.0f);
				gl.glVertex3f(-1.0f + num * 2f, -1.0f, 1.0f - numz * 2f);
				gl.glEnd();

				// roof
//				gl.glBegin(GL2.GL_QUADS);
//				gl.glTexCoord2f(1.0f, 1.0f);
//				gl.glVertex3f(-1.0f + num * 2f, 1.0f, -1.0f - numz * 2f);
//				gl.glTexCoord2f(0.0f, 1.0f);
//				gl.glVertex3f(1.0f + num * 2f, 1.0f, -1.0f - numz * 2f);
//				gl.glTexCoord2f(0.0f, 0.0f);
//				gl.glVertex3f(1.0f + num * 2f, 1.0f, 1.0f - numz * 2f);
//				gl.glTexCoord2f(1.0f, 0.0f);
//				gl.glVertex3f(-1.0f + num * 2f, 1.0f, 1.0f - numz * 2f);
				gl.glEnd();
				gl.glBindTexture(GL.GL_TEXTURE_2D, textureWall);			
				if (matrix[num][numz] == 0) {
					
					
					
					// Draw Cube
					gl.glBegin(GL2.GL_QUADS);
		
					gl.glTexCoord2f(0.0f, 0.0f);
					gl.glVertex3f(-1.0f + num * 2f, -1.0f, 1.0f - numz * 2f);
					gl.glTexCoord2f(1.0f, 0.0f);
					gl.glVertex3f(1.0f + num * 2f, -1.0f, 1.0f - numz * 2f);
					gl.glTexCoord2f(1.0f, 1.0f);
					gl.glVertex3f(1.0f + num * 2f, 1.0f, 1.0f - numz * 2f);
					gl.glTexCoord2f(0.0f, 1.0f);
					gl.glVertex3f(-1.0f + num * 2f, 1.0f, 1.0f - numz * 2f);

					gl.glTexCoord2f(1.0f, 0.0f);
					gl.glVertex3f(-1.0f + num * 2f, -1.0f, -1.0f - numz * 2f);
					gl.glTexCoord2f(1.0f, 1.0f);
					gl.glVertex3f(-1.0f + num * 2f, 1.0f, -1.0f - numz * 2f);
					gl.glTexCoord2f(0.0f, 1.0f);
					gl.glVertex3f(1.0f + num * 2f, 1.0f, -1.0f - numz * 2f);
					gl.glTexCoord2f(0.0f, 0.0f);
					gl.glVertex3f(1.0f + num * 2f, -1.0f, -1.0f - numz * 2f);

					gl.glTexCoord2f(1.0f, 0.0f);
					gl.glVertex3f(1.0f + num * 2f, -1.0f, -1.0f - numz * 2f);
					gl.glTexCoord2f(1.0f, 1.0f);
					gl.glVertex3f(1.0f + num * 2f, 1.0f, -1.0f - numz * 2f);
					gl.glTexCoord2f(0.0f, 1.0f);
					gl.glVertex3f(1.0f + num * 2f, 1.0f, 1.0f - numz * 2f);
					gl.glTexCoord2f(0.0f, 0.0f);
					gl.glVertex3f(1.0f + num * 2f, -1.0f, 1.0f - numz * 2f);

					gl.glTexCoord2f(0.0f, 0.0f);
					gl.glVertex3f(-1.0f + num * 2f, -1.0f, -1.0f - numz * 2f);
					gl.glTexCoord2f(1.0f, 0.0f);
					gl.glVertex3f(-1.0f + num * 2f, -1.0f, 1.0f - numz * 2f);
					gl.glTexCoord2f(1.0f, 1.0f);
					gl.glVertex3f(-1.0f + num * 2f, 1.0f, 1.0f - numz * 2f);
					gl.glTexCoord2f(0.0f, 1.0f);
					gl.glVertex3f(-1.0f + num * 2f, 1.0f, -1.0f - numz * 2f);
					
					gl.glTexCoord2f(1.0f, 1.0f);
					gl.glVertex3f(-1.0f + num * 2f, 1.0f, -1.0f - numz * 2f);
					gl.glTexCoord2f(0.0f, 1.0f);
					gl.glVertex3f(1.0f + num * 2f, 1.0f, -1.0f - numz * 2f);
					gl.glTexCoord2f(0.0f, 0.0f);
					gl.glVertex3f(1.0f + num * 2f, 1.0f, 1.0f - numz * 2f);
					gl.glTexCoord2f(1.0f, 0.0f);
					gl.glVertex3f(-1.0f + num * 2f, 1.0f, 1.0f - numz * 2f);
					
					gl.glEnd();

				}
			}
		}
	}
}
