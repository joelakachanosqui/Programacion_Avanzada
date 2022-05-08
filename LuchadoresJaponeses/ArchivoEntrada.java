package LuchadoresJaponeses;

import java.io.*;
import java.util.*;

public class ArchivoEntrada {
	private String nombreArchivo;
	
	public ArchivoEntrada(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public ArrayList<Luchador> readFile() {
	
		ArrayList<Luchador> listaLuchadores = null;
		
		Scanner myReader = null;
		
		try {
			File archivo = new File("C:\\Users\\jkach\\eclipse-workspace\\ejercicioOIA\\" + this.nombreArchivo + ".in");
			myReader = new Scanner(archivo);
			myReader.useLocale(Locale.ENGLISH);
			listaLuchadores = new ArrayList<Luchador>();
			int cantidadLuchadores = myReader.nextInt();
			
			for(int i=0; i<cantidadLuchadores; i++) {
				Luchador luchador  = new Luchador(myReader.nextInt(),myReader.nextInt());;
				listaLuchadores.add(luchador);
			}
			
		} catch(FileNotFoundException exception) {
			exception.printStackTrace();
			System.out.println(exception.getCause());
		} finally {
			myReader.close();
		}
		
		return listaLuchadores;
	}
}
