
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
public class main {

    /**
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        //Generamos genetica inicial
        Genetica gen_base = new Genetica();
        List<Hormiga> hormigas = new ArrayList<Hormiga>();
        List<Planta> plantas = new ArrayList<Planta>();
        Posicion home = new Posicion(5, 5);
        int identificador = 0;
        for (int i = 0; i < 1; i++){
            hormigas.add(new Hormiga(i, home, 500, gen_base.heredar()));
        }
        List<Hormiguero> h = new ArrayList<Hormiguero>();
        h.add(new Hormiguero(home, hormigas));
        
        home = new Posicion(1, 1);
        plantas.add(new Planta(1, 5, home, "spora"));
        home = new Posicion(Constante.MAX_MAPA - 1, Constante.MAX_MAPA - 1);
        plantas.add(new Planta(1, 5, home, "spora"));
        home = new Posicion(1, Constante.MAX_MAPA - 1);
        plantas.add(new Planta(1, 5, home, "spora"));
        home = new Posicion(Constante.MAX_MAPA - 1, 1);
        plantas.add(new Planta(1, 5, home, "spora"));
        
        Mapa map = new Mapa(Constante.MAX_MAPA, Constante.MAX_MAPA, h, plantas);
        int [][] array = map.getMapaMundi();
        map.actualizar();
        for (int k = 0; k < 100; k++){
            //Thread.sleep(1000);
            
            map.avanzar();
            map.actualizar();
            for (int i = 0; i < array.length; i++){
                for (int j = 0; j <array[0].length; j++){
                    System.out.print(map.getPosMapaMundi(new Posicion(i, j)) + " ");
                }
                System.out.println();
            }
            System.out.println("\n");
        }
    }
}
