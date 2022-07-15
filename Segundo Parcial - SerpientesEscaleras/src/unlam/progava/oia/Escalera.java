package unlam.progava.oia;

public class Escalera {
	int desde;
	int hasta;
	
	Escalera(int desde,int hasta){
		this.desde = desde;
		this.hasta = hasta;
	}

	@Override
	public String toString() {
		return "Escalera [desde=" + desde + ", hasta=" + hasta + "]";
	}
	
	
}
