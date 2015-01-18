
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Crispian
 */
public class main {

    /**
     * @param args
     */
    public static void main(String[] args) throws InterruptedException, IOException {
        //Generamos genetica inicial
        Genetica gen_base = new Genetica();
        List<Hormiga> hormigas = new ArrayList<Hormiga>();
        List<Planta> plantas = new ArrayList<Planta>();
        Posicion home = new Posicion(5, 5);
        Hormiguero tmp = new Hormiguero(home,hormigas);
        List<Hormiguero> h = new ArrayList<Hormiguero>();
        h.add(new Hormiguero(home, tmp.GenerarDescendencia(Constante.N_HORMIGAS)));
        
        home = new Posicion(1, 1);
        plantas.add(new Planta(1, 5, home, "spora"));
        home = new Posicion(Constante.MAX_MAPA_X - 1, Constante.MAX_MAPA_Y - 1);
        plantas.add(new Planta(1, 5, home, "spora"));
        home = new Posicion(1, Constante.MAX_MAPA_Y - 1);
        plantas.add(new Planta(1, 5, home, "spora"));
        home = new Posicion(Constante.MAX_MAPA_X - 1, 1);
        plantas.add(new Planta(1, 5, home, "spora"));
        
        Mapa map = new Mapa(Constante.MAX_MAPA_X, Constante.MAX_MAPA_Y, h, plantas);
        int [][] array = map.getMapaMundi();
        
        
         //Grafica
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        Ventana v = new Ventana();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            v.setVisible(true);
            }
        });
        
        map.actualizar();
        v.setMapa(map.getMapaFeromonas(), map.getMapaMundi());
        for (int k = 0; k < 700; k++){
            Thread.sleep(500);
            map.avanzar();
            map.actualizar();
            v.setMapa(map.getMapaFeromonas(), map.getMapaMundi());
        }
    }
}
