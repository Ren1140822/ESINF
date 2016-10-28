/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashSet;
import java.util.LinkedHashSet;
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
public class UserTest {

    public UserTest() {
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
     * Test of getNickname method, of class User.
     */
//    @Test
//    public void testGetNickname() {
//        System.out.println("getNickname");
//        User instance = new User();
//        String expResult = "";
//        String result = instance.getNickname();
//        assertEquals(expResult, result);
//       
//    }
//
//    /**
//     * Test of equals method, of class User.
//     */
//    @Test
//    public void testEquals() {
//        System.out.println("equals");
//        Object otherObject = null;
//        User instance = new User();
//        boolean expResult = false;
//        boolean result = instance.equals(otherObject);
//        assertEquals(expResult, result);
//        
//    }
//
//    /**
//     * Test of getEmail method, of class User.
//     */
//    @Test
//    public void testGetEmail() {
//        System.out.println("getEmail");
//        User instance = new User();
//        String expResult = "";
//        String result = instance.getEmail();
//        assertEquals(expResult, result);
//        
//    }
//
//    /**
//     * Test of getPoints method, of class User.
//     */
//    @Test
//    public void testGetPoints() {
//        System.out.println("getPoints");
//        User instance = new User();
//        int expResult = 0;
//        int result = instance.getPoints();
//        assertEquals(expResult, result);
//      
//    }
//
//    /**
//     * Test of getCurrentCity method, of class User.
//     */
//    @Test
//    public void testGetCurrentCity() {
//        System.out.println("getCurrentCity");
//        User instance = new User();
//        String expResult = "";
//        City result = instance.getCurrentCity();
//        assertEquals(expResult, result);
//        
//    }
//
//    /**
//     * Test of getFriendsByCity method, of class User.
//     */
////    @Test
////    public void testGetFriendsByCity() {
////        System.out.println("getFriendsByCity");
////        String cityName = "";
////        User instance = new User();
////        int expResult = 0;
////        int result = instance.getFriendsByCity(cityName);
////        assertEquals(expResult, result);
////        
////    }
//
//    /**
//     * Test of getFriends method, of class User.
//     */
//    @Test
//    public void testGetFriends() {
//        System.out.println("getFriends");
//        User instance = new User();
//        Set<User> expResult = null;
//        Set<User> result = instance.getFriends();
//        assertEquals(expResult, result);
//       
//    }
//
//    /**
//     * Test of setEmail method, of class User.
//     */
//    @Test
//    public void testSetEmail() {
//        System.out.println("setEmail");
//        String email = "";
//        User instance = new User();
//        instance.setEmail(email);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setCurrentCity method, of class User.
//     */
//    @Test
//    public void testSetCurrentCity() {
//        System.out.println("setCurrentCity");
//        City currentCity = null;
//        User instance = new User();
//        instance.setCurrentCity(currentCity);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setFriends method, of class User.
//     */
//    @Test
//    public void testSetFriends() {
//        System.out.println("setFriends");
//        Set<User> friends = null;
//        User instance = new User();
//        instance.setFriends(friends);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getVisitPoints method, of class User.
//     */
//    @Test
//    public void testGetVisitPoints() {
//        System.out.println("getVisitPoints");
//        User instance = new User();
//        int expResult = 0;
//        int result = instance.getVisitPoints();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setVisitPoints method, of class User.
//     */
//    @Test
//    public void testSetVisitPoints() {
//        System.out.println("setVisitPoints");
//        int visitPoints = 0;
//        User instance = new User();
//        instance.setVisitPoints(visitPoints);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addFriend method, of class User.
//     */
//    @Test
//    public void testAddFriend() {
//        System.out.println("addFriend");
//        User user = null;
//        User instance = new User();
//        boolean expResult = false;
//        boolean result = instance.addFriend(user);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of removeFriend method, of class User.
//     */
//    @Test
//    public void testRemoveFriend() {
//        System.out.println("removeFriend");
//        User user = null;
//        User instance = new User();
//        boolean expResult = false;
//        boolean result = instance.removeFriend(user);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
    /**
     * Test of friendExists method, of class User.
     */
    @Test
    public void testFriendExists() {
        System.out.println("friendExists");
        User user = new User();
        User instance = new User();
        instance.getFriends().add(user);
        boolean expResult = true;
        boolean result = instance.friendExists(user);
        assertEquals(expResult, result);
       
    }
        @Test
    public void testFriendExistsFail() {
        System.out.println("friendExistsFail");
        User user = new User();
        City c = new City();
        user.getCitiesVisited().add(c);
        user.setEmail("new email");
        User instance = new User();
        instance.getFriends().add(user);
        boolean expResult = false;
        User newUser = new User();
        newUser.getCitiesVisited().add(c);
        boolean result = instance.friendExists(newUser);
        assertEquals(expResult, result);
       
    }

     /**
     * Test of checkIn method, of class User.
    * */
    @Test
    public void testCheckIn() {
        System.out.println("checkIn");
        City city = new City();
        User instance = new User();
        instance.getCitiesVisited().add(city);
        boolean expResult = false;
        boolean result = instance.checkIn(city);
        assertEquals(expResult, result);
      
    }
        @Test
    public void testCheckInPass() {
        System.out.println("checkIn");
        City city = new City();
        User instance = new User();
        instance.getCitiesVisited().add(city);
        City city2 = new City();
        city2.setCityName("city 2");
        boolean expResult = true;
        boolean result = instance.checkIn(city2);
        assertEquals(expResult, result);
      
    }
    /**
     * Test of getFriendsByCity method, of class User.
     */
//    @Test
//    public void testGetFriendsByCity() {
//        System.out.println("getFriendsByCity");
//        User user1 = new User();
//        User user2 = new User();
//        User user3 = new User();
//
//        User thisUser = new User();
//        City c = new City();
//        c.setLatitude(12833333);
//        c.setLongitude(12833333);
//        City c1 = new City();
//
//        c1.setLatitude(2223333);
//        c1.setLongitude(12833333);
//        City c2 = new City();
//        c2.setLatitude(11833333);
//        c2.setLongitude(11833333);
//        City c3 = new City();
//        c3.setLatitude(122832333);
//        c3.setLongitude(122823333);
//        thisUser.getCitiesVisited().add(c);
//        user1.getCitiesVisited().add(c1);
//        user2.getCitiesVisited().add(c2);
//        user3.getCitiesVisited().add(c3);
//        String cityName = c.getCityName();
//        int numberOfResults = 2;
//        User instance = thisUser;
//        user1.setNickname("user1");
//        user2.setNickname("user2");
//        user3.setNickname("user3");
//        instance.getFriends().add(user1);
//        instance.getFriends().add(user2);
//        instance.getFriends().add(user3);
//        Set<User> expResult = new LinkedHashSet<>();
//        expResult.add(user2);
//        expResult.add(user1);
//        expResult.add(user3);
//        Set<User> result = instance.getFriendsByCity(cityName, numberOfResults);
//        assertEquals(expResult, result);
//
//    }

    
    @Test
    public void testEquals() {
        System.out.println("equals");
        User u = new User();
        Object otherObject = u;
        User instance = u;
        boolean expResult = true;
        boolean result = instance.equals(otherObject);
        assertEquals(expResult, result);
      
    }

    /**
     * Test of addFriend method, of class User.
     */
    @Test
    public void testAddFriend() {
        System.out.println("addFriend");
        User user = new User();
        User instance = new User();
        boolean expResult = true;
        boolean result = instance.addFriend(user);
        assertEquals(expResult, result);
     
    }

    /**
     * Test of removeFriend method, of class User.
     */
    @Test
    public void testRemoveFriend() {
        System.out.println("removeFriend");
        User user =  new User();
        User instance = new User();
        boolean expResult = false;
        boolean result = instance.removeFriend(user);
        assertEquals(expResult, result);
    
    }

   
  
    /**
     * Test of getFriendsByCity method, of class User.
     */
    @Test
    public void testGetFriendsByCity_City() {
        System.out.println("getFriendsByCity");
        City city = new City();
        User user = new User();
        user.getCitiesVisited().add(city);
        User instance = new User();
        instance.addFriend(user);
        Set<User> expResult = new HashSet<>();
        expResult.add(user);
        Set<User> result = instance.getFriendsByCity(city);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getFriendsByCity method, of class User.
     */
    @Test
    public void testGetFriendsByCity_String() {
        System.out.println("getFriendsByCity");
      
        City city = new City();
        User user = new User();
        user.getCitiesVisited().add(city);
          String cityName = city.getCityName();
        User instance = new User();
        instance.addFriend(user);
        Set<User> expResult = new HashSet<>();
        expResult.add(user);
        Set<User> result = instance.getFriendsByCity(city);
        assertEquals(expResult, result);
    }

    /**
     * Test of getFriendsByCity method, of class User.
     */
    @Test
    public void testGetFriendsByCity_double_double() {
        System.out.println("getFriendsByCity");
       
        City city = new City();
        User user = new User();
        user.getCitiesVisited().add(city);
      double latitude = city.getLatitude();
        double longitude = city.getLongitude();
        User instance = new User();
        instance.addFriend(user);
        Set<User> expResult = new HashSet<>();
        expResult.add(user);
        Set<User> result = instance.getFriendsByCity(city);
    
    }
      
    
}
