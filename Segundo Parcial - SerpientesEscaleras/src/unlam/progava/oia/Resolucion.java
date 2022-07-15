package unlam.progava.oia;

import java.util.ArrayList;
import java.util.List;

public class Resolucion {
	List<Escalera> esc = new ArrayList<Escalera>();
	List<Serpiente> snk = new ArrayList<Serpiente>();
	
	public void setEsc(List<Escalera> esc) {
		this.esc = esc;
	}

	public void setSnk(List<Serpiente> snk) {
		this.snk = snk;
	}

	public int resolver(){	
		// Si tengo escaleras dobles o serpientes dobles, unifico.
		verificarEscalerasDobles(esc);
		verificarSnakesDobles(snk);
		
		int cantidadNodosTot = 5*5;
		ArrayList<Nodo> nodos = new ArrayList<Nodo>();
		Grafo grafo;
		BFS bfs = new BFS();
		
		for(int i=0;i<=cantidadNodosTot;i++){
			for(int j=1;j<=6&&i+j<=cantidadNodosTot;j++){
				int origen = i, destino = i+j;
				
				int suboEscalera = subirEscalera(esc,destino);
				int bajoSerpiente = bajarSerpiente(snk,destino);
				
				if(suboEscalera>-1) {
					destino = suboEscalera;
				} 
				
				if(bajoSerpiente!=-1) {
					destino = bajoSerpiente;
				} 
				
				nodos.add(new Nodo(origen,destino));
			}
		}
		
		grafo = new Grafo(nodos,cantidadNodosTot);
			
		return bfs.resolver(grafo,cantidadNodosTot);
	}
	
	
	public int subirEscalera(List<Escalera> esc, int j) {
		//Lo que va a hacer es fijarse si hay escalera entre i+j
		//Devuelve -1 si no hay
		//Sino devuelve la posicion a la que sube
		
		for(Escalera valor: esc) {
			if(valor.desde == j) {
				return valor.hasta;
			}
		}
		
		return -1;
	}
	
	public int bajarSerpiente(List<Serpiente> snk, int dest) {
		//
		for(Serpiente valor: snk) {
			if(valor.desde == dest) {
				return valor.hasta;
			}
		}
		return -1;
	}
	
	public void verificarEscalerasDobles(List<Escalera> escalerasEntrada) {
		//Me fijo si tengo escaleras dobles y unifico
		//Ejemplo escalera desde 4 a 16 y escalera de 16 a 23
		//Resultante >> escalera de 4 a 23
		
		int i = 0;
		while(i+1<escalerasEntrada.size() && escalerasEntrada.get(i).hasta == escalerasEntrada.get(i+1).desde) {
				escalerasEntrada.add(new Escalera(escalerasEntrada.get(i).desde,escalerasEntrada.get(i+1).hasta));
				escalerasEntrada.remove(escalerasEntrada.get(i));
				escalerasEntrada.remove(escalerasEntrada.get(i));
			
			i++;
					
		}
		
		for(int j=0; j<escalerasEntrada.size();j++) {
			if(j+1<escalerasEntrada.size()) {
				if(escalerasEntrada.get(j).desde == escalerasEntrada.get(j+1).hasta) {
					escalerasEntrada.add(new Escalera(escalerasEntrada.get(j+1).desde,escalerasEntrada.get(j).hasta));
					escalerasEntrada.remove(escalerasEntrada.get(j));
					escalerasEntrada.remove(escalerasEntrada.get(j));
				}
			}
	}

		
				
		for(int j=0;j<escalerasEntrada.size();j++) {
			System.out.println(escalerasEntrada.get(j));
		}
	}
	
	public void verificarSnakesDobles(List<Serpiente> snakesEntrada) {
		for(int i=0;i<snakesEntrada.size();i++) {
			if(i+1<snakesEntrada.size()) {
				if(snakesEntrada.get(i).hasta == snakesEntrada.get(i+1).desde) {
					snakesEntrada.add(new Serpiente(snakesEntrada.get(i).desde, snakesEntrada.get(i+1).hasta));
					snakesEntrada.remove(snakesEntrada.get(i));
					snakesEntrada.remove(snakesEntrada.get(i));
				}
			}
		}
	}

}
