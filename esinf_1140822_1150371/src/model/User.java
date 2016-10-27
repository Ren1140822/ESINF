/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class User implements Friendable, Checkinable {

    private String nickname;

    private String email;

    private City currentCity;

    private Set<User> friends;

    private Set<City> citiesVisited;

    private int visitPoints;

    private static String DEFAULT_NICKNAME = "No nickname";

    private static String DEFAULT_EMAIL = "No email";

    private static int DEFAULT_VISIT_POINTS = 0;

    public User() {
        this.nickname = DEFAULT_NICKNAME;
        this.email = DEFAULT_EMAIL;

        this.friends = new HashSet<User>();

        this.citiesVisited = new HashSet<City>();
        this.visitPoints = DEFAULT_VISIT_POINTS;

    }

    public User(String nickname, String email, String currentCity, Set<User> friends, Set<City> citiesVisited, int visitPoints) {

        this.nickname = nickname;
        this.email = email;

        this.friends = friends;
        this.citiesVisited = citiesVisited;
        this.visitPoints = visitPoints;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public City getCurrentCity() {
        return (City) this.citiesVisited.toArray()[citiesVisited.size()-1];
    }

    public void setCurrentCity(City currentCity) {
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

    public Set<City> getCitiesVisited() {
        return citiesVisited;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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
        if (!friendExists(user)) {
            this.friends.add(user);
            user.friends.add(this);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeFriend(User user) {
        if (friendExists(user)) {
            this.friends.remove(user);
            user.friends.remove(this);
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

    
    @Override
    public boolean checkIn(City city) {
        if (!this.getCurrentCity().equals(city)) {
            this.visitPoints += city.getNumberOfPointsAwarded();
            if (city.getMayor().getVisitPoints() < this.visitPoints) {
                city.setMayor(this);
            }
            this.citiesVisited.add(city);
            return true;
        }
        return false;
    }

    public int getPoints() {
        int ret = 0;
        for (City citie : citiesVisited) {
            ret += citie.getNumberOfPointsAwarded();
        }
        return ret;
    }

    public Set<User> getFriendsByCity(String cityName, int numberOfResults) {

        Set<User> friends = new LinkedHashSet();
        long thisLatitude =  ((City)this.citiesVisited.toArray()[citiesVisited.size()-1]).getLatitude();
        long thisLongitude =  ((City)this.citiesVisited.toArray()[citiesVisited.size()-1]).getLongitude();
        Set<User> actualFriends = getFriends();
        Comparator<Long> comparator = new Comparator<Long>() {
            @Override
            public int compare(Long t, Long t1) {
                return (t > t1) ? 1 : t < t1 ? -1 : 0;
            }
        };

        Map<Long, User> mapNearbyUsers = new TreeMap<>(comparator);

        for (User friend : actualFriends) {
            if (friend.getCurrentCity().getCityName().equals(cityName)) {
                long otherLatitude = friend.getCurrentCity().getLatitude();
                long otherLongitude = friend.getCurrentCity().getLongitude();
                long differenceLatitude = Math.abs(thisLatitude - otherLatitude);
                long differenceLongitude = Math.abs(thisLongitude - otherLongitude);
                long sum = differenceLatitude + differenceLongitude;
                mapNearbyUsers.put(sum, friend);

            }
        }
        int index=0;
        for (User user : mapNearbyUsers.values()) {
            if(index>=numberOfResults)
            {
               break;
            }
               friends.add(user);
        }
        return friends;
    }

}
