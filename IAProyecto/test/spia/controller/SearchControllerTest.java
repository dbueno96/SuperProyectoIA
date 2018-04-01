/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spia.controller;

import iaproyecto.Archivo;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import spia.algorithm.AAsteriskAlgorithm;
import spia.algorithm.Result;
import spia.algorithm.UniformCostAlgorithm;

/**
 *
 * @author Viviana
 */
public class SearchControllerTest {
    
    private static int[][] MATRIX;

    @BeforeClass
    public static void before() {
        Archivo a = new Archivo();
        try {
            a.leerArchivo("C:\\Users\\Viviana\\Desktop\\Prueba1.txt");
        } catch (IOException ex) {
            Logger.getLogger(SearchControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        MATRIX = a.readText();
    }
    
    @Test
    public void testSearchUniformCost() {
        System.out.println("testSearchUniformCost");

        Result result = new Result();
        try {
            result = SearchController.getInstance().search(MATRIX, UniformCostAlgorithm.CLAZZ_NAME);
        } catch (Exception ex) {
            Logger.getLogger(SearchControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Assert.assertNotNull("result is null.", result);
        System.out.println(result);
    }
    
    @Test
    public void testSearchAAsterisk() {
        System.out.println("testSearchAAsterisk");

        Result result = new Result();
        try {
            result = SearchController.getInstance().search(MATRIX, AAsteriskAlgorithm.CLAZZ_NAME);
        } catch (Exception ex) {
            Logger.getLogger(SearchControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }       
        
        Assert.assertNotNull("result is null.", result);
        System.out.println(result);
    }

}
