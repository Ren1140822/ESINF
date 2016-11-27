/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
    public void testGetClosestFriends() {
        System.out.println("getClosestFriends");
        String username = "nick0";
        Double distance = 20d;
        SocialNetwork instance = new SocialNetwork();
        Iterable<User> expResult = null;
        Iterable<User> result = instance.getClosestFriends(username, distance);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of shortestPathBetweenUsers method, of class SocialNetwork.
     */
    @Test
    public void testShortestPathBetweenUsers() {
        System.out.println("shortestPathBetweenUsers");
        User u1 = null;
        User u2 = null;
        SocialNetwork instance = new SocialNetwork();
        LinkedList<City> expResult = null;
        LinkedList<City> result = instance.shortestPathBetweenUsers(u1, u2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of shortestPathMostFriendsCity method, of class SocialNetwork.
     */
    @Test
    public void testShortestPathMostFriendsCity() {
        System.out.println("shortestPathMostFriendsCity");
        String user = "";
        String friend = "";
        SocialNetwork instance = new SocialNetwork();
        LinkedList<City> expResult = null;
        LinkedList<City> result = instance.shortestPathMostFriendsCity(user, friend);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
