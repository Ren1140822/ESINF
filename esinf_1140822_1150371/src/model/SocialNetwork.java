/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.AddCityController;
import controller.AddUserController;
import controller.RemoveUserController;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Jose Silva <1150371@isep.ipp.pt>
 */
public class SocialNetwork implements Checkinable {

    private ListOfCities listOfCities;
    private ListOfUsers listOfUsers;

    /**
     * Creates instance of this class.
     */
    public SocialNetwork() {
        listOfCities = new ListOfCities();
        listOfUsers = new ListOfUsers();
    }

    /**
     * Gets the list of cities class reference
     *
     * @return the ListOfCities
     */
    public ListOfCities getListOfCities() {
        return listOfCities;
    }

    /**
     * Sets the list of cities class reference.
     *
     * @param ListOfCities the ListOfCities to set
     */
    public void setListOfCities(ListOfCities ListOfCities) {
        this.listOfCities = ListOfCities;
    }

    /**
     * Gets the list of users class reference.
     *
     * @return the listOfUsers
     */
    public ListOfUsers getListOfUsers() {
        return listOfUsers;
    }

    /**
     * Sets the list of users class reference.
     *
     * @param listOfUsers the listOfUsers to set
     */
    public void setListOfUsers(ListOfUsers listOfUsers) {
        this.listOfUsers = listOfUsers;
    }

    /**
     * Testing purposes for junit implementations.
     *
     * @param nickname
     * @param email
     * @param currentCity
     * @param friends
     * @param cities
     * @param visitPoints
     * @return
     */
    public boolean addUser(String nickname, String email, String currentCity,List<City> cities, int visitPoints) {

        AddUserController controller = new AddUserController(this);
        return controller.AddUser(nickname, email, currentCity,  cities, visitPoints);

    }

    /**
     * Testing purposes.
     *
     * @param nickname
     * @return
     */
    public boolean removeUser(String nickname) {
        RemoveUserController controller = new RemoveUserController(this);
        return controller.removeUser(nickname);
    }

    /**
     * Testing purposes - Adds a new city
     *
     * @param cityName the name of the city
     * @param numberOfPointsAwarded points awarded for checking in
     * @param latitude latitude of the city
     * @param longitude longitude of the city
     * @return
     */
    public boolean addCity(String cityName, int numberOfPointsAwarded, double latitude, double longitude) {
        AddCityController citiesController = new AddCityController(this);
        return citiesController.addCity(cityName, numberOfPointsAwarded, numberOfPointsAwarded, numberOfPointsAwarded);

    }

    @Override
    public boolean checkIn(String user, String city) {
        City c = listOfCities.getCityByName(city);
        User u = (listOfUsers.getUserByNickname(user));
        if (u != null && c != null) {
            if (u.checkIn(c)) {
                return c.updateMayor(u);
            }
        }
        return false;
    }

    /**
     * Gets user's friends by city object.
     *
     * @param city the city to check
     * @return the list of friends
     */
    public Map<String, User> getFriendsByCity(String nickname, String cityName) {
        Map<String, User> friendsNearby = new HashMap();
        Set<User> usersFriends = listOfUsers.getFriendsMap().get(listOfUsers.getUserByNickname(nickname));
        if (usersFriends != null) {
            for (User u : usersFriends) {
                if (u.getCurrentCity() != null) {
                    if (u.getCurrentCity().equals(listOfCities.getCityByName(cityName))) {
                        friendsNearby.put(nickname, u);
                    }
                }
            }
            return friendsNearby;
        }
        return null;
    }

    /**
     * Gets user's friends by coordinated.
     *
     * @param latitude the latitude
     * @param longitude the longitude
     * @return the user's friends
     */
    public Map<String,User> getFriendsByCity(String nickname,double latitude, double longitude) {
        Map<String, User> friendsNearby = new HashMap();
        Set<User> usersFriends = listOfUsers.getFriendsMap().get(listOfUsers.getUserByNickname(nickname));
        if (usersFriends != null) {
            for (User u : usersFriends) {
                  City c = (listOfCities.getCityByCoordinates(latitude,longitude));
                if (u.getCurrentCity() != null&& c!=null) {
                  
                    if (u.getCurrentCity().equals(c)) 
                    {
                        friendsNearby.put(nickname, u);
                    }
                }
            }
            return friendsNearby;
        }
        return null;
    }
}
