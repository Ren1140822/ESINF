/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import java.util.Set;
import model.City;
import model.ListOfUsers;
import model.MainRegistry;
import model.User;

/**
 *
 * @author Jose Silva <1150371@isep.ipp.pt>
 */
public class AddUserController {

    MainRegistry r;
    ListOfUsers listOfUsers;

    /**
     *this class constructor
     * @param r the main registry
     */
    public AddUserController(MainRegistry r) {
        this.r = r;
        this.listOfUsers = r.getListOfUsers();
    }

    /**
     *Adds a new user.
     * @param nickname the users nickname
     * @param email the users email
     * @param currentCity the users current city
     * @param friends the users friend 
     * @param cities the users visited city list
     * @param visitPoints the users current points
     * @return
     */
    public boolean AddUser(String nickname, String email, String currentCity, Set<User> friends,List<City> cities, int visitPoints) {

        if (verifyData(nickname, email)) {
            listOfUsers.getUserSet().add(new User(nickname, email, currentCity, friends, cities, visitPoints));
            return true;
        }
        return false;
    }

    /**
     * Verifies user data integrity.
     * @param nickname the users nickname
     * @param email the users email
     * @return true if all validated
     */
    private boolean verifyData(String nickname, String email) {
        Set<User> listOfUserss = listOfUsers.getUserSet();
        for (User user : listOfUserss) {
            if (user.getNickname().equals(nickname) || user.getEmail().equals(email)) {
                return false;
            }
        }
        return true;
    }
}
