package utils;

import java.util.ArrayList;
import java.util.List;

public class Grafo {

	private List<Vertice> grafo = new ArrayList<Vertice>();

	public void setVertices(List<Vertice> vertices) {
		this.grafo.addAll(vertices);
	}

	public void adicionarVertice(Vertice novoVertice) {
		this.grafo.add(novoVertice);
	}

	public List<Vertice> getVertices() {
		return this.grafo;
	}

	public Vertice encontrarVertice(String nome) {
		for (int i = 0; i < this.getVertices().size(); i++) {
			if (nome.equalsIgnoreCase(this.getVertices().get(i).getLabel())) {
				return this.getVertices().get(i);
			}
		}
		return null;

	}

	public Vertice encontrarVerticePoint(Point point) {
		for (int i = 0; i < this.getVertices().size(); i++) {
			if (point.x == this.getVertices().get(i).getPoint().x
					&& point.y == this.getVertices().get(i).getPoint().y) {
				return this.getVertices().get(i);
			}
		}
		return null;
	}

}