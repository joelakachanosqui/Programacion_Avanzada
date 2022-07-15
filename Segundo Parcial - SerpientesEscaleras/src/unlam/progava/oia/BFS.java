package unlam.progava.oia;

import java.util.LinkedList;
//import java.util.List;
import java.util.Queue;

public class BFS {

	public int resolver(Grafo grafo, int cantNodosTot) {

		boolean[] visitados = new boolean[cantNodosTot+1];
		Queue<Minimo> cola = new LinkedList<Minimo>();

		Minimo nodo = new Minimo(0,0);
		cola.add(nodo);
		visitados[0] = true;

		while (!cola.isEmpty()) {
			nodo = cola.poll();
			nodo.visitado = true;

			if(nodo.origen == cantNodosTot) {
				return nodo.min; //Retornar minimo
			}
			
			//Por cada nodo adyacente, si no esta visitado, agregarlo a la cola
			
			for(int elNodo: grafo.adyacencias.get(nodo.origen)) { 
				if(!visitados[elNodo]) {
					visitados[elNodo] = true;
					cola.add(new Minimo(elNodo, nodo.min+1));
				}
			}
			
		}
		
		return -1;
	}
}