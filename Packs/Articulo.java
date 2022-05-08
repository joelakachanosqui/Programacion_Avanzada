package C07_Packs;

public class Articulo {
	String nombre;
	double precio;
	
	public Articulo(String nombre, double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public String getNombre() {
		return nombre;
	}
}
