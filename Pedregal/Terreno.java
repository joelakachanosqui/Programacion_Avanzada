package Pedregal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Terreno {
	protected int largoTerreno, anchoTerreno, frenteCasa, anchoCasa, cantidadPiedras;
	protected String orientacion, sePuede;
	private String nombreArchivoOut = "pedregal";
	
	public Terreno() {
	
	}
	
	//Getter y Setter
	
	public void setLargoTerreno(int largoTerreno) {
		this.largoTerreno = largoTerreno;
	}

	public void setAnchoTerreno(int anchoTerreno) {
		this.anchoTerreno = anchoTerreno;
	}

	public void setFrenteCasa(int frenteCasa) {
		this.frenteCasa = frenteCasa;
	}

	public void setAnchoCasa(int anchoCasa) {
		this.anchoCasa = anchoCasa;
	}
	
	public int getCantidadPiedras() {
		return this.cantidadPiedras;
	}

	public void setCantidadPiedras(int cantidadPiedras) {
		this.cantidadPiedras = cantidadPiedras;
	}

	public int getLargoTerreno() {
		return largoTerreno;
	}

	public int getAnchoTerreno() {
		return anchoTerreno;
	}

	public int getFrenteCasa() {
		return frenteCasa;
	}

	public int getAnchoCasa() {
		return anchoCasa;
	}	
	
	private String getOrientacion() {
		return this.orientacion;
	}
	
	
	private String getSePuede() {
		return this.sePuede;
	}
	
	//Resolución
	
	public void buscarEspacio(List<Piedra> coordenadasPiedras) {
		int menorI = 0, menorJ = 0, tokenAcceso = 0;
		
		for(int i=0;i<this.getLargoTerreno();i++) {
			for(int j=0; j<this.getAnchoTerreno(); j++) {
				if(this.entraCasa(i,j)) {
					if(insertarCasa(i,j, coordenadasPiedras)) {
						if(tokenAcceso == 0) {
							menorI = i;
							menorJ = j;
							tokenAcceso = -1;
						} else {
							if(i<menorI || j<menorJ) {
								menorI = i;
								menorJ = j;
							}
						}
					}
				} 
			}
		}
		
		if(tokenAcceso!= 0) {
			this.sePuede = "SI";
			this.ubicarCasa(menorI, menorJ);
		}
		else {
			this.sePuede = "NO";
			this.writeFile(this.sePuede);
		}
	}	


	public boolean entraCasa(int ejeI, int ejeJ) {
		return ((this.getLargoTerreno()-ejeI >= this.getFrenteCasa() && 
				this.getAnchoTerreno()-ejeJ >= this.getAnchoCasa()) ||
				(this.getLargoTerreno()-ejeI >= this.getAnchoCasa() && 
				this.getAnchoTerreno()-ejeJ >= this.getFrenteCasa()));
	}
	
	public boolean insertarCasa(int ejeI, int ejeJ, List<Piedra> coordenadasPiedras) {
		for(int i=ejeI; i<(ejeI + this.getFrenteCasa()); i++) {
			for(int j=ejeJ; j<(ejeJ + this.getAnchoCasa()); j++) {
				if(hayPiedra(i, j, coordenadasPiedras))
					return false;
			}
		}
		
		return true;
	}
	
	public void calcularOrientaciónCasa(int i, int j) {
		Random random = new Random();
		if(this.getFrenteCasa() > this.getAnchoCasa()) {
			if(random.nextInt() % 2 == 0)
				this.orientacion = "S";
			else
				this.orientacion = "N";
		} else {
			if(random.nextInt() % 2 == 0)
				this.orientacion = "O";
			else
				this.orientacion = "E";
		}
	}

	
	public boolean hayPiedra(int ejeI, int ejeJ, List<Piedra> coordenadas) {
		for(Piedra piedra : coordenadas) {
			if(ejeI == piedra.getEjeX() && ejeJ == piedra.getEjeY())
				return true;
		}
		
		return false;
	}
	
	public void ubicarCasa(int menorI, int menorJ) {
		this.calcularOrientaciónCasa(menorI, menorJ);
		this.writeFile(menorI,menorJ);
	}

	//Lectura de archivo
	public List<Piedra> readFile(String nombreArchivo) {
		File archivo = null;
		Scanner myReader = null;
		List<Piedra> listaPiedras = null;
		//System.out.println(System.getProperty("user.dir"));
		
		try {
			archivo = new File(nombreArchivo + ".in");
			myReader = new Scanner(archivo);
			listaPiedras = new ArrayList<Piedra>();
			
			this.setLargoTerreno(myReader.nextInt());
			this.setAnchoTerreno(myReader.nextInt());
			this.setFrenteCasa(myReader.nextInt());
			this.setAnchoCasa(myReader.nextInt());
			this.setCantidadPiedras(myReader.nextInt());
			
			for(int i=0; i<this.getCantidadPiedras(); i++) {
				Piedra piedra = new Piedra(myReader.nextInt()-1, myReader.nextInt()-1);
				listaPiedras.add(piedra);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Archivo .in no encontrado");
		} finally {
			myReader.close();
		}
		
		Collections.sort(listaPiedras);
		
		return listaPiedras;
	}
	
	//Escritura de archivo
	
	public void writeFile(int coordenadaI, int coordenadaJ) {
		FileWriter archivoOut = null;
		PrintWriter myWriter = null;
		
		try {
			archivoOut = new FileWriter(this.nombreArchivoOut + ".out");
			myWriter = new PrintWriter(archivoOut);
			
			myWriter.println(this.getSePuede());
			myWriter.print(coordenadaI);
			myWriter.print(" ");
			myWriter.println(coordenadaJ);
			myWriter.println(this.getOrientacion());
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			myWriter.close();
		}
	}
	
	public void writeFile(String valor) {
		
		FileWriter archivoOut = null;
		PrintWriter myWriter = null;
		
		try {
			archivoOut = new FileWriter(this.nombreArchivoOut + ".out");
			myWriter = new PrintWriter(archivoOut);
			
			myWriter.println(valor);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			myWriter.close();
		}
	}
}
