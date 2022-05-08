package C07_Packs;

public class Main {

	public static void main(String[] args) {
		Pack pack = new Pack("CocaCola",150,6);
		Pack pack2 = new Pack("CocaCola",150,6);
		Pack pack3 = new Pack("CocaCola",150,6);
		Pack pack4 = new Pack("CocaCola",150,6);
		Pack pack5 = new Pack("CocaCola",150,6);
		Individual ind1 = new Individual("Sprite", 100);
		
		Compra carritoCompra = new Compra();
		
		carritoCompra.agregarArticulo(pack);
		carritoCompra.agregarArticulo(pack5);
		carritoCompra.agregarArticulo(pack2);
		pack3.aplicarDescuento(50);
		carritoCompra.agregarArticulo(pack3);
		pack4.unoDeRegalo();
		carritoCompra.agregarArticulo(pack4);
		carritoCompra.agregarArticulo(ind1);
		
		carritoCompra.imprimirCarrito();
		System.out.println("Precio total carrito: " + carritoCompra.calcularPrecioFinal());

	}

}
