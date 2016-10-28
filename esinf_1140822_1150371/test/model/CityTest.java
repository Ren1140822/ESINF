/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
public class CityTest {

    public CityTest() {
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
     * Test of getCityName method, of class City.
     */
    @Test
    public void testGetCityName() {
        System.out.println("getCityName");
        City instance = new City();
        String expResult = "No name";
        String result = instance.getCityName();
        assertEquals(expResult, result);

    }

    /**
     * Test of getLatitude method, of class City.
     */
    @Test
    public void testGetLatitude() {
        System.out.println("getLatitude");
        City instance = new City();
        double expResult = 0.0;
        double result = instance.getLatitude();
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of getLongitude method, of class City.
     */
    @Test
    public void testGetLongitude() {
        System.out.println("getLongitude");
        City instance = new City();
        double expResult = 0.0;
        double result = instance.getLongitude();
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of getNumberOfPointsAwarded method, of class City.
     */
    @Test
    public void testGetNumberOfPointsAwarded() {
        System.out.println("getNumberOfPointsAwarded");
        City instance = new City();
        int expResult = 0;
        int result = instance.getNumberOfPointsAwarded();
        assertEquals(expResult, result);

    }

    /**
     * Test of getMayor method, of class City.
     */
    @Test
    public void testGetMayor() {
        System.out.println("getMayor");
        City instance = new City();
        User user = new User();
        instance.setMayor(user);

        User expResult = user;
        User result = instance.getMayor();
        assertEquals(expResult, result);

    }

    /**
     * Test of setCityName method, of class City.
     */
    @Test
    public void testSetCityName() {
        System.out.println("setCityName");
        String cityName = "set";
        City instance = new City();
        instance.setCityName(cityName);
        boolean isSet = instance.getCityName().equals("set");
        assertEquals(isSet, true);
    }

    /**
     * Test of setLatitude method, of class City.
     */
    @Test
    public void testSetLatitude() {
        System.out.println("setLatitude");
        double latitude = 222.3;
        City instance = new City();
        instance.setLatitude(latitude);
        boolean isSet = instance.getLatitude() == 222.3;
        assertEquals(isSet, true);
    }

    /**
     * Test of setLongitude method, of class City.
     */
    @Test
    public void testSetLongitude() {
        System.out.println("setLongitude");
        double longitude = 222.3;
        City instance = new City();
        instance.setLongitude(longitude);
        boolean isSet = instance.getLongitude() == 222.3;
        assertEquals(isSet, true);
    }

    /**
     * Test of setNumberOfPointsAwarded method, of class City.
     */
    @Test
    public void testSetNumberOfPointsAwarded() {
        System.out.println("setNumberOfPointsAwarded");
        int numberOfPointsAwarded = 23;
        City instance = new City();
        instance.setNumberOfPointsAwarded(numberOfPointsAwarded);
        boolean isSet = instance.getNumberOfPointsAwarded() == 23;
        assertEquals(isSet, true);
    }

    /**
     * Test of setMayor method, of class City.
     */
    @Test
    public void testSetMayor() {
        System.out.println("setMayor");
        User mayor = new User();
        City instance = new City();
        instance.setMayor(mayor);
        boolean isSet = instance.getMayor().equals(mayor);
        assertEquals(isSet,true);
    }

    /**
     * Test of equals method, of class City.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        City c = new City();
        Object otherObject = c;
        City instance =c;
        boolean expResult =true;
        boolean result = instance.equals(otherObject);
        assertEquals(expResult, result);
     
    }



}
