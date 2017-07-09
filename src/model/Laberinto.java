package model;

import javax.media.opengl.GL2;

import model.impl.GameCanvas;
import utils.Grafo;
import utils.LeerArquivoLaberinto;

public class Laberinto {
	int id;
	int filas;
	int columnas;
	private Grafo grafo;
	private int[][] matriz;
	private static Laberinto instance;
//	private Renderer  renderer = null;
	private OperationDrawLaberinto operationDrawLaberinto;
	private Laberinto() {
		grafo = new Grafo();
		grafo.setVertices(LeerArquivoLaberinto.leerGrafo("laberinto.txt","grafo"));
		filas = LeerArquivoLaberinto.filas;
		columnas = LeerArquivoLaberinto.columnas;
		matriz = LeerArquivoLaberinto.matriz;
//		renderer = new Renderer();
//		renderer.loadMatrix(matriz, filas, columnas);
		operationDrawLaberinto = new OperationDrawLaberinto(this);
	}
	public static Laberinto instance(){
		if(instance == null){
			instance = new Laberinto();
		}
		return instance;
	}
	public void init(GL2 gl, GameCanvas canvas){
		operationDrawLaberinto.init(gl, canvas);
	}
	public void draw(GL2 gl){
		operationDrawLaberinto.draw(gl);
//		final GLCanvas canvas = new GLCanvas();
//		final Frame frame = new Frame("Drawing Maze");
//		final Animator animator = new Animator(canvas);
//		canvas.addGLEventListener(renderer);
//		canvas.addKeyListener(renderer);
//		frame.add(canvas);
//		frame.setSize(640, 480);
//		frame.setResizable(true);
//		frame.addWindowListener(new WindowAdapter() {
//			public void windowClosing(WindowEvent e) {
//				frame.dispose();
//				System.exit(0);
//			}
//		});
//		animator.start();
//		frame.setVisible(true);
//		canvas.requestFocus();
	}
	public void clear(){}
	public Grafo getGrafo(){
		return grafo;
	}
	public Grafo setGrafo(){
		return grafo;
	}
	public int getFilas() {
		return filas;
	}
	public void setFilas(int filas) {
		this.filas = filas;
	}
	public int getColumnas() {
		return columnas;
	}
	public void setColumnas(int columnas) {
		this.columnas = columnas;
	}
	public int[][] getMatriz() {
		return matriz;
	}
	public void setMatriz(int[][] matriz) {
		this.matriz = matriz;
	}
		
}
