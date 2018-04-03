/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spia.util;

import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;
import spia.algorithm.Node;

/**
 *
 * @author Viviana
 * Se crea estructura propia de encolamiento debido a que la clase DefaultMutableTreeNode
 * no implementa la interfaz Comparable.
 */
public class Queue {

    private final ArrayList<DefaultMutableTreeNode> queue;

    public Queue() {
        queue = new ArrayList<>();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int getSize() {
        return queue.size();
    }
    
    public void add(DefaultMutableTreeNode node) {
        int i;
        for (i = queue.size() - 1; i >= 0; i--) {
            if (((Node) node.getUserObject()).getfValue() <= ((Node) queue.get(i).getUserObject()).getfValue()) {
                queue.add(i + 1, node);
                return;
            }
        }
        queue.add(i + 1, node);
    }
    
    public void add(int pos, DefaultMutableTreeNode node){
        
        queue.add(pos, node);
    }
    public DefaultMutableTreeNode get (int i )
    {
        return queue.get(i);
    }
    public DefaultMutableTreeNode poll(int i){
        DefaultMutableTreeNode tormv = queue.get(i);
        queue.remove(i);
        return tormv;
    }
    public DefaultMutableTreeNode poll() throws ArrayIndexOutOfBoundsException {
        DefaultMutableTreeNode tormv = queue.get(queue.size() - 1);
        queue.remove(queue.size() - 1);
        return tormv;
    }
}
