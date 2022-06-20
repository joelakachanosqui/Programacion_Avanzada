package E00_DiagonalMatriz;

public class Ejercicio00 {
	public boolean comprobar(int[][] matriz) {
		int sumatoria = matriz[0][0];
		
		for(int i = 1; i < matriz.length; i++){
			if(matriz[i][i] == sumatoria){
				sumatoria += matriz[i][i];
			} else return false;
		}
		
		 return true;
	}
	
	public static void main(String[] args) { 
		int [][] prueba = {
				{7, 2, 3},
				{4, 7, 6},
				{7, 8, 14}
		};
		
		Ejercicio00 miEjercicio = new Ejercicio00(); 
		
		System.out.println(miEjercicio.comprobar(prueba));
	}
}
