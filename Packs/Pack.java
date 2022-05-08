package C07_Packs;

public class Pack extends Articulo {
	int cantidadProductos;
	
	public Pack(String nombre, double precio, int cantidadProductos) {
		super(nombre, precio);
		this.cantidadProductos = cantidadProductos;
	}

	public void aplicarDescuento(int descuento) {
		double porcentajeTotal = (100-descuento);
		this.precio *= (porcentajeTotal/100);
	}
	
	public void unoDeRegalo() {
		double precioUnitario = this.precio/this.cantidadProductos;
		this.precio -= precioUnitario;
	}
	
}
