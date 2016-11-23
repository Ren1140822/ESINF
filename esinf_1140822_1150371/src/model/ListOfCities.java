/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Jose Silva <1150371@isep.ipp.pt>
 */
public class ListOfCities {
    private Map<String,City> listOfCities;


    /**
     *builds instance of this class.
     */
    public ListOfCities() {
        listOfCities = new HashMap<String,City>();
    }
    
    /**
     *Gets city by city name.
     * @param cityName the city name
     * @return the city if it exists
     */
    public City getCityByName(String cityName){
        for (City city : listOfCities.values()) {
            if(city.getCityName().equals(cityName)){
                return city;
            }
        }
        return null;
    }
    
    public City getCityByCoordinates(double lat,double lon){
        for (City c : listOfCities.values()) {
            if(c.getLatitude()==lat&&c.getLongitude() == lon){
                return c;
            }
        }
        return null;
    }
    
    /**
     *Gets city by username if mayor.
     * @param user the username
     * @return the city if found
     */
    public City getCityByUser(String nick)
    {
        for (City city : listOfCities.values()) {
            if(city.getMayor().getNickname().equals(nick))
            {
                return city;
            }
        }
        return null;
    }

    /**
     *Gets list of cities.
     * @return the list of cities
     */
    public Map<String,City> getListOfCities() {
        return listOfCities;
    }

    /**
     *Sets list of cities.
     * @param listOfCities the list of sities
     */
    public void setListOfCities(Map<String, City> listOfCities) {
        this.listOfCities = listOfCities;
    }
    
    /**
     *Gets a map of cities and mayors with most visit points by descending order.
     * @return a map containing these informations
     */
    public Map<City,User> getMapOfCitiesAndMayorsByDescOrder()
    {
         Map<City,User> mapOfCitiesAndMayorsByDescOrderMap = new LinkedHashMap();
         ArrayList<User> usersList = new ArrayList();
         for (City city : listOfCities.values()) {
            usersList.add(city.getMayor());
            
        }
         Comparator<User> comparator = new Comparator<User>() {
             @Override
             public int compare(User t, User t1) {
                return (t.getVisitPoints()>t1.getVisitPoints())?-1:t.getVisitPoints()<t1.getVisitPoints()?1:0;
             }
         };
         Collections.sort(usersList, comparator);
         for (User user : usersList) {
            mapOfCitiesAndMayorsByDescOrderMap.put(getCityByUser(user.getNickname()), user);
        }
         return mapOfCitiesAndMayorsByDescOrderMap;
    }
     @Override
    public boolean equals(Object l2){
       ListOfCities aux=(ListOfCities)l2;
        if(this==l2){
            return true;
        }
        for (City city : this.getListOfCities().values()) {
            for (City city2 : aux.getListOfCities().values()) {
                if(!city.equals(city2)){
                    return false;
                }
            }
        }
        return true;
    }
    
    
}
