import java.util.List;


public class Hormiguero {
	private Posicion m_pos;
	private List<Hormiga> m_listaHormigas;
	
	public Posicion getPos() {
		return m_pos;
	}


	public List<Hormiga> getListaHormigas() {
		return m_listaHormigas;
	}
	
	public void setPos(Posicion pos) {
		this.m_pos = pos;
	}

	public void setListaHormigas(List<Hormiga> listaHormigas) {
		this.m_listaHormigas = listaHormigas;
	}
	

	public Hormiguero(Posicion pos, List<Hormiga> listaHormigas){
		this.setPos(pos);
		this.setListaHormigas(listaHormigas);
	}
}
