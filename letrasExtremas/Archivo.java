package letrasExtremas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class Archivo {
	private String nombreArchivo;
	
	Archivo(){
		this.nombreArchivo = "letrasExtremas";
	}
	
	public String[] readFile() {
		File archivo = null;
		Scanner myReader = null;
		int cantidadPalabras = 0;
		String[] letrasExtremas = null;

		try {
			archivo = new File(this.nombreArchivo + ".in");
			myReader = new Scanner(archivo);
			cantidadPalabras = myReader.nextInt();
			letrasExtremas = new String[cantidadPalabras];
			
			for(int i=0; i<cantidadPalabras; i++) {
				letrasExtremas[i] = myReader.next();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			myReader.close();
		}
		
		return letrasExtremas;
	}
	
	
	public void writeFile(List<Character> letra, List<String> str) {
		FileWriter archivo = null;
		PrintWriter myWriter = null;
		
		try {
			archivo = new FileWriter(this.nombreArchivo + ".out");
			myWriter = new PrintWriter(archivo);
			
			for(int i=0; i<letra.size(); i++) {
				myWriter.print(letra.get(i));
				myWriter.print(" ");
			}
			
			myWriter.println();
			
			for(int j=0; j<str.size(); j++) {
				myWriter.println(str.get(j));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			myWriter.close();
		}
	}
	
}
