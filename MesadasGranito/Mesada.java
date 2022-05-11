package MesadasGranito;

import java.util.*;

public class Mesada implements Comparable<Mesada> {
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
				
		//Imprimo solo a modo informativo
		for(Mesada mesada:listaMesada)
			System.out.println(mesada);

		int cantidadApilados = 1;
		Mesada mesadaAnt = listaMesada.get(0);
			
		for(Mesada mesadaActual : listaMesada) {
			if(!mesadaAnt.puedeApilar(mesadaActual))
				cantidadApilados++;
			
			mesadaAnt = mesadaActual;
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
	public int compareTo(Mesada otraMesada) {
		if (this.ancho > otraMesada.ancho)
			return 1;
		if (this.ancho < otraMesada.ancho)
			return -1;
		if (this.ancho == otraMesada.ancho) {
			if (this.largo > otraMesada.largo)
				return 1;
			if (this.largo < otraMesada.largo)
				return -1;
		}
		return 0;
	}
}
