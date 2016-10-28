/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.FileNotFoundException;
import java.util.HashSet;
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
import model.MainRegistry;

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
        String filePath = "D:\\Cities.txt";
        
        Set<City> expResult = new HashSet();
        expResult.add(new City("porto",221,2003.3321,2));
        Set<City> result = InputOutput.readCityFromFile(filePath);
        boolean isEqual=false;
        for(City city : expResult)
        {
            for (City city2 : result) {
                isEqual= city.equals(city2);
                
            }
            if(!isEqual){
                break;
            }
        }
        assertTrue(isEqual);
      
    }

    /**
     * Test of readUsersFromFile method, of class InputOutput.
     */
    @Test
    public void testReadUsersFromFile() throws Exception {
        System.out.println("readUsersFromFile");
        String cityPath = "D:\\cities10.txt";
        String filePath = "D:\\users10.txt";
        MainRegistry r = new MainRegistry();
        Set<City> cities = InputOutput.readCityFromFile(cityPath);
       ListOfCities listOfCities = new ListOfCities();
       listOfCities.setListOfCities(cities);
       r.setListOfCities(listOfCities);
       Set<User> expResult =  new HashSet();
       
      //TODO, criar set utilizadores com expected result, pelo menos 5
     Set<User> result = InputOutput.readUsersFromFile(filePath, r);
        assertEquals(expResult, result);
       
    }

  
    
}
