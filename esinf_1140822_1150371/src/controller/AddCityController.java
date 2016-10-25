/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.City;
import model.ListOfCities;
import model.MainRegistry;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class AddCityController {
    
     MainRegistry r;
    ListOfCities listOfCities;
    public AddCityController(MainRegistry r)
    {
        this.r=r;
        this.listOfCities = r.getListOfCities();
        
    }
    
    public boolean addCity(String cityName,long latitude,long longitude,int nrPoints)
    {
        if(verifyData(cityName,nrPoints))
        {
            listOfCities.getListOfCities().add(new City(cityName,latitude,longitude,nrPoints));
            return true;
        }
        return false;
    }
    
    private boolean verifyData(String cityName,int nrPoints)
    {
        for (City city : listOfCities.getListOfCities()) {
            if(city.getCityName().equals(cityName)||nrPoints<0)
            {
                return false;
            }
        }
        return true;
    }
    
}
