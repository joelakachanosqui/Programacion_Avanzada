package Boletin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Archivo {
	private String nombreArchivo;
	
	Archivo(){
		this.nombreArchivo = "boletin";
	}
	
	public Boletin readFile() {
		File archivo = null;
		Scanner myReader = null;
		int[] notas = null;
		Boletin boletin = null;
		
		try {
			archivo = new File(this.nombreArchivo + ".in");
			myReader = new Scanner(archivo);
			boletin = new Boletin();
			int cantidadNotas = myReader.nextInt();
			notas = new int[cantidadNotas];
			
			for(int i=0; i<cantidadNotas; i++) {
				notas[i] = myReader.nextInt();
			}
			
			boletin.setCantidadNotas(cantidadNotas);
			boletin.setNotas(notas);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			myReader.close();
		}
		
		return boletin;
	}
	
	public void writeFile(int suma, int promedio, boolean aprueba, int mejorNota) {
		FileWriter archivo = null;
		PrintWriter myWriter = null;
		
		try {
			archivo = new FileWriter(this.nombreArchivo + ".out");
			myWriter = new PrintWriter(archivo);
			
			myWriter.println(suma);
			myWriter.println(promedio);
			if(aprueba == true)
				myWriter.println("SI");
			else
				myWriter.println("NO");
			myWriter.println(mejorNota);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			myWriter.close();
		}
	}
	
}
