package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LeerArquivoLaberinto {
	public static int filas;
	public static int columnas;
	public static int[][] matriz;
	public static List<Vertice> leerGrafo(String fileNameEntrada, String fileNameSalida) {

		Grafo g = new Grafo();
		try {
			File entrada = new File(fileNameEntrada);
			FileWriter salida = new FileWriter(fileNameSalida);
			PrintWriter pw = new PrintWriter(salida);
			filas = 0;
			columnas = 0;
			Scanner flujoE = new Scanner(entrada);
			filas = flujoE.nextInt();
			columnas = flujoE.nextInt();
			matriz = new int[filas][columnas];
			Map<String, Vertice> mapa = new HashMap<String, Vertice>();
			int k = 0;
			for (int i = 0; i < filas; i++) {
				for (int j = 0; j < columnas; j++) {
					matriz[i][j] = flujoE.nextInt();
					if (matriz[i][j] == 1) {
						String label = "" + k;
						Vertice v = (Vertice) mapa.get(i+""+j);
						if (v == null)
							v = new Vertice();
						v.setLabel(label);
						v.setPoint(new Point(i, j));
//						System.out.println(v.toString());
						mapa.put(i+""+j, v);
						g.adicionarVertice(v);
						k++;
					}
				}
			}
			
			int [][] aristas = new int[k][k];
			for (int k2 = 0; k2 < filas; k2++) {
				for (int l = 0; l < columnas; l++) {
					if(matriz[k2][l] == 1){
						Vertice v = (Vertice) mapa.get(k2+""+l);
						List<Vertice> vecinosActuales = new ArrayList<Vertice>();
						List<Arista> aristasActuales = new ArrayList<Arista>();
						if(matriz[k2][l] == 1){
							Vertice vecino = (Vertice) mapa.get(k2+""+l);
							aristas[Integer.parseInt(v.getLabel())][Integer.parseInt(vecino.getLabel())] = 1;
							vecinosActuales.add(vecino);
							Arista arista = new Arista(v, vecino);
							aristasActuales.add(arista);
						}
						if(l-1 >= 0){
							if(matriz[k2][l-1] == 1){
								Vertice vecino = (Vertice) mapa.get(k2+""+(l-1));
								aristas[Integer.parseInt(v.getLabel())][Integer.parseInt(vecino.getLabel())] = 1;
								vecinosActuales.add(vecino);
								Arista arista = new Arista(v, vecino);
								aristasActuales.add(arista);
							}
						}
						if(k2-1 >= 0){
							if(matriz[k2-1][l] == 1){
								Vertice vecino = (Vertice) mapa.get((k2-1)+""+(l));
								aristas[Integer.parseInt(v.getLabel())][Integer.parseInt(vecino.getLabel())] = 1;
								vecinosActuales.add(vecino);
								Arista arista = new Arista(v, vecino);
								aristasActuales.add(arista);
							}
						}
						if(k2+1 < filas){
							if(matriz[k2+1][l] == 1){
								Vertice vecino = (Vertice) mapa.get((k2+1)+""+(l));
								aristas[Integer.parseInt(v.getLabel())][Integer.parseInt(vecino.getLabel())] = 1;
								vecinosActuales.add(vecino);
								Arista arista = new Arista(v, vecino);
								aristasActuales.add(arista);
							}
						}
						if(l+1< columnas){
							if(matriz[k2][l+1] == 1){
								Vertice vecino = (Vertice) mapa.get((k2)+""+(l+1));
								aristas[Integer.parseInt(v.getLabel())][Integer.parseInt(vecino.getLabel())] = 1;
								vecinosActuales.add(vecino);
								Arista arista = new Arista(v, vecino);
								aristasActuales.add(arista);
							}
						}
						v.setVecinos(vecinosActuales);
						v.setAristas(aristasActuales);
					}
				}
			}
			for (int l = 0; l < aristas.length; l++) {
				for (int l2 = 0; l2 < aristas[0].length; l2++) {
					pw.print(aristas[l][l2]);
					if(l2 != aristas[0].length-1){
						pw.print(" ");
					}
				}
				if(l != aristas.length-1){
					pw.println();
				}
			}
			pw.close();
			flujoE.close();
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return g.getVertices();
	}

//	public static void main(String[] args) {
//		leerGrafo("laberinto.txt","grafo.txt");
//	}
}