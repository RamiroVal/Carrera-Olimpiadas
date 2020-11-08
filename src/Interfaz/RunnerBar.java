package Interfaz;

import Eventos.EventosRunnerBar;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
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
    private static int tam;
    private JButton btnGo;
    private JLabel[] lblNombres;
    private JLabel[] lblFinalistas;
    private JProgressBar[] bar;
    
    /**
     * Constructor
     */
    public RunnerBar(){
        super("Carrera Olímpica");
        setLayout(null);
        setSize(1000,519);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(51, 51, 51));
        setIconImage(new ImageIcon(getClass().getResource("/iconos/juegos-olimpicos.png")).getImage());
        
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
        panelCarrera.setBackground(new Color(51, 51, 51));
        
        bar = new JProgressBar[tam];
        
        for(int i = 0; i < tam; i++){
            bar[i] = new JProgressBar();
            bar[i].setBackground(new Color(128, 128, 128));
            bar[i].setBorder(new LineBorder(new Color(100, 100, 100)));
            panelCarrera.add(bar[i]);
        }
        
        add(panelCarrera);
    }
    
    /**
     * Se encarga de crear el panel donde estan los nombres de los distintos países
     * de la competición
     */
    private void creaPanelNombres(){
        JPanel panelNombres = new JPanel(new GridLayout(tam,1,1,11));
        panelNombres.setBounds(75, 130, 90, 300);
        panelNombres.setBackground(new Color(51, 51, 51));
        
        lblNombres= new JLabel[tam];
        
        for(int i=0;i<tam;i++){
            lblNombres[i] = new JLabel("…");
            lblNombres[i].setForeground(Color.WHITE);
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
        panelFinalistas.setBackground(new Color(51, 51, 51));
        
        lblFinalistas = new JLabel[tam];
        
        
        for(int i=0;i<tam;i++){
            lblFinalistas[i] = new JLabel("");
            lblFinalistas[i].setForeground(Color.WHITE);
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
        lblFinalistasTitulo.setBounds(750, 100, 120, 20);
        lblTitulo.setBounds(325, 25, 500, 30);
        
        lblTitulo.setFont(new Font("Calibri", Font.BOLD, 30));
        lblTitulo.setForeground(Color.WHITE);
        lblFinalistasTitulo.setFont(new Font("Calibri", Font.BOLD, 17));
        lblFinalistasTitulo.setForeground(Color.WHITE);
        
        ImageIcon i = createImageIcon("/iconos/ejecutar.png");
        
        btnGo = new JButton("GO!",i);
        btnGo.setForeground(Color.WHITE);
        btnGo.setBounds(75, 70, 80, 40);
        btnGo.setOpaque(true);
        btnGo.setFocusPainted(false);
        btnGo.setBorder(new LineBorder(Color.BLACK));
        btnGo.setBackground(new Color(69, 69, 69));
        btnGo.addActionListener(new EventosRunnerBar(this));
        btnGo.addMouseListener(new EventosRunnerBar(this));
        
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
    
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = RunnerBar.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

}