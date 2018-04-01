/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spia.algorithm;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Viviana
 */
public interface SearchAlgorithm {
    
    int f(DefaultMutableTreeNode node);

    int g(DefaultMutableTreeNode node);

    

    void expand(DefaultMutableTreeNode node);

    public DefaultMutableTreeNode search(DefaultMutableTreeNode node) throws Exception;
}
