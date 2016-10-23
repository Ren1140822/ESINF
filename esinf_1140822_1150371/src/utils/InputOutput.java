/*
 * To change this license header, choose License Headers in Project Properties.
 */
package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import model.City;
import model.User;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class InputOutput {

    public static Set<City> readCityFromFile(String filePath) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(filePath));
        Set<City> cities = new HashSet<City>();
        String cityName;
        int cityPoints;
        long latitude;
        long longitude;

        while (scan.hasNext()) {
            String entireString = scan.next();
            String[] splitString = entireString.split(",");
            cityName = splitString[0];
            longitude = Long.parseLong(splitString[1]);
            cityPoints = Integer.parseInt(splitString[3]);
            latitude = Long.parseLong(splitString[2]);

            City tmpCity = new City(cityName, latitude, longitude, cityPoints);
            cities.add(tmpCity);

        }

        return cities;

    }

    public static Set<User> readUsersFromFile(String filePath) {
        Set<User> users = new HashSet<User>();

        return users;

    }

}
