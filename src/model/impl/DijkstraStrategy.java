package model.impl;

import java.util.List;
import java.util.Queue;

import model.GameStrategy;
import model.Laberinto;
import model.Personaje;
import utils.Dijkstra;
import utils.Grafo;
import utils.Vertice;
/**
 * Patron Strategy
 * -StrategyConcreto
 * @author XD
 *
 */
public class DijkstraStrategy implements GameStrategy {
	/*
	 * (non-Javadoc)
	 * @see model.GameStrategy#getMoves(model.Personaje, model.Laberinto, model.Personaje)
	 */
	@Override
	public Queue<Vertice> getMoves(Personaje enemigos, Laberinto maze,
			Personaje player) {
		System.out.println("Getting DikstraStrategy");
		Dijkstra algoritmo = new Dijkstra();
		Grafo grafo = maze.getGrafo();
		Vertice v1 = grafo.encontrarVerticePoint(enemigos.getCurrentPosition());
		
		Vertice v2 = grafo.encontrarVerticePoint(player.getCurrentPosition());
		System.out.println("Origen " + v1.toString());
		
		System.out.println("Destino " + v2.toString());
		Queue<Vertice> resultado = algoritmo.encontrarMenorCaminoDijkstra(grafo, v1, v2);
		System.out.println("Mejor Camino " + resultado);
		return resultado;
	}
}
