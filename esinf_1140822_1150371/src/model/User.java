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
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class User implements Friendable {

    private String nickname;

    private String email;

    private String currentCity;

    private Set<User> friends;

    private int visitPoints;

    private static String DEFAULT_NICKNAME = "No nickname";

    private static String DEFAULT_EMAIL = "No email";

    private static String DEFAULT_CURRENT_CITY = "No current city";

    private static int DEFAULT_VISIT_POINTS = 0;

    public User() {
        this.nickname = DEFAULT_NICKNAME;
        this.email = DEFAULT_EMAIL;
        this.currentCity = DEFAULT_CURRENT_CITY;
        this.friends = new HashSet<User>();
        this.visitPoints = DEFAULT_VISIT_POINTS;

    }

    public User(String nickname, String email, String currentCity, Set<User> friends, int visitPoints) {
        this.nickname = nickname;
        this.email = email;
        this.currentCity = currentCity;
        this.friends = friends;
        this.visitPoints = visitPoints;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }

    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    public int getVisitPoints() {
        return visitPoints;
    }

    public void setVisitPoints(int visitPoints) {
        this.visitPoints = visitPoints;
    }

    public String getNickname() {
        return nickname;
    }

    public boolean equals(Object otherObject) {

        if (this == otherObject) {

            return true;
        }
        User otherUser = (User) otherObject;
        return this.getNickname().equals(otherUser.getNickname()) && this.currentCity.equals(otherUser.currentCity) && this.email.equals(otherUser.email) && this.friends.equals(otherUser.friends) && this.visitPoints == otherUser.visitPoints;
    }

    @Override
    public boolean addFriend(User user) {
        if(!friendExists(user)){
            this.friends.add(user);
            user.friends.add(this);
            return true;
        }
        return false;
    }

    @Override
    public boolean friendExists(User user) {
        for (User friend : friends) {
            if (friend.equals(user)) {
                return true;
            }
        }
        return false;
    }
}
