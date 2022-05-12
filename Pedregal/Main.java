package Pedregal;

public class Main {

	public static void main(String[] args) {
		String nombreArchivo = "pedregal";
		Terreno terreno = new Terreno();
		
		terreno.buscarEspacio(terreno.readFile(nombreArchivo));
	}

}
