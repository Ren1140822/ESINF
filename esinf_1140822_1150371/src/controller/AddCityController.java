/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.City;
import model.ListOfCities;
import model.SocialNetwork;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class AddCityController {
    
     SocialNetwork r;
    ListOfCities listOfCities;

    /**
     *This class constructor
     * @param r the main registry
     */
    public AddCityController(SocialNetwork r)
    {
        this.r=r;
        this.listOfCities = r.getListOfCities();
        
    }
    
    /**
     *adds a city to the list
     * @param cityName the city name
     * @param latitude the city latitude
     * @param longitude the city longitude
     * @param nrPoints the city nr of points
     * @return
     */
    public boolean addCity(String cityName,long latitude,long longitude,int nrPoints)
    {
        if(verifyData(cityName,nrPoints))
        {
            listOfCities.getListOfCities().put(cityName,new City(cityName,nrPoints,latitude,longitude));
            return true;
        }
        return false;
    }
    
    /**
     * Verifies the integrity of city data
     * @param cityName the city name
     * @param nrPoints the number of points
     * @return true if all OK
     */
    private boolean verifyData(String cityName,int nrPoints)
    {
        for (City city : listOfCities.getListOfCities().values()) {
            if(city.getCityName().equals(cityName)||nrPoints<0)
            {
                return false;
            }
        }
        return true;
    }
    
}
