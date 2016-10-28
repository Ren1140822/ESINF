/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Jose Silva <1150371@isep.ipp.pt>
 */
public class ListOfUsers {

 

    private Set<User> userSet;

    /**
     *
     */
    public ListOfUsers() {
      
      
         userSet = new HashSet<>();
    }

    /**
     *
     * @return
     */
    public Set<User> getUserSet() {
        return userSet;
    }

    /**
     *
     * @param userSet
     */
    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }

    /**
     *
     * @param nick
     * @return
     */
    public User getUserByNickname(String nick) {
        for (User user : userSet) {
            if (user.getNickname().equals(nick)) {
                return user;
            }
        }
        return null;
    }

    /**
     *
     * @return
     */
    public User getMostInfluentUser(){
        User user1= (User)userSet.toArray()[0];
        for (User user : userSet) {
            if(user.getFriends().size()>user1.getFriends().size()){
                user1=user;
            }
        }
        return user1;
    }
}
