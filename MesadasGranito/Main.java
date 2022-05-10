package MesadasGranito;

public class Main {

	public static void main(String[] args) {
		String nombreArchivo = "mesadas";
		ArchivoEntrada archivoEntrada = new ArchivoEntrada(nombreArchivo);
		Mesada mesadas = new Mesada();
		
		int cantidadApilados = mesadas.compararMesadas(archivoEntrada.readFile());
				
		ArchivoSalida archivoSalida = new ArchivoSalida(nombreArchivo);
		
		//Imprimo solo a modo informativo
		System.out.println("Cantidad Apilados: " + cantidadApilados);
		
		archivoSalida.writeFile(cantidadApilados);

	}
}
