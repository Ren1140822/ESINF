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

 
    private Map<User,City> usersMap;
    public ListOfUsers() {
      
         usersMap = new HashMap<>();
    }

    /**
     * @return the listOfUsers
     */
    public Map<User,City> getMapOfUsers() {
     
        return usersMap;
    }

    public void setUsersMap(Map<User, City> usersMap) {
        this.usersMap = usersMap;
    }


    public User getUserByNickname(String nick) {
        for (User user : usersMap.keySet()) {
            if (user.getNickname().equals(nick)) {
                return user;
            }
        }
        return null;
    }
}
