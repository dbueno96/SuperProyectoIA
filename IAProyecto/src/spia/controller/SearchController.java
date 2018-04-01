/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spia.controller;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import spia.algorithm.AAsteriskAlgorithm;
import spia.algorithm.BaseAlgorithm;
import spia.algorithm.Node;
import spia.algorithm.Result;
import spia.algorithm.UniformCostAlgorithm;

/**
 *
 * @author Viviana
 */
public class SearchController {
    
    private static SearchController instance;
    
    private SearchController(){        
    }
    
    public static SearchController getInstance() {
        if (instance == null){
            synchronized(SearchController.class){
                if (instance == null) {
                    instance = new SearchController();
                }
            }
        }
        return instance;
    }
    
    // Eg. SearchController.getInstance().search(matrix, AAsterik.class.getName())
    public Result search(int[][] matrix, String algorithm) throws Exception {
        Result result = null;
        
        // Construimos el nodo donde esta mario.
        Node node = new Node(this.getInitPosition(matrix));
        DefaultMutableTreeNode jNode = new DefaultMutableTreeNode(node);
        DefaultTreeModel tree = new DefaultTreeModel(jNode);
        
        switch(algorithm) {
            case UniformCostAlgorithm.CLAZZ_NAME:
                UniformCostAlgorithm uca = new UniformCostAlgorithm();
                uca.getResult().setTree(tree);
                uca.setmatrix(matrix);                
                uca.search(jNode);                
                result = uca.getResult();
                break;
            case AAsteriskAlgorithm.CLAZZ_NAME:
                AAsteriskAlgorithm aa = new AAsteriskAlgorithm();
                aa.getResult().setTree(tree);
                aa.setmatrix(matrix);
                aa.setFinalPosition(this.getFinalPosition(matrix));
                aa.search(jNode);                
                result = aa.getResult();
                break;
            default:                
                break; 
        }
        return result;
    }
    
    private int[] getInitPosition(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 2) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
    
    private int[] getFinalPosition(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 5) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
    
    
}
