/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iaproyecto.GUI;
import iaproyecto.Hilo;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
    JLabel [][] matrizLabel = new JLabel [FILAS][COLUMNAS];
    int[][] matrizNumeros = new int[10][10];
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
       matrizNumeros = matriz;
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
       prueba3.setIcon(new ImageIcon(getClass().getResource("/iaproyecto/imagenes/marioletrero2.gif")));
       prueba3.setBounds(30,0,300,300);
       
       JLabel prueba4 = new JLabel("", SwingConstants.CENTER);
       prueba4.setIcon(new ImageIcon(getClass().getResource("/iaproyecto/imagenes/titu.png")));
       prueba4.setBounds(30,300,300,111);
       

       opciónInformada.setIcon(new ImageIcon(getClass().getResource("/iaproyecto/imagenes/busquedainformada.png")));
       opciónInformada.setBounds(80,500,218,72);
       
       opciónnoInformada.setIcon(new ImageIcon(getClass().getResource("/iaproyecto/imagenes/busquedanoinformada.png")));
       opciónnoInformada.setBounds(80,600,218,72);
       
       panelOptions.add(prueba3);
       panelOptions.add(prueba4);
       panelOptions.add(opciónInformada);
       opciónInformada.addActionListener(this);
       panelOptions.add(opciónnoInformada);
       opciónnoInformada.addActionListener(this);
       
        opciónAmplitud.setBounds(120,450,132,40);
        opciónAmplitud.setIcon(new ImageIcon(getClass().getResource("/iaproyecto/imagenes/amplitud.png")));
        panelOptions.add(opciónAmplitud);
        opciónAmplitud.setVisible(false);
        opciónCosto.setBounds(65,520,250,40);
        opciónCosto.setIcon(new ImageIcon(getClass().getResource("/iaproyecto/imagenes/costo.png")));
        panelOptions.add(opciónCosto);
        opciónCosto.setVisible(false);
        opciónProfundidad.setBounds(20,590,340,60);
        opciónProfundidad.setIcon(new ImageIcon(getClass().getResource("/iaproyecto/imagenes/profundidad.png")));
        panelOptions.add(opciónProfundidad);
        opciónProfundidad.setVisible(false);
       
        opciónAvara.setBounds(130,450,110,38);
        opciónAvara.setIcon(new ImageIcon(getClass().getResource("/iaproyecto/imagenes/avara.png")));
        panelOptions.add(opciónAvara);
        opciónAasterisco.setBounds(130,520,110,38);
        opciónAasterisco.setIcon(new ImageIcon(getClass().getResource("/iaproyecto/imagenes/Aasterisco.png")));
        panelOptions.add(opciónAasterisco);
        opciónAvara.setVisible(false);
        opciónAasterisco.setVisible(false);
        
        reset.setBounds(100,700,178,52);
        reset.setIcon(new ImageIcon(getClass().getResource("/iaproyecto/imagenes/reset.png")));
        panelOptions.add(reset);
        reset.setVisible(false);
       
       
      panelGame.setLayout(new GridLayout(FILAS,COLUMNAS));
		
      
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
      
        valoresAsociadosImagenes(matrizNumeros,matrizLabel);
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
                            matrizLab[i][j].setIcon(new ImageIcon(getClass().getResource("/iaproyecto/imagenes/espacio.jpg")));
                            break;
                        case 1:
                            matrizLab[i][j].setIcon(new ImageIcon(getClass().getResource("/iaproyecto/imagenes/muro.jpg")));
                            break;
                        case 2:
                            matrizLab[i][j].setIcon(new ImageIcon(getClass().getResource("/iaproyecto/imagenes/mario.gif")));
                            break;
                        case 3:
                            matrizLab[i][j].setIcon(new ImageIcon(getClass().getResource("/iaproyecto/imagenes/flor.jpg")));
                            break;
                        case 4:
                            matrizLab[i][j].setIcon(new ImageIcon(getClass().getResource("/iaproyecto/imagenes/tortuga.png")));
                            break;
                        case 5:
                            matrizLab[i][j].setIcon(new ImageIcon(getClass().getResource("/iaproyecto/imagenes/princesa.jpg")));
                            break;
                        default:
                            break;
                    }
                    
                }
            }
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==opciónInformada) { 
            try {
                botonesInformada();
            } catch (InterruptedException ex) {
                Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource()==opciónnoInformada) { 
            botonesnoInformada();
        }
        if (e.getSource()==reset) { 
            reset();
        }        
    }
    
    public void botonesInformada() throws InterruptedException{

        opciónInformada.setVisible(false);
        opciónnoInformada.setVisible(false);
        opciónAvara.setVisible(true);
        opciónAasterisco.setVisible(true);
        resetReference=1;
        reset.setVisible(true);
        reset.addActionListener(this);
        ejecuta(matrizLabel, matrizNumeros);
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
    
    public ArrayList<int[]> listaPrueba(){
        ArrayList<int[]> camino = new  ArrayList<>();
        int[] prueba3 = {0,3};
        int[] prueba = {0,4};
        int[] prueba2 = {0,5};
        int[] prueba4 = {1,5};
        int[] prueba5 = {2,5};
        int[] prueba6 = {3,5};
        camino.add(prueba3);
        camino.add(prueba);
        camino.add(prueba2);
        camino.add(prueba4);
        camino.add(prueba5);
        camino.add(prueba6);
        
        
        return camino;
}
    
    public void ejecuta(JLabel[][] matrizLab, int[][] matriz){
     ArrayList<int[]> camino = listaPrueba();
     moveteMario(camino,matrizLab, matriz);
    }
    
    
    public void moveteMario(ArrayList<int[]> caminoMario, JLabel[][] matrizLab, int [][] matriz) {
        
        int[] inicia = caminoMario.get(0);
 
        matrizLab[inicia[0]][inicia[1]].setIcon(new ImageIcon(getClass().getResource("/iaproyecto/imagenes/espacio.jpg")));
        int guardar=-1;
        int[] antes = new int[2];
        int[] marioAhora= new int[2];
        
        
        for(int i=1;i<caminoMario.size();i++){
            
            antes=caminoMario.get(i-1);
            if(guardar==0){
               matrizLab[antes[0]][antes[1]].setIcon(new ImageIcon(getClass().getResource("/iaproyecto/imagenes/espacio.jpg")));
               //System.out.println(prueba2[0]+ " "  + prueba2[1]);
               
            }

            else if(guardar==1){
               matrizLab[antes[0]][antes[1]].setIcon(new ImageIcon(getClass().getResource("/iaproyecto/imagenes/muro.jpg")));
            }
            
            else if(guardar==3){
               matrizLab[antes[0]][antes[1]].setIcon(new ImageIcon(getClass().getResource("/iaproyecto/imagenes/flor.jpg"))); 
            }
            marioAhora = caminoMario.get(i);
            matrizLab[marioAhora[0]][marioAhora[1]].setIcon(new ImageIcon(getClass().getResource("/iaproyecto/imagenes/mariocorredor.gif")));
            System.out.println(marioAhora[0]+ " "  + marioAhora[1]);
            JOptionPane.showMessageDialog(panelOptions, "Move");
            guardar = matriz[marioAhora[0]][marioAhora[1]];
        }
        matrizLab[marioAhora[0]][marioAhora[1]].setIcon(new ImageIcon(getClass().getResource("/iaproyecto/imagenes/marioPrincessKiss.gif")));
        
    }
    
    
 
}
