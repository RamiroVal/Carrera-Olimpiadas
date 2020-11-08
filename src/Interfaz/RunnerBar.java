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

/**
 *
 * @author jesus
 */

public class RunnerBar extends JFrame {
    private static final long serialVersionUID = 1L;
    private static int tam;
    private JButton btnGo;
    private static JLabel [] lblNombres;
    private static JLabel [] lblFinalistas;
    private static JProgressBar [] bar;
    private Color ColorPorDefecto;
    
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

    public String[] seleccionador(){
        String namesCountry[] = {"Argentina","Panama","Brasil","United States","Mexico","United Kingdom",
            "Canada","Venezuela","Alemania","China","Jamaica","Somalia","Barbados","Kenia","Etiopia","Sudafrica",
            "Australia","Japon","Uganda","Francia","Tanzania","Letonia","Honduras","Haiti","Portugal","Israel",
            "Egipto","Russia","Tri.Tobago","Noruega"};
        String [] country = new String[tam];

        for(int i=0;i<tam;i++){ country[i]=namesCountry[ ((int) (Math.random()*(0-29)+29)) ]; }
            return country;
    }
    
    public JButton getBtnGo(){
        return btnGo;
    }
    
    public int getTam(){
        return tam;
    }
    
    public JLabel[] getLblNombres(){
        return lblNombres;
    }
    
    public JProgressBar[] getBar(){
        return bar;
    }
    
    public Color getColorPorDefecto(){
        return ColorPorDefecto;
    }
    
    public JLabel[] getLblFinalistas(){
        return lblFinalistas;
    }
    

    public static void main(String [] args){
        new RunnerBar().setVisible(true);
    }

}