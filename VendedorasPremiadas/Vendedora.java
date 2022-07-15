package VendedorasPremiadas;

import java.util.*;

public class Vendedora {
	private int cantVentasVendedora, mayor, numVendedora;
	protected int[] ventas;
	private boolean participa;
	
	public Vendedora() {
		this.participa = false;
		this.mayor = 0;
	}

	public void setVentas(int[] ventas) {
		this.ventas = ventas;
	}

	public int getCantVentasVendedora() {
		return cantVentasVendedora;
	}

	public void setCantVentasVendedora(int cantVentasVendedora) {
		this.cantVentasVendedora = cantVentasVendedora;
	}
	
	public void setMayor(int mayor) {
		this.mayor = mayor;
	}
	
	public void setNumVendedora(int numVendedora) {
		this.numVendedora = numVendedora;
	}
	
	public void encontrarVendedora(List<Vendedora> listVendedoras, int minimoVentas) {
 		Archivo archivoOut = new Archivo();
		int cantidadVendedoras = listVendedoras.size();
		
		
		this.setearParticipacion(listVendedoras, minimoVentas);
		List<Vendedora> vendedoras = this.eliminarDescalificada(listVendedoras);
				
		if(vendedoras.size()==0) {
			archivoOut.writeFile("´No hay ganadoras´");
			return;
		}
		
		this.hallarGanadora(vendedoras, minimoVentas);
		
		while(this.compararMayores(vendedoras, minimoVentas) == -1) {
			minimoVentas++;
			this.setearParticipacion(listVendedoras, minimoVentas);
			this.sigueParticipando(vendedoras);
			if(cantidadVendedoras == 2 && this.compararMayores(vendedoras, minimoVentas) == -1) {
				archivoOut.writeFile("´No se puede desempatar´");
				return;
			}
			vendedoras = this.eliminarDescalificada(listVendedoras);
			System.out.println();
			System.out.println("NUEVALISTA");
			for(Vendedora vendedora: vendedoras) {
				System.out.println(vendedora);
			}
			if(vendedoras.size()==0) {
				archivoOut.writeFile("´No hay ganadoras´");
				return;
			}
			this.hallarGanadora(vendedoras, (minimoVentas));
		} 
		
	}
	
	public void setearParticipacion(List<Vendedora> vendedoras, int minimo) {
		for(Vendedora vendedora: vendedoras) {
			if(vendedora.cantVentasVendedora >= minimo)
				vendedora.participa = true;	
			else
				vendedora.participa = false;
		}
	}
	
	public List<Vendedora> eliminarDescalificada(List<Vendedora> vendedoras) {
		List<Vendedora> newVendedoras = new LinkedList<Vendedora>();
		for(Vendedora vendedora: vendedoras) {
			if(vendedora.participa)
				newVendedoras.add(vendedora);
		}
		return newVendedoras;
	}
		
