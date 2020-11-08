package Eventos;

import Interfaz.RunnerBar;
import java.awt.Color;
import subprocesos.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 * Clase encargada de manejar los eventos de RunnerBar implementa
 * AtionListener
 * @author jesus
 */
public class EventosRunnerBar extends MouseAdapter implements ActionListener{
    
    private final RunnerBar frame;
    
    public EventosRunnerBar(RunnerBar frame){
        this.frame = frame;
    }
    
    /**
     * Método ationPerformed para el manejo de eventos
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e){
        int tam = frame.getTam();
        frame.getBtnGo().setEnabled(false);
        for(int i = 0; i < tam; i++){
            frame.getLblFinalistas()[i].setText("");
            frame.getBar()[i].setStringPainted(true);
            frame.getBar()[i].setString("");
        }

        String [] country = new String[tam];
        country = frame.seleccionador();

        for(int i = 0; i < tam; i++){
            frame.getLblNombres()[i].setText(country[i]);
        }

        Hilos[] hilos = new Hilos[tam];

        for(int i = 0; i < tam; i++){
            hilos[i] = new Hilos(frame.getBar()[i], country[i], i); 
        }
            
        for(int i = 0; i < tam; i++){
            hilos[i].execute();
        }

        tablaFinal fin = new tablaFinal(frame, hilos);
        fin.execute();
        
    }
    
    @Override
    public void mouseEntered(MouseEvent e){
        frame.getBtnGo().setBackground(new Color(128, 128, 128));
        
    }
    
    @Override
    public void mouseExited(MouseEvent e){
        frame.getBtnGo().setBackground(new Color(69, 69, 69));
    }
    
}
