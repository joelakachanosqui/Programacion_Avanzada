package FormandoEquipos;

//import java.util.ArrayList;
import java.util.List;

public class Respuesta {
	public Resultado compararRespuestas(List<String> respuestas) {		
		int maxCant = 0, posI = 0, cantPersonas = 0;
		for(int i=0; i<respuestas.size(); i++) {
			int cantidadIguales = 0, j = 0;
			while ((i+1)<respuestas.size()-1 && j<respuestas.get(0).length() &&
					respuestas.get(i).charAt(j) == respuestas.get(i + 1).charAt(j)) {
				cantidadIguales++;
				j++;
			}

			if (cantidadIguales == maxCant) {
				cantPersonas++;
			}

			if (cantidadIguales > maxCant) {
				maxCant = cantidadIguales;
				posI = i;
				cantPersonas = 2;
			}
		}
		
		if(maxCant == 0)
			cantPersonas = 0;
		
		String respuestasAfinidad = this.hallarResAfinidad(respuestas, posI, maxCant);
		Resultado res = new Resultado();
		
		res.setAfinidad(cantPersonas*(int)Math.pow(2, maxCant));
		res.setRespuestas(respuestasAfinidad);
		
		return res;
	}
	
	public String hallarResAfinidad(List<String> respuestas, int posicion, int cantidad) {
		String respuesta = respuestas.get(posicion);
		String escritura = "";
		char[] res = new char[cantidad];
		respuesta.getChars(0, cantidad, res, 0);
		
		for(int i=0; i<res.length;i++) {
			String charToString = String.valueOf(res[i]);
			escritura += charToString;
		}

		return escritura;
	}
	
	
	
}
