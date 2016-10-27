/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashSet;
import java.util.LinkedHashMap;
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

    ListOfCities instance;

    public ListOfCitiesTest() {

        instance = new ListOfCities();
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
        City c = new City();
        instance.getListOfCities().add(c);
        String cityName = "No name";
        ListOfCities instance = this.instance;
        City expResult = c;
        City result = instance.getCityByName(cityName);
        assertEquals(expResult, result);

    }

    /**
     * Test of getListOfCities method, of class ListOfCities.
     */
    @Test
    public void testGetListOfCities() {
        System.out.println("getListOfCities");
        City c = new City();
        instance.getListOfCities().add(c);
        ListOfCities instance = this.instance;

        Set<City> expResult = new HashSet();
        expResult.add(c);
        Set<City> result = instance.getListOfCities();
        assertEquals(expResult, result);

    }

    /**
     * Test of getCityByUser method, of class ListOfCities.
     */
    @Test
    public void testGetCityByUser() {
        System.out.println("getCityByUser");
        City c = new City();

        ListOfCities instance = this.instance;
        User u = new User();
        c.setMayor(u);
        instance.getListOfCities().add(c);
        City expResult = c;
        City result = instance.getCityByUser(u);
        assertEquals(expResult, result);
    }

    /**
     * Test of getMapOfCitiesAndMayorsByDescOrder method, of class ListOfCities.
     */
    @Test
    public void testGetMapOfCitiesAndMayorsByDescOrder() {
        System.out.println("getMapOfCitiesAndMayorsByDescOrder");
        City c = new City();
        City c2 = new City();
        City c3 = new City();
        ListOfCities instance = this.instance;
        User u = new User();
        u.setVisitPoints(200);
        User u2 = new User();
        u2.setVisitPoints(100);
        User u3 = new User();
        u3.setVisitPoints(10);
        c2.setMayor(u);
        c3.setMayor(u3);
        c.setMayor(u2);
        instance.getListOfCities().add(c);
        instance.getListOfCities().add(c2);
        instance.getListOfCities().add(c3);

        Map<City, User> expResult = new LinkedHashMap();
        expResult.put(c2, u);
        expResult.put(c3, u3);
        expResult.put(c, u2);
        Map<City, User> result = instance.getMapOfCitiesAndMayorsByDescOrder();
        assertEquals(expResult, result);

    }

}
