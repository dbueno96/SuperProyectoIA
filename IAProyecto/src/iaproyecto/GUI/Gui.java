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
import spia.algorithm.Result;
import spia.controller.SearchController;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import spia.algorithm.Node;

/**
 *
 * @author Nathalia
 */
public class Gui implements ActionListener {

    private static final int COLUMNAS = 10;
    private static final int FILAS = 10;
    JLabel[][] matrizLabel = new JLabel[FILAS][COLUMNAS];
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
    int tiempo = 0;
    int nodosExpandidos = 0;
    int profundidadArbol = 0;
    JLabel tiempoLabel = new JLabel("tiempo: " + tiempo, SwingConstants.CENTER);

    public Gui(int[][] matriz) {
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
        prueba3.setBounds(30, 0, 300, 300);

        JLabel prueba4 = new JLabel("", SwingConstants.CENTER);
        prueba4.setIcon(new ImageIcon(getClass().getResource("/iaproyecto/imagenes/titu.png")));
        prueba4.setBounds(30, 300, 300, 111);

        opciónInformada.setIcon(new ImageIcon(getClass().getResource("/iaproyecto/imagenes/busquedainformada.png")));
        opciónInformada.setBounds(80, 500, 218, 72);

        opciónnoInformada.setIcon(new ImageIcon(getClass().getResource("/iaproyecto/imagenes/busquedanoinformada.png")));
        opciónnoInformada.setBounds(80, 600, 218, 72);

        panelOptions.add(prueba3);
        panelOptions.add(prueba4);
        panelOptions.add(opciónInformada);
        opciónInformada.addActionListener(this);
        panelOptions.add(opciónnoInformada);
        opciónnoInformada.addActionListener(this);

        opciónAmplitud.setBounds(120, 450, 132, 40);
        opciónAmplitud.setIcon(new ImageIcon(getClass().getResource("/iaproyecto/imagenes/amplitud.png")));
        panelOptions.add(opciónAmplitud);
        opciónAmplitud.setVisible(false);
        opciónAmplitud.addActionListener(this);
        opciónCosto.setBounds(65, 520, 250, 40);
        opciónCosto.setIcon(new ImageIcon(getClass().getResource("/iaproyecto/imagenes/costo.png")));
        panelOptions.add(opciónCosto);
        opciónCosto.setVisible(false);
        opciónCosto.addActionListener(this);
        opciónProfundidad.setBounds(20, 590, 340, 60);
        opciónProfundidad.setIcon(new ImageIcon(getClass().getResource("/iaproyecto/imagenes/profundidad.png")));
        opciónProfundidad.addActionListener(this);
        panelOptions.add(opciónProfundidad);
        opciónProfundidad.setVisible(false);

        opciónAvara.setBounds(130, 450, 110, 38);
        opciónAvara.setIcon(new ImageIcon(getClass().getResource("/iaproyecto/imagenes/avara.png")));
        panelOptions.add(opciónAvara);
        opciónAvara.addActionListener(this);
        opciónAasterisco.setBounds(130, 520, 110, 38);
        opciónAasterisco.setIcon(new ImageIcon(getClass().getResource("/iaproyecto/imagenes/Aasterisco.png")));
        opciónAasterisco.addActionListener(this);
        panelOptions.add(opciónAasterisco);
        opciónAvara.setVisible(false);
        opciónAasterisco.setVisible(false);

        reset.setBounds(100, 700, 178, 52);
        reset.setIcon(new ImageIcon(getClass().getResource("/iaproyecto/imagenes/reset.png")));
        panelOptions.add(reset);
        reset.setVisible(false);

        tiempoLabel.setBounds(100, 900, 178, 52);
        //tiempoLabel.setIcon(new ImageIcon(getClass().getResource("/iaproyecto/imagenes/muro.jpg")));
        panelOptions.add(tiempoLabel);
        tiempoLabel.setVisible(false);

        panelGame.setLayout(new GridLayout(FILAS, COLUMNAS));

        int prueba = 10;
        int prueba2 = 10;
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                matrizLabel[i][j] = new JLabel("", SwingConstants.CENTER);

                matrizLabel[i][j].setBounds(prueba + 10, prueba2 + 10, 300, 300);
                //   v.getContentPane().setForeground(Color.white);
                panelGame.add(matrizLabel[i][j]);
            }
        }

        valoresAsociadosImagenes(matrizNumeros, matrizLabel);
        matrizLabel[2][5].setForeground(Color.red);

        v.pack();
        v.setVisible(true);
        v.setSize(1400, 1070);
        v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void valoresAsociadosImagenes(int[][] matrix, JLabel[][] matrizLab) {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
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
        if (e.getSource() == opciónInformada) {
            try {
                botonesInformada();
            } catch (InterruptedException ex) {
                Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == opciónnoInformada) {
            botonesnoInformada();
        }
        if (e.getSource() == reset) {
            reset();
        }
        if (e.getSource() == opciónAvara) {
            opciónAasterisco.setVisible(false);
            try {
                ejecutaAlgoritmo(3);
            } catch (Exception ex) {
                Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (e.getSource() == opciónAmplitud) {
            try {
                ejecutaAlgoritmo(0);
            } catch (Exception ex) {
                Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (e.getSource() == opciónAasterisco) {
            try {
                ejecutaAlgoritmo(1);
            } catch (Exception ex) {
                Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (e.getSource() == opciónCosto) {
            try {
                ejecutaAlgoritmo(4);
            } catch (Exception ex) {
                Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (e.getSource() == opciónProfundidad) {
            try {
                ejecutaAlgoritmo(2);
            } catch (Exception ex) {
                Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public void botonesInformada() throws InterruptedException {

        opciónInformada.setVisible(false);
        opciónnoInformada.setVisible(false);
        opciónAvara.setVisible(true);
        opciónAasterisco.setVisible(true);
        resetReference = 1;
        reset.setVisible(true);
        reset.addActionListener(this);
    }

    public void reset() {
        if (resetReference == 1) {
            opciónAvara.setVisible(false);
            opciónAasterisco.setVisible(false);
            opciónInformada.setVisible(true);
            opciónnoInformada.setVisible(true);
            reset.setVisible(false);
        }
        if (resetReference == 2) {
            opciónAmplitud.setVisible(false);
            opciónCosto.setVisible(false);
            opciónProfundidad.setVisible(false);
            opciónInformada.setVisible(true);
            opciónnoInformada.setVisible(true);
            reset.setVisible(false);
        }
    }

    public void botonesnoInformada() {
        opciónInformada.setVisible(false);
        opciónnoInformada.setVisible(false);
        opciónAmplitud.setVisible(true);
        opciónCosto.setVisible(true);
        opciónProfundidad.setVisible(true);
        reset.setVisible(true);
        resetReference = 2;
    }

    public void ejecutaAlgoritmo(int n) throws Exception {

        SearchController controlador = SearchController.getInstance();

        Result result = null;
        long tiempoInicio = 0;
        long tiempoFinal = 0;  
        switch (n) {
            case 0:
                tiempoInicio = System.nanoTime(); 
                
                result = controlador.search(matrizNumeros, "Amplitud");
               
                tiempoFinal = System.nanoTime() ;
                System.out.println(tiempoFinal); 
                
                String pendejada = String.valueOf( (tiempoFinal - tiempoInicio) / 10000);
                System.out.println(pendejada);
                tiempoLabel.setText(pendejada +  "x 10^-4 ns");
                tiempoLabel.setVisible(true);
                
            case 1:
                result = controlador.search(matrizNumeros, "AAsterik");
                tiempoLabel.setText("Expandidos: " + result.getExpandedNodes() );
                tiempoLabel.setVisible(true);
                break;
            case 2:
                result = controlador.search(matrizNumeros, "Profundidad");
                tiempoLabel.setText("Depth: " + result.getDepth());
                tiempoLabel.setVisible(true);
                break;
            case 3:
                result = controlador.search(matrizNumeros, "Avara");
                break;
            case 4:
                result = controlador.search(matrizNumeros, "UniformCostAlgorithm");
                break;
            default:
                break;
        }

         
        
        tiempoLabel.setVisible(true);
        ejecuta(matrizLabel, matrizNumeros, result.getPath());

    }

    public void ejecuta(JLabel[][] matrizLab, int[][] matriz, ArrayList<int[]> camin) {
        ArrayList<int[]> camino = camin;
        Runnable runnable = () -> {
            try {
                moveteMario(camino, matrizLab, matriz);
            } catch (InterruptedException ex) {
                Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
            }
        };

        Thread moveThread = new Thread(runnable);
        moveThread.start();
        //moveteMario(camino,matrizLab, matriz);
    }

    public void moveteMario(ArrayList<int[]> caminoMario, JLabel[][] matrizLab, int[][] matriz) throws InterruptedException {

        int[] inicia = caminoMario.get(0);

        matrizLab[inicia[0]][inicia[1]].setIcon(new ImageIcon(getClass().getResource("/iaproyecto/imagenes/espacio.jpg")));
        int guardar = -1;
        int[] antes = new int[2];
        int[] marioAhora = new int[2];

        for (int i = 1; i < caminoMario.size(); i++) {

            antes = caminoMario.get(i - 1);
            if (guardar == 0 || guardar ==2 ) {
                matrizLab[antes[0]][antes[1]].setIcon(new ImageIcon(getClass().getResource("/iaproyecto/imagenes/espacio.jpg")));
                //System.out.println(prueba2[0]+ " "  + prueba2[1]);

            } else if (guardar == 1) {
                matrizLab[antes[0]][antes[1]].setIcon(new ImageIcon(getClass().getResource("/iaproyecto/imagenes/muro.jpg")));
            } else if (guardar == 3) {
                matrizLab[antes[0]][antes[1]].setIcon(new ImageIcon(getClass().getResource("/iaproyecto/imagenes/flor.jpg")));
            } else if (guardar == 4) {
                matrizLab[antes[0]][antes[1]].setIcon(new ImageIcon(getClass().getResource("/iaproyecto/imagenes/tortuga.png")));
            }
            marioAhora = caminoMario.get(i);
            matrizLab[marioAhora[0]][marioAhora[1]].setIcon(new ImageIcon(getClass().getResource("/iaproyecto/imagenes/mariocorredor.gif")));
            Thread.sleep(300);
           // System.out.println(marioAhora[0] + " " + marioAhora[1]);
            guardar = matriz[marioAhora[0]][marioAhora[1]];
        }
        
        if (marioAhora[0]==0 && marioAhora[1] == 8 ){
            System.out.println("por aqui paso mario");
        }
        
        matrizLab[marioAhora[0]][marioAhora[1]].setIcon(new ImageIcon(getClass().getResource("/iaproyecto/imagenes/marioPrincessKiss.gif")));

    }

}
