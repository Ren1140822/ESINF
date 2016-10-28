/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import model.City;
import model.MainRegistry;
import model.User;
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
public class AddUserControllerTest {
    MainRegistry r;
    AddUserController instance;
    public AddUserControllerTest() {
        r = new MainRegistry();
        instance = new AddUserController(r);
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
     * Test of AddUser method, of class AddUserController.
     */
    @Test
    public void testAddUser() {
        System.out.println("AddUser");
        String nickname = "Renato";
        String email = "something@something";
        String currentCity = "porto";
        Set<User> friends = new HashSet();
       List<City> cities =  new LinkedList();
        int visitPoints = 0;
        AddUserController instance = this.instance;
        boolean expResult =true;
        boolean result = instance.AddUser(nickname, email, currentCity, friends, cities, visitPoints);
        assertEquals(expResult, result);
        
    }
        /**
     * Test of AddUser method, of class AddUserController.
     */
    @Test
    public void testAddUserFail() {
        System.out.println("AddUser");
        String nickname = "Renato";
        String email = "something@something";
        String currentCity = "porto";
        Set<User> friends = new HashSet();
            List<City> cities =  new LinkedList();
        int visitPoints = 0;
        AddUserController instance = this.instance;
        boolean expResult =false;
        boolean result = instance.AddUser(nickname, email, currentCity, friends, cities, visitPoints);//adds same user twice
        result = instance.AddUser(nickname, email, currentCity, friends, cities, visitPoints);
        assertEquals(expResult, result);
        
    }
    
}
