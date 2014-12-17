

/**
 * @author Gillermo Rivero
 * @author Boris Ballester
 * @author Cristian Luis
 */
public class Posicion {
	int x;
	int y;
	
	Posicion(){
		this.x = 0;
		this.y = 0;
	}
	
	Posicion(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	Posicion(Posicion posicion){
		this.x = posicion.x;
		this.y = posicion.y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
}
