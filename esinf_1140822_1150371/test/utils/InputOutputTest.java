/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;
import model.City;
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
        expResult.add(new City("porto",2003,2003,2));
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
//    @Test
//    public void testReadUsersFromFile() {
//        System.out.println("readUsersFromFile");
//        String filePath = "";
//        Set<User> expResult = null;
//        Set<User> result = InputOutput.readUsersFromFile(filePath);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
