/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Eventos.EventosRunnerBar;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.LineBorder;

/**
 * Programa que simula una carrera olímpica por medio de barras de progreso
 * @author Jesus
 */
public class RunnerBar extends JFrame {
    private static final long serialVersionUID = 1L;
    private static int tam;
    private JButton btnGo;
    private JLabel [] lblNombres;
    private JLabel [] lblFinalistas;
    private JProgressBar [] bar;
    private Color ColorPorDefecto;
    
    /**
     * Constructor
     */
    public RunnerBar(){
        super("Enviador");
        setLayout(null);
        setSize(1000,519);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        tam = 10;
        
        creaInterfaz();
        creaPanelCarrera();
        creaPanelNombres();
        creaPanelFinalistas();
        
    }
    
    /**
     * Se encarga de crear el panel donde estan las barras de carga
     */
    private void creaPanelCarrera(){
        JPanel panelCarrera = new JPanel(new GridLayout(tam,1,1,11));
        panelCarrera.setBounds(200, 130, 500, 300);
        
        bar = new JProgressBar[tam];
        
        for(int i = 0; i < tam; i++){
            bar[i] = new JProgressBar();
            panelCarrera.add(bar[i]);
        }
        
        ColorPorDefecto = bar[0].getForeground();
        
        add(panelCarrera);
    }
    
    /**
     * Se encarga de crear el panel donde estan los nombres de los distintos países
     * de la competición
     */
    private void creaPanelNombres(){
        JPanel panelNombres = new JPanel(new GridLayout(tam,1,1,11));
        panelNombres.setBounds(75, 130, 90, 300);
        
        lblNombres= new JLabel[tam];
        
        for(int i=0;i<tam;i++){
            lblNombres[i] = new JLabel("…");
            panelNombres.add(lblNombres[i]);
        }
        
        add(panelNombres);
    }
    
    /**
     * Se encarga de crear el panel donde están los países
     * que van llegando a la meta
     */
    private void creaPanelFinalistas(){
        JPanel panelFinalistas= new JPanel(new GridLayout(tam,1,1,1));
        panelFinalistas.setBounds(750, 130, 200, 250);
        
        lblFinalistas = new JLabel[tam];
        
        
        for(int i=0;i<tam;i++){
            lblFinalistas[i] = new JLabel("");
            panelFinalistas.add(lblFinalistas[i]);
        }
        
        add(panelFinalistas);
    }
    
    /**
     * Se encarga de los objetos que estan en el frame principal
     */
    private void creaInterfaz(){
        JLabel lblFinalistasTitulo = new JLabel("Finalistas!!");
        JLabel lblTitulo = new JLabel("Carrera Olímpica");
        lblFinalistasTitulo.setBounds(750, 100, 70, 20);
        lblTitulo.setBounds(325, 25, 500, 30);
        
        btnGo = new JButton("GO!");
        btnGo.setBounds(75, 100, 70, 20);
        
        btnGo.addActionListener(new EventosRunnerBar(this));
        
        add(lblFinalistasTitulo);
        add(lblTitulo);
        add(btnGo);
    }

    /**
     * Tiene una lista de países del cual se escogen 10 de forma aleatoria
     * @return - Un vector con los países seleccionados
     */
    public String[] seleccionador(){
        String namesCountry[] = {"Argentina","Panamá","Brasil","EEUU","México","Reino Unido",
            "Canadá","Venezuela","Alemania","China","Jamaica","Somalía","Barbados","Kenia","Etiopía","Sudáfrica",
            "Australia","Japón","Uganda","Francia","Tanzania","Letonia","Honduras","Haití","Portugal","Israel",
            "Egipto","Rusia","Tri.Tobago","Noruega"};
        String[] country = new String[tam];

        for(int i=0;i<tam;i++){ 
            country[i] = namesCountry[(int)(Math.random() * 29)]; 
        }
            return country;
    }
    
    /**
     * Getter
     * @return - JButton Go
     */
    public JButton getBtnGo(){
        return btnGo;
    }
    
    /**
     * Getter
     * @return - int tam
     */
    public int getTam(){
        return tam;
    }
    
    /**
     * Getter
     * @return - JLabel lblNombres
     */
    public JLabel[] getLblNombres(){
        return lblNombres;
    }
    
    /**
     * Getter
     * @return - JProgressBar bar
     */
    public JProgressBar[] getBar(){
        return bar;
    }
    
    /**
     * Getter
     * @return - Color ColorPorDefecto
     */
    public Color getColorPorDefecto(){
        return ColorPorDefecto;
    }
    
    /**
     * Getter
     * @return - JLabel lblFinalistas
     */
    public JLabel[] getLblFinalistas(){
        return lblFinalistas;
    }
    
    /**
     * Main
     * @param args 
     */
    public static void main(String [] args){
        new RunnerBar().setVisible(true);
    }

}