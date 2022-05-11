package MesadasGranito;

public class Main {

	public static void main(String[] args) {
		String nombreArchivo = "test1";
		Archivo archivoEntrada = new Archivo(nombreArchivo);
		Mesada mesadas = new Mesada();
		
		int cantidadApilados = mesadas.compararMesadas(archivoEntrada.readFile());
				
		Archivo archivoSalida = new Archivo(nombreArchivo);
		
		//Imprimo solo a modo informativo
		System.out.println("Cantidad Apilados: " + cantidadApilados);
		
		archivoSalida.writeFile(cantidadApilados);

	}
}
