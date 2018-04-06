/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spia.algorithm;

import java.util.Arrays;
import javax.swing.tree.DefaultMutableTreeNode;
import spia.util.Queue;

/**
 *
 * @author Viviana
 */
public abstract class BaseAlgorithm {

    protected int[][] matrix;
    protected Result result;
    protected Queue queue;
   

    public BaseAlgorithm() {
        result = new Result();
        queue = new Queue();
    }
   

    public int[][] getmatrix() {
        return matrix;
    }

    public void setmatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    protected int getCost(Node node) {
        int coorx = node.getCoordinate()[0];
        int coory = node.getCoordinate()[1];

        int cost;
        switch (this.matrix[coorx][coory]) {
            //camino libre 
            case 0:
                cost = 1;
                break;
            // punto donde se encuentra mario
            case 2:
                cost = 1;
                break;
            // si hay una flor
            case 3:
                cost = 1;
                break;
            // si hay una tortuga 
            case 4:
                if (node.isFlower()) {
                    cost = 1;
                } else {
                    cost = 7;
                }
                break;
            // meta, encontraste a la princesa
            case 5:
                cost = 1;
                break;
            default:
                cost = -1;
                break;
        }

        return cost;

    }

    protected boolean hasBeenExpanded(DefaultMutableTreeNode node) {
        return hasBeenExpandedAux(((Node) node.getUserObject()).getCoordinate(),
                (DefaultMutableTreeNode) node.getParent());
    }

    protected boolean hasBeenExpandedAux(int[] coordinate, DefaultMutableTreeNode parentnode) {
        if (parentnode == null) {
            return false;
        } else if (Arrays.equals(coordinate, ((Node) parentnode.getUserObject()).getCoordinate())) {
            return true;
        } else {
            return hasBeenExpandedAux(coordinate, (DefaultMutableTreeNode) parentnode.getParent());
        }
    }

    public boolean isGoal(DefaultMutableTreeNode node) {
        int[] coor = (int[]) ((Node) node.getUserObject()).getCoordinate();
        return this.matrix[coor[0]][coor[1]] == 5;
    }
    
    public boolean isFlower(DefaultMutableTreeNode node) {
        int[] coor = (int[]) ((Node) node.getUserObject()).getCoordinate();
        return this.matrix[coor[0]][coor[1]] == 3;
    }

    protected boolean isAValidPosition(int[] position) {
        // validamos que la coordenada pertenezca al mundo.
        if ((0 <= position[0] && position[0] < this.matrix.length) && (0 <= position[1] && position[1] < this.matrix.length)) {
            // Verificamos que no se trate de una pared.
            return matrix[position[0]][position[1]] != 1;
        }
        return false;
    }

}
