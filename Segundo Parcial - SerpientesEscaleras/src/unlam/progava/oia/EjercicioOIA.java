package unlam.progava.oia;


// La CC del ejercicio es O(n3)
// Si bien podr�a resolverse con complejidad O(n2) no encontramos la forma de llevarlo a cabo de esa forma


public class EjercicioOIA {
	Archivo archivo;
	BFS bfs;
	Resolucion minimo = new Resolucion();
	int res;
	
	public static void main(String[] args) {
		EjercicioOIA ejercicio = new EjercicioOIA();
		
		ejercicio.leer("src/unlam/progava/oia/out/00.out");
		ejercicio.resolver();
		ejercicio.escribir("src/unlam/progava/oia/out/00.out");
	}

	/**
	 * Este método se encarga de leer la entrada de la
	 * consigna desde el archivo.
	 */
	public void leer(String path) {
		archivo = new Archivo(path);
		archivo.leerArchivo(minimo);
	}
	
	/**
	 * Este método se encarga de escribir la salida de la
	 * consigna en el archivo.
	 */
	public void escribir(String path) {
		archivo = new Archivo(path);
		archivo.escribirArchivo(res);
	}
	
	/**
	 * Este método debe realizar la resolución del ejercicio.
	 * NO DEBE SITUARSE LA LOGICA AQUI, sino que se pueden
	 * utilizar clases adicionales, y los objetos creados en la
	 * etapa de lectura.
	 * Utilizar este mismo paquete para toda la resolución.
	 */
	public void resolver() {
		res = minimo.resolver();
	}
}
