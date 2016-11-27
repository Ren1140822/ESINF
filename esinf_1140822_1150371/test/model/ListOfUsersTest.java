/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import graphbase.Graph;
import java.io.FileNotFoundException;
import java.util.HashSet;
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
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class ListOfUsersTest {

    SocialNetwork r;
    ListOfUsers instance;

    public ListOfUsersTest() throws FileNotFoundException {
        r = new SocialNetwork();
        instance = r.getListOfUsers();
        ListOfUsers instance = this.instance;
        ListOfCities list = new ListOfCities();
        list.setListOfCities(InputOutput.readCityFromFile("D:\\cities300.txt"));
        r.setListOfCities(list);
        instance.setUserMap(InputOutput.readUsersFromFile("D:\\users300.txt", r));

        instance.addFriend("nick0", "nick1");
        instance.addFriend("nick1", "nick3");
        instance.addFriend("nick1", "nick6");
        instance.addFriend("nick4", "nick5");
        instance.addFriend("nick6", "nick7");
        instance.addFriend("nick7", "nick4");

        instance.addFriendToGraph();
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
//     * Test of getUserSet method, of class ListOfUsers.
//     */
//    @Test
//    public void testGetUserSet() {
//        System.out.println("getUserSet");
//        Set<User> userSet = new HashSet();
//        ListOfUsers instance = this.instance;
//        instance.setUserSet(userSet);
//        Set<User> expResult = userSet;
//        Set<User> result = instance.getUserSet();
//        assertEquals(expResult, result);
//
//    }
//
//    /**
//     * Test of setUserSet method, of class ListOfUsers.
//     */
//    @Test
//    public void testSetUserSet() {
//        System.out.println("setUserSet");
//        Set<User> userSet = new HashSet();
//        ListOfUsers instance = this.instance;
//        instance.setUserSet(userSet);
//        boolean isSet = instance.getUserSet() != null;
//        assertEquals(isSet, true);
//    }
//
//    /**
//     * Test of getUserByNickname method, of class ListOfUsers.
//     */
//    @Test
//    public void testGetUserByNickname() {
//        System.out.println("getUserByNickname");
//        User u = new User();
//        String nick = "No nickname";
//        ListOfUsers instance = this.instance;
//        instance.getUserSet().add(u);
//        User expResult = u;
//        User result = instance.getUserByNickname(nick);
//        assertEquals(expResult, result);
//
//    }
//    /**
//     * Test of getMostInfluentUsers method, of class ListOfUsers.
//     */
//    @Test
//    public void testGetMostInfluentUsers() {
//        System.out.println("getMostInfluentUsers");
//        int numberOfResults = 2;
//        ListOfUsers instance = new ListOfUsers();
//
//        User user1 = new User();
//        User user2 = new User();
//        User user3 = new User();
//        user1.addFriend(user2);
//        user1.addFriend(user3);
//        List<User> expResult = new LinkedList();
//        expResult.add(user1);
//        expResult.add(user2);
//        expResult.add(user3);
//        instance.getUserSet().add(user1);
//        instance.getUserSet().add(user2);
//        instance.getUserSet().add(user3);
//        List<User> result = instance.getMostInfluentUsers(numberOfResults);
//        assertEquals(expResult, result);
//
//    }
//
//    /**
//     * Test of getUserMap method, of class ListOfUsers.
//     */
//    @Test
//    public void testGetUserMap() {
//        System.out.println("getUserMap");
//        ListOfUsers instance = new ListOfUsers();
//        Map<String, User> expResult = null;
//        Map<String, User> result = instance.getUserMap();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getFriendsMap method, of class ListOfUsers.
//     */
//    @Test
//    public void testGetFriendsMap() {
//        System.out.println("getFriendsMap");
//        ListOfUsers instance = new ListOfUsers();
//        Map<User, Set<User>> expResult = null;
//        Map<User, Set<User>> result = instance.getFriendsMap();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of equals method, of class ListOfUsers.
//     */
//    @Test
//    public void testEquals() {
//        System.out.println("equals");
//        Object l2 = null;
//        ListOfUsers instance = new ListOfUsers();
//        boolean expResult = false;
//        boolean result = instance.equals(l2);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addFriend method, of class ListOfUsers.
//     */
//    @Test
//    public void testAddFriend() {
//        System.out.println("addFriend");
//        String nickname1 = "";
//        String nickname2 = "";
//        ListOfUsers instance = new ListOfUsers();
//        boolean expResult = false;
//        boolean result = instance.addFriend(nickname1, nickname2);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * // * Test of removeFriend method, of class ListOfUsers. //
     */
//    @Test
//    public void testRemoveFriend() {
//        System.out.println("removeFriend");
//        String nickname1 = "";
//        String nickname2 = "";
//        ListOfUsers instance = new ListOfUsers();
//        boolean expResult = false;
//        boolean result = instance.removeFriend(nickname1, nickname2);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of friendExists method, of class ListOfUsers.
//     */
//    @Test
//    public void testFriendExists() {
//        System.out.println("friendExists");
//        String nickname1 = "";
//        String nickname2 = "";
//        ListOfUsers instance = new ListOfUsers();
//        boolean expResult = false;
//        boolean result = instance.friendExists(nickname1, nickname2);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addFriendToGraph method, of class ListOfUsers.
//     */
//    @Test
//    public void testAddFriendToGraph() {
//        System.out.println("addFriendToGraph");
//        ListOfUsers instance = new ListOfUsers();
//        boolean expResult = false;
//        boolean result = instance.addFriendToGraph();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of getRelationshipDistance method, of class ListOfUsers.
     */
    @Test
    public void testGetRelationshipDistance() throws FileNotFoundException {
        System.out.println("getRelationshipDistance");
        String nickname1 = "nick0";
        String nickname2 = "nick3";
        ListOfUsers instance = this.instance;
        ListOfCities list = new ListOfCities();
        list.setListOfCities(InputOutput.readCityFromFile("D:\\cities10.txt"));
        r.setListOfCities(list);
        instance.setUserMap(InputOutput.readUsersFromFile("D:\\users10.txt", r));

        instance.addFriend("nick0", "nick1");
        instance.addFriend("nick1", "nick3");
        instance.addFriend("nick1", "nick6");
        instance.addFriend("nick4", "nick5");
        instance.addFriend("nick6", "nick7");
        instance.addFriend("nick7", "nick4");
        instance.addFriendToGraph();
        Graph<User, Integer> friendsGraph = instance.getFriendsGraph();
        int expResult = 3;
        int result = instance.getRelationshipDistance(nickname1, nickname2);
        assertEquals(expResult, result);

    }

    /**
     * Test of findUsersWithinRelationshipDistance method, of class ListOfUsers.
     */
    @Test
    public void testFindUsersWithinRelationshipDistance() {
        System.out.println("findUsersWithinRelationshipDistance");
        String nickname1 = "nick0";
        int distance = 2;
        ListOfUsers instance = this.instance;
        LinkedList<User> list = new LinkedList<>();

        list.add(instance.getUserByNickname("nick1"));
        list.add(instance.getUserByNickname("nick6"));
        list.add(instance.getUserByNickname("nick7"));
        list.add(instance.getUserByNickname("nick4"));
        list.add(instance.getUserByNickname("nick3"));

        Iterable<User> expResult = list;
        Iterable<User> result = instance.findUsersWithinRelationshipDistance(nickname1, distance);
        assertEquals(expResult, result);

    }

    /**
     * Test of findUsersWithGreatestRelationshipDistance method, of class
     * ListOfUsers.
     */
    @Test
    public void testFindUsersWithGreatestRelationshipDistance() {
        System.out.println("findUsersWithGreatestRelationshipDistance");
        ListOfUsers instance = this.instance;
        LinkedList<User> list = new LinkedList<>();

        list.add(instance.getUserByNickname("nick0"));
        list.add(instance.getUserByNickname("nick5"));

        Iterable<User> expResult = list;
        Iterable<User> result = instance.findUsersWithGreatestRelationshipDistance();
        assertEquals(expResult, result);
    }

    /**
     * Test of removeFriend method, of class ListOfUsers.
     */
    @Test
    public void testgetCommonDirectVertices() {
        System.out.println("getCommonDirectVertices");
        String nickname1 = "nick4";
        String nickname2 = "nick7";
        ListOfUsers instance = this.instance;
        LinkedList<User> list = new LinkedList<>();

        instance.addFriend("nick7", "nick5");
        instance.addFriend("nick4", "nick3");
        instance.addFriend("nick7", "nick3");
        instance.addFriendToGraph();
        list.add(instance.getUserByNickname("nick5"));
        list.add(instance.getUserByNickname("nick3"));
        Iterable<User> expResult = list;
        Iterable<User> result = instance.findUsersWithFriendsInCommon(nickname1, nickname2);
        assertEquals(expResult, result);

    }

    /**
     * Test of removeFriend method, of class ListOfUsers.
     */
    @Test
    public void testgetMostInfluentialUser() {
        System.out.println("getMostInfluentialUser");

        ListOfUsers instance = this.instance;
        User expResult = instance.getUserByNickname("nick6");
        User result = instance.findMostInfluentialUser();
        assertEquals(expResult, result);
    }
//  
}
