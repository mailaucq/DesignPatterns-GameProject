package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import utils.Dijkstra;
import utils.Grafo;
import utils.LeerArquivoLaberinto;
import utils.Vertice;

public class TestLaberintoGrafo {
	public static void main(String[] args) {
		Grafo grafo = new Grafo();
		grafo.setVertices(LeerArquivoLaberinto.leerGrafo("laberinto.txt","grafo.txt"));
		Vertice i1 = new Vertice();
		Vertice i2 = new Vertice();
		i1 = grafo.encontrarVertice("1");
		i2 = grafo.encontrarVertice("6");
		Queue<Vertice> resultado = new LinkedList<Vertice>();
		Dijkstra algoritmo = new Dijkstra();
		resultado = algoritmo.encontrarMenorCaminoDijkstra(grafo, i1, i2);
		System.out.println("Mejor Camino" + resultado);
	}
}
