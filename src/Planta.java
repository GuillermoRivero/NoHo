
/**
 * @author Guillermo Rivero
 * @author Boris Ballester
 * @author Cristian Luis
 */

public class Planta {
	//ATRIBUTOS
	private int m_id;
	private int m_vida;
	private Posicion m_posicion;
	private String m_reproduccion;
	
	//CONSTRUCTOR
	public Planta(int id,int vidaInicial, Posicion posInicial, String modoReproduccion){
		this.setID(id);
		this.setVida(vidaInicial);
		this.setPos(posInicial);
		this.setReproduccion(modoReproduccion);
	}

	//SETTERS
	public void setID(int m_id) {
		this.m_id = m_id;
	}

	public void setVida(int m_vida) {
		this.m_vida = m_vida;
	}

	public void setPos(Posicion m_pos) {
		this.m_posicion = m_pos;
	}

	public void setReproduccion(String m_mov) {
		this.m_reproduccion = m_mov;
	}
	
	//GETTERS
	public int getID(){
		return this.m_id;
	}

	public int getVida() {
		return m_vida;
	}

	public Posicion getPos() {
		return this.m_posicion;
	}
	
	public String getReproduccion() {
		return this.m_reproduccion;
	}
	
	//METODOS
	/*public Planta reproducirse(){
		switch(this.m_reproduccion){
		case "ESPORAS":
			
			break;
		case "CUMULO":
			
			break;
		
		}
		
	}*/
	
}
