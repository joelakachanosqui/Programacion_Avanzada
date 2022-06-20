package E02_SumaValoresMatriz;

//Escribir un método en Java que de una matriz numérica dada, 
//devuelva una matriz con la misma cantidad de elementos, 
//pero donde cada valor es la suma de sus adyacentes originales (arriba, abajo, izquierda, y derecha; si existen)
//
//Ejemplo:
//Para la matriz
// 8  2 -3  4
// 5 -6 -6 20
//21  1 -5  0
//
//La salida debe ser
//15  1  -3 21
//28 -4   0 18
//27 11 -10 15

public class Ejercicio02 {
	public static void main(String[] args) {
		int[][] matriz = {
				{8,2,-3,4},
				{5,-6,-6,20},
				{21,1,-5,0}
		};
		
		Ejercicio02 matrizAdyacentes = new Ejercicio02();
		
		int[][] matrizFinal = matrizAdyacentes.sumaAdyacentes(matriz);
		
		for(int i=0;i<matrizFinal.length;i++) {
			for(int j=0;j<matrizFinal[i].length;j++) {
				System.out.print(matrizFinal[i][j]);
				System.out.print(" ");
			}
			System.out.println("");
		}
	}
	
	public int[][] sumaAdyacentes (int[][] matrizOriginal) {
		int[][] matrizNueva = new int[matrizOriginal.length][matrizOriginal[0].length];
		
		for(int i=0;i<matrizOriginal.length;i++) {
			for(int j=0;j<matrizOriginal[i].length;j++) {
				matrizNueva[i][j] = matrizOriginal[i][j];
				if(i-1!=-1)
					matrizNueva[i][j] += matrizOriginal[i-1][j];
				if(j-1!=-1)
					matrizNueva[i][j] += matrizOriginal[i][j-1];
				if(i!=matrizOriginal.length-1)
					matrizNueva[i][j] += matrizOriginal[i+1][j];
				if(j!=matrizOriginal.length)
					matrizNueva[i][j] += matrizOriginal[i][j+1];
			}
		}
		
		return matrizNueva;
	}
}
