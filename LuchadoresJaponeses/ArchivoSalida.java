package LuchadoresJaponeses;

import java.io.*;

public class ArchivoSalida {
	private String nombreArchivo;
	
	public ArchivoSalida(String nombreArchivo) {
		super();
		this.nombreArchivo = nombreArchivo;
	}

	public void writeFile(int[] luchadoresDominados) {
		FileWriter archivoOut = null;
		PrintWriter myWriter = null;
		
		try {
			archivoOut = new FileWriter("C:\\Users\\jkach\\eclipse-workspace\\ejercicioOIA\\" + this.nombreArchivo + ".out");
			myWriter = new PrintWriter(archivoOut);
			
			for(int i=0; i<luchadoresDominados.length; i++) {
				myWriter.println(luchadoresDominados[i]);
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			myWriter.close();
		}
		
	}
}

