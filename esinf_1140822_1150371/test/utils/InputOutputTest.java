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
     * Test of readUsersFromFile method, of class InputOutput.
     */
//    @Test
//    public void testReadUsersFromFile() throws Exception {
//        System.out.println("readUsersFromFile");
//        String cityPath = "D:\\cities10.txt";
//        String filePath = "D:\\users10.txt";
//        SocialNetwork r = new SocialNetwork();
//        Set<City> cities = InputOutput.readCityFromFile(cityPath);
//        ListOfCities listOfCities = new ListOfCities();
//        listOfCities.setListOfCities(cities);
//        r.setListOfCities(listOfCities);
//        Set<User> expResult = new LinkedHashSet();
//        expResult.add(nick0(r));
//        expResult.add(nick1(r));
//        expResult.add(nick2(r));
//        expResult.add(nick3(r));
//        expResult.add(nick4(r));
//        Set<User> result=new LinkedHashSet();
//        result = InputOutput.readUsersFromFile(filePath, r);
//        boolean bool;
//        for (User user : result) {
//            if (user.equals(nick2(r))){
//                
//            }
//        }
//        assertEquals(expResult, result);
//
//    }
//
//    private User nick0(SocialNetwork r) {
//        List<City> cities = new LinkedList();
//        cities.add(r.getListOfCities().getCityByName("city4"));
//        cities.add(r.getListOfCities().getCityByName("city6"));
//        Set<User> friends = new HashSet();
//        friends.add(r.getListOfUsers().getUserByNickname("nick7"));
//        friends.add(r.getListOfUsers().getUserByNickname("nick4"));
//        friends.add(r.getListOfUsers().getUserByNickname("nick3"));
//        User u = new User("nick0", "mail_0_@sapo.pt", null, friends, cities, 144);
//        return u;
//    }
//
//    private User nick1(SocialNetwork r) {
//        List<City> cities = new LinkedList();
//        cities.add(r.getListOfCities().getCityByName("city5"));
//        cities.add(r.getListOfCities().getCityByName("city9"));
//        cities.add(r.getListOfCities().getCityByName("city4"));
//        Set<User> friends = new HashSet();
//        friends.add(r.getListOfUsers().getUserByNickname("nick6"));
//        friends.add(r.getListOfUsers().getUserByNickname("nick2"));
//        friends.add(r.getListOfUsers().getUserByNickname("nick8"));
//        User u = new User("nick1", "mail_1_@sapo.pt", null, friends, cities, 0);
//        u.setVisitPoints(203);
//        return u;
//    }
//
//    private User nick2(SocialNetwork r) {
//        List<City> cities = new LinkedList();
//
//        cities.add(r.getListOfCities().getCityByName("city0"));
//          cities.add(r.getListOfCities().getCityByName("city2"));
//        Set<User> friends = new HashSet();
//        friends.add(r.getListOfUsers().getUserByNickname("nick6"));
//        friends.add(r.getListOfUsers().getUserByNickname("nick7"));
//        friends.add(r.getListOfUsers().getUserByNickname("nick8"));
//        friends.add(r.getListOfUsers().getUserByNickname("nick1"));
//        User u = new User("nick2", "mail_2_@sapo.pt", null, friends, cities, 0);
//        u.setVisitPoints(109);
//        return u;
//    }
//
//    private User nick3(SocialNetwork r) {
//        List<City> cities = new LinkedList();
//        cities.add(r.getListOfCities().getCityByName("city8"));
//        Set<User> friends = new HashSet();
//        friends.add(r.getListOfUsers().getUserByNickname("nick0"));
//        friends.add(r.getListOfUsers().getUserByNickname("nick8"));
//        friends.add(r.getListOfUsers().getUserByNickname("nick7"));
//        friends.add(r.getListOfUsers().getUserByNickname("nick6"));
//        friends.add(r.getListOfUsers().getUserByNickname("nick5"));
//        User u = new User("nick3", "mail_3_@sapo.pt", null, friends, cities, 0);
//        u.setVisitPoints(7);
//        return u;
//    }
//
//    private User nick4(SocialNetwork r) {
//        List<City> cities = new LinkedList();
//        cities.add(r.getListOfCities().getCityByName("city6"));
//        cities.add(r.getListOfCities().getCityByName("city8"));
//        Set<User> friends = new HashSet();
//        friends.add(r.getListOfUsers().getUserByNickname("nick9"));
//        friends.add(r.getListOfUsers().getUserByNickname("nick0"));
//        User u = new User("nick4", "mail_4_@sapo.pt", null, friends, cities, 0);
//        u.setVisitPoints(87);
//        return u;
//    }
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

}
