/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class City {

    private String cityName;

    private long latitude;

    private long longitude;

    private int numberOfPointsAwarded;

    private User mayor;

    private static String DEFAULT_CITY_NAME = "No name";

    private static long DEFAULT_LATITUDE = 0;

    private static long DEFAULT_LONGITUDE = 0;

    private static int DEFAULT_NUMBER_OF_POINTS_AWARDED = 0;

    public City() {
        this.cityName = DEFAULT_CITY_NAME;
        this.latitude = DEFAULT_LATITUDE;
        this.longitude = DEFAULT_LONGITUDE;
        this.numberOfPointsAwarded = DEFAULT_NUMBER_OF_POINTS_AWARDED;
        this.mayor = new User();
    }

    public City(String cityName, long latitude, long longitude, int numberOfPointsAwarded) {
        this.cityName = cityName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.numberOfPointsAwarded = numberOfPointsAwarded;
        this.mayor = new User();
    }

    public String getCityName() {
        return cityName;
    }

    public long getLatitude() {
        return latitude;
    }

    public long getLongitude() {
        return longitude;
    }

    public int getNumberOfPointsAwarded() {
        return numberOfPointsAwarded;
    }

    public User getMayor() {
        return mayor;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public void setNumberOfPointsAwarded(int numberOfPointsAwarded) {
        this.numberOfPointsAwarded = numberOfPointsAwarded;
    }

    public void setMayor(User mayor) {
        this.mayor = mayor;
    }

    public boolean equals(Object otherObject) {

        if(this==otherObject)
        {
            return true;
        }
        City otherCity = (City)otherObject;
        return this.cityName.equals(otherCity.cityName) && this.latitude == otherCity.latitude && this.longitude == otherCity.longitude && this.numberOfPointsAwarded == otherCity.numberOfPointsAwarded && this.mayor.equals(otherCity.mayor);
    }

}
