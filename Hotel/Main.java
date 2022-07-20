package Hotel;

public class Main {
	public static void main(String[] args) {
		Hotel hotel = new Hotel(3);
		Hotel hotelBis = new Hotel(4);
		
		boolean buscarHabitacion, equalsHab;
		
		buscarHabitacion = hotel.ocuparHabitacion(2, 2); //Se ocupa en hab 1
		buscarHabitacion = hotel.ocuparHabitacion(2, 2); //Se ocupa en hab 2
		buscarHabitacion = hotel.ocuparHabitacion(3, 2); //Se ocupa en hab 3
		//buscarHabitacion = hotel.ocuparHabitacion(2, 2); // No se ocupa porque estan las tres ocupadas
		//buscarHabitacion = hotel.ocuparHabitacion(7, 2); // No se ocupa porque supera máximo de personas (8)
		
		if(buscarHabitacion)
			System.out.println("Se ocupo una habitación");
		else
			System.out.println("No se ocupo ninguna habitación");
		
		System.out.println(hotel.cantidadPersonasHotel());
		
		int cantMayores = 3;
		
		System.out.println("Cantidad de habitaciones con " + cantMayores + " mayores es: " 
							+ hotel.contarHabitacionesCon(cantMayores));
		
		equalsHab = hotel.equals(hotelBis);
		
		if(equalsHab)
			System.out.println("Misma cantidad de habitaciones");
		else
			System.out.println("Diferente cantidad de habitaciones");
	}
}
