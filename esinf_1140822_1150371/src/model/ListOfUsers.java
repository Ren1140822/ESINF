/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Jose Silva <1150371@isep.ipp.pt>
 */
public class ListOfUsers {

 

    private Set<User> userSet;

    /**
     *Builds instance of this class.
     */
    public ListOfUsers() {
         userSet = new HashSet<>();
    }

    /**
     *Gets the set of users.
     * @return a set containing all users
     */
    public Set<User> getUserSet() {
        return userSet;
    }

    /**
     *Sets the set of users.
     * @param userSet the user set
     */
    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }

    /**
     *Gets user object by nickname.
     * @param nick the user nickname
     * @return the user if found
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
     *Gets most influent users
     * @return the list of most influent users
     */
    public List<User> getMostInfluentUsers(int numberOfResults){
         Comparator<User> comparator = new Comparator<User>() {
            @Override
            public int compare(User t, User t1) {
                return (t.getFriends().size() > t1.getFriends().size()) ? -1 : t.getFriends().size() < t1.getFriends().size()?1:0;
            }
        };
       List<User> usersList = new LinkedList();
        for (User user : userSet) {
            usersList.add(user);
        }
        Collections.sort(usersList,comparator);
          List<User> limitedUsersList  = new LinkedList();
          for (int i = 0; i <  numberOfResults+1; i++) {
            limitedUsersList.add(usersList.get(i));
        }
        return limitedUsersList;
    }
}
