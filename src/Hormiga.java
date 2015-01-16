/**
 * @author Gillermo Rivero
 * @author Boris Ballester
 * @author Cristian Luis
 */
public class Hormiga {

    /**
     * @atributos
     *
     */
    private Posicion pos;
    private boolean comida;
    private int vida;
    private Genetica genes;
    private int id;

    /**
     * Constructor
     *
     * @params pos
     */
    public Hormiga(int identificador, Posicion inicial, int life, Genetica gen) {
        id = identificador;
        pos = inicial;
        vida = life;
        genes = gen;
        comida = false;
    }

    /**
     * Getters & Setters
     *
     * @param pos Posicion en el mapa (coordenadas x y)
     */
    public void setPos(Posicion pos) {
        this.pos = pos;
    }

    public void setComida(boolean comida) {
        this.comida = comida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Posicion getPos() {
        return pos;
    }

    public boolean isComida() {
        return comida;
    }

    public int getVida() {
        return vida;
    }

    public Genetica getGenes() {
        return genes;
    }

    public int getId() {
        return id;
    }

    /**
     * Metodos
     */
    public boolean isAlive() {
        if (vida > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean mover(int[][] entorno, int[][] feromonas, Posicion home) {
        int[][] percepcion = new int[2][9];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                percepcion[0][i + 3 * j] = entorno[i][j];
                percepcion[1][i + 3 * j] = feromonas[i][j];
            }
        }
        Posicion nueva = genes.consultar(comida, percepcion, home, pos);
        pos = nueva;
        if (comida) {
            if (home.equal(pos)) {
                comida = false;
            }
        } else {
            if (genes.comidaEncontrada()) {
                comida = true;
            }
        }
        return false;
    }

    
}
