/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;
import java.util.HashSet;
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
}
