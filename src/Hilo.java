//package hormigas;

import java.util.Random;
import javax.swing.JPanel;


/**
 * @Fecha : 22-abr-2014
 * @Alumno: alu0100693386
 * @Autor : Cristian Luis Hdez.
 * @E-mail: Crispilandia@gmail.com
 */
public class Hilo implements Runnable {

    private Panel lienzo;
    private Thread t;

    public Hilo(Panel p) {
        lienzo = p;
        t = new Thread( this );
        t.setPriority(Thread.NORM_PRIORITY);
        t.start();
    }

    @Override
    public void run() {
        double tp = 0;
        while (true) {
            
            try {
                t.sleep(10);
            } catch (InterruptedException ex) {
                System.out.println("Error al dormir el Hilo");
            }
            
            /*
            Random rnd = new Random();
            for(int i = 0; i < lienzo.filas; i++){
                for(int j = 0; j < lienzo.columnas; j++){
                    lienzo.matrizObjetos[i][j] = (int)(rnd.nextDouble() * 4 + 1);
                    lienzo.matrizFeromonas[i][j] = (int)(rnd.nextDouble() + 1);
                }
            }
            */
            //ACTUALIZAR MATRICES DEL MAPA MEDIANTE LOS METODOS
            //void setObjetos(int[][] matrizObjetos):
            //void setFeromonas(int[][] matrizObjetos)
            
            //RECORDAR QUE EL TAMAÑO DEL MAPA SE DEFINE EN EL VENTANA.JAVA
            lienzo.repaint();
            //System.out.println("Tiempo : " + tp);
            //tp= tp+0.5;
        }
    }

    void stop() {
        t.stop();
    }
}
