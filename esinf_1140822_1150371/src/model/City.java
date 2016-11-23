/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class City {

    private String cityName;

    private double latitude;

    private  double longitude;

    private int numberOfPointsAwarded;

    private User mayor;
    
    private Map<User,Integer> userPointsMap;

    private static String DEFAULT_CITY_NAME = "No name";

    private static long DEFAULT_LATITUDE = 0;

    private static long DEFAULT_LONGITUDE = 0;

    private static int DEFAULT_NUMBER_OF_POINTS_AWARDED = 0;

    /**
     *Default constructor.
     */
    public City() {
        this.cityName = DEFAULT_CITY_NAME;
        this.latitude = DEFAULT_LATITUDE;
        this.longitude = DEFAULT_LONGITUDE;
        this.numberOfPointsAwarded = DEFAULT_NUMBER_OF_POINTS_AWARDED;
        this.mayor = new User();
    }

    /**
     *City constructor.
     * @param cityName the city name
     * @param numberOfPointsAwarded number of points city awards
     * @param latitude city latitude
     * @param longitude city longitude
     */
    public City(String cityName,  int numberOfPointsAwarded, double latitude,  double longitude) {
        this.cityName = cityName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.numberOfPointsAwarded = numberOfPointsAwarded;
        this.mayor = new User();
        userPointsMap  = new HashMap();
    }

    /**
     *gets city name
     * @return the city name
     */
    public String getCityName() {
        return cityName;
    }

    /**
     *gets city latitude.
     * @return the city latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     *gets city longitude.
     * @return the city longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     *gets number of points this city awards.
     * @return the number of points
     */
    public int getNumberOfPointsAwarded() {
        return numberOfPointsAwarded;
    }

    /**
     *Gets the city mayor.
     * @return this city mayor
     */
    public User getMayor() {
        return mayor;
    }

    /**
     *Sets city name.
     * @param cityName the city new name
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     *sets city latitude
     * @param latitude the latitude
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     *sets city longitude
     * @param longitude the longitude
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     *sets number of points awarded
     * @param numberOfPointsAwarded the number of points
     */
    public void setNumberOfPointsAwarded(int numberOfPointsAwarded) {
        this.numberOfPointsAwarded = numberOfPointsAwarded;
    }

    /**
     *sets city mayor
     * @param mayor the city mayor
     */
    public void setMayor(User mayor) {
        this.mayor = mayor;
    }

    /**
     *sees if two cities are equal
     * @param otherObject the other city
     * @return true if equal, false otherwise
     */
    public boolean equals(Object otherObject) {

        if (this ==null  || (getClass() != otherObject.getClass())) {

            return false;
        }
        City otherCity = (City)otherObject;
        return this.getCityName().equals(otherCity.getCityName()) && this.latitude == otherCity.latitude && this.longitude == otherCity.longitude && this.numberOfPointsAwarded == otherCity.numberOfPointsAwarded && this.getMayor().equals(otherCity.getMayor());
    }
    
    /**
     *Returns a description of this object in a string
     * @return the description
     */
    public String toString(){
        return this.cityName+" "+ this.latitude+" "+ this.longitude +" "+ this.mayor.toString() +" "+this.numberOfPointsAwarded;
    }

        @Override
    public int hashCode() {
        return Objects.hash(cityName,longitude,latitude,mayor,numberOfPointsAwarded);
    }
    
    /**
     * Updates mayor
     * @param u
     * @return 
     */
    public boolean updateMayor(User u){
        for (User usr : userPointsMap.keySet()) {
            if(usr.equals(u)){
                if(userPointsMap.get(u).intValue()>userPointsMap.get(mayor).intValue()){
                    this.mayor = u;
                    return true;
                }
            }
        }
        return false;
    }
}
