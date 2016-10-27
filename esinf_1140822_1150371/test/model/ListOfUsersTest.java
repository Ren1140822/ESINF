/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashSet;
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
public class ListOfUsersTest {
    MainRegistry r;
    ListOfUsers instance;
    public ListOfUsersTest() {
        r = new MainRegistry();
        instance = r.getListOfUsers();
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
     * Test of getUserSet method, of class ListOfUsers.
     */
    @Test
    public void testGetUserSet() {
        System.out.println("getUserSet");
        Set<User> userSet = new HashSet();
        ListOfUsers instance = this.instance;
        instance.setUserSet(userSet);
        Set<User> expResult =  userSet;
        Set<User> result = instance.getUserSet();
        assertEquals(expResult, result);
     
    }

    /**
     * Test of setUserSet method, of class ListOfUsers.
     */
    @Test
    public void testSetUserSet() {
        System.out.println("setUserSet");
      Set<User> userSet = new HashSet();
        ListOfUsers instance = this.instance;
        instance.setUserSet(userSet);
        boolean isSet = instance.getUserSet()!=null;
        assertEquals(isSet, true);
    }

    /**
     * Test of getUserByNickname method, of class ListOfUsers.
     */
    @Test
    public void testGetUserByNickname() {
        System.out.println("getUserByNickname");
        User u = new User();
        String nick = "No nickname";
        ListOfUsers instance = this.instance;
        instance.getUserSet().add(u);
        User expResult = u;
        User result = instance.getUserByNickname(nick);
        assertEquals(expResult, result);
      
    }
    
}
