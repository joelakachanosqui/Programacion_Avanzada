package MesadasGranito;

import java.io.*;
import java.util.*;


public class ArchivoEntrada {
	private String nombreArchivo;
	
	public ArchivoEntrada(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public List<Mesada> readFile() {
	
		List<Mesada> listaMesadas = null;
		
		Scanner myReader = null;
		
		try {
			File archivo = new File("\\src\\MesadasGranito\\" + this.nombreArchivo + ".in");
			myReader = new Scanner(archivo);
			myReader.useLocale(Locale.ENGLISH);
			listaMesadas = new LinkedList<Mesada>();
			int cantidadMesadas = myReader.nextInt();
			int ancho, largo;
			
			for(int i=0; i<cantidadMesadas; i++) {
				largo = myReader.nextInt();
				ancho = myReader.nextInt();
				if(ancho > largo) {
					Mesada mesada  = new Mesada(ancho, largo);
					listaMesadas.add(mesada);					
				} else {
					Mesada mesada  = new Mesada(largo, ancho);
					listaMesadas.add(mesada);
				}
			}
			
		} catch(FileNotFoundException exception) {
			exception.printStackTrace();
			System.out.println(exception.getCause());
		} finally {
			myReader.close();
		}
		
		return listaMesadas;
	}
}
