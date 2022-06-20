package E03_ModasMatriz;

//Escribir un m�todo en Java que de una matriz num�rica dada, devuelva un vector con n elementos, 
//donde cada elemento es la moda de una fila. Si hubiese m�s de una moda, se deber� utilizar la de mayor valor
//
//Ejemplo:
//Para la matriz
// 1  2  3  4
// 5 -6 -6 20
// 1  1 10 10
//
//La salida debe ser
//4 -6 10

public class Ejercicio03 {
	public static void main(String[] args) {
		int[][] matriz = {
				{1,2,3,4},
				{5,-6,-6,20},
				{10,10,11,11}
		};
		
		Ejercicio03 calculoModa = new Ejercicio03();
		//dataType[] arrayName = new dataType[]{elementos} para inicializar un array sin tama�o
		int[] string = new int[matriz[0].length+1];
		
		for(int i=0;i<matriz.length;i++) {
			for(int j=0;j<matriz[i].length;j++) {
					string[j] = matriz[i][j];
			}
			System.out.print(calculoModa.modaMatriz(string) + " ");
		}
		
	}
	
	public int modaMatriz(int[] array) {
		int moda=-1, maxRepeticion=-1;
		
		for(int i=0;i<array.length;i++) {
			
			//El valor apareci� una vez
			int cantApariciones=1;
			
			//Me fijo en lo que resta del array cuantas veces aparece este valor
			for(int j=0;j<array.length;j++) {
				if(array[i]==array[j])
					cantApariciones++;
			}
			
			//Si las repeticiones de este valor son mayor que las que ya habian como m�ximas
			//reemplazo el valor de la moda
			if(cantApariciones>maxRepeticion) {
				moda=array[i];
				maxRepeticion=cantApariciones;
			}
			
			//Si la cantidad de repeticiones son las mismas y el valor actual es mayor
			//reemplazo el valor de la moda
			if(cantApariciones==maxRepeticion && array[i]>moda) {
					moda=array[i];
			}
		}

		return moda;

	}
}
