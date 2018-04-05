/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iaproyecto;

import iaproyecto.GUI.Gui;
import java.io.IOException;



/**
 *
 * @author invitado
 */
public class IAProyecto {
    

    public static void main(String[] args) throws IOException {
        
        Archivo a = new Archivo();
        
        String ruta = a.leerArchivo("/Usuario/Desktop/Prueba1.txt");
        String[] parts = ruta.split(" ");
     
        int[][] arrayCamino = new int[10][10];
        arrayCamino = a.readText();
        Gui ejecución = new Gui(arrayCamino);
      
     }
   
}