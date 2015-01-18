import java.util.ArrayList;
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

    public Hormiguero(Posicion pos, List<Hormiga> listaHormigas) {
        this.setPos(pos);
        this.setListaHormigas(listaHormigas);
    }

    public List<Hormiga> GenerarDescendencia(int n) {
        List<Hormiga> hijas = new ArrayList<Hormiga>();
        if (this.m_listaHormigas.size() > 0) {
            int i = 0;
            while (i < n) {
                for (int j = 0; (j < this.m_listaHormigas.size()) && (i < n); j++) {
                    hijas.add(new Hormiga(i, m_pos, Constante.TIEMPO_VIDA, (this.m_listaHormigas.get(i).getGenes().heredar())));
                }
            }
        } else {
            Genetica genes = new Genetica();
            for (int i = 0; i < n; i++) {
                hijas.add(new Hormiga(i, m_pos, Constante.TIEMPO_VIDA, genes.heredar()));
            }
        }
        return hijas;
    }
}
