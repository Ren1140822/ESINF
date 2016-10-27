/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Jose Silva <1150371@isep.ipp.pt>
 */
public class ListOfCities {

    private Set<City> listOfCities;

    public ListOfCities() {
        listOfCities = new HashSet<City>();
    }
    
    public City getCityByName(String cityName){
        for (City city : listOfCities) {
            if(city.getCityName().equals(cityName)){
                return city;
            }
        }
        return null;
    }
    
    public City getCityByUser(User user)
    {
        for (City city : listOfCities) {
            if(city.getMayor().equals(user))
            {
                return city;
            }
        }
        return null;
    }

    public Set<City> getListOfCities() {
        return listOfCities;
    }
    
    public Map<City,User> getMapOfCitiesAndMayorsByDescOrder()
    {
         Map<City,User> mapOfCitiesAndMayorsByDescOrderMap = new LinkedHashMap();
         ArrayList<User> usersList = new ArrayList();
         for (City city : listOfCities) {
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
            mapOfCitiesAndMayorsByDescOrderMap.put(getCityByUser(user), user);
        }
         return mapOfCitiesAndMayorsByDescOrderMap;
    }
}
