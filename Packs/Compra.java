package C07_Packs;

import java.util.ArrayList;

public class Compra {
	ArrayList<Articulo> carritoCompra = new ArrayList<Articulo>();
	
	public void agregarArticulo(Articulo articulo) {
		carritoCompra.add(articulo);
	}
	
	public double calcularPrecioFinal() {
		int cantidadArticulos = carritoCompra.size();
		double precioFinal = 0;
		for(int i=0; i<cantidadArticulos; i++)
			precioFinal += carritoCompra.get(i).getPrecio();
		
		return precioFinal;
	}
	
	public void imprimirCarrito() {
		int cantidadArticulos = carritoCompra.size();
		for(int i=0; i<cantidadArticulos; i++) {
			System.out.println("Articulo " + (i+1) + ": " + carritoCompra.get(i).getNombre() + "	Precio: " + carritoCompra.get(i).getPrecio());
		}
	}
}
