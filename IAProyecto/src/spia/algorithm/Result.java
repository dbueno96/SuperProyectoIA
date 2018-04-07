/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spia.algorithm;

import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import spia.algorithm.Node;

/**
 *
 * @author Viviana
 */
public class Result {

    private int createdNodes;
    private int expandedNodes;
    private int treeDepth = 0;
    private DefaultTreeModel tree;
    private boolean goalReached;
    private  ArrayList<int[]> path; 

    public int getCreatedNodes() {
        return createdNodes;
    }

    public void setDepth(DefaultMutableTreeNode node){
       
        int nodeDepth = ((Node) ((DefaultMutableTreeNode) node).getUserObject()).getDepth();
        System.out.println("Max Depth() = " + treeDepth );
        System.out.println("NodeDepth() " + nodeDepth);
        if(nodeDepth >= treeDepth){
            this.treeDepth = nodeDepth;
        }
    }
    
     public int getDepth(){
        return treeDepth;
    }
    public void setCamino(DefaultMutableTreeNode node) {

        //    TreePath path = new TreePath(node.getPath() )
        path =  new ArrayList<int[]> ();
        TreeNode[] treePath = node.getPath();
        int size = treePath.length;

        for (int i = 0; i < size; i++) {
            path.add( ((Node) ((DefaultMutableTreeNode) treePath[i]).getUserObject()).getCoordinate());
            
        }
        
        int[] a = new int[4];

        System.out.println("camino.length() = " + treePath.length);
    }
    
    public ArrayList<int[]> getPath(){
        return path;
    }

    public void setCreatedNodes(int createdNodes) {
        this.createdNodes = createdNodes;
    }

    public void incCreatedNodes() {
        this.createdNodes++;
    }

    public int getExpandedNodes() {
        return expandedNodes;
    }

    public void setExpandedNodes(int expandedNodes) {
        this.expandedNodes = expandedNodes;
    }

    public void incExpandedNodes() {
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
