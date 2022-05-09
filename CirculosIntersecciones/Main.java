package CirculosIntersecciones;

public class Main {
	public static void main(String[] args) {
		
		Circulo circulo1 = new Circulo(new Punto(1, 2), 1);
		Circulo circulo2 = new Circulo(new Punto(-2, 0), 5);
		
		System.out.println(circulo1.intersectaCon(circulo2));		
	}
}
