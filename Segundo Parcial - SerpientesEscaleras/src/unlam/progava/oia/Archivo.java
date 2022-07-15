package unlam.progava.oia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Archivo {
	private String filename;

	public Archivo(String filename) {
		this.filename = filename;
	}
	
	public void leerArchivo(Resolucion res){
		Scanner scanner=null; 
		int cantidadSnakes,cantidadEscaleras;
		List<Escalera> escaleras = new ArrayList<Escalera>();
		List<Serpiente> serpientes = new ArrayList<Serpiente>();
		
		try{
			File file=new File(filename);
			scanner=new Scanner(file);
			cantidadSnakes=scanner.nextInt();
			
			while(cantidadSnakes!=0) {
				int hasta = scanner.nextInt();
				int desde = scanner.nextInt();
				serpientes.add(new Serpiente(desde,hasta));
				cantidadSnakes--;
			}
			
			cantidadEscaleras=scanner.nextInt();
			
			while(cantidadEscaleras!=0) {
				int desde = scanner.nextInt();
				int hasta = scanner.nextInt();
				escaleras.add(new Escalera(desde,hasta));
				cantidadEscaleras--;
			}
			
		}catch(FileNotFoundException e){
			System.out.println(e.getMessage());
		}finally{
			scanner.close();
		}
		
		res.setEsc(escaleras);
		res.setSnk(serpientes);

	}
	
	
	public void escribirArchivo(int cantidadSaltos){
		File file=null;
		FileWriter filewriter=null;
		PrintWriter printwriter=null;
		try{
			file=new File(filename);
			filewriter=new FileWriter(file);
			printwriter=new PrintWriter(filewriter);
			printwriter.print(cantidadSaltos);
		}catch(IOException e){
			System.out.println(e.getMessage());
		}finally{
			if(file!=null){
				try{
					filewriter.close();
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
		}
	}
}
