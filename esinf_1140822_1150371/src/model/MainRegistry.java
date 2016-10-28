/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.AddUserController;
import controller.RemoveUserController;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Jose Silva <1150371@isep.ipp.pt>
 */
public class MainRegistry {

    private ListOfCities listOfCities;
    private ListOfUsers listOfUsers;

    /**
     *Creates instance of this class.
     */
    public MainRegistry() {
        listOfCities = new ListOfCities();
        listOfUsers = new ListOfUsers();
    }

    /**Gets the list of cities class reference
     * @return the ListOfCities
     */
    public ListOfCities getListOfCities() {
        return listOfCities;
    }

    /**Sets the list of cities class reference.
     * @param ListOfCities the ListOfCities to set
     */
    public void setListOfCities(ListOfCities ListOfCities) {
        this.listOfCities = ListOfCities;
    }

    /**Gets the list of users class reference.
     * @return the listOfUsers
     */
    public ListOfUsers getListOfUsers() {
        return listOfUsers;
    }

    /**Sets the list of users class reference.
     * @param listOfUsers the listOfUsers to set
     */
    public void setListOfUsers(ListOfUsers listOfUsers) {
        this.listOfUsers = listOfUsers;
    }

    /**
     * Testing purposes for junit implementations.
     * @param nickname
     * @param email
     * @param currentCity
     * @param friends
     * @param cities
     * @param visitPoints
     * @return 
     */
    public boolean addUser(String nickname, String email, String currentCity, Set<User> friends,List<City>cities, int visitPoints) {

        AddUserController controller = new AddUserController(this);
        return controller.AddUser(nickname, email, currentCity, friends,cities, visitPoints);

     
    }
  /**
     * Testing purposes.
     * @param nickname
     * @return 
     */
    public boolean removeUser(String nickname) {
        RemoveUserController controller = new RemoveUserController(this);
        return controller.removeUser(nickname);
    }

}
