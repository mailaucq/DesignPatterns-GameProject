package utils;

import java.util.ArrayList;
import java.util.List;

public class Vertice implements Comparable<Vertice> {

	private String label;
	private Point point;
	private int distancia;
	private boolean visitado = false;
	private Vertice padre;
	private List<Arista> aristas = new ArrayList<Arista>();
	private List<Vertice> vecinos = new ArrayList<Vertice>();

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}
	
	public void visitar() {

		this.visitado = true;
	}

	public boolean verificarVisita() {

		return visitado;
	}

	public void setDistancia(int distancia) {

		this.distancia = distancia;
	}

	public int getDistancia() {

		return this.distancia;
	}

	public void setPadre(Vertice padre) {

		this.padre = padre;
	}

	public Vertice getPadre() {

		return this.padre;
	}

	public void setVecinos(List<Vertice> vecinos) {

		this.vecinos.addAll(vecinos);

	}

	public List<Vertice> getVecinos() {

		return this.vecinos;
	}

	public void setAristas(List<Arista> aristas) {

		this.aristas.addAll(aristas);

	}

	public List<Arista> getAristas() {

		return aristas;
	}
	
	public void resetVertice() {
		this.visitado = false;
		this.padre = null;
	}
	
	public int compareTo(Vertice vertice) {
		if (this.getDistancia() < vertice.getDistancia())
			return -1;
		else if (this.getDistancia() == vertice.getDistancia())
			return 0;

		return 1;

	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Vertice) {
			Vertice vRef = (Vertice) obj;
			if (this.getLabel().equals(vRef.getLabel()))
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Vertice [label=" + label + ", point=" + point + "]";
	}
}