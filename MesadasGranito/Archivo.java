package MesadasGranito;

import java.io.*;
import java.util.*;


public class Archivo {
	private String nombreArchivo;
	
	public Archivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public ArrayList<Mesada> readFile() {
	
		ArrayList<Mesada> listaMesadas = null;
		
		Scanner myReader = null;
		
		try {
			File archivo = new File(this.nombreArchivo + ".in");
			myReader = new Scanner(archivo);
			myReader.useLocale(Locale.ENGLISH);
			listaMesadas = new ArrayList<Mesada>();
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
		
		Collections.sort(listaMesadas, Collections.reverseOrder());
		
		return listaMesadas;
	}
	
	public void writeFile(int cantidadApilados) { 
		FileWriter archivoOut = null;
		PrintWriter myWriter = null;
		
		try {
			archivoOut = new FileWriter(this.nombreArchivo + ".out");
			myWriter = new PrintWriter(archivoOut);
			
			myWriter.println(cantidadApilados);
			
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			myWriter.close();
		}
		
	}
}
