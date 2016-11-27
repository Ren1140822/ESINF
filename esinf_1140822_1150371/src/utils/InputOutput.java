/*
 * To change this license header, choose License Headers in Project Properties.
 */
package utils;

import graphMatrizAdj.AdjacencyMatrixGraph;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
    public static Map<String,City> readCityFromFile(String filePath) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(filePath));
        Map<String,City> cities = new HashMap<String,City>();
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
            cities.put(tmpCity.getCityName(),tmpCity);

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
    public static    Map<String, User>  readUsersFromFile(String filePath, SocialNetwork r) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(filePath));
       Map<String, User> userMap = new LinkedHashMap<>();
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
            userMap.put(newUser.getNickname(), newUser);

        }

        return userMap;

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
    //2.a)
    public AdjacencyMatrixGraph<City,Double> loadCitiesGraph(String filepath,HashSet<City> existingCities) throws FileNotFoundException, IOException{
        AdjacencyMatrixGraph<City,Double> citiesGraph = new AdjacencyMatrixGraph<>();
        // insert existint cities on graph
        for (City city : existingCities) {
            citiesGraph.insertVertex(city);
        }
        //read file
        BufferedReader buffedReader =new BufferedReader(new FileReader(filepath));
        String currentLine;
        
        while((currentLine=buffedReader.readLine())!=null){
            String[] lineSplit=currentLine.split(",");
            String city1=lineSplit[0];
            String city2=lineSplit[1];
            Double distance=Double.parseDouble(lineSplit[2]);
            
            City firstCity=null;
            City secondCity=null;
            Iterable<City> cities=citiesGraph.vertices();
            for (City city : cities) {
                if(city.getCityName().equals(city1)){
                    firstCity=city;
                }
                if(city.getCityName().equals(city2)){
                    secondCity=city;
                }
            }
            if(firstCity!=null & secondCity!=null){
                citiesGraph.insertEdge(firstCity, secondCity, distance);
            }
        }
        return citiesGraph;
    }
}
