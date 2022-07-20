package Hotel;

import java.util.Arrays;
import java.util.Objects;

public class Hotel {
	private int habitacion;
	private int[] mayores;
	private int[] menores;
	
	
	public Hotel(int cantHabitaciones) {
		this.habitacion = cantHabitaciones;
		this.mayores = new int[habitacion];
		this.menores = new int[habitacion];
	}
	
	public Hotel() {
		
	}
	
	public boolean ocuparHabitacion (int mayor, int menor) {
		int habitacion = 0;
		
		if(mayor + menor > 8)
			return false;
		
		while(this.mayores[habitacion] != 0 || this.menores[habitacion] != 0) {
			habitacion++;
			if(habitacion == this.habitacion)
				return false;
		}
		
		this.mayores[habitacion] = mayor;
		this.menores[habitacion] = menor;
		
		return true;
	}
	
	public int cantidadPersonasHotel() {
		int contadorPersonas = 0;
		
		for(int i=0; i<this.habitacion; i++) {
			contadorPersonas += this.mayores[i] + this.menores[i];
		}
		
		return contadorPersonas;
	}
	
	public int contarHabitacionesCon(int mayores) {
		int cantHabitaciones = 0;
		
		for(int i=0; i<this.habitacion; i++) {
			if(this.mayores[i] == mayores)
				cantHabitaciones++;
		}
		
		return cantHabitaciones;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(mayores);
		result = prime * result + Arrays.hashCode(menores);
		result = prime * result + Objects.hash(habitacion);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hotel other = (Hotel) obj;
		return habitacion == other.habitacion;
	}
	
	
}
