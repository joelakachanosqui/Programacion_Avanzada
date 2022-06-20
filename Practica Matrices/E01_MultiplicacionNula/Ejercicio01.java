package E01_MultiplicacionNula;

public class Ejercicio01 {
	public static void main(String[] args) {
		int matrizPrueba[][] = {
				{1,2,3},
				{4,5,6},
				{7,8,0}
		};
		
		Ejercicio01 miEjercicio = new Ejercicio01();
		
		if(miEjercicio.comprobarMatriz(matrizPrueba) == true) 
			System.out.println("El resultado de la multiplicación es cero");
		else
			System.out.println("El resultado de la multiplicación es distinto a cero");		
	}
	
	public boolean comprobarMatriz (int[][] matriz) {
		//Lo inicializamos en 1 porque sino siempre el resultado dará 0.
		int sumatoriaMultiplicacion = 1;
		
		//Recorremos toda la matriz y vamos multiplicando cada valor.
		for (int i=0; i<matriz.length;i++) {
			for (int j=0; j<matriz[0].length;j++) {
				sumatoriaMultiplicacion *= matriz[i][j]; 
				//Podría haber puesto que si alguno de los valores es cero ya el resultado es true.
			}
		}
		
		if (sumatoriaMultiplicacion == 0)
			return true;
		else
			return false;
	}
}
