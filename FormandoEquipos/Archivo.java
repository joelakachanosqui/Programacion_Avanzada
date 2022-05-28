package FormandoEquipos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Archivo {
	String name;
	
	Archivo(){
		this.name = "formandoEquipos";
	}
	
	public List<String> readFile() {
		File file = null;
		Scanner reader = null;
		List<String> respuestas = null; 
		int colaboradores;
		
		try {
			file = new File(this.name + ".in");
			reader = new Scanner(file);
			
			respuestas = new ArrayList<String>();
			reader.nextInt();
			colaboradores = reader.nextInt();
			
			for(int i=0; i<colaboradores; i++) {
				respuestas.add(reader.next());
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			reader.close();
		}
		
		Collections.sort(respuestas);				
		return respuestas;
	}
	
	public void writeFile(Resultado res) {
		FileWriter archivo = null;
		PrintWriter myWriter = null;
		
		try {
			archivo = new FileWriter(this.name + ".out");
			myWriter = new PrintWriter(archivo);
			
			myWriter.println(res.getAfinidad());
			myWriter.println(res.getRespuestas());
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			myWriter.close();
		}
	}
}
