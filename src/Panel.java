/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package hormigas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Guillermo
 */

public class Panel extends JPanel{

    int[][] matrizObjetos;
    int[][] matrizFeromonas;
    int filas;
    int columnas;
    private int tamObjetos;
    final BufferedImage imgFondo;
    final BufferedImage imgHormiga;
    private boolean pintarObjetos;
    private boolean pintarFeromonas;
    

    
    Panel(int filas, int columnas) throws IOException{
        super();
        this.imgFondo = ImageIO.read(new File("fondo.jpg"));
        this.imgHormiga = ImageIO.read(new File("ant.png"));
        this.filas = filas;
        this.columnas = columnas;
        matrizObjetos = new int[filas][columnas];
        matrizFeromonas = new int[filas][columnas];
        tamObjetos = 10;
        pintarObjetos = true;
        pintarFeromonas = true;
        System.out.println(filas);
        System.out.println(columnas);
        Random rnd = new Random();
        for(int i = 0; i < filas; i++){
            for(int j = 0; j < columnas; j++){
                matrizObjetos[i][j] = 0;
                matrizFeromonas[i][j] = 0 ;
            }
        }
        
    }
 
    public void paintComponent(Graphics d){
        Graphics2D dw = (Graphics2D) d;
        
        
        dw.setColor(Color.WHITE);
        dw.fillRect(0, 0, this.getWidth(), this.getHeight());
        
        dw.drawImage(imgFondo, 0, 0, null);
        for(int i = 0; i < filas; i++){
            for(int j = 0; j < columnas; j++){
                int x = j*tamObjetos;
                int y = i*tamObjetos;
                if(pintarObjetos)
                switch(matrizObjetos[i][j]){
                    case 2: 
                        //Pintar hormiga
                        //dw.drawImage(imgHormiga, 0, 0, null);
                        dw.setColor(Color.BLACK);
                        dw.fillRect(x, y, tamObjetos, tamObjetos);
                        break;
                    case 3: 
                        //Pintar planta
                        dw.setColor(Color.GREEN);
                        dw.fillRect(x, y, tamObjetos, tamObjetos);
                        break;
                    case 4:
                        //Pintar hormiga y planta
                        dw.setColor(Color.YELLOW);
                        dw.fillRect(x, y, tamObjetos, tamObjetos);
                        break;
                }
                if(pintarFeromonas)
                switch(matrizFeromonas[i][j]){
                    case 0: //No hacer nada
                        break;
                    default:
                        dw.setColor(Color.BLUE);
                        dw.fillRect(x+(tamObjetos/3), y+(tamObjetos/3), tamObjetos-(tamObjetos/3)*2, tamObjetos-(tamObjetos/3)*2);
                        break;
                }
            }
        }
        
    }
    
    void setObjetos(int[][] matrizObjetos){
        for(int i = 0; i < filas; i++){
            for(int j = 0; j < columnas; j++){
                this.matrizObjetos[i][j] = matrizObjetos[i][j];
            }
        }
    }
    void setFeromonas(int[][] matrizFeromonas){
        for(int i = 0; i < filas; i++){
            for(int j = 0; j < columnas; j++){
                //DEBUG System.out.println("Valor i " + i + "  Valor j " +j);
                this.matrizFeromonas[i][j] = matrizFeromonas[i][j];
            }
        }
    }
    void setPintarFeromonas(boolean estado){
        pintarFeromonas = estado;
    }
    void setPintarObjetos(boolean estado){
        pintarObjetos = estado;
    }
    boolean getPintarFeromonas(){
        return pintarFeromonas;
    }
    boolean getPintarObjetos(){
        return pintarObjetos;
    }
}
