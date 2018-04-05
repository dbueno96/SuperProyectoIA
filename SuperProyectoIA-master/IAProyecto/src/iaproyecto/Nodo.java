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
        int posni;
        int posnj;
        
        public void Nodo() 
        {
            nodoPadre =null;
            estadoProblema = null; 
            profundidad = 100; 
            costo= 100; 
            heuristica = 100; 
            posni =-1;
            posnj =-1;
            
        }
        
        public void Nodo(Nodo padre, int[][] estado, String operador, int prof, int costo, int heuristica, int posni, int posnj)
        {
            this.nodoPadre = padre; 
            this.estadoProblema = estado; 
            this.operador = operador; 
            this.profundidad = prof; 
            this.costo = costo; 
            this.heuristica = heuristica; 
            this.posni = posni;
            this.posnj = posnj;
            
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
        
           public void setPosni(int posni)
        {
            this.posni = posni; 
        }
           public void setPosnj(int posnj)
        {
            this.posnj = posnj; 
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
        
            public int getPonsi() 
        {
            return posni; 
        }
            public int getPonsj() 
        {
            return posnj; 
        }
        
        
        public int[][] posiblesMovimientosNoValidados(int []marioPosn, int i , int j){
            marioPosn[0]=j;
            marioPosn[1]=i;
                    
            
            int[][] posibles = new int[4][2];
            if(marioPosn[0]!=0&&marioPosn[0]!=9&&marioPosn[1]!=0&&marioPosn[1]!=9){
                posibles[0][0]= marioPosn[1]; //izquierda
                posibles[0][1]= marioPosn[0]-1; 
                
                
                posibles[1][0]= marioPosn[1]; //derecha
                posibles[1][1]= marioPosn[0]+1;
                
                posibles[2][0]= marioPosn[1]-1;//arriba
                posibles[2][1]= marioPosn[0];
                
                
                posibles[3][0]= marioPosn[1]+1; //abajo
                posibles[3][1]= marioPosn[0];
            }
            
            //No puede ir hacia abajo ni hacia la izquierda
            else if(marioPosn[1]==9 && marioPosn[0]==0){
                posibles[0][0]= 10; //izquierda
                posibles[0][1]= 10; 
                
                posibles[1][0]= marioPosn[0]+1; //derecha
                posibles[1][1]= marioPosn[1];
                
                posibles[2][0]= marioPosn[1]-1;//arriba
                posibles[2][1]= marioPosn[0];
                
                posibles[3][0]= 10; //abajo
                posibles[3][1]= 10;
            }
            
            //No puede ir hacia arriba ni a la derecha
            else if(marioPosn[0]==9 && marioPosn[1]==0){
                posibles[0][0]= marioPosn[1]; //izquierda
                posibles[0][1]= marioPosn[0]-1; 
                
                posibles[1][0]= 10; //derecha
                posibles[1][1]= 10;
                
                posibles[2][0]= 10; //arriba
                posibles[2][1]= 10; 
                
                posibles[3][0]= marioPosn[1]+1; //abajo
                posibles[3][1]= marioPosn[0];
            }
            
            //No puede ir hacia abajo ni a la derecha
            else if(marioPosn[0]==9 && marioPosn[1]==9){
                posibles[0][0]= marioPosn[1]; //izquierda
                posibles[0][1]= marioPosn[0]-1; 
                
                posibles[1][0]= 10; //derecha
                posibles[1][1]= 10;
                
                posibles[2][0]= marioPosn[1]-1;//arriba
                posibles[2][1]= marioPosn[0];
                
                posibles[3][0]= 10; //abajo
                posibles[3][1]= 10;
            }
            
             //No puede ir hacia arriba ni a la izquierda
            else if(marioPosn[0]==0 && marioPosn[1]==0){
                posibles[0][0]= 10; //izquierda
                posibles[0][1]= 10; 
                
                posibles[1][0]= marioPosn[1]; //derecha
                posibles[1][1]= marioPosn[0]+1;
                
                posibles[2][0]= 10; //arriba
                posibles[2][1]= 10; 
                
                posibles[3][0]= marioPosn[1]+1; //abajo
                posibles[3][1]= marioPosn[0];
            }
            
            
            
            //No puede ir hacia la izquierda
            else if(marioPosn[0]==0){
                posibles[0][0]= 10; //izquierda
                posibles[0][1]= 10; 
                
                posibles[1][0]= marioPosn[1]; //derecha
                posibles[1][1]= marioPosn[0]+1;
                
                posibles[2][0]= marioPosn[1]-1;//arriba
                posibles[2][1]= marioPosn[0]; 
                
                posibles[3][0]= marioPosn[1]+1; //abajo
                posibles[3][1]= marioPosn[0];
            }
            

            //No puede ir hacia la derecha
            else if(marioPosn[0]==9){
                posibles[0][0]= marioPosn[1]; //izquierda
                posibles[0][1]= marioPosn[0]-1; 
                
                posibles[1][0]= 10; //derecha
                posibles[1][1]= 10;
                
                posibles[2][0]= marioPosn[1]-1;//arriba
                posibles[2][1]= marioPosn[0]; 
                
                posibles[3][0]= marioPosn[1]+1; //abajo
                posibles[3][1]= marioPosn[0];
            }
            
            //No puede ir hacia arriba
            else if(marioPosn[1]==0){
                posibles[0][0]= marioPosn[1]; //izquierda
                posibles[0][1]= marioPosn[0]-1; 
                
                posibles[1][0]= marioPosn[1]; //derecha
                posibles[1][1]= marioPosn[0]+1;
                
                posibles[2][0]= 10; //arriba
                posibles[2][1]= 10; 
                
                posibles[3][0]= marioPosn[1]+1; //abajo
                posibles[3][1]= marioPosn[0];
            }
            //No puede ir hacia abajo
            else if(marioPosn[1]==9){
                posibles[0][0]= marioPosn[1]; //izquierda
                posibles[0][1]= marioPosn[0]-1; 
                
                posibles[1][0]= marioPosn[1]; //derecha
                posibles[1][1]= marioPosn[0]+1;
                
                posibles[2][0]= marioPosn[1]-1;//arriba
                posibles[2][1]= marioPosn[0];
                
                posibles[3][0]= 10; //abajo
                posibles[3][1]= 10;
            }
            
            return posibles;
        }
        
        
        
        public int[] dondeEstasMario(int[][] matrix){
        int[] marioLocation = new int[2];
        
        for(int i= 0 ; i <10; i++){
                for(int j=0; j<10; j++ ){
                    if(matrix[i][j]==2){
                    marioLocation[0]=j;
                    marioLocation[1]=i; //Estan trucadas las filas y columnas aparece es como columna y fila
                    }  
                }
            }
        return marioLocation;
    }
        
        public int[][] posiblesMovimientosValidados(int[][] matrizz, int i, int j){
         
        int[] marioEsta = dondeEstasMario(matrizz);
        int[][] move = posiblesMovimientosNoValidados(marioEsta, i, j);
        
             
        for(int k= 0 ; k <4; k++){
           if(move[k][0]!=10&&move[k][1]!=10){
                    if(matrizz[move[k][0]][move[k][1]]==1){
                        move[k][0]=10;
                        move[k][1]=10;
                    }
           }
            }
         return move;
         }
       
        
}

