/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Crispian
 */
public class Genetica {

    /**
     * @atributos 
     * p_secund 
     *      0 -> Vacia
     *      1 -> Pared 
     *      2 -> Hormiga 
     *      3 -> Plantas 
     *      4 -> Plantas + Hormigas 
     *      5 -> Feromonas. 
     * p_move -> matriz que indica la probabilidad que tiene la hormiga de moverse hacia una casilla adyacente.
     *
     */
    private double[] p_secund;
    private double[] p_mov;
    private double p_volver;
    private boolean food;

    public Genetica() {
        p_secund = new double[6];
        p_secund[0] = Constante.PROB_I_INICIAL;
        p_secund[1] = 0;
        p_secund[2] = Constante.PROB_H_INICIAL;
        p_secund[3] = Constante.PORB_P_INICIAL;
        p_secund[4] = Constante.PORB_P_INICIAL + Constante.PROB_H_INICIAL;
        p_secund[5] = Constante.PROB_F_INICIAL;
        p_volver = Constante.PROB_V_INICIAL;
        p_mov = new double[9];
        for (int i = 0; i < 9; i++) {
            p_mov[i] = Constante.PROB_M_INICIAL;
        }
        food = false; 
    }

    public Genetica(double[] secund, double[] mov) {
        p_secund = secund;
        p_mov = mov;
        p_volver = Constante.PROB_V_INICIAL;
    }

    public void comprobarGenetica(){
        System.out.println("Probabilidaddes: ");
        System.out.println("Prob 0: " + p_secund[0]);
        System.out.println("Prob 1: " + p_secund[1]);
        System.out.println("Prob 2: " + p_secund[2]);
        System.out.println("Prob 3: " + p_secund[3]);
        System.out.println("Prob 4: " + p_secund[4]);
        System.out.println("Prob 5: " + p_secund[5]);
        System.out.println("Mover 0: " + p_mov[0]);
        System.out.println("Mover 1: " + p_mov[1]);
        System.out.println("Mover 2: " + p_mov[2]);
        System.out.println("Mover 3: " + p_mov[3]);
        System.out.println("Mover 4: " + p_mov[4]);
        System.out.println("Mover 5: " + p_mov[5]);
        System.out.println("Mover 6: " + p_mov[6]);
        System.out.println("Mover 7: " + p_mov[7]);
        System.out.println("Mover 8: " + p_mov[8]);
    }
    
    /**
     * @param comida: si la hormiga ya lleva comida consigo. casa: pocision del
     * hormigero. actual: Pocision actual de la hormiga.
     */
    public Posicion consultar(boolean comida, int[][] entorno, Posicion casa, Posicion actual) {
        double tmp = Math.random();
        if (comida && (tmp < p_volver)) {
            food = false;
            System.out.println("Volviendo a Casa.");
            return volver(casa, actual);
        } else {
            double vector[] = new double[9];
            for (int i = 0; i < 9; i++) {
                /* Probabilidad = Prob_Moverse *  Prob_percibido + Prob_Feromonas * Nº de feromonas */
                if (entorno[0][i] == 1){
                    vector[i] = -1000;
                } else {
                    vector[i] = (((Math.random() * p_mov[i]) * p_secund[entorno[0][i]]) + p_secund[5] * entorno[1][i]);
                }
            }
            double max = vector[0];
            int indice = 0;
            for (int i = 1; i < 9; i++) {
                if (max < vector[i]) {
                    max = vector[i];
                    indice = i;
                }
            }
            System.out.println();
            if (entorno[0][indice] > 2) {
               food = true; 
            } 
            return nuevaPos(indice, actual);
        }
    }

    private Posicion volver(Posicion casa, Posicion actual) {
        int x = actual.getX(), y = actual.getY();

        if (actual.getX() != casa.getX()) {
            if (actual.getX() > casa.getX()) {
                x--;
            } else {
                x++;
            }
        }
        if (actual.getY() != casa.getY()) {
            if (actual.getY() > casa.getY()) {
                y--;
            } else {
                y++;
            }
        }
        return new Posicion(x, y);
    }

    public Genetica heredar() {
        double alteracion;
        double[] mov = new double[9];
        double[] secund = new double[6];
        for (int i = 0; i < 9; i++) {
            alteracion = Math.random();
            if (alteracion < 0.2) {
                double signo = Math.random();
                if (signo > 0.5) {
                    mov[i] = p_mov[i] + alteracion * 2;
                } else {
                    mov[i] = p_mov[i] - alteracion * 2;
                }
            } else {
                mov[i] = p_mov[i];
            }
        }

        for (int j = 0; j < 6; j++) {
            alteracion = Math.random();
            if (alteracion < 0.2) {
                double signo = Math.random();
                if (signo > 0.5) {
                    secund[j] = p_secund[j] + alteracion * 2;
                } else {
                    secund[j] = p_secund[j] - alteracion * 2;
                }
            } else {
                secund[j] = p_secund[j];
            }
        }

        return (new Genetica(secund, mov));
    }

    private Posicion nuevaPos(int indice, Posicion actual) {
        int x = actual.getX(), y = actual.getY();
        if ((indice == 0) || (indice == 3) || (indice == 6)) {
            x--;
        }
        if ((indice == 2) || (indice == 5) || (indice == 8)) {
            x++;
        }
        if ((indice == 0) || (indice == 1) || (indice == 2)) {
            y--;
        }
        if ((indice == 6) || (indice == 7) || (indice == 8)) {
            y++;
        }
        /*
        if (x < 0){
            x = 0; 
        }
        if (x > (Constante.MAX_MAPA-1)){
            x = (Constante.MAX_MAPA-1);
        }
        if (y < 0){
            y = 0; 
        }
        if (y > (Constante.MAX_MAPA-1)){
            y = (Constante.MAX_MAPA-1);
        }
        */
        return (new Posicion(x, y));
    }
    
    public boolean comidaEncontrada(){
        return food;
    }
}
