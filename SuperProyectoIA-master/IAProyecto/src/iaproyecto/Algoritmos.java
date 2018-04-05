/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iaproyecto;

import java.util.*;
import java.util.LinkedList;

/**
 *
 * @author Nathalia
 */
public class Algoritmos {
    
    public int[] eresMeta(int[][] matriz){
        int[] meta = new int[2];
        
        for(int i= 0 ; i <10; i++){
                for(int j=0; j<10; j++ ){
                    if(matriz[i][j]==5){
                    meta[0]=j;
                    meta[1]=i;
                    }  
                }
            }
        return meta;
    }
    
    public boolean busquedaAmplitud(int[][] matrizResolver){
        boolean encontroMeta = false;
        LinkedList cola = new LinkedList();
        Nodo nodoRaiz = new Nodo();
        nodoRaiz.Nodo(null, matrizResolver, "", 0, 0, 0, nodoRaiz.dondeEstasMario(matrizResolver)[1],nodoRaiz.dondeEstasMario(matrizResolver)[0]);
        cola.offer(nodoRaiz);
        Vector guardaSolucion=new Vector();
        int contadorProfundidad=0;
        
        if(nodoRaiz.dondeEstasMario(matrizResolver)==eresMeta(matrizResolver)){
        guardaSolucion.addElement(nodoRaiz);
        encontroMeta=true;

        }
        else {
            while(encontroMeta==false){
                Nodo nodo = new Nodo(); 
                nodo = (Nodo) cola.poll();
                System.out.println("sacando " + nodo.getPonsi() + " " + nodo.getPonsj());
                if(nodo.getPonsi()==eresMeta(matrizResolver)[1]&&nodo.getPonsj()==eresMeta(matrizResolver)[0]){
                    guardaSolucion.addElement(nodo);
                    encontroMeta=true;
                }
                else{
                    int[][] matrizMovimientos = new int[4][2];
                    matrizMovimientos = nodo.posiblesMovimientosValidados(matrizResolver, nodo.getPonsi(), nodo.getPonsj());
                    for(int i=0;i<4;i++){
                        System.out.println(matrizMovimientos[i][0] + " " + matrizMovimientos[i][1]);
                    }
                    contadorProfundidad=nodo.getProfundidad()+1;
                    int[] locationPapa = nodo.dondeEstasMario(matrizResolver);
                    for(int i=0;i<4;i++){
                       
                       if(matrizMovimientos[i][0]!=10&&locationPapa[0]!=matrizMovimientos[i][0]&&
                               locationPapa[1]!=matrizMovimientos[i][1]){
                       Nodo nodoHijo = new Nodo();
                     
                  /*      System.out.println("Esto " +matrizResolver[matrizMovimientos[i][0]][matrizMovimientos[i][1]]);
                       
                       matrizResolver[matrizMovimientos[i][0]][matrizMovimientos[i][1]]=2;
                       
                       
                        System.out.println("Esto AHORA " + matrizResolver[matrizMovimientos[i][0]][matrizMovimientos[i][1]]);
                        
                        
                       matrizResolver[locationPapa[1]][locationPapa[0]] = nodo.getValorActual();
                      
                       System.out.println(nodo.getValorActual() + "de " + locationPapa[0] + " " + locationPapa[1]);
                       //
                                  for(int k= 0 ; k<10; k++)
            {
                for(int j=0; j<10; j++ ) 
                {
                    System.out.print(matrizResolver[k][j] + " ");
                }
                System.out.println();
                       
          */
                 
                       nodoHijo.Nodo(nodo, matrizResolver, "", contadorProfundidad, 
                               0,0,matrizMovimientos[i][0],matrizMovimientos[i][1]);
                       
                       cola.offer(nodoHijo);
                       
                        nodo = (Nodo) cola.element();
                       System.out.println("mostrando" + nodo.getPonsi() + " " + nodo.getPonsj());
                       }
                    }
                } 
        }
        }
        return encontroMeta;
    }
    
}
