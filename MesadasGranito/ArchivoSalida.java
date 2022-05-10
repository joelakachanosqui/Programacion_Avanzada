package MesadasGranito;

import java.io.*;

public class ArchivoSalida {
	private String nombreArchivo;
	
	public ArchivoSalida(String nombreArchivo) {
		super();
		this.nombreArchivo = nombreArchivo;
	}

	public void writeFile(int cantidadApilados) { 
		FileWriter archivoOut = null;
		PrintWriter myWriter = null;
		
		try {
			archivoOut = new FileWriter("\\src\\MesadasGranito\\" + this.nombreArchivo + ".out");
			myWriter = new PrintWriter(archivoOut);
			
			myWriter.println(cantidadApilados);
			
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			myWriter.close();
		}
		
	}
}
