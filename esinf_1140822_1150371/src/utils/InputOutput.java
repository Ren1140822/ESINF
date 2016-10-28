/*
 * To change this license header, choose License Headers in Project Properties.
 */
package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import model.City;
import model.MainRegistry;
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
       double latitude;
      double longitude;

        while (scan.hasNext()) {
            String entireString = scan.next();
            String[] splitString = entireString.split(",");
            cityName = splitString[0];
            longitude = Double.parseDouble(splitString[3]);
            cityPoints = Integer.parseInt(splitString[1]);
            latitude = Double.parseDouble(splitString[2]);

            City tmpCity = new City(cityName,cityPoints,latitude, longitude);
            cities.add(tmpCity);

        }

        return cities;

    }

    public static Set<User> readUsersFromFile(String filePath, MainRegistry r) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(filePath));
        Set<User> users = new HashSet<>();
        String nickName = "";
        String email = "";
        List<City> cities = new LinkedList();
        Set<User> friends = new HashSet<User>();
        while (scan.hasNext()) {
            String firstLine = scan.next();
            String secondLine = scan.next();
            String[] splitFirstLine = firstLine.split(",");
            nickName = splitFirstLine[0];
            email = splitFirstLine[1];
            cities = getCitiesFromString(firstLine, r);
            friends = getFriendsFromString(secondLine, r);
            Object[] aux = cities.toArray();
            City currentCity = (City) aux[0];
            
            User newUser = new User(nickName, email, currentCity.getCityName(), friends, cities,0);
            for(City c: newUser.getCitiesVisited()){
                newUser.setVisitPoints(newUser.getVisitPoints()+c.getNumberOfPointsAwarded());
            }
            users.add(newUser);

        }

        return users;

    }

    private static List<City> getCitiesFromString(String line, MainRegistry r) {
        List<City> cities = new LinkedList<City>();
        String[] splitString = line.split(",");
        for (int i = 2; i < splitString.length; i++) {
            City city = r.getListOfCities().getCityByName(splitString[i]);
            cities.add(city);
        }
        return cities;
    }

    private static Set<User> getFriendsFromString(String line, MainRegistry r) {
        Set<User> friends = new HashSet<User>();
        String[] splitString = line.split(",");
        for (String string : splitString) {
            User friend = r.getListOfUsers().getUserByNickname(string);
            friends.add(friend);

        }

        return friends;
    }

}
