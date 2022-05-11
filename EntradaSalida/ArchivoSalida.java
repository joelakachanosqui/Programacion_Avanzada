package E07_EntradaSalida;

import java.io.*;
import java.util.*;

public class ArchivoSalida {
	String nombreArchivo;

	public ArchivoSalida(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	
	public void crearArchSalida() {
		FileWriter archivoOut = null;
		PrintWriter printWriter = null;
		File archivoIn = null;
		Scanner myReader = null;
		int mayor = 0, menor = 0, promedio = 0, cantLineas = 0,
			numeroActual = 0;
		
		try {
			archivoIn = new File(this.nombreArchivo + ".in");
			myReader = new Scanner(archivoIn);
			archivoOut = new FileWriter(nombreArchivo + ".out");
			printWriter = new PrintWriter(archivoOut);
			
			
			while(myReader.hasNextInt()) {
				numeroActual = myReader.nextInt();
				promedio += numeroActual;				
				cantLineas++;
				
				if(mayor < numeroActual)
					mayor = numeroActual;
				if(menor > numeroActual)
					menor = numeroActual;
				
			}
			
			promedio /= cantLineas;

			printWriter.println("+----------+-------+");
			printWriter.print("| Máximo   | ");
			printWriter.println(String.format("%5d |", mayor));
			printWriter.println("+----------+-------+");
			printWriter.print("| Mínimo   | ");
			printWriter.println(String.format("%5d |", menor));
			printWriter.println("+----------+-------+");
			printWriter.print("| Promedio | ");
			printWriter.println(String.format("%5d |", promedio));
			printWriter.print("+----------+-------+");
			
		} catch(Exception exception) {
			System.out.println("Exception FNF");
			exception.printStackTrace();
		} finally {
			if(archivoOut!=null) {
				try {
					archivoOut.close();
				} catch (IOException exception) {
					System.out.println("Exception2");
					exception.printStackTrace();
				}
			}
		}
		
	}
}
