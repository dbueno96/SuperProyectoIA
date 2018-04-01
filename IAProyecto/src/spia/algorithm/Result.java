/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spia.algorithm;

import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Viviana
 */
public class Result {
    private int createdNodes;
    private int expandedNodes;
    private DefaultTreeModel tree;
    private boolean goalReached;

    public int getCreatedNodes() {
        return createdNodes;
    }

    public void setCreatedNodes(int createdNodes) {
        this.createdNodes = createdNodes;
    }
    
    public void incCreatedNodes () {
        this.createdNodes++;
    }

    public int getExpandedNodes() {
        return expandedNodes;
    }

    public void setExpandedNodes(int expandedNodes) {
        this.expandedNodes = expandedNodes;
    }
    
    public void incExpandedNodes () {
        this.expandedNodes++;
    }
  
    public DefaultTreeModel getTree() {
        return tree;
    }

    public void setTree(DefaultTreeModel tree) {
        this.tree = tree;
    }

    public boolean isGoalReached() {
        return goalReached;
    }

    public void setGoalReached(boolean goalReached) {
        this.goalReached = goalReached;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.getClass().getName());
        sb.append(" ");
        sb.append(this.createdNodes);
        sb.append(" ");
        sb.append(this.expandedNodes);
        sb.append(" ");
        sb.append(this.goalReached);
        sb.append(" ");
        sb.append(this.tree.toString());
        return sb.toString();        
    }
    
}
