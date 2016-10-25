/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Set;
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

    public AddUserController(MainRegistry r, ListOfUsers listOfUsers) {
        this.r = r;
        this.listOfUsers = listOfUsers;
    }

    public boolean AddUser(String nickname, String email, String currentCity, Set<User> friends, int visitPoints) {
        if (verifyData(nickname, email)) {
            listOfUsers.getListOfUsers().add(new User(nickname, email, currentCity, friends, visitPoints));
            return true;
        }
        return false;
    }

    private boolean verifyData(String nickname, String email) {
        Set<User> listOfUserss = listOfUsers.getListOfUsers();
        for (User user : listOfUserss) {
            if (user.getNickname().equals(nickname) || user.getEmail().equals(email)) {
                return false;
            }
        }
        return true;
    }
}
