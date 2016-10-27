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
public class User {

    /**
     * @return the nickname
     */
    public String getNickname() {
        return nickname;
    }

    private String nickname;

    private String email;

    private String currentCity;

    private Set<User> friends;

    private int visitPoints;

    private static String DEFAULT_NICKNAME = "No nickname";

    private static String DEFAULT_EMAIL = "No email";

    private static String DEFAULT_CURRENT_CITY = "No current city";

    private static int DEFAULT_VISIT_POINTS = 0;

    private static Set<City> cities;

    public User() {
        this.nickname = DEFAULT_NICKNAME;
        this.email = DEFAULT_EMAIL;
        this.currentCity = DEFAULT_CURRENT_CITY;
        this.friends = new HashSet<User>();
        this.visitPoints = DEFAULT_VISIT_POINTS;

    }

    public User(String nickname, String email, Set<User> friends, Set<City> cities) {
        this.nickname = nickname;
        this.email = email;
        Object[] citiess = cities.toArray();
        this.currentCity = citiess[0].toString();
        this.friends = friends;
        this.cities = cities;
        this.visitPoints = citiess.length;
    }

    public boolean equals(Object otherObject) {

        if (this == otherObject) {

            return true;
        }
        User otherUser = (User) otherObject;
        return this.getNickname().equals(otherUser.getNickname()) && this.currentCity.equals(otherUser.currentCity) && this.getEmail().equals(otherUser.getEmail()) && this.friends.equals(otherUser.friends) && this.visitPoints == otherUser.visitPoints;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    public int getPoints() {
        int ret = 0;
        for (City citie : cities) {
            ret += citie.getNumberOfPointsAwarded();
        }
        return ret;
    }

    public String getCurrentCity() {
        return this.currentCity;
    }

    public int getFriendsByCity(String cityName) {
        int count = 0;
        for (User friend : friends) {

            if (friend.getCurrentCity().equals(cityName)) {
                count++;
            }
        }
        return count;
    }
}
