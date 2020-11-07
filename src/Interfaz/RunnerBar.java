/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

/**
 *
 * @author jesus
 */
public class RunnerBar extends JFrame implements ActionListener{
    private static final long serialVersionUID = 1L;
    private JPanel RunnerPanel, nombres,finalistasPanel;
    private static int tam=10;
    private JButton go;
    private JLabel titulo,finalistasTitulo;
    private static JLabel [] names;
    private static JLabel [] finalistas;
    private static JProgressBar [] bar;
    private Color ColorPorDefecto;
    //——————————————————————————-Constructor
    public void launchWindows(){
        setLayout(null);
        finalistasTitulo=new JLabel("Finalistas!");
        titulo=new JLabel("CARRERA DE LAS OLIMPIADAS");
        go=new JButton("GO!");
        bar = new JProgressBar[tam];
        names= new JLabel[tam];
        finalistas= new JLabel[tam];
        //Font s = titulo.getFont();
        titulo.setFont(new Font("Comic Sans MS",Font.BOLD,20));

        //C,F,ESPACIOHORIZONTAL,ESPACIOVERTICAL
        RunnerPanel=new JPanel(new GridLayout(tam,1,1,11));
        nombres=new JPanel(new GridLayout(tam,1,1,11));
        finalistasPanel= new JPanel(new GridLayout(tam,1,1,1));

        go.addActionListener(this);

        for(int i=0;i<tam;i++){
            bar[i] = new JProgressBar();
            RunnerPanel.add(bar[i]);
            names[i] = new JLabel("…");
            nombres.add(names[i]);
            finalistas[i] = new JLabel("");
            finalistasPanel.add(finalistas[i]);
        }

        titulo.setBounds(325, 25, 500, 30);
        finalistasTitulo.setBounds(750, 100, 70, 20);
        go.setBounds(75, 100, 70, 20);
        nombres.setBounds(75, 130, 90, 300);
        RunnerPanel.setBounds(200, 130, 500, 300);
        finalistasPanel.setBounds(750, 130, 200, 250);
        add(titulo);
        add(finalistasTitulo);
        add(nombres);
        add(RunnerPanel);
        add(finalistasPanel);
        add(go);

        ColorPorDefecto=bar[0].getForeground();

        setTitle("Enviador");
        setSize(1000,519);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //——————————————————————————Aciones de boton
    public void actionPerformed(ActionEvent e) {
        go.setEnabled(false);
        for(int i=0;i<tam;i++){
            finalistas[i].setText("");
            bar[i].setStringPainted(true);
            bar[i].setForeground(ColorPorDefecto);
            bar[i].setString("");
        }

        String [] country = new String[tam];
        country=seleccionador();

        for(int i=0;i<tam;i++){ names[i].setText(country[i]); }

            //HilosColorXpais [] hilos = new HilosColorXpais[tam];
            Hilos [] hilos = new Hilos[tam];

            //for(int i=0;i<tam;i++){ hilos[i]= new HilosColorXpais(bar[i],country[i]); }
            for(int i=0;i<tam;i++){ hilos[i]= new Hilos(bar[i],country[i],i); }
            for(int i=0;i<tam;i++){ hilos[i].start(); }

            tablaFinal fin = new tablaFinal(finalistas,hilos,tam,go);
            fin.start();
    }
    //——————————————————————————————Metodo
    private String[] seleccionador(){
        String namesCountry[] = {"Argentina","Panama","Brasil","United States","Mexico","United Kingdom",
            "Canada","Venezuela","Alemania","China","Jamaica","Somalia","Barbados","Kenia","Etiopia","Sudafrica",
            "Australia","Japon","Uganda","Francia","Tanzania","Letonia","Honduras","Haiti","Portugal","Israel",
            "Egipto","Russia","Tri.Tobago","Noruega"};
        String [] country = new String[tam];

        for(int i=0;i<tam;i++){ country[i]=namesCountry[ ((int) (Math.random()*(0-29)+29)) ]; }
            return country;
    }
    //=================================================================MAIN============================
    public static void main(String [] args){
        RunnerBar o = new RunnerBar(); o.launchWindows();
    }

}//FIN CLASE