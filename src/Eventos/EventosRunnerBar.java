/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import Interfaz.RunnerBar;
import subprocesos.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author jesus
 */
public class EventosRunnerBar implements ActionListener{
    
    private RunnerBar frame;
    
    public EventosRunnerBar(RunnerBar frame){
        this.frame = frame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        int tam = frame.getTam();
        frame.getBtnGo().setEnabled(false);
        for(int i = 0; i < tam; i++){
            frame.getLblFinalistas()[i].setText("");
            frame.getBar()[i].setStringPainted(true);
            frame.getBar()[i].setForeground(frame.getColorPorDefecto());
            frame.getBar()[i].setString("");
        }

        String [] country = new String[tam];
        country = frame.seleccionador();

        for(int i = 0; i < tam; i++){
            frame.getLblNombres()[i].setText(country[i]);
        }

            Hilos [] hilos = new Hilos[tam];

            for(int i = 0; i < tam; i++){
                hilos[i] = new Hilos(frame.getBar()[i], country[i],i); 
            }
            
            for(int i = 0; i < tam; i++){
                hilos[i].start();
            }

            tablaFinal fin = new tablaFinal(frame.getLblFinalistas(), hilos, tam, frame.getBtnGo());
            fin.start();
        
    }
    
}
