/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Map;
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

    public AddUserController(MainRegistry r) {
        this.r = r;
        this.listOfUsers = r.getListOfUsers();
    }

    public boolean AddUser(String nickname, String email, String currentCity, Set<User> friends, int visitPoints) {
        if (verifyData(nickname, email)) {
            listOfUsers.getMapOfUsers().put(new User(nickname, email, currentCity, friends, visitPoints),new City());
            return true;
        }
        return false;
    }

    private boolean verifyData(String nickname, String email) {
       Map<User,City> listOfUserss = listOfUsers.getMapOfUsers();
        for (User user : listOfUserss.keySet()) {
            if (user.getNickname().equals(nickname) || user.getEmail().equals(email)) {
                return false;
            }
        }
        return true;
    }
}
