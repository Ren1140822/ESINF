/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Map;
import java.util.Set;
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
public class ListOfCitiesTest {
    
    public ListOfCitiesTest() {
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
     * Test of getCityByName method, of class ListOfCities.
     */
    @Test
    public void testGetCityByName() {
        System.out.println("getCityByName");
        String cityName = "";
        ListOfCities instance = new ListOfCities();
        City expResult = null;
        City result = instance.getCityByName(cityName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListOfCities method, of class ListOfCities.
     */
    @Test
    public void testGetListOfCities() {
        System.out.println("getListOfCities");
        ListOfCities instance = new ListOfCities();
        Set<City> expResult = null;
        Set<City> result = instance.getListOfCities();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCityByUser method, of class ListOfCities.
     */
    @Test
    public void testGetCityByUser() {
        System.out.println("getCityByUser");
        User user = null;
        ListOfCities instance = new ListOfCities();
        City expResult = null;
        City result = instance.getCityByUser(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMapOfCitiesAndMayorsByDescOrder method, of class ListOfCities.
     */
    @Test
    public void testGetMapOfCitiesAndMayorsByDescOrder() {
        System.out.println("getMapOfCitiesAndMayorsByDescOrder");
        ListOfCities instance = new ListOfCities();
         
        Map<City, User> expResult = null;
        Map<City, User> result = instance.getMapOfCitiesAndMayorsByDescOrder();
        assertEquals(expResult, result);
     
        fail("The test case is a prototype.");
    }
    
}
