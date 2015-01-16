
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
        gen_base.comprobarGenetica();
        gen_base.heredar().comprobarGenetica();
        List<Hormiga> hormigas = new ArrayList<Hormiga>();
        List<Planta> plantas = new ArrayList<Planta>();
        Posicion home = new Posicion(17, 17);
        int identificador = 0;
        for (int i = 0; i < 30; i++){
            hormigas.add(new Hormiga(i, home, 500, gen_base.heredar()));
            
        }
        plantas.add(null);
        List<Hormiguero> h = new ArrayList<Hormiguero>();
        h.add(new Hormiguero(home, hormigas));
        Mapa map = new Mapa(35, 35, h, plantas);
        int [][] array = map.getMapaMundi();
        for (int k = 0; k < 10; k++){
            Thread.sleep(1000);
            map.actualizar();
            map.avanzar();
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
