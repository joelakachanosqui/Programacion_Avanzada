package unlam.progava.oia;

//import java.util.ArrayList;

public class Minimo {	
	public int origen;
	public int min;
	protected boolean visitado;
	
	public Minimo(int origen, int min) {
		 this.origen = origen;
	     this.min = min;
	     this.visitado = false;
	}

}
