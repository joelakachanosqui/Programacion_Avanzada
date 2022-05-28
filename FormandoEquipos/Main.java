package FormandoEquipos;

public class Main {

	public static void main(String[] args) {
		Archivo archivo = new Archivo();
		Respuesta respuesta = new Respuesta();
		archivo.writeFile(respuesta.compararRespuestas(archivo.readFile()));
	}

}
