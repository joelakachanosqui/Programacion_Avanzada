package LuchadoresJaponeses;

import java.util.*;

public class Cuadrilatero {
	
	public int[] dominaA(ArrayList<Luchador> listaLuchadores) {
		int lenghtLista = listaLuchadores.size();
		int dominados = 0;
		int[] cantidadDominados = new int[lenghtLista];
		

			for (int i=0; i<lenghtLista; i++) {
				for(int j=0; j<lenghtLista; j++) {
					if(j == i && j<lenghtLista-1)
						j++;
					
					if(listaLuchadores.get(i).getPeso() > listaLuchadores.get(j).getPeso() && 
							listaLuchadores.get(i).getAltura() > listaLuchadores.get(j).getAltura())
						dominados++;	
					
					if(listaLuchadores.get(i).getPeso() == listaLuchadores.get(j).getPeso() && 
							listaLuchadores.get(i).getAltura() > listaLuchadores.get(j).getAltura())
						dominados++;
					
					if(listaLuchadores.get(i).getPeso() > listaLuchadores.get(j).getPeso() && 
							listaLuchadores.get(i).getAltura() == listaLuchadores.get(j).getAltura())
						dominados++;
					
				}
				cantidadDominados[i] = dominados;
				dominados = 0;
				
			}

		
		return cantidadDominados;
	}
}