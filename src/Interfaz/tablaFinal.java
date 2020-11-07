/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author jesus
 */
class tablaFinal extends Thread{
    public JLabel [] finalistas;
    public Hilos [] hilos;
    //public HilosColorXpais [] hilos;
    int tam;
    public JButton go;

    //public tablaFinal(JLabel[] finalistas,HilosColorXpais [] hilos, int tam, JButton go)
    public tablaFinal(JLabel[] finalistas,Hilos [] hilos, int tam, JButton go)
    {
        this.go = go;
        this.finalistas= new JLabel[tam];
        this.finalistas=finalistas;
        this.hilos = hilos;
        this.tam=tam;
    }

    public void run() {
        Font s = finalistas[0].getFont();
        int x=0;
        while(x<10){
            for(int i=0;i<tam;i++){
                if(hilos[i].yaFinalizo()!=null){

                    if(x==0){
                        finalistas[x].setForeground(Color.ORANGE);
                        finalistas[x].setFont(new Font(s+"",Font.BOLD,24)); }

                    if(x==1){
                        finalistas[x].setForeground(Color.GRAY);
                        finalistas[x].setFont(new Font(s+"",Font.BOLD,19)); }

                    if(x==2){
                        finalistas[x].setForeground(new Color(159, 80, 0));
                        finalistas[x].setFont(new Font(s+"",Font.BOLD,16)); }

                    finalistas[x].setText((x+1)+". "+ hilos[i].yaFinalizo());
                    hilos[i].stopFinalizo();
                    x++;
                }
            }
        }
        go.setEnabled(true);
    }
}