package E07_EntradaSalida;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class ArchivoEntrada {
	String nombreArchivo;

	public ArchivoEntrada(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	
	public void crearArchEntrada (int cantNumeros, int numeroMaximo) {
		FileWriter archivo = null;
		PrintWriter printWriter = null;
		
		try {
			archivo = new FileWriter(this.nombreArchivo + ".in");
			printWriter = new PrintWriter(archivo);

			Random numeroRandom = new Random();
			
			for(int i=0; i<cantNumeros; i++) {
				int numerosEscribir = numeroRandom.nextInt(numeroMaximo);
				printWriter.println(numerosEscribir);
			}
			
			
		} catch (Exception exception) {
			System.out.println("Exception");
			exception.printStackTrace();
		} finally {
			if(archivo!=null) {
				try {
					archivo.close();
				} catch (IOException exception) {
					System.out.println("Exception2");
					exception.printStackTrace();
				}
			}
		}
	}
	
	
}
