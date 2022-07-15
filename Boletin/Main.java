package Boletin;

public class Main {

	public static void main(String[] args) {
		Archivo archivo = new Archivo();
		Boletin boletin = archivo.readFile();
		boletin.obtenerDatos();
	}

}
