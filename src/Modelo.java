import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Crispian
 */
class Modelo {

    private Ventana v;

    public Modelo(Ventana V) {
        v = V;
    }

    public void iniciarSimulacion(int horm, int h, int p, Panel panel) throws InterruptedException {
        //Inicializacion
        
        List<Hormiga> hormigas = new ArrayList<Hormiga>();
        List<Planta> plantas = new ArrayList<Planta>();
        Posicion home = new Posicion(0, 0);
        Hormiguero tmp = new Hormiguero(home, hormigas);
        List<Hormiguero> hormigueros = new ArrayList<Hormiguero>();
        Mapa map = new Mapa(Constante.MAX_MAPA_X, Constante.MAX_MAPA_Y, hormigueros, plantas);
        for (int i = 0; i < horm; i++) {

            List<Hormiga> hormigax = new ArrayList<Hormiga>();
            home = map.generarPosicion();
            tmp.setPos(home);
            hormigueros.add(new Hormiguero(home, tmp.GenerarDescendencia(h)));
        }
        for (int i = 0; i < p; i++) {
            home = map.generarPosicion();
            plantas.add(new Planta(i, Constante.TIEMPO_VIDA, home, "cumulo"));
        }

        map.actualizar();
        v.setMapa(map.getMapaFeromonas(), map.getMapaMundi());
        for (int k = 0; k < 600; k++) {
            Thread.sleep(500);
            map.avanzar();
            map.actualizar();
            v.setMapa(map.getMapaFeromonas(), map.getMapaMundi());
        }
    }

    public void nuevaGeneracion() {

    }

}
