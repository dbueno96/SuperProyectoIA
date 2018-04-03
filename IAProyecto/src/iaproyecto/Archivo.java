/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iaproyecto;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author invitado
 */
public class Archivo {
    
    public String leerArchivo(String archivo) throws FileNotFoundException, IOException
    {
        String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        String camino = "";
        while((cadena = b.readLine())!=null) {
          camino = camino + cadena;

       }
        b.close();
        return camino;
    }
    
    
    public BufferedReader getBuffered(String link){

    FileReader lector  = null;
    BufferedReader br = null;
    try {
         File Arch=new File(link);
        if(!Arch.exists()){
           System.out.println("No existe el archivo");
        }else{
           lector = new FileReader(link);
           br = new BufferedReader(lector);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return br;
}
    
    public int [][]  readText()
    {
        try
        {
            //ruta de tu archivo
            String ruta = "resources/Prueba1.txt";
            BufferedReader br = getBuffered(ruta);
            //leemos la primera linea
            String linea =  br.readLine();
            //creamos la matriz vacia
            int[][] matriz = new int[10][10];
            //contador
            int contador = 0;
            while(linea != null)
            {
                String[] values = linea.split(" ");
                
                //recorremos el arrar de string
                for (int i = 0; i<values.length; i++) {
                    //se obtiene el primer caracter de el arreglo de strings
                    matriz[contador][i] = Character.getNumericValue(values[i].charAt(0)) ;
                    
                }
                contador++;
                linea = br.readLine();
                
                
            }
            
            for(int i= 0 ; i <10; i++)
            {
                for(int j=0; j<10; j++ ) 
                {
                    System.out.print(matriz[i][j] + " ");
                }
                System.out.println();
            }
            return matriz;
        }
        catch (IOException | NumberFormatException e) {
        e.printStackTrace();
    }
        return null;
        
    
    }
    
    
}
