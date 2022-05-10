package MesadasGranito;

import java.util.*;

public class Mesada implements Comparator<Mesada> {
	int largo;
	int ancho;
	
	public Mesada(int largo, int ancho) {
		this.largo = largo;
		this.ancho = ancho;
	}
	
	public Mesada() {
		
	}
	
	public boolean puedeApilar(Mesada mesada) {
		return ((mesada.largo <= this.largo && mesada.ancho <= this.ancho) ||
				(mesada.largo <= this.ancho && mesada.ancho <= this.largo));
	}
	
	public int compararMesadas(List<Mesada> listaMesada) {	
		
		//Ordeno la lista - Se puede optimizar
		Collections.sort(listaMesada, new Comparator<Mesada>() {			
		    @Override
		    public int compare(Mesada o1, Mesada o2) {
		    	return (o2.largo-o1.largo);
		    }
		});
				
		//Imprimo solo a modo informativo
		for(Mesada mesada:listaMesada)
			System.out.println(mesada);

		int cantidadApilados = 1;
		
		for(int i=0; i<listaMesada.size(); i++) {
			//Por leer la primera mesada ya asumo que hay una apilada
			cantidadApilados = 1;
			
			//Asigno a j en una posición más adelante que i para comparar
			for(int j=i+1; j<listaMesada.size(); j++) {
				if(listaMesada.get(i).puedeApilar(listaMesada.get(j))) {
					cantidadApilados++;
					
					//Si apiló al último elemento devuelvo la cantidad de apilados
					if(j == listaMesada.size()-1)
						return cantidadApilados;
					
				// Si la mesada siguiente no se puede apilar, salgo del segundo for e incremento i
				} else
					j = listaMesada.size()-1;		
			}
		}
		
		return cantidadApilados;
	}
	

	public int getLargo() {
		return this.largo;
	}
	
	public int getAncho() {
		return this.ancho;
	}

	@Override
	public String toString() {
		return largo + " " + ancho;
	}

	@Override
	public int compare(Mesada o1, Mesada o2) {
		return (o1.largo-o2.largo);
	}
}
