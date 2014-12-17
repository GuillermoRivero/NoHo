
/**
 * @author Gillermo Rivero
 * @author Boris Ballester
 * @author Cristian Luis
 */

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;



public class Hormiga extends Agent{
	
	//Atributos
	Posicion posicion;
	int salud;
	Behaviour primerComportamiento;

/*
 * Estados del agente: se obtiene mediante getAgentState();
 * 
 * Iniciado: El objeto Agente está creado pero todavía no se ha registrado en el AMS, no tiene nombre ni dirección y tampoco se puede comunicar con otros agentes.
 * Activo: El Agente está registrado en el AMS, tiene un nombre, una dirección y puede acceder a todas las opciones de JADE.
 * Suspendido: El Agente está parado. Su hilo de ejecución está detenido y no ejecuta ningún Comportamiento.
 * En espera: El Agente está bloqueado esperando por algo. Su hilo de ejecución está dormido en un monitor de java y se despertará cuando se cumpla una cierta condición (cuando reciba un mensaje).
 * Desconocido: El Agente ha sido eliminado. El hilo de ejecución ha terminado y se ha eliminado del registro del AMS.
 * Tránsito: Un Agente móvil entra en este estado mientras está migrando a una nueva localización. El sistema sigue guardando los mensajes en el buffer hasta que el agente vuelve a estar activo.
 */
	
	
/*
 * AL crear un agente se llama al constructor
 * se crea el indentificador de agente AID
 * se registra el agente en el AMS
 * se ejecuta el meotdo setup, donde puedes introducir codigo relativo a la inicializacion
 * 
 */
	
/*
 * Hay dos formas de ejecurar un agente, desde el gui de jade o desde la linea de comandos
 */
	
	protected void setup(){
		addBehaviour(new ComportamientoBuscador());
		System.out.println("La hormiga con mas SUAJ " + getAID().getName() + " esta en marcha.");
	}
	
	protected void takeDown(){
		
	}
	
	public void deleteAgent(){
		doDelete();
	}
	
	private class ComportamientoBuscador extends Behaviour{

		public void action(){
			/*
			 * Action es el metodo que se ejecuta cuando se realiza un comportamiento
			 * No deberia tener tiempo de ejecucion alto ya que no se puede interrumpir
			 */
	        System.out.println("Mi nombre es: "+getName() );
	            System.out.println("Soy el comportamiento buscador");
	            primerComportamiento = new ComportamientoRecolector();
	            myAgent.addBehaviour(primerComportamiento); //Cambiar el comportamiento
	 
	    }
		
	    public boolean done(){ //Se ejecuta cuando acaba action, devuelve true si se ha ejecutado action, en caso de que devuelva true, se borra el comportamiento completado de la cola de comportamientos
	    	//http://programacionjade.wikispaces.com/Comportamientos EJEMPLO 2.3
	        return true;
	    }

	}
	
	private class ComportamientoRecolector extends Behaviour{
        public void action(){
            System.out.println("Soy el comportamiento recolector");
            myAgent.removeBehaviour(primerComportamiento); //eliminar el primer comportamiento
          //El metodo block evita que se ejecute el comportamiento durante un tiempo determinado, en este caso 1 segundo
            block(1000);
    }
        public boolean done(){
            return true;
        }
   }
	
	private class ComportamientoOneShot extends OneShotBehaviour { //es un tipo de comportamiento que solo se ejecuta una vez. done() siempre devuelve true.
        public void action() {
           System.out.println("Ejecutamos la accion una sola vez");
           myAgent.doDelete();
         }
    }
	
	private class ComportamientoCiclico extends CyclicBehaviour { //es un tipo de comportamiento que se ejecuta siempre que este activo el agente, hay que tener cuidado que no consuma todo el uso de la cpu done() siempre devuelve false
        public void action() {
           System.out.println("Ejecutamos la accion ciclicamente");
        }
   }
}
