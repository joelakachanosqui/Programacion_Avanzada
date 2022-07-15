package Boletin;

public class Boletin {
	int cantidadNotas;
	int[] notas = new int [cantidadNotas];
	boolean aprueba;
	
	Boletin() {
		
	}

	public int getCantidadNotas() {
		return cantidadNotas;
	}

	public void setCantidadNotas(int cantidadNotas) {
		this.cantidadNotas = cantidadNotas;
	}

	public int[] getNotas() {
		return notas;
	}

	public void setNotas(int[] notas) {
		this.notas = notas;
	}
	
	public void obtenerDatos() {
		Archivo archivoOut = new Archivo();
		int suma = this.obtenerSuma();
		int promedio = this.obtenerPromedio(suma);
		if(promedio >= 7)
			this.aprueba = true;
		else
			this.aprueba = false;
		int mejorNota = obtenerMejorNota();
		
		archivoOut.writeFile(suma, promedio, this.aprueba, mejorNota);
	}
	
	public int obtenerSuma() {
		int sumaNotas = 0;
		for(int i=0; i<this.cantidadNotas; i++)
			sumaNotas += this.notas[i];
		return sumaNotas;
	}
	
	public int obtenerPromedio(int suma) {
		return suma/=this.cantidadNotas;
	}
	
	public int obtenerMejorNota() {
		int mejorNota = this.notas[0];
		for(int i=0; i<this.cantidadNotas; i++) {
			if(this.notas[i] > mejorNota)
				mejorNota = this.notas[i];
		}
		return mejorNota;
	}
	
	
}
