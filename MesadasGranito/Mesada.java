package MesadasGranito;

import java.util.*;

public class Mesada {
	int largo;
	int ancho;
	
	public Mesada(int largo, int ancho) {
		this.largo = largo;
		this.ancho = ancho;
	}
	
	public Mesada() {
		
	}

	public boolean puedeApilar(Mesada mesada) {
		return (mesada.ancho <= this.ancho && mesada.largo <= this.largo || 
				mesada.largo <= this.ancho && mesada.ancho <= this.largo);
	}
	
	public int compararMesadas(ArrayList<Mesada> listaMesada) {		
		
									//Imprimo solo a modo informativo
		for(Mesada mesada:listaMesada)
			System.out.println(mesada);

		int cantidadApilados = 0, auxiliarApilados;
		
		for(int i=0; i<listaMesada.size(); i++) {
			int auxI = i;
			
			auxiliarApilados = 0;
			
			for(int j=0; j<listaMesada.size(); j++) {
				if(auxI==j && j<listaMesada.size()-1)
					j++;
				if(listaMesada.get(auxI).puedeApilar(listaMesada.get(j))) {
					auxiliarApilados++;
				}
			
		
			if(i==0)
				cantidadApilados = auxiliarApilados;
			else if(auxiliarApilados>cantidadApilados)
				cantidadApilados = auxiliarApilados;
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
	

	
}
