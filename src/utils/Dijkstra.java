package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Dijkstra {
	public Queue<Vertice> encontrarMenorCaminoDijkstra(Grafo grafo, Vertice v1,
			Vertice v2) {
		Queue<Vertice> result = new LinkedList<Vertice>();
		List<Vertice> menorCamino = new ArrayList<Vertice>();
		Vertice verticeCamino = new Vertice();
		Vertice actual = new Vertice();
		Vertice vecino = new Vertice();
		List<Vertice> noVisitados = new ArrayList<Vertice>();
		menorCamino.add(v1);
		for (int i = 0; i < grafo.getVertices().size(); i++) {
			if (grafo.getVertices().get(i).getLabel()
					.equals(v1.getLabel())) {
				grafo.getVertices().get(i).setDistancia(0);
			} else {
				grafo.getVertices().get(i).setDistancia(9999);
			}
			grafo.getVertices().get(i).resetVertice();
			noVisitados.add(grafo.getVertices().get(i));
		}

		Collections.sort(noVisitados);

		while (!noVisitados.isEmpty()) {
			actual = noVisitados.get(0);
			for (int i = 0; i < actual.getAristas().size(); i++) {
				vecino = actual.getAristas().get(i).getDestino();
//				System.out.println("Vecino de actual " + actual + ": " + vecino);
				if (!vecino.verificarVisita()) {
					if (vecino.getDistancia() > (actual.getDistancia() + actual
							.getAristas().get(i).getPeso())) {
						vecino.setDistancia(actual.getDistancia()
								+ actual.getAristas().get(i).getPeso());
						vecino.setPadre(actual);
						if (vecino == v2) {
							menorCamino.clear();
							menorCamino.add(vecino);
							verticeCamino = vecino;
							while (verticeCamino.getPadre() != null) {
								menorCamino.add(verticeCamino.getPadre());
								verticeCamino = verticeCamino.getPadre();
							}
							Collections.sort(menorCamino);
						}
					}
				}
			}
			actual.visitar();
			noVisitados.remove(actual);
			Collections.sort(noVisitados);
//			System.out.println("Todavia no ha sido visitados:" + noVisitados);
		}
		result.addAll(menorCamino);
		return result;
	}
}
