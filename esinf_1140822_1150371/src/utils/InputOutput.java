/*
 * To change this license header, choose License Headers in Project Properties.
 */
package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import model.City;
import model.SocialNetwork;
import model.User;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class InputOutput {

    /**
     *Reads cities from a txt file.
     * @param filePath the file path
     * @return the set of cities
     * @throws FileNotFoundException
     */
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

    /**
     *Reads users from a given txt file
     * @param filePath the file path
     * @param r the main registry to read cities
     * @return the list of users
     * @throws FileNotFoundException
     */
    public static Set<User> readUsersFromFile(String filePath, SocialNetwork r) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(filePath));
        Set<User> users = new LinkedHashSet<>();
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
            
            User newUser = new User(nickName, email, currentCity.getCityName(), cities,0);
            for(City c: newUser.getCitiesVisited()){
                newUser.setVisitPoints(newUser.getVisitPoints()+c.getNumberOfPointsAwarded());
            }
            users.add(newUser);

        }

        return users;

    }

    /**
     * Gets cities from string ( cities need to be uploaded first).
     * @param line the line
     * @param r the main registry
     * @return  the list of cities
     */
    private static List<City> getCitiesFromString(String line, SocialNetwork r) {
        List<City> cities = new LinkedList<City>();
        String[] splitString = line.split(",");
        for (int i = 2; i < splitString.length; i++) {
            City city = r.getListOfCities().getCityByName(splitString[i]);
            cities.add(city);
        }
        return cities;
    }

    /**
     * Gets friends from string.
     * @param line the line
     * @param r the main registry
     * @return  the list of friends
     */
    private static Set<User> getFriendsFromString(String line, SocialNetwork r) {
        Set<User> friends = new HashSet<User>();
        String[] splitString = line.split(",");
        for (String string : splitString) {
            User friend = r.getListOfUsers().getUserByNickname(string);
            friends.add(friend);
        }
        return friends;
    }

    /**
     * Reads the cities to a graph
     * @param path the file path
     * @throws FileNotFoundException 
     */
    public static void readCitiesToGraph(String path) throws FileNotFoundException{
        Scanner scan = new Scanner(new File(path));
        String line = scan.next();
        String[] lineSplit = line.split(",");
        String city1= lineSplit[0];
        String city2 = lineSplit[1];
        long distance = Long.parseLong(lineSplit[2]);
       
        
        
    }
}
