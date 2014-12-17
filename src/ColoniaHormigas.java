
/**
 * @author Gillermo Rivero
 * @author Boris Ballester
 * @author Cristian Luis
 */

import java.util.ArrayList;

class ColoniaHormigas{
	final int NUMERO_HORMIGAS_POR_DEFECTO = 30;
	
	
	ArrayList<Hormiga> hormigas;
	Posicion posicionNido;
	
	ColoniaHormigas(Posicion posicionNido){
		for(int i = 0; i < NUMERO_HORMIGAS_POR_DEFECTO; i++){
			hormigas.add(new Hormiga());
		}		
		this.posicionNido = new Posicion(posicionNido);
	}
	
	ColoniaHormigas(int numeroHormigas, Posicion posicionNido){
		for(int i = 0; i < numeroHormigas; i++){
			hormigas.add(new Hormiga());
		}
		this.posicionNido = new Posicion(posicionNido);
	}	
	
	
}
