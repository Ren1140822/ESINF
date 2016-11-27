/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import graphMatrizAdj.AdjacencyMatrixGraph;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.InputOutput;

/**
 *
 * @author Jose Silva <1150371@isep.ipp.pt>
 */
public class SocialNetworkTest {

    public SocialNetworkTest() {
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

//    /**
//     * Test of getListOfCities method, of class SocialNetwork.
//     */
//    @Test
//    public void testGetListOfCities() {
//        System.out.println("getListOfCities");
//        SocialNetwork instance = new SocialNetwork();
//        ListOfCities expResult = new ListOfCities();
//        ListOfCities result = instance.getListOfCities();
//        assertEquals(expResult, result);
//        
//    }
//
//    /**
//     * Test of setListOfCities method, of class SocialNetwork.
//     */
//    @Test
//    public void testSetListOfCities() {
//        System.out.println("setListOfCities");
//        ListOfCities ListOfCities = null;
//        SocialNetwork instance = new SocialNetwork();
//        instance.setListOfCities(ListOfCities);
//       
//    }
//
//    /**
//     * Test of getListOfUsers method, of class SocialNetwork.
//     */
//    @Test
//    public void testGetListOfUsers() {
//        System.out.println("getListOfUsers");
//        SocialNetwork instance = new SocialNetwork();
//        ListOfUsers expResult = new ListOfUsers();
//        ListOfUsers result = instance.getListOfUsers();
//        assertEquals(expResult, result);
//        
//    }
//
//    /**
//     * Test of setListOfUsers method, of class SocialNetwork.
//     */
//    @Test
//    public void testSetListOfUsers() {
//        System.out.println("setListOfUsers");
//        ListOfUsers listOfUsers = null;
//        SocialNetwork instance = new SocialNetwork();
//        instance.setListOfUsers(listOfUsers);
//       
//    }
//
//    /**
//     * Test of addUser method, of class SocialNetwork.
//     */
//    @Test
//    public void testAddUser() {
//        System.out.println("addUser");
//        String nickname = "";
//        String email = "";
//        String currentCity = "";
//        Set<User> friends = null;
//        List<City> cities = null;
//        int visitPoints = 0;
//        SocialNetwork instance = new SocialNetwork();
//        boolean expResult = true;
//        boolean result = instance.addUser(nickname, email, currentCity, friends, cities, visitPoints);
//        assertEquals(expResult, result);
//        
//    }
//
//    /**
//     * Test of removeUser method, of class SocialNetwork.
//     */
//    @Test
//    public void testRemoveUser() {
//        System.out.println("removeUser");
//        String nickname = "";
//        SocialNetwork instance = new SocialNetwork();
//        boolean expResult = false;
//        boolean result = instance.removeUser(nickname);
//        assertEquals(expResult, result);
//      
//    }
//
//    /**
//     * Test of addCity method, of class SocialNetwork.
//     */
//    @Test
//    public void testAddCity() {
//        System.out.println("addCity");
//        String cityName = "sem nome";
//        int numberOfPointsAwarded = 0;
//        double latitude = 0.0;
//        double longitude = 0.0;
//        SocialNetwork instance = new SocialNetwork();
//        boolean expResult = true;
//        boolean result = instance.addCity(cityName, numberOfPointsAwarded, latitude, longitude);
//        assertEquals(expResult, result);
//       
//    }
//
//    /**
//     * Test of checkIn method, of class SocialNetwork.
//     */
//    @Test
//    public void testCheckIn() {
//        System.out.println("checkIn");
//        String user = "";
//        String city = "";
//        SocialNetwork instance = new SocialNetwork();
//        boolean expResult = false;
//        boolean result = instance.checkIn(user, city);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getFriendsByCity method, of class SocialNetwork.
//     */
//    @Test
//    public void testGetFriendsByCity_String_String() {
//        System.out.println("getFriendsByCity");
//        String nickname = "";
//        String cityName = "";
//        SocialNetwork instance = new SocialNetwork();
//        Map<String, User> expResult = null;
//        Map<String, User> result = instance.getFriendsByCity(nickname, cityName);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getFriendsByCity method, of class SocialNetwork.
//     */
//    @Test
//    public void testGetFriendsByCity_3args() {
//        System.out.println("getFriendsByCity");
//        String nickname = "";
//        double latitude = 0.0;
//        double longitude = 0.0;
//        SocialNetwork instance = new SocialNetwork();
//        Map<String, User> expResult = null;
//        Map<String, User> result = instance.getFriendsByCity(nickname, latitude, longitude);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of getClosestFriends method, of class SocialNetwork.
     */
    @Test
    public void testGetClosestFriends() throws FileNotFoundException, IOException {
        System.out.println("getClosestFriends");
        String username = "nick2";
        Double distance = 200d;
        SocialNetwork instance = new SocialNetwork();
        instance.getListOfCities().setListOfCities(InputOutput.readCityFromFile("D:\\city10.txt"));
        instance.getListOfCities().cityGraph = InputOutput.loadCitiesGraph("D:\\cityConnections10.txt", InputOutput.readCityFromFile("D:\\city10.txt").values());
        instance.setListOfUsers(InputOutput.readUsersFromFile("D:\\users10.txt", instance));
        instance.getListOfUsers().getUserByNickname(username).setCurrentCity(instance.getListOfCities().getCityByName("city0"));
        instance.getListOfUsers().addFriendToGraph();

        Iterable<User> result = instance.getClosestFriends(username, distance);
        for (User user : result) {
            System.out.println("\nTEstGetClosestFriends\t" + user.toString());
        }

    }

    /**
     * Test of shortestPathBetweenUsers method, of class SocialNetwork.
     */
    @Test
    public void testShortestPathBetweenUsers() throws FileNotFoundException, IOException {
        System.out.println("shortestPathBetweenUsers");
        SocialNetwork instance = new SocialNetwork();

        instance.getListOfCities().cityGraph = InputOutput.loadCitiesGraph("D:\\cityConnections10.txt", InputOutput.readCityFromFile("D:\\city10.txt").values());
        instance.getListOfCities().setListOfCities(InputOutput.readCityFromFile("D:\\city10.txt"));
        instance.setListOfUsers(InputOutput.readUsersFromFile("D:\\users10.txt", instance));
        User u1 = instance.getListOfUsers().getUserByNickname("nick0");
        User u2 = instance.getListOfUsers().getUserByNickname("nick1");

        LinkedList<City> result = instance.shortestPathBetweenUsers(u1, u2);
        for (City city : result) {
            System.out.println(city.toString());
        }

    }

    /**
     * Test of shortestPathMostFriendsCity method, of class SocialNetwork.
     */
    @Test
    public void testShortestPathMostFriendsCity() throws FileNotFoundException, IOException {
        System.out.println("shortestPathMostFriendsCity");
        String user = "nick2";
        String friend = "nick1";
       SocialNetwork instance = new SocialNetwork();
        instance.getListOfCities().setListOfCities(InputOutput.readCityFromFile("D:\\city10.txt"));
        instance.getListOfCities().cityGraph = InputOutput.loadCitiesGraph("D:\\cityConnections10.txt", InputOutput.readCityFromFile("D:\\city10.txt").values());
        instance.setListOfUsers(InputOutput.readUsersFromFile("D:\\users10.txt", instance));
        instance.getListOfUsers().addFriendToGraph();
        instance.getListOfUsers().addFriendToGraph();
        LinkedList<City> result = instance.shortestPathMostFriendsCity(user, friend);
        
        for (City city : result) {
            System.out.println(city.getCityName()+",");
        }
        
       
    }

    /**
     * Test of getListOfCities method, of class SocialNetwork.
     */
    @Test
    public void testGetListOfCities() {
        System.out.println("getListOfCities");
        SocialNetwork instance = new SocialNetwork();
        ListOfCities expResult = null;
        ListOfCities result = instance.getListOfCities();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListOfCities method, of class SocialNetwork.
     */
    @Test
    public void testSetListOfCities() {
        System.out.println("setListOfCities");
        ListOfCities ListOfCities = null;
        SocialNetwork instance = new SocialNetwork();
        instance.setListOfCities(ListOfCities);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListOfUsers method, of class SocialNetwork.
     */
    @Test
    public void testGetListOfUsers() {
        System.out.println("getListOfUsers");
        SocialNetwork instance = new SocialNetwork();
        ListOfUsers expResult = null;
        ListOfUsers result = instance.getListOfUsers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListOfUsers method, of class SocialNetwork.
     */
    @Test
    public void testSetListOfUsers() {
        System.out.println("setListOfUsers");
        ListOfUsers listOfUsers = null;
        SocialNetwork instance = new SocialNetwork();
        instance.setListOfUsers(listOfUsers);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addUser method, of class SocialNetwork.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        String nickname = "";
        String email = "";
        String currentCity = "";
        List<City> cities = null;
        int visitPoints = 0;
        SocialNetwork instance = new SocialNetwork();
        boolean expResult = false;
        boolean result = instance.addUser(nickname, email, currentCity, cities, visitPoints);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeUser method, of class SocialNetwork.
     */
    @Test
    public void testRemoveUser() {
        System.out.println("removeUser");
        String nickname = "";
        SocialNetwork instance = new SocialNetwork();
        boolean expResult = false;
        boolean result = instance.removeUser(nickname);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCity method, of class SocialNetwork.
     */
    @Test
    public void testAddCity() {
        System.out.println("addCity");
        String cityName = "";
        int numberOfPointsAwarded = 0;
        double latitude = 0.0;
        double longitude = 0.0;
        SocialNetwork instance = new SocialNetwork();
        boolean expResult = false;
        boolean result = instance.addCity(cityName, numberOfPointsAwarded, latitude, longitude);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkIn method, of class SocialNetwork.
     */
    @Test
    public void testCheckIn() {
        System.out.println("checkIn");
        String user = "";
        String city = "";
        SocialNetwork instance = new SocialNetwork();
        boolean expResult = false;
        boolean result = instance.checkIn(user, city);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFriendsByCity method, of class SocialNetwork.
     */
    @Test
    public void testGetFriendsByCity_String_String() {
        System.out.println("getFriendsByCity");
        String nickname = "";
        String cityName = "";
        SocialNetwork instance = new SocialNetwork();
        Map<String, User> expResult = null;
        Map<String, User> result = instance.getFriendsByCity(nickname, cityName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFriendsByCity method, of class SocialNetwork.
     */
    @Test
    public void testGetFriendsByCity_3args() {
        System.out.println("getFriendsByCity");
        String nickname = "";
        double latitude = 0.0;
        double longitude = 0.0;
        SocialNetwork instance = new SocialNetwork();
        Map<String, User> expResult = null;
        Map<String, User> result = instance.getFriendsByCity(nickname, latitude, longitude);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
