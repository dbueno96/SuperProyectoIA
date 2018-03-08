/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iaproyecto;

/**
 *
 * @author daniel
 */
public class Nodo {
        
        private Nodo nodoPadre;  
        private int[][] estadoProblema; 
        String operador;
        int profundidad ; 
        int costo; 
        int heuristica; 
        
        public void Nodo() 
        {
            nodoPadre =null;
            estadoProblema = null; 
            profundidad = 100; 
            costo= 100; 
            heuristica = 100; 
            
        }
        
        public void Nodo(Nodo padre, int[][] estado, String operador, int prof, int costo, int heursitica)
        {
            this.nodoPadre = padre; 
            this.estadoProblema = estado; 
            this.operador = operador; 
            this.profundidad = prof; 
            this.costo = costo; 
            this.heuristica = heuristica; 
            
        }
       
        public void setNodoPadre(Nodo padre)
        {
            this.nodoPadre = padre;
        }
        
        public void setEstadoProble(int[][] estado)
        {
            this.estadoProblema = estado; 
        }
    
        public void setOperador(String operador)
        {
            this.operador = operador;
        }
        
        public void setCosto(int costo)
        {
            this.costo = costo; 
        }
        
        public void setHeuristica(int heuristica)
        {
            this.heuristica = heuristica; 
        }
        
        public Nodo getNodoPadre()
        {
            return nodoPadre;
        }
        
        public int[][] getEstadoProblema()
        {
            return estadoProblema;
        }
        
        public String getOperador()
        {
            return operador; 
        }
        
        public int getCosto()
        {
            return costo; 
        }
        
        public int getProfundidad()
        {
            return profundidad;
        }
        
        public int getHeuristica() 
        {
            return heuristica; 
        }
}

