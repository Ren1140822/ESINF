/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Jose Silva <1150371@isep.ipp.pt>
 */
public class MainRegistry {

    private ListOfCities listOfCities;
    private ListOfUsers listOfUsers;

    public MainRegistry() {
        listOfCities = new ListOfCities();
        listOfUsers = new ListOfUsers();
    }

    /**
     * @return the ListOfCities
     */
    public ListOfCities getListOfCities() {
        return listOfCities;
    }

    /**
     * @param ListOfCities the ListOfCities to set
     */
    public void setListOfCities(ListOfCities ListOfCities) {
        this.listOfCities = ListOfCities;
    }

    /**
     * @return the listOfUsers
     */
    public ListOfUsers getListOfUsers() {
        return listOfUsers;
    }

    /**
     * @param listOfUsers the listOfUsers to set
     */
    public void setListOfUsers(ListOfUsers listOfUsers) {
        this.listOfUsers = listOfUsers;
    }

}
