package Pedregal;

public class Piedra implements Comparable<Piedra>{
	int ejeX, ejeY;

	public Piedra(int ejeX, int ejeY) {
		this.ejeX = ejeX;
		this.ejeY = ejeY;
	}
	
	public Piedra() {
		
	}
	
	
	public int getEjeX() {
		return ejeX;
	}

	public int getEjeY() {
		return ejeY;
	}

	@Override
	public int compareTo(Piedra otraPiedra) {
		if(this.ejeX<otraPiedra.ejeX)
			return -1;
		if(this.ejeX>otraPiedra.ejeX)
			return 1;
		if(this.ejeX==otraPiedra.ejeX) {
			if(this.ejeY<otraPiedra.ejeY)
				return -1;
			if(this.ejeY>otraPiedra.ejeY)
				return 1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return ejeX + " " + ejeY;
	}
	
	
	
}
