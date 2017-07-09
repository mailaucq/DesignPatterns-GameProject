package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import utils.Dijkstra;
import utils.Grafo;
import utils.LeerArquivoGrafo;
import utils.Vertice;

public class TestGrafo {
	public static void main(String[] args) {
		Grafo grafo = new Grafo();
		grafo.setVertices(LeerArquivoGrafo.leerGrafo("grafo.txt"));
		Vertice i1 = new Vertice();
		Vertice i2 = new Vertice();
		i1 = grafo.encontrarVertice("v1");
		i2 = grafo.encontrarVertice("v4");
		Queue<Vertice> resultado = new LinkedList<Vertice>();
		Dijkstra algoritmo = new Dijkstra();
		resultado = algoritmo.encontrarMenorCaminoDijkstra(grafo, i1, i2);
		System.out.println("Mejor Camino" + resultado);
	}
}
