package LuchadoresJaponeses;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		String nombreArchivo = "luchadores";
		ArrayList<Luchador> listaLuchadores = new ArrayList<Luchador>();
		ArchivoEntrada archivoEntrada = new ArchivoEntrada(nombreArchivo);
		Cuadrilatero cuadrilatero = new Cuadrilatero();
		
		listaLuchadores = archivoEntrada.readFile();
		
		int[] dominados = cuadrilatero.dominaA(listaLuchadores);
		
		ArchivoSalida archivoSalida = new ArchivoSalida(nombreArchivo);
		
		archivoSalida.writeFile(dominados);
		
		System.out.println("Se escribió el archivo " + nombreArchivo + ".out");
		
	}
}
