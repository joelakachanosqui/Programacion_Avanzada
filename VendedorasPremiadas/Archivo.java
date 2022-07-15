package VendedorasPremiadas;

import java.io.*;
import java.util.*;

public class Archivo {
	String nombreArchivo;
	int cantidadVendedoras, minimoVentas;
	
	public Archivo() {
		this.nombreArchivo = "vendedoras";
	}
	
	public Archivo(String nombre) {
		this.nombreArchivo = nombre;
	}

	public List<Vendedora> readFile() {
		File archivo = null;
		Scanner myReader = null;
		List<Vendedora> listaVendedoras = null;
		int cantidadVentas = 0, numeroVendedora = 1;
		int[] ventas;
		
		try {
			archivo = new File(this.nombreArchivo + ".in");
			myReader = new Scanner(archivo);
			listaVendedoras = new LinkedList<Vendedora>();
			
			this.cantidadVendedoras = myReader.nextInt();
			
			while(cantidadVendedoras>0) {
				Vendedora vendedora = new Vendedora();
				vendedora.setNumVendedora(numeroVendedora);
				cantidadVentas = myReader.nextInt();				
				ventas = new int[cantidadVentas];
				
				vendedora.setCantVentasVendedora(cantidadVentas);
				for(int i=0; i<cantidadVentas; i++) {
					ventas[i] = myReader.nextInt();
				}
				vendedora.setVentas(ventas);;
				listaVendedoras.add(vendedora);
				cantidadVendedoras--;
				numeroVendedora++;
			}
			
			this.minimoVentas = myReader.nextInt();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			myReader.close();
		}

		return listaVendedoras;
	}
	
	public void writeFile(int numeroVend, int cantVentas, int total) {
		FileWriter archivo = null;
		PrintWriter myWriter = null;
		
		try {
			archivo = new FileWriter(this.nombreArchivo + ".out");
			myWriter = new PrintWriter(archivo);
			
			myWriter.println(numeroVend);
			myWriter.print(cantVentas + " " + total);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			myWriter.close();
		}
	}
	
	public void writeFile(String str) {
		FileWriter archivo = null;
		PrintWriter myWriter = null;
		
		try {
			archivo = new FileWriter(this.nombreArchivo + ".out");
			myWriter = new PrintWriter(archivo);
			
			myWriter.print(str);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			myWriter.close();
		}
	}

	public int getCantidadVendedoras() {
		return cantidadVendedoras;
	}

	public int getMinimoVentas() {
		return minimoVentas;
	}

}
