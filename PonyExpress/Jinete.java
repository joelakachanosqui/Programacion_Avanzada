package PonyExpress;

public class Jinete {

	public int jinetes(int[] estaciones) { 
		int cantidadMillas = 0, cantidadJinetes = 0;
		
		for(int i=0; i<estaciones.length; i++) {
			cantidadMillas += estaciones[i];
			if(i<estaciones.length-1 && cantidadMillas+estaciones[i+1]>100) {
				cantidadJinetes++;
				cantidadMillas = 0;
			}
		}
		
		cantidadJinetes++;
				
		return cantidadJinetes;
	}
}
