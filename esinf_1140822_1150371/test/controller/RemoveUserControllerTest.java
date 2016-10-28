/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.HashSet;
import java.util.LinkedList;
import model.MainRegistry;
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
public class RemoveUserControllerTest {
    MainRegistry r ;
    RemoveUserController instance;
    public RemoveUserControllerTest() {
        r= new MainRegistry();
        instance= new RemoveUserController(r);
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
     * Test of removeUser method, of class RemoveUserController.
     */
    @Test
    public void testRemoveUser() {
        System.out.println("removeUser");
        
        String nick = "user1";
        RemoveUserController instance =this.instance;
         r.addUser(nick, nick, nick, new HashSet(), new LinkedList(), 0);
        boolean expResult = true;
        boolean result = instance.removeUser(nick);
        assertEquals(expResult, result);
   
    }
    /**
     * Test of remove user method to fail.
     */
        @Test
    public void testRemoveUserFail() {
        System.out.println("removeUser");
        
        String nick = "user1";
        RemoveUserController instance =this.instance;
        
        boolean expResult = false;
        boolean result = instance.removeUser(nick);//cant find user, returns false
        assertEquals(expResult, result);
   
    }
    
}
