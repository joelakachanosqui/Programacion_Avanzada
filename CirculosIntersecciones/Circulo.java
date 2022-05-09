package CirculosIntersecciones;

public class Circulo {
	Punto punto = new Punto();
	double radio;
	
	public Circulo(Punto punto, double radio) {
		this.punto = punto;
		this.radio = radio;
	}
	
	// (x - h)2 + (y - k)2 = r2 
	public boolean intersectaCon(Circulo circulo) {
//		int distanciaPuntosX = calcularDistanciaPuntos(this.punto.ejeX, circulo.punto.ejeX);
//		int distanciaPuntosY = calcularDistanciaPuntos(this.punto.ejeY, circulo.punto.ejeY);
		
//		if((this.radio + circulo.radio) >= distanciaPuntosX && (this.radio + circulo.radio) >= distanciaPuntosY)
//			return true;
//		
		
		double calculo = (Math.pow(this.punto.ejeX - circulo.punto.ejeX,2) + Math.pow(this.punto.ejeY - circulo.punto.ejeY,2));
		
		Math.pow(calculo, 2);
		
		return false;
	}
	
	public int calcularDistanciaPuntos(int eje1, int eje2) {
		if(eje2 >= 0)
			return eje1 - eje2;
		else
			return eje1 + eje2;
	}
	
	
	
}
