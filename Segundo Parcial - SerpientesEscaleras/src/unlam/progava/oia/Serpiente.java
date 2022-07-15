package unlam.progava.oia;

public class Serpiente {
	int desde;
	int hasta;
	
	Serpiente(int desde,int hasta){
		this.desde = desde;
		this.hasta = hasta;
	}

	@Override
	public String toString() {
		return "Serpiente [desde=" + desde + ", hasta=" + hasta + "]";
	}
	
	
}
