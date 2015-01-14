import java.util.List;


import java.util.ArrayList;


/**
 * @author Gillermo Rivero
 * @author Boris Ballester
 * @author Cristian Luis
 */

public class Mapa {

	//ATRIBUTOS
	private int [][] m_mapaMundi;
	private int [][] m_mapaFeromonas;
	private List<Hormiguero> m_hormigueros;
	private List<Planta> m_plantas;
	
	//CONSTRUCTOR
    public Mapa(int filas, int columnas, List<Hormiguero> hormigueros, List<Planta> plantas){
    	this.setPlantas(plantas);
    	this.setHormigueros(hormigueros);
    	this.setMapaFeromonas(new int [filas][columnas]);
    	this.setMapaMundi(new int [filas][columnas]);
    	this.actualizar();
    }

    //GETTERS
	public int[][] getMapaMundi() {
		return m_mapaMundi;
	}

	public int[][] getMapaFeromonas() {
		return m_mapaFeromonas;
	}

	public List<Hormiguero> getHormigueros() {
		return m_hormigueros;
	}
	
	public List<Planta> getPlantas() {
		return m_plantas;
	}

	//SETTERS
	public void setMapaMundi(int[][] mapaMundi) {
		this.m_mapaMundi = mapaMundi;
	}
	
	public void setMapaFeromonas(int[][] mapaFeromonas) {
		this.m_mapaFeromonas = mapaFeromonas;
	}
	
	public void setHormigueros(List<Hormiguero> hormiguero) {
		this.m_hormigueros = hormiguero;
	}
		
	public void setPlantas(List<Planta> plantas) {
		this.m_plantas = plantas;
	}
    
	
	//METODOS
	public void setPosMapaMundi(Posicion pos, int value){
		this.m_mapaMundi[pos.x][pos.y] = value;
	}
	
	public int getPosMapaMundi(Posicion pos){
		return this.m_mapaMundi[pos.x][pos.y];
	}
	
	public void setPosMapaFeromonas(Posicion pos, int value){
		this.m_mapaFeromonas[pos.x][pos.y] = value;
	}
	
	public int getPosMapaFeromonas(Posicion pos){
		return this.m_mapaFeromonas[pos.x][pos.y];
	}
	
	public void actualizar(){
		for(int i = 0; i < this.m_hormigueros.size();i++){
			List<Hormiga> hormigasHormiguero = this.m_hormigueros.get(i).getListaHormigas();
			for(int j = 0; j<hormigasHormiguero.size();j++){
				Posicion posicionHormiga = hormigasHormiguero.get(j).posicion;
				int valorCelda = getPosMapaMundi(posicionHormiga);
				switch(valorCelda){
					case 0:
						setPosMapaMundi(posicionHormiga, 2);
						break;
					case 3:
						setPosMapaMundi(posicionHormiga, 4);
						break;
				}
				//TODO: FEROMONAS
			}
			
		}
	}
	
	public int[][] obtenerAdyacencia(Posicion pos){
		int[][] matrizAdyacencia = new int[3][3];
		
		int filas = this.m_mapaMundi.length;
		int columnas = this.m_mapaMundi[0].length;
		
		//NORTE
		if(pos.x - 1 < 0){
			matrizAdyacencia[0][1] = 1;//BLOQUEADA
		}else{
			matrizAdyacencia[0][1] = getPosMapaMundi(new Posicion(pos.x-1,pos.y));
		}
		//SUR
		if(pos.x + 1 >= filas){
			matrizAdyacencia[2][1] = 1;//BLOQUEADA
		}else{
			matrizAdyacencia[2][1] = getPosMapaMundi(new Posicion(pos.x+1,pos.y));
		}		
		//ESTE
		if(pos.y + 1 >= columnas){
			matrizAdyacencia[1][2] = 1;//BLOQUEADA
		}else{
			matrizAdyacencia[1][2] = getPosMapaMundi(new Posicion(pos.x,pos.y+1));
		}			
		//OESTE
		if(pos.y - 1 < 0){
			matrizAdyacencia[1][0] = 1;//BLOQUEADA
		}else{
			matrizAdyacencia[1][0] = getPosMapaMundi(new Posicion(pos.x,pos.y-1));
		}					
		//NOROESTE 
		if(pos.x - 1 < 0 || pos.y - 1 < 0 ){
			matrizAdyacencia[0][0] = 1;//BLOQUEADA
		}else{
			matrizAdyacencia[0][0] = getPosMapaMundi(new Posicion(pos.x-1,pos.y-1));
		}		
		//NORESTE
		if(pos.x - 1 < 0 || pos.y + 1 >= columnas ){
			matrizAdyacencia[2][2] = 1;//BLOQUEADA
		}else{
			matrizAdyacencia[2][2] = getPosMapaMundi(new Posicion(pos.x-1,pos.y+1));
		}	
		//SUROESTE
		if(pos.x + 1 >= filas || pos.y - 1 < 0){
			matrizAdyacencia[2][2] = 1;//BLOQUEADA
		}else{
			matrizAdyacencia[2][2] = getPosMapaMundi(new Posicion(pos.x+1,pos.y-1));
		}			
		//SURESTE
		if(pos.x + 1 >= filas || pos.y + 1 >= columnas ){
			matrizAdyacencia[2][0] = 1;//BLOQUEADA
		}else{
			matrizAdyacencia[2][0] = getPosMapaMundi(new Posicion(pos.x+1,pos.y+1));
		}
		//CENTRO
		matrizAdyacencia[1][1] = getPosMapaMundi(pos);
		return matrizAdyacencia;
	}
	
	
	public void avanzar(){
		for(int i = 0; i < this.m_hormigueros.size();i++){
			List<Hormiga> hormigasHormiguero = this.m_hormigueros.get(i).getListaHormigas();
			for(int j = 0; j<hormigasHormiguero.size();j++){
				Hormiga hormigaAux = hormigasHormiguero.get(j);
				//TODO: MOVER HORMIGA
			}
			
		}
		for(int i = 0; i < this.m_plantas.size();i++){
			//TODO: MOVER PLANTA
		}
	}
    
}
