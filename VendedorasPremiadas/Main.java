package VendedorasPremiadas;

//import java.util.ArrayList;
//import java.util.List;

public class Main {
	public static void main(String[] args) {
		Archivo archivo = new Archivo();
		Vendedora vendedora = new Vendedora();
		vendedora.encontrarVendedora(archivo.readFile(), archivo.getMinimoVentas());
		
	}
}
