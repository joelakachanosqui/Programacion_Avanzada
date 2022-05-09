package MesadasGranito;

import java.io.*;
import java.util.*;


public class ArchivoEntrada {
	private String nombreArchivo;
	
	public ArchivoEntrada(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public ArrayList<Mesada> readFile() {
	
		ArrayList<Mesada> listaMesadas = null;
		
		Scanner myReader = null;
		
		try {
			File archivo = new File("C:\\Users\\jkach\\eclipse-workspace\\ejercicioOIA\\src\\MesadasGranito\\" + this.nombreArchivo + ".in");
			myReader = new Scanner(archivo);
			myReader.useLocale(Locale.ENGLISH);
			listaMesadas = new ArrayList<Mesada>();
			int cantidadMesadas = myReader.nextInt();
			
			for(int i=0; i<cantidadMesadas; i++) {
				Mesada mesada  = new Mesada(myReader.nextInt(), myReader.nextInt());
				listaMesadas.add(mesada);
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
