package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class LeerArquivoGrafo {

	public static List<Vertice> leerGrafo(String fileName) {

		Grafo g = new Grafo();
		Vertice v = null;
		File f = new File(fileName);
		String vertices[];
		String linea;
		ArrayList<String[]> s1 = new ArrayList<String[]>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			int k = 1;
			Map<String, Vertice> mapa = new HashMap<String, Vertice>();
			while ((linea = br.readLine()) != null) {
				if (linea.contains(" ")) {
					String[] token = linea.split(" ");
					vertices = new String[token.length];
					List<Vertice> vecinosActuales = new ArrayList<Vertice>();
					List<Arista> aristasActuales = new ArrayList<Arista>();
					vertices[0] = "v" + k;
					v = (Vertice) mapa.get(vertices[0]);
					if (v == null)
						v = new Vertice();
					v.setLabel(vertices[0]);
					v.setPoint(new Point(k,1));
					mapa.put(vertices[0], v);
					for (int i = 1; i < token.length; i++) {
						vertices[i] = "v" + (i + 1);
						if (!token[i].equalsIgnoreCase("0") && k != (i + 1)) {
							Vertice vit = mapa.get(vertices[i]);
							if (vit == null)
								vit = new Vertice();
							vit.setLabel(vertices[i]);
							vit.setPoint(new Point(k, (i+1)));
							vecinosActuales.add(vit);
							mapa.put(vertices[i], vit);
							Arista ait = new Arista(v, vit);
							ait.setPeso(Integer.parseInt(token[i]));
							// ait.setPeso(1);
							aristasActuales.add(ait);
						}
					}
					v.setVecinos(vecinosActuales);
					v.setAristas(aristasActuales);
					k++;
				}
				g.adicionarVertice(v);
				s1.clear();

			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return g.getVertices();
	}
}