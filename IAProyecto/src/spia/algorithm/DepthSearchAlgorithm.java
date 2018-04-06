/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spia.algorithm;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author daniel
 */
public class DepthSearchAlgorithm extends BaseAlgorithm implements SearchAlgorithm{

   public static final String CLAZZ_NAME = "Profundidad";
   public static final String[] direcciones ={"derecha", "abajo", "arriba", "izquierda"};

    private int[] finalPosition;

    public int [] getFinalPosition(){
        return finalPosition; 
    }
    public void setFinalPosition(int [] finalPosition){
        this.finalPosition = finalPosition;
    }
    
    public int h(DefaultMutableTreeNode node) {
        int[] coorNode = ((Node) node.getUserObject()).getCoordinate();
        return Math.abs(finalPosition[0] - coorNode[0]) + Math.abs(finalPosition[1] - coorNode[1]);
    }

    @Override
    public int f(DefaultMutableTreeNode node) {
        return h(node) + g(node);
    }

    @Override
    public int g(DefaultMutableTreeNode node) {
        int cost = super.getCost((Node) node.getUserObject());
        return ((Node) ((DefaultMutableTreeNode) node.getParent()).getUserObject()).getfValue() + cost;
    }

    @Override
    public void expand(DefaultMutableTreeNode node) {
        int[] coor = (int[]) ((Node) node.getUserObject()).getCoordinate();
        // Agregmos a node cada HIJO VALIDO.
        // El orden de las operaciones sera Derecha, Abajo, Izquierda, Arriba.
        int[][] childrenpositions = new int[4][2];
        childrenpositions[0] = new int[]{coor[0], coor[1] - 1};  // Derecha      
        childrenpositions[1] = new int[]{coor[0] + 1, coor[1]}; // Abajo
        childrenpositions[2] = new int[]{coor[0], coor[1] + 1}; // Izquierda
        childrenpositions[3] = new int[]{coor[0] - 1, coor[1]}; // Arriba
        for (int i = 0; i < childrenpositions.length; i++) {

            if (isAValidPosition(childrenpositions[i])) {

                // Preguntamos si el nodo ha sido expandido anteriormente en su camino.
                // Con el fin de evitar ciclos.
                if (!super.hasBeenExpandedAux(childrenpositions[i], node)) {
                    Node tmpNode = new Node(childrenpositions[i],direcciones[i]);
                    DefaultMutableTreeNode tmpJNode = new DefaultMutableTreeNode(tmpNode);
                    // Lo agregamos a los hijos del nodo padre, de esta manera construimos el arbol.
                    super.result.getTree().insertNodeInto(tmpJNode, node, node.getChildCount());

                    // Actualizamos el snapshot del nodo expandido con respecto a la flor.
                    // flower es true si la propiedad flower del nodo padre es true o si 
                    // se encuentra en una posicion con flor. false en cualquier otro caso.
                    tmpNode.setFlower(((Node) node.getUserObject()).isFlower() || super.isFlower(tmpJNode));
                    
                   
                    // Aumentamos en uno la cantidad de nodos creados.
                    super.getResult().incCreatedNodes();
                    // Añadimos al inicio de la cola de nodos por procesar.
                    super.queue.add(0, tmpJNode);

                }
            }
        }
    }
    
    @Override
    public DefaultMutableTreeNode search(DefaultMutableTreeNode node) throws Exception {
       if (isGoal(node)) {
            ((Node) node.getUserObject()).setGoal(true);
            super.getResult().setGoalReached(true);
            super.getResult().setCamino(node);
            return node;
        } else {

            expand(node);
            this.result.incExpandedNodes();

            if (super.queue.isEmpty()) {
                throw new Exception("No es posible llegar a la meta.");
            }

            DefaultMutableTreeNode nextNode = super.queue.poll(0);

            return search(nextNode);

        }
    }
    
}
