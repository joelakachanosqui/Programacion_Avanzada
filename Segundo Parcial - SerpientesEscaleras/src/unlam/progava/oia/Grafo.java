package unlam.progava.oia;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
	//Armamos grafo con lista de adyacencias
	
	public List<List<Integer>> adyacencias = null;
	
	public Grafo(ArrayList<Nodo> nodos, int cantNodosTot) {
		adyacencias = new ArrayList<>();
		
		for(int i=0;i<cantNodosTot;i++) {
			adyacencias.add(new ArrayList<>());
		}
		
		for(Nodo nodo: nodos) {
			adyacencias.get(nodo.origen).add(nodo.destino);
		}

	}
	
}
