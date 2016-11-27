/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import graphMatrizAdj.AdjacencyMatrixGraph;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import model.City;
import model.ListOfCities;
import model.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import model.SocialNetwork;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class InputOutputTest {

    public InputOutputTest() {
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
     * Test of readCityFromFile method, of class InputOutput.
     */
    @Test
    public void testReadCityFromFile() throws FileNotFoundException {
        System.out.println("readCityFromFile");
        String filePath = "D:\\city10.txt";

        Set<City> expResult = new HashSet();
        expResult.add(new City("city0", 28, 41.243345, -8.674084));
        Collection<City> result = InputOutput.readCityFromFile(filePath).values();
        boolean isEqual = false;
        City city = new City("city0", 28, 41.243345, -8.674084);

        assertTrue(result.contains(city));

    }


    /**
     * Test of readCitiesToGraph method, of class InputOutput.
     */
    /**
     * Test of loadCitiesGraph method, of class InputOutput.
     */
    @Test
    public void testLoadCitiesGraph() throws Exception {
        System.out.println("loadCitiesGraph");
        String filepath = "D:\\cityConnections10.txt";
        Collection<City> existingCities = InputOutput.readCityFromFile("D:\\city10.txt").values();
        InputOutput instance = new InputOutput();
        AdjacencyMatrixGraph<City, Double> result = instance.loadCitiesGraph(filepath, existingCities);
        System.out.println(result);
        City city0 = new City("city0", 28, 41.243345, -8.674084);
        City city3 = new City("city3", 42, 41.118700, -8.589700);

        if (result.getEdge(city0, city3) == 38) {

            assertTrue(true);
        } else {
            assertTrue(false);
        }

    }

    /**
     * Test of readUsersFromFile method, of class InputOutput.
     */
    @Test
    public void testReadUsersFromFile() throws Exception {
        System.out.println("readUsersFromFile");
        String filePath = "D:\\users10.txt";
        SocialNetwork r = new SocialNetwork();
        r.getListOfCities().setListOfCities(InputOutput.readCityFromFile("D:\\city10.txt"));
        Map<User, Set<User>> result = InputOutput.readUsersFromFile(filePath, r);
        System.out.println("hello");
        
     
    }

 
}
