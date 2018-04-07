/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iaproyecto;

import iaproyecto.GUI.Gui;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import spia.util.FileManager;
import spia.controller.SearchController;
import spia.algorithm.*; 

/**
 *
 * @author invitado
 */
public class IAProyecto {
    

    public static void main(String[] args) throws IOException {
        
        /*Archivo a = new Archivo();
        
        String ruta = a.leerArchivo("/home/daniel/Desktop/Prueba1.txt");
        String[] parts = ruta.split(" ");
     
        int[][] arrayCamino = new int[10][10];
        arrayCamino = a.readText();
        
        Algoritmos algo = new Algoritmos();
        //Nodo nodo = new Nodo();
        boolean respuesta = algo.busquedaAmplitud(arrayCamino);
        System.out.println(respuesta);
        */
        
        FileManager fm = new FileManager("/home/daniel/Downloads/SuperProyectoIA-SPIA-CostoUnif.A.Avara.Ampl.Profu/IAProyecto/Prueba1.txt"); 
        fm.readFile();
        
        Archivo a = new Archivo(); 
        int [][] mapa = new int[10][10]; 
        mapa = a.readText(); 
        
        SearchController sc = SearchController.getInstance() ; 
        
        try {
           /* System.out.println("Amplitud");
             
            Result result  = sc.search(mapa, "Amplitud");
            System.out.println("Created Nodes " + result.getCreatedNodes()); 
            System.out.println("Expanded Nodes " + result.getExpandedNodes() ); */
          /*
            
            TreeNode[] nodosCamino = result.getTree().getPathToRoot((TreeNode) result.getTree().getRoot());
            int [] pos = new int[2] ; 
            pos[0] = ((Node) ((DefaultMutableTreeNode) nodosCamino[0].getParent()).getUserObject()).getCoordinate()[0];
            System.out.println("pos0: " +pos[0]);
           
            int [] pos = new int[2] ; 
            pos= (Node) nodosCamino[0].getCoordinate();
            
            ((Node) ((DefaultMutableTreeNode) node.getParent()).getUserObject()).getCoordinate();
            ((Node ((DefaultMutableTreeNode) ((DefaultTreeModel) result.getTree()).get )))
         */ 
          /*System.out.println("Profundidad");
            result  = sc.search(mapa, "Profundidad");
            System.out.println("Created Nodes " + result.getCreatedNodes()); 
            System.out.println("Expanded Nodes " + result.getExpandedNodes() );
            
            System.out.println("Avara");
            result  = sc.search(mapa, "Avara");
            System.out.println("Created Nodes " + result.getCreatedNodes()); 
            System.out.println("Expanded Nodes " + result.getExpandedNodes() );
            
            System.out.println("a Asterisco");
            result = sc.search(mapa, "AAsterik");
             System.out.println("Created Nodes " + result.getCreatedNodes()); 
            System.out.println("Expanded Nodes " + result.getExpandedNodes() );
            
            System.out.println("Costo Uniforme");
            result = sc.search(mapa, "UniformCostAlgorithm");
            System.out.println("Created Nodes " + result.getCreatedNodes()); 
            System.out.println("Expanded Nodes " + result.getExpandedNodes() );
            */
            Gui ejecución = new Gui(mapa);
            
            
            
        } catch (Exception ex) {
            Logger.getLogger(IAProyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
      
     }
   
}