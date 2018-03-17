/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iaproyecto;

import java.io.IOException;



/**
 *
 * @author invitado
 */
public class IAProyecto {
    

    public static void main(String[] args) throws IOException {
        
        Archivo a = new Archivo();
        
        String ruta = a.leerArchivo("/home/daniel/Desktop/hola.txt");
        String[] parts = ruta.split(" ");
       /* for(int i = 0 ; i < parts.length; i++ ) 
        {
            System.out.println(parts[i]);
        }*/
     //   System.out.println(parts);
     
        int[][] arrayCamino = new int[10][10];
        int j=0;
        
        arrayCamino = a.readText(); 
        
        
        /*
        for(int i=0;i<10;i++){
            
            if ((i==10) && (i==90) && (i==20) && (i==30) && (i==40) && (i==50) && (i==60) && (i==70) && (i==80)){
                j=j++;
                i= 0;
                arrayCamino[i][j] = Integer.parseInt(parts[i]);
                System.out.println(i);
            }
            else 
               // System.out.println(i);
                arrayCamino[i][j] = Integer.parseInt(parts[i]);
                
        }
        for (int i = 0 ; i < arrayCamino[0].length  ; i++ )
        {
            for(int t = 0 ; t < arrayCamino[0].length; t++)
            {
                System.out.println(arrayCamino[i][t]);
                
            }
            System.out.println("\n");
        }
        System.out.println(arrayCamino);
        
      */  
      
     }
   
}