/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spia.algorithm;


/**
 *
 * @author Viviana
 */
public class Node {

    private final int [] coordinate;
    private int fValue;
    private int gValue;
    private int hValue;
    private boolean goal;
    private boolean flower;
    private String camino;

    public Node(int [] coordinate, String camino) {
        this.coordinate = coordinate;
        goal = false;
        flower=false;
        fValue = 0;
        gValue = 0;
        hValue = 0;
        this.camino = this.camino + " " + camino; 
        
    }
    
    public void setCamino(String camino){
        camino =  camino+this.camino; 
    }
    
    public String getCamino(){
        return camino;
    }
    
    public int [] getCoordinate() {
        return this.coordinate;
    }

    public int getfValue() {
        return fValue;
    }

    public void setfValue(int fValue) {
        this.fValue = fValue;
    }

    public int getgValue() {
        return gValue;
    }

    public void setgValue(int gValue) {
        this.gValue = gValue;
    }

    public int gethValue() {
        return hValue;
    }

    public void sethValue(int hValue) {
        this.hValue = hValue;
    }

    public boolean isGoal() {
        return goal;
    }

    public void setGoal(boolean goal) {
        this.goal = goal;
    }

    public boolean isFlower() {
        return flower;
    }

    public void setFlower(boolean flower) {
        this.flower = flower;
    }

}
