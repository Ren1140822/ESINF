/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
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

    private List<City> citiesVisited;

    private int visitPoints;

    private static String DEFAULT_NICKNAME = "No nickname";

    private static String DEFAULT_EMAIL = "No email";

    private static int DEFAULT_VISIT_POINTS = 0;

    /**
     *
     */
    public User() {
        this.nickname = DEFAULT_NICKNAME;
        this.email = DEFAULT_EMAIL;
        this.friends = new HashSet<User>();
        this.citiesVisited = new LinkedList<City>();
        this.visitPoints = DEFAULT_VISIT_POINTS;

    }

    /**
     *
     * @param nickname the users nickname
     * @param email        the users email
     * @param currentCity   the users current city
     * @param friends   the users friends
     * @param citiesVisited the cities visited
     * @param visitPoints   visit points
     */
    public User(String nickname, String email, String currentCity, Set<User> friends, List<City> citiesVisited, int visitPoints) {
        this.nickname = nickname;
        this.email = email;
        this.friends = friends;
        this.citiesVisited = citiesVisited;
        this.visitPoints = visitPoints;

    }

    /**Gets user email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**Sets the users email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *Gets users current city
     * @return the current city if there's any null otherwise
     */
    public City getCurrentCity() {
        if (citiesVisited.size() > 0) {
            City city = (City) this.citiesVisited.toArray()[citiesVisited.size() - 1];
            return city;
        }
        return null;
    }

    /**
     *Sets the current city.
     * @param currentCity the current city
     */
    public void setCurrentCity(City currentCity) {
        this.currentCity = currentCity;
    }

    /**
     *Gets the user's friends.
     * @return a set with users
     */
    public Set<User> getFriends() {
        return friends;
    }

    /**
     *Sets the users friends.
     * @param friends a set of users
     */
    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    /**
     *Gets visit points.
     * @return the users visit points
     */
    public int getVisitPoints() {
        return visitPoints;
    }

    /**
     *Sets the visit points.
     * @param visitPoints the visit points
     */
    public void setVisitPoints(int visitPoints) {
        this.visitPoints = visitPoints;
    }

    /**
     *Gets user nickname.
     * @return the users nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     *Gets cities visited by the user.
     * @return a list of cities visited
     */
    public List<City> getCitiesVisited() {
        return citiesVisited;
    }

    /**
     *Sets user nickname
     * @param nickname the users nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     *Sees if this object is equal as another one.
     * @param otherObject the object to compare
     * @return true if they're equal
     */
    public boolean equals(Object otherObject) {

        if (this == null || (getClass() != otherObject.getClass())) {

            return false;
        }
        User otherUser = (User) otherObject;
        boolean ret = this.getNickname().equals(otherUser.getNickname()) && this.getEmail().equals(otherUser.getEmail()) && this.getFriends().equals(otherUser.getFriends()) && this.getVisitPoints() == otherUser.getVisitPoints();
        if (this.citiesVisited.size() > 0 && otherUser.citiesVisited.size() > 0 && ret == true) {
            ret = this.getCurrentCity().equals(otherUser.getCurrentCity());
        }
        return ret;
    }

    /**
     *Adds a friend to this user.
     * @param user the user to add
     * @return true if added sucessfully
     */
    @Override
    public boolean addFriend(User user) {
        if (!friendExists(user)) {
            this.friends.add(user);
            user.friends.add(this);
            return true;
        }
        return false;
    }

    /**
     *Removes a friend of this user.
     * @param user the user to remove
     * @return true if removed sucessfully
     */
    @Override
    public boolean removeFriend(User user) {
        if (friendExists(user)) {
            this.friends.remove(user);
            user.friends.remove(this);
            return true;
        }
        return false;
    }

    /**
     *Sees if friend exists on this users list.
     * @param user the friend to check for
     * @return true if exists
     */
    @Override
    public boolean friendExists(User user) {
        for (User friend : friends) {
            if (friend.equals(user)) {
                return true;
            }
        }
        return false;
    }

    /**
     *Checks in a city, interface implementation.
     * @param city the city to check in for
     * @return true if checked in sucessfully false otherwise.
     */
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



//    /**
//     *
//     * @param cityName
//     * @param numberOfResults
//     * @return
//     */
//    public Set<User> getFriendsByCity(String cityName, int numberOfResults) {
//
//        Set<User> friends = new LinkedHashSet();
//        double thisLatitude = this.getCurrentCity().getLatitude();
//        double thisLongitude = this.getCurrentCity().getLongitude();
//
//        Set<User> actualFriends = getFriends();
//        Comparator<Double> comparator = new Comparator<Double>() {
//            @Override
//            public int compare(Double t, Double t1) {
//                return (t > t1) ? 1 : t < t1 ? -1 : 0;
//            }
//        };
//
//        Map<Double, User> mapNearbyUsers = new TreeMap<>(comparator);
//
//        for (User friend : actualFriends) {
//            if (friend.getCurrentCity().getCityName().equals(cityName)) {
//                double otherLatitude = friend.getCurrentCity().getLatitude();
//                double otherLongitude = friend.getCurrentCity().getLongitude();
//                double differenceLatitude = Math.abs(thisLatitude - otherLatitude);
//                double differenceLongitude = Math.abs(thisLongitude - otherLongitude);
//                double sum = differenceLatitude + differenceLongitude;
//                mapNearbyUsers.put(sum, friend);
//
//            }
//        }
//        int index = 0;
//        for (User user : mapNearbyUsers.values()) {
//            if (index >= numberOfResults) {
//                break;
//            }
//            friends.add(user);
//        }
//        return friends;
//    }

    /**
     *Gets user's friends by city object.
     * @param city the city to check
     * @return the list of friends
     */
    public Set<User> getFriendsByCity(City city) {
        Set<User> friendsNearby = new HashSet();
        for (User friend : friends) {
            if (friend.getCurrentCity() != null) {
                if (friend.getCurrentCity().equals(city)) {
                    friendsNearby.add(friend);
                }
            }
        }
        return friendsNearby;
    }

   /**
     *Gets user's friends by city name.
     * @param cityName the city name to check
     * @return the list of friends
     */
    public Set<User> getFriendsByCity(String cityName) {
        Set<User> friendsNearby = new HashSet();
        for (User friend : friends) {
            if (friend.getCurrentCity() != null) {
                if (friend.getCurrentCity().getCityName().equals(cityName)) {
                    friendsNearby.add(friend);
                }
            }
        }
        return friendsNearby;
    }

    /**
     *Gets user's friends by coordinated.
     * @param latitude the latitude
     * @param longitude the longitude
     * @return the user's friends
     */
    public Set<User> getFriendsByCity(double latitude, double longitude) {
        Set<User> friendsNearby = new HashSet();
        for (User friend : friends) {
            if (friend.getCurrentCity() != null) {
                if (friend.getCurrentCity().getLatitude() == latitude && friend.getCurrentCity().getLongitude() == longitude) {
                    friendsNearby.add(friend);
                }
            }
        }
        return friendsNearby;
    }

}
