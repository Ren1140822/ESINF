/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.FileNotFoundException;
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
import model.MainRegistry;

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
        String filePath = "D:\\Cities.txt";

        Set<City> expResult = new HashSet();
        expResult.add(new City("porto", 221, 2003.3321, 2));
        Set<City> result = InputOutput.readCityFromFile(filePath);
        boolean isEqual = false;
        for (City city : expResult) {
            for (City city2 : result) {
                isEqual = city.equals(city2);

            }
            if (!isEqual) {
                break;
            }
        }
        assertTrue(isEqual);

    }

    /**
     * Test of readUsersFromFile method, of class InputOutput.
     */
    @Test
    public void testReadUsersFromFile() throws Exception {
        System.out.println("readUsersFromFile");
        String cityPath = "D:\\cities10.txt";
        String filePath = "D:\\users10.txt";
        MainRegistry r = new MainRegistry();
        Set<City> cities = InputOutput.readCityFromFile(cityPath);
        ListOfCities listOfCities = new ListOfCities();
        listOfCities.setListOfCities(cities);
        r.setListOfCities(listOfCities);
        Set<User> expResult = new LinkedHashSet();
        expResult.add(nick0(r));
        expResult.add(nick1(r));
        expResult.add(nick2(r));
        expResult.add(nick3(r));
        expResult.add(nick4(r));
        Set<User> result=new LinkedHashSet();
        result = InputOutput.readUsersFromFile(filePath, r);
        boolean bool;
        for (User user : result) {
            if (user.equals(nick2(r))){
                
            }
        }
        assertEquals(expResult, result);

    }

    private User nick0(MainRegistry r) {
        List<City> cities = new LinkedList();
        cities.add(r.getListOfCities().getCityByName("city4"));
        cities.add(r.getListOfCities().getCityByName("city6"));
        Set<User> friends = new HashSet();
        friends.add(r.getListOfUsers().getUserByNickname("nick7"));
        friends.add(r.getListOfUsers().getUserByNickname("nick4"));
        friends.add(r.getListOfUsers().getUserByNickname("nick3"));
        User u = new User("nick0", "mail_0_@sapo.pt", null, friends, cities, 144);
        return u;
    }

    private User nick1(MainRegistry r) {
        List<City> cities = new LinkedList();
        cities.add(r.getListOfCities().getCityByName("city5"));
        cities.add(r.getListOfCities().getCityByName("city9"));
        cities.add(r.getListOfCities().getCityByName("city4"));
        Set<User> friends = new HashSet();
        friends.add(r.getListOfUsers().getUserByNickname("nick6"));
        friends.add(r.getListOfUsers().getUserByNickname("nick2"));
        friends.add(r.getListOfUsers().getUserByNickname("nick8"));
        User u = new User("nick1", "mail_1_@sapo.pt", null, friends, cities, 0);
        u.setVisitPoints(203);
        return u;
    }

    private User nick2(MainRegistry r) {
        List<City> cities = new LinkedList();

        cities.add(r.getListOfCities().getCityByName("city0"));
          cities.add(r.getListOfCities().getCityByName("city2"));
        Set<User> friends = new HashSet();
        friends.add(r.getListOfUsers().getUserByNickname("nick6"));
        friends.add(r.getListOfUsers().getUserByNickname("nick7"));
        friends.add(r.getListOfUsers().getUserByNickname("nick8"));
        friends.add(r.getListOfUsers().getUserByNickname("nick1"));
        User u = new User("nick2", "mail_2_@sapo.pt", null, friends, cities, 0);
        u.setVisitPoints(109);
        return u;
    }

    private User nick3(MainRegistry r) {
        List<City> cities = new LinkedList();
        cities.add(r.getListOfCities().getCityByName("city8"));
        Set<User> friends = new HashSet();
        friends.add(r.getListOfUsers().getUserByNickname("nick0"));
        friends.add(r.getListOfUsers().getUserByNickname("nick8"));
        friends.add(r.getListOfUsers().getUserByNickname("nick7"));
        friends.add(r.getListOfUsers().getUserByNickname("nick6"));
        friends.add(r.getListOfUsers().getUserByNickname("nick5"));
        User u = new User("nick3", "mail_3_@sapo.pt", null, friends, cities, 0);
        u.setVisitPoints(7);
        return u;
    }

    private User nick4(MainRegistry r) {
        List<City> cities = new LinkedList();
        cities.add(r.getListOfCities().getCityByName("city6"));
        cities.add(r.getListOfCities().getCityByName("city8"));
        Set<User> friends = new HashSet();
        friends.add(r.getListOfUsers().getUserByNickname("nick9"));
        friends.add(r.getListOfUsers().getUserByNickname("nick0"));
        User u = new User("nick4", "mail_4_@sapo.pt", null, friends, cities, 0);
        u.setVisitPoints(87);
        return u;
    }

}
