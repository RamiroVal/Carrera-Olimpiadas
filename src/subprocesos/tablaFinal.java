package subprocesos;

import Interfaz.RunnerBar;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingWorker;

/**
 * Clase que extiende de SwingWorker
 * se encarga de mostrar los ganadores
 * en el pánel correspondiente
 * @author jesus
 */
public class tablaFinal extends SwingWorker<Void, Object>{

    private final RunnerBar frame;
    private final Hilos[] hilos;

    /**
     * Constructor
     * @param frame - Se utiliza para hacer referencia a otros objetos
     * @param hilos - Se utiliza para saber qué barra de progreso ha terminado
     */
    public tablaFinal(RunnerBar frame, Hilos[] hilos)
    {
        this.frame = frame;
        this.hilos = hilos;
    }

    /**
     * Método de SwingWorker
     * @return - void
     */
    @Override
    public Void doInBackground() {
        int x = 0;
        while(x < 10){
            for(int i = 0; i < frame.getTam(); i++){
                if(hilos[i].yaFinalizo() != null){

                    if(x == 0){
                        frame.getLblFinalistas()[x].setForeground(Color.ORANGE);
                        frame.getLblFinalistas()[x].setFont(new Font("Calibri", Font.BOLD,24)); 
                    }

                    if(x == 1){
                        frame.getLblFinalistas()[x].setForeground(Color.GRAY);
                        frame.getLblFinalistas()[x].setFont(new Font("Calibri", Font.BOLD,19)); 
                    }

                    if(x == 2){
                        frame.getLblFinalistas()[x].setForeground(new Color(159, 80, 0));
                        frame.getLblFinalistas()[x].setFont(new Font("Calibri", Font.BOLD,16)); 
                    }

                    frame.getLblFinalistas()[x].setText((x + 1) + ". " + hilos[i].yaFinalizo());
                    hilos[i].stopFinalizo();
                    x++;
                }
            }
        }
        
        return null;
    }
    
    /**
     * Método done de SwingWorker, se encarga de avilitar el botón Go
     */
    @Override
    public void done(){
        frame.getBtnGo().setEnabled(true);
    }

}