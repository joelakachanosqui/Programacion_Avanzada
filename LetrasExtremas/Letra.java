package letrasExtremas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Letra {
	char letra;
	int cantRepetidos;
	
	Letra(){
		
	}
	
	public void setLetra(char letra) {
		this.letra = letra;
	}

	public void setCantRepetidos(int cantRepetidos) {
		this.cantRepetidos = cantRepetidos;
	}


	public void resolucion(String[] arrayString) {
		//Arrays.sort(arrayString, String.CASE_INSENSITIVE_ORDER);
		char[] caracteres = this.hallarExtremas(arrayString);
		List<Letra> letras = this.setearRepeticiones(caracteres);
		List<Character> resultado = this.hallarMasRepetido(letras);
		this.imprimirResultados(resultado, arrayString);
	}
	
	
	public char[] hallarExtremas(String [] arrayStrings) {
		int cantidadExtremas = arrayStrings.length * 2;
		char[] extremas = new char[cantidadExtremas];
		int j=0;
		
		for(int i=0; i<arrayStrings.length;i++) {
			String str = arrayStrings[i];
			char[] CharArray = str.toCharArray();
			char firstChar = CharArray[0];
			extremas[j] = firstChar;
			j++;
			char lastChar = CharArray[CharArray.length - 1];
			extremas[j] = lastChar;
			j++;
		}
		Arrays.sort(extremas);
		
		return extremas;
	}
	
	public List<Letra> setearRepeticiones(char[] extremas) {
		int cantRepetidos = 0;
		List<Letra> usados = new ArrayList<Letra>();
		
		for(int i=0; i<extremas.length; i++) {
			cantRepetidos = 1;
			while((i+1)<extremas.length && extremas[i+1] == extremas[i]) {
				cantRepetidos++;
				i++;
			}
			
			Letra letra = new Letra();
			letra.setLetra(extremas[i]); 
			letra.setCantRepetidos(cantRepetidos); 
			usados.add(letra);
		}
					
		return usados;
	}
	
	public List<Character> hallarMasRepetido(List<Letra> letras) {
		int masRepetido = 0;
		List<Character> repetidas = new ArrayList<Character>();		
				
		for(int i=0; i<letras.size(); i++) {
			if(letras.get(i).cantRepetidos >= masRepetido) 
				masRepetido = letras.get(i).cantRepetidos;
		}
		
		for(int j=0; j<letras.size(); j++) {
			if(letras.get(j).cantRepetidos == masRepetido)
				repetidas.add(letras.get(j).letra);
		}
		
		return repetidas;
	}
	
	public void imprimirResultados(List<Character> resultado, String[] arrayString) {
		Archivo archivoOut = new Archivo();
		Letra palabra = new Letra();
		
		List<String> palabras = palabra.obtenerPalabras(resultado, arrayString);
		
		palabras = this.eliminarDuplicados(palabras);
		
		archivoOut.writeFile(resultado, palabras);
		
	}
	
	public List<String> obtenerPalabras(List<Character> letras, String[] arrayString) {
		List<String> lasQueVan = new ArrayList<String>();
		for(int i=0; i<arrayString.length; i++) {
			String str = arrayString[i];
			char[] CharArray = str.toCharArray();
			char firstChar = CharArray[0];
			char lastChar = CharArray[CharArray.length - 1];
			for(int j=0; j<letras.size(); j++) {
				if(firstChar == letras.get(j) || lastChar == letras.get(j)) {
					lasQueVan.add(arrayString[i]);
				}
				
			}
		}
		return lasQueVan;

	}
	
	public List<String> eliminarDuplicados(List<String> str) {
		List<String> newList = new ArrayList<String>();
		for(int i=0; i<str.size(); i++) {
			if(!existe(newList, str.get(i)))
				newList.add(str.get(i));
		}
		return newList;
	}
	
	public boolean existe(List<String> str, String palabra) {
		for(int i=0; i<str.size(); i++) {
			if(palabra.equals(str.get(i)))
				return true;
		}
		return false;
	}
	
	//Solo se hace a modo de prueba

	@Override
	public String toString() {
		return "Letra [letra=" + letra + ", cantRepetidos=" + cantRepetidos + "]";
	}
	
	
	
}
