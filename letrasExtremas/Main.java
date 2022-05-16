package letrasExtremas;

public class Main {
	public static void main(String[] args) {
		Archivo archivo = new Archivo();
		Letra letra = new Letra();
		
		String[] res = archivo.readFile();
				
		letra.resolucion(res);
	}
}
