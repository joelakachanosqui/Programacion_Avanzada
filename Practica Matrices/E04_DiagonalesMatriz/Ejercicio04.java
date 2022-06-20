package E04_DiagonalesMatriz;

//Escribir un método en Java que de una matriz cuadrada dada, 
//devuelva una matriz con n filas, donde cada una tendrá los datos de una de las diagonales 
//(de abajo a la izquierda hacia arriba a la derecha)
//
//Ejemplo:
//Para la matriz
// 1  2  3  4
// 5  6  7  8
// 9 10 11 12
//13 14 15 16
//
//La salida debe ser
//13
// 9 14
// 5 10 15
// 1  6 11 16
// 2  7 12
// 3  8
// 4

public class Ejercicio04 {
	int[][] generarMatResultado(int[][] mat) {
		
		int tamMat = mat.length;
		int filFinal=0;
		int[][] matFinal = new int[tamMat * 2 - 1][tamMat];
		for (int recorrCol1 = (tamMat - 1); recorrCol1 >= 0; recorrCol1--) {			
			int filDiag=recorrCol1;
			int cantElemDiag=tamMat-filDiag;
			for (int colDiag = 0; colDiag < cantElemDiag;colDiag++) {
				matFinal[filFinal][colDiag]=mat[filDiag][colDiag];	
				filDiag++;
			}
			filFinal++;
		}
		for(int recorrFil1=1;recorrFil1<tamMat;recorrFil1++) {
			int colDiag=recorrFil1;
			int colFinal=0;
			int cantElemDiag=tamMat-colDiag;
			for(int filDiag=0;filDiag<(cantElemDiag);filDiag++) {
				matFinal[filFinal][colFinal]=mat[filDiag][colDiag];
				colDiag++;
				colFinal++;
			}
			filFinal++;
		}
		return matFinal;
		
	}

	public static void main(String[] args) {
		int[][]entrada=
				{{1,2,3,4},
				 {5,6,7,8},
				 {9,10,11,12},
				{13,14,15,16}};
		int[][]salidaEsperada=
			{
					{13,0,0,0},
					 {9,14,0,0},
					 {5,10,15,0},
					 {1,6,11,16},
					 {2,7,12,0},
					 {3,8,0,0},
					 {4,0,0,0}
			};
		Ejercicio04 objeto=new Ejercicio04();
		int[][]salida=objeto.generarMatResultado(entrada);
		
		boolean ok=true;
		for(int i=0;i<salida.length;i++)
			for(int j=0;j<salida[0].length;j++)
				if(salida[i][j]!=salidaEsperada[i][j])
					ok=false;
		
		if(ok)
			System.out.println("El resultado es el esperado");
		else
			System.out.println("El resultado no es el esperado");
	}

}
