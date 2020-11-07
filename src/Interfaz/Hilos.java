/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.awt.Color;
import javax.swing.JProgressBar;

/**
 *
 * @author jesus
 */
public class Hilos extends Thread{
    private JProgressBar bar;
    private String pais,fin=null;
    private int colors;
    private Color [] colores={Color.BLUE,Color.CYAN,Color.GRAY,
    Color.GREEN, Color.MAGENTA, Color.ORANGE,
    Color.PINK,Color.RED,Color.WHITE,Color.YELLOW};

    public Hilos(JProgressBar bar,String pais,int colors){
        this.bar = bar;
        this.pais = pais;
        this.colors = colors;
    }

    public void run() {
        bar.setStringPainted(true);
        int y=0, t=0;
        bar.setForeground(colores[colors]);
        while(y<=100){
            t=(int)(Math.random()*(3-10)+10);
            y=y+(int)(Math.random()*(1-5)+5);
            bar.setValue(y);
            bar.repaint();
            if(y!=100){
            try{Thread.sleep( t*100 );} catch (InterruptedException e){} }
        }

        bar.setForeground(Color.BLACK);
        bar.setString(pais+" finalizo!");
        fin=pais;
    }

public String yaFinalizo(){ return fin; }

public void stopFinalizo(){ fin=null; }

}