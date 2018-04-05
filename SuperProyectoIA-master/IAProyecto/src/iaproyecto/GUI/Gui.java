/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iaproyecto.GUI;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
/**
 *
 * @author Nathalia
 */
public class Gui implements ActionListener {
    private static final int COLUMNAS = 10;
    private static final int FILAS = 10;
    JFrame v = new JFrame();
    JButton opciónInformada = new JButton();
    JButton opciónnoInformada = new JButton();
    JPanel panelGame = new JPanel();
    JPanel panelOptions = new JPanel();
    JButton opciónAvara = new JButton();
    JButton opciónAasterisco = new JButton();
    JButton opciónCosto = new JButton();
    JButton opciónAmplitud = new JButton();
    JButton opciónProfundidad = new JButton();
    JButton reset = new JButton();
    int resetReference = 0;
    
    public Gui(int[][] matriz){

       panelOptions.setBackground(Color.white);
       v.add(panelGame);
       v.add(panelOptions);
       v.getContentPane().setLayout(null);
       panelGame.setBounds(0, 0, 1000, 1000);
       panelGame.setForeground(Color.red);
       panelOptions.setBounds(1000, 0, 400, 1400);
       panelOptions.setForeground(Color.white);

       
       panelOptions.setLayout(null);
       JLabel prueba3 = new JLabel("", SwingConstants.CENTER);
       prueba3.setIcon(new ImageIcon("/Users/Nathalia/Desktop/marioletrero2.gif"));
       prueba3.setBounds(30,0,300,300);
       
       JLabel prueba4 = new JLabel("", SwingConstants.CENTER);
       prueba4.setIcon(new ImageIcon("/Users/Nathalia/Desktop/titu.png"));
       prueba4.setBounds(30,300,300,111);
       

       opciónInformada.setIcon(new ImageIcon("/Users/Nathalia/Desktop/busquedainformada.png"));
       opciónInformada.setBounds(80,500,218,72);
       
       opciónnoInformada.setIcon(new ImageIcon("/Users/Nathalia/Desktop/busquedanoinformada.png"));
       opciónnoInformada.setBounds(80,600,218,72);
       
       panelOptions.add(prueba3);
       panelOptions.add(prueba4);
       panelOptions.add(opciónInformada);
       opciónInformada.addActionListener(this);
       panelOptions.add(opciónnoInformada);
       opciónnoInformada.addActionListener(this);
       
        opciónAmplitud.setBounds(120,450,132,40);
        opciónAmplitud.setIcon(new ImageIcon("/Users/Nathalia/Desktop/amplitud.png"));
        panelOptions.add(opciónAmplitud);
        opciónAmplitud.setVisible(false);
        opciónCosto.setBounds(65,520,250,40);
        opciónCosto.setIcon(new ImageIcon("/Users/Nathalia/Desktop/costo.png"));
        panelOptions.add(opciónCosto);
        opciónCosto.setVisible(false);
        opciónProfundidad.setBounds(20,590,340,60);
        opciónProfundidad.setIcon(new ImageIcon("/Users/Nathalia/Desktop/profundidad.png"));
        panelOptions.add(opciónProfundidad);
        opciónProfundidad.setVisible(false);
       
        opciónAvara.setBounds(130,450,110,38);
        opciónAvara.setIcon(new ImageIcon("/Users/Nathalia/Desktop/avara.png"));
        panelOptions.add(opciónAvara);
        opciónAasterisco.setBounds(130,520,110,38);
        opciónAasterisco.setIcon(new ImageIcon("/Users/Nathalia/Desktop/Aasterisco.png"));
        panelOptions.add(opciónAasterisco);
        opciónAvara.setVisible(false);
        opciónAasterisco.setVisible(false);
        
        reset.setBounds(100,700,178,52);
        reset.setIcon(new ImageIcon("/Users/Nathalia/Desktop/reset.png"));
        panelOptions.add(reset);
        reset.setVisible(false);
       
       
      panelGame.setLayout(new GridLayout(FILAS,COLUMNAS));
		
      JLabel [][] matrizLabel = new JLabel [FILAS][COLUMNAS];
      int prueba = 10;
      int prueba2 = 10;
      for (int i=0;i<FILAS;i++)
         for (int j=0;j<COLUMNAS;j++)
         {
            matrizLabel[i][j] = new JLabel("", SwingConstants.CENTER);
            
            matrizLabel[i][j].setBounds(prueba+10, prueba2+10, 300, 300);
         //   v.getContentPane().setForeground(Color.white);
            panelGame.add(matrizLabel[i][j]);
         }
      
        valoresAsociadosImagenes(matriz,matrizLabel);
        matrizLabel[2][5].setForeground(Color.red);

      
      v.pack();
      v.setVisible(true);
      v.setSize(1400,1070);
      v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    public void valoresAsociadosImagenes(int[][] matrix,JLabel [][] matrizLab){
        
              for(int i= 0 ; i <10; i++){
                for(int j=0; j<10; j++ ){
                    switch (matrix[i][j]) {
                        case 0:
                            matrizLab[i][j].setIcon(new ImageIcon("/Users/Nathalia/Desktop/espacio.jpg"));
                            break;
                        case 1:
                            matrizLab[i][j].setIcon(new ImageIcon("/Users/Nathalia/Desktop/muro.jpg"));
                            break;
                        case 2:
                            matrizLab[i][j].setIcon(new ImageIcon("/Users/Nathalia/Desktop/mario.gif"));
                            break;
                        case 3:
                            matrizLab[i][j].setIcon(new ImageIcon("/Users/Nathalia/Desktop/flor.jpg"));
                            break;
                        case 4:
                            matrizLab[i][j].setIcon(new ImageIcon("/Users/Nathalia/Desktop/tortuga.png"));
                            break;
                        case 5:
                            matrizLab[i][j].setIcon(new ImageIcon("/Users/Nathalia/Desktop/princesa.jpg"));
                            break;
                        default:
                            break;
                    }
                    
                }
            }
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==opciónInformada) { 
            botonesInformada();
        }
        if (e.getSource()==opciónnoInformada) { 
            botonesnoInformada();
        }
        if (e.getSource()==reset) { 
            reset();
        }        
    }
    
    public void botonesInformada(){

        opciónInformada.setVisible(false);
        opciónnoInformada.setVisible(false);
        opciónAvara.setVisible(true);
        opciónAasterisco.setVisible(true);
        resetReference=1;
        reset.setVisible(true);
        reset.addActionListener(this);
    }
    
    public void reset(){
        if(resetReference==1){
            opciónAvara.setVisible(false);
            opciónAasterisco.setVisible(false);
            opciónInformada.setVisible(true);
            opciónnoInformada.setVisible(true);
            reset.setVisible(false);
        }
        if(resetReference==2){
            opciónAmplitud.setVisible(false);
            opciónCosto.setVisible(false);            
            opciónProfundidad.setVisible(false);
            opciónInformada.setVisible(true);
            opciónnoInformada.setVisible(true);
            reset.setVisible(false);            
        }
    }
    
    public void botonesnoInformada(){
        opciónInformada.setVisible(false);
        opciónnoInformada.setVisible(false);
        opciónAmplitud.setVisible(true);
        opciónCosto.setVisible(true);
        opciónProfundidad.setVisible(true);
        reset.setVisible(true);
        resetReference=2;
    }
    
    public void moveteMario(int x, int y){
       // intPasoAnterior=
        
    }
 
}
