/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subprocesos;

import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import javax.swing.border.LineBorder;

/**
 * Clase que se encarga de aumentar las distintas 
 * JProgressBar para simular la carrera
 * @author jesus
 */
public class Hilos extends SwingWorker<Void, Object>{
    private JProgressBar bar;
    private String pais,fin=null;
    private int colors;
    private Color [] colores={Color.BLUE, Color.CYAN, Color.GRAY,
    Color.GREEN, Color.MAGENTA, Color.ORANGE,
    Color.PINK, Color.RED, Color.DARK_GRAY, Color.YELLOW};

    /**
     * Constructor
     * @param bar - Objeto JProgressBar
     * @param pais - String país al que corresponde JProgressBar
     * @param colors - int para seleccionar un color
     */
    public Hilos(JProgressBar bar, String pais, int colors){
        this.bar = bar;
        this.pais = pais;
        this.colors = colors;
    }
    
    /**
     * Método doInBlackground de SwingWorker que se encarga de administrar
     * los subprocesos
     * @return - void
     */
    @Override
    protected Void doInBackground(){
        bar.setStringPainted(true);
        int y = 0, t = 0;
        bar.setForeground(colores[colors]);
        while(y <= 100){
            t = (int)(Math.random()*(-7) + 10);
            y = y + (int)(Math.random()*(-4) + 5);
            bar.setValue(y);
            bar.repaint();
            if(y != 100){
                try {
                    Thread.sleep(t * 100);
                } catch(InterruptedException e) { } 
            }
        }
        return null;
    }
    
    /**
     * Método done de SwingWorker, se ejecuta una vez terminado doInBackground
     */
    @Override
    protected void done(){
        bar.setForeground(Color.BLACK);
        bar.setString(pais + " finalizo!");
        fin = pais;
    }

    /**
     * Getter
     * @return - String: Regresa el país que ha finalizado
     */
    public String yaFinalizo(){
        return fin; 
    }

    /**
     * Asigna null a fin para poder saber qué países han finalizado despues
     */
    public void stopFinalizo(){ 
        fin = null; 
    }

}