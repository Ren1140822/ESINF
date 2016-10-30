/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jose Silva <1150371@isep.ipp.pt>
 */
public class MainRegistryTest {
    
    public MainRegistryTest() {
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
     * Test of getListOfCities method, of class MainRegistry.
     */
    @Test
    public void testGetListOfCities() {
        System.out.println("getListOfCities");
        MainRegistry instance = new MainRegistry();
        ListOfCities expResult = new ListOfCities();
        ListOfCities result = instance.getListOfCities();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setListOfCities method, of class MainRegistry.
     */
    @Test
    public void testSetListOfCities() {
        System.out.println("setListOfCities");
        ListOfCities ListOfCities = null;
        MainRegistry instance = new MainRegistry();
        instance.setListOfCities(ListOfCities);
       
    }

    /**
     * Test of getListOfUsers method, of class MainRegistry.
     */
    @Test
    public void testGetListOfUsers() {
        System.out.println("getListOfUsers");
        MainRegistry instance = new MainRegistry();
        ListOfUsers expResult = new ListOfUsers();
        ListOfUsers result = instance.getListOfUsers();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setListOfUsers method, of class MainRegistry.
     */
    @Test
    public void testSetListOfUsers() {
        System.out.println("setListOfUsers");
        ListOfUsers listOfUsers = null;
        MainRegistry instance = new MainRegistry();
        instance.setListOfUsers(listOfUsers);
       
    }

    /**
     * Test of addUser method, of class MainRegistry.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        String nickname = "";
        String email = "";
        String currentCity = "";
        Set<User> friends = null;
        List<City> cities = null;
        int visitPoints = 0;
        MainRegistry instance = new MainRegistry();
        boolean expResult = true;
        boolean result = instance.addUser(nickname, email, currentCity, friends, cities, visitPoints);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of removeUser method, of class MainRegistry.
     */
    @Test
    public void testRemoveUser() {
        System.out.println("removeUser");
        String nickname = "";
        MainRegistry instance = new MainRegistry();
        boolean expResult = false;
        boolean result = instance.removeUser(nickname);
        assertEquals(expResult, result);
      
    }

    /**
     * Test of addCity method, of class MainRegistry.
     */
    @Test
    public void testAddCity() {
        System.out.println("addCity");
        String cityName = "sem nome";
        int numberOfPointsAwarded = 0;
        double latitude = 0.0;
        double longitude = 0.0;
        MainRegistry instance = new MainRegistry();
        boolean expResult = true;
        boolean result = instance.addCity(cityName, numberOfPointsAwarded, latitude, longitude);
        assertEquals(expResult, result);
       
    }
    
}
