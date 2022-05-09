package MesadasGranito;

import java.io.*;

public class ArchivoSalida {
	private String nombreArchivo;
	
	public ArchivoSalida(String nombreArchivo) {
		super();
		this.nombreArchivo = nombreArchivo;
	}

	public void writeFile(int cantidadApilados) { //Cambiar
		FileWriter archivoOut = null;
		PrintWriter myWriter = null;
		
		try {
			archivoOut = new FileWriter("C:\\Users\\jkach\\eclipse-workspace\\ejercicioOIA\\src\\MesadasGranito\\" + this.nombreArchivo + ".out");
			myWriter = new PrintWriter(archivoOut);
			
			myWriter.println(cantidadApilados);
			
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			myWriter.close();
		}
		
	}
}
