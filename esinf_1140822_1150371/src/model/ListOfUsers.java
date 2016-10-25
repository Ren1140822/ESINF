/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Jose Silva <1150371@isep.ipp.pt>
 */
public class ListOfUsers {

    private Set<User> listOfUsers;
   
    public ListOfUsers() {
        listOfUsers = new HashSet<User>();
    }

    /**
     * @return the listOfUsers
     */
    public Set<User> getListOfUsers() {
        return listOfUsers;
    }

    /**
     * @param listOfUsers the listOfUsers to set
     */
    public void setListOfUsers(Set<User> listOfUsers) {
        this.listOfUsers = listOfUsers;
    }

    public User getUserByNickname(String nick) {
        for (User user : listOfUsers) {
            if (user.getNickname().equals(nick)) {
                return user;
            }
        }
        return null;
    }
}
