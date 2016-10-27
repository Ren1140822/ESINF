/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
    @Test
    public void testGetNickname() {
        System.out.println("getNickname");
        User instance = new User();
        String expResult = "";
        String result = instance.getNickname();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of equals method, of class User.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object otherObject = null;
        User instance = new User();
        boolean expResult = false;
        boolean result = instance.equals(otherObject);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getEmail method, of class User.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        User instance = new User();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getPoints method, of class User.
     */
    @Test
    public void testGetPoints() {
        System.out.println("getPoints");
        User instance = new User();
        int expResult = 0;
        int result = instance.getPoints();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of getCurrentCity method, of class User.
     */
    @Test
    public void testGetCurrentCity() {
        System.out.println("getCurrentCity");
        User instance = new User();
        String expResult = "";
        String result = instance.getCurrentCity();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getFriendsByCity method, of class User.
     */
    @Test
    public void testGetFriendsByCity() {
        System.out.println("getFriendsByCity");
        String cityName = "";
        User instance = new User();
        int expResult = 0;
        int result = instance.getFriendsByCity(cityName);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getFriends method, of class User.
     */
    @Test
    public void testGetFriends() {
        System.out.println("getFriends");
        User instance = new User();
        Set<User> expResult = null;
        Set<User> result = instance.getFriends();
        assertEquals(expResult, result);
       
    }
    
}
