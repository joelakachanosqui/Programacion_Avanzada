package E07_EntradaSalida;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		ArchivoEntrada archEntrada = new ArchivoEntrada("archivoPrueba");
		
		int maximoNumero = 12000, minimoCantidad = 10000, maximoCantidad = 20000;
		
		Random numeroRandom = new Random();
		
		int cantidadCaracteres = numeroRandom.nextInt(maximoCantidad-minimoCantidad) 
								+ minimoCantidad;
		
		System.out.println(cantidadCaracteres);
		
		archEntrada.crearArchEntrada(cantidadCaracteres, maximoNumero);
		
		ArchivoSalida archSalida = new ArchivoSalida("archivoPrueba");
		
		archSalida.crearArchSalida();

	}
}