	public int hallarGanadora(List<Vendedora> vendedoras, int minimo) {
		for(Vendedora vendedora: vendedoras) {
			System.out.println(" size "+  vendedora.ventas.length);
			int minimoVentas = minimo;
			System.out.println("MINIMO = " + minimo);
			int mayor = vendedora.ventas[0];
			int posMayor = 0;
			for(int i=0; i<vendedora.ventas.length; i++) {
				if(vendedora.ventas[i]>mayor) {
					mayor = vendedora.ventas[i];
					posMayor = i;
				}
			}
			System.out.println("-----------");
			System.out.println("Mayor: " + mayor + " posicion: " + posMayor);
			vendedora.setMayor(mayor);
			minimoVentas--;
			int auxPosicion = posMayor;
			int token = 0;
			while(minimoVentas>0) {
				if(token == 0) {
					if(auxPosicion==0) {
						auxPosicion++;
						vendedora.mayor += vendedora.ventas[auxPosicion];
					} else if(auxPosicion==vendedora.ventas.length) {
						auxPosicion--;
						vendedora.mayor += vendedora.ventas[auxPosicion];
					} else if((auxPosicion-1)>=0 && (auxPosicion+1)<vendedora.ventas.length &&
							vendedora.ventas[auxPosicion-1]>vendedora.ventas[auxPosicion+1]) {
						auxPosicion--;	
						vendedora.mayor += vendedora.ventas[auxPosicion];
					} else if((auxPosicion+1)<vendedora.ventas.length && (auxPosicion-1)>=0 &&
							vendedora.ventas[auxPosicion-1]<vendedora.ventas[auxPosicion+1]) {
						auxPosicion++;
						vendedora.mayor += vendedora.ventas[auxPosicion];
					}
					token = -1;
				} else {
					if(posMayor>auxPosicion) {
						if((posMayor+1)<=vendedora.ventas.length && (auxPosicion-1)>=0) {
							if(vendedora.ventas[posMayor+1] >= vendedora.ventas[auxPosicion-1]) {
								posMayor++;
								vendedora.mayor += vendedora.ventas[posMayor];
							} else {
								auxPosicion--;
								vendedora.mayor += vendedora.ventas[auxPosicion];
							}								
						} else if((auxPosicion-1)<0 && (posMayor+1)<vendedora.ventas.length){
							posMayor++;
							vendedora.mayor += vendedora.ventas[posMayor];
						} else if((posMayor+1)>vendedora.ventas.length && (auxPosicion-1)>=0) {
							auxPosicion--;
							vendedora.mayor += vendedora.ventas[auxPosicion];
						}
					} else {
						if((posMayor-1)>=0 && (auxPosicion+1)<vendedora.ventas.length) {
							if(vendedora.ventas[posMayor-1] >= vendedora.ventas[auxPosicion+1]) {
								posMayor--;
								vendedora.mayor += vendedora.ventas[posMayor];
							} else {
								auxPosicion++;
								vendedora.mayor += vendedora.ventas[auxPosicion];
							}								
						} else if((auxPosicion+1)>=vendedora.ventas.length && (posMayor-1)>=0){
							posMayor--;
							vendedora.mayor += vendedora.ventas[posMayor];
						} else if((posMayor-1)<0 && (auxPosicion+1)<vendedora.ventas.length) {
							auxPosicion++;
							vendedora.mayor += vendedora.ventas[auxPosicion];
						}
					}
				}

				System.out.println("mayor " + vendedora.mayor + " posic " + auxPosicion);
				System.out.println();
					
				minimoVentas--;
			}
		}
	

		return -1;
	}


	public int compararMayores(List<Vendedora> vendedoras, int minimo) {
		int auxMayor = 0, tokenMov = 0, numeroVendedora = 0, repetido = 0;
		Archivo archivoOut = new Archivo();
		
		for(Vendedora vendedora: vendedoras) {
			if(vendedora.mayor > auxMayor) {
				auxMayor = vendedora.mayor;
				numeroVendedora = vendedora.numVendedora;
			}else if(vendedora.mayor == auxMayor) {
				tokenMov++;
				repetido = vendedora.mayor;
			}
		}
		
		if(repetido == 0 || (tokenMov!=0 && repetido<auxMayor)) {
			archivoOut.writeFile(numeroVendedora, minimo, auxMayor);
			return 0;
		} else
			return -1;
	}
	
	public void sigueParticipando(List<Vendedora> vendedoras) {
		int auxMayor = 0;
		
		for(Vendedora vendedora: vendedoras) {
			if(vendedora.mayor >= auxMayor) 
				auxMayor = vendedora.mayor;
			else if(vendedora.mayor < auxMayor) {
				vendedora.participa = false;
			}
		}
		
		
	}
	
	@Override
	public String toString() {
		return "Vendedora [cantVentasVendedora=" + cantVentasVendedora
				+ ", ventas=" + Arrays.toString(ventas) + ", Participa? = " + participa + "]";
	}
	
	
}
