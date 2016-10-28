/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.MainRegistry;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class AddCityControllerTest {
    
    public AddCityControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addCity method, of class AddCityController.
     */
    @Test
    public void testAddCity() {
        System.out.println("addCity");
        String cityName = "test";
        long latitude = 0L;
        long longitude = 0L;
        int nrPoints = 0;
        AddCityController instance = new AddCityController(new MainRegistry());
        boolean expResult =true;
        boolean result = instance.addCity(cityName, latitude, longitude, nrPoints);
        assertEquals(expResult, result);
      
    }
    @Test
    public void testAddCityFail() {
        System.out.println("addCityFail");
        String cityName = "test";
        long latitude = 0L;
        long longitude = 0L;
        int nrPoints = -1;
        AddCityController instance = new AddCityController(new MainRegistry());
        boolean expResult =true;
        boolean result = instance.addCity(cityName, latitude, longitude, nrPoints);
        assertEquals(expResult, result);
      
    }
    @Test
    public void testAddCityFail2() {
        System.out.println("addCityFail2");
        String cityName = "test";
        long latitude = 0L;
        long longitude = 0L;
        int nrPoints = -1;
        AddCityController instance = new AddCityController(new MainRegistry());
        boolean expResult = false;
        boolean result = instance.addCity(cityName, latitude, longitude, nrPoints);
        result = instance.addCity(cityName, latitude, longitude, nrPoints);
        //fail to add same city
        assertEquals(expResult, result);
      
    }
    
}
