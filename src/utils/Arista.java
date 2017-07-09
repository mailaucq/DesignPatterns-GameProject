package utils;

public class Arista {

	private int peso;
	private Vertice origen;
	private Vertice destino;

	public Arista(Vertice v1, Vertice v2) {
		this.peso = 1;
		this.origen = v1;
		this.destino = v2;
	}

	public void setPeso(int peso) {

		this.peso = peso;
	}

	public int getPeso() {

		return peso;
	}

	public void setDestino(Vertice destino) {
		this.destino = destino;
	}

	public Vertice getDestino() {
		return destino;
	}

	public void setOrigen(Vertice origen) {
		this.origen = origen;
	}

	public Vertice getOrigen() {
		return origen;
	}

}