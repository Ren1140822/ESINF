/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import BST.BST;
import controller.AddCityController;
import controller.AddUserController;
import controller.RemoveUserController;
import graphMatrizAdj.GraphAlgorithms;
import graphMapAdj.Edge;
import graphMapAdj.Graph;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Jose Silva <1150371@isep.ipp.pt>
 */
public class SocialNetwork implements Checkinable,Comparator<User> {

    private ListOfCities listOfCities;
    private ListOfUsers listOfUsers;

    /**
     * Creates instance of this class.
     */
    public SocialNetwork() {
        listOfCities = new ListOfCities();
        listOfUsers = new ListOfUsers();
    }

    /**
     * Gets the list of cities class reference
     *
     * @return the ListOfCities
     */
    public ListOfCities getListOfCities() {
        return listOfCities;
    }

    /**
     * Sets the list of cities class reference.
     *
     * @param ListOfCities the ListOfCities to set
     */
    public void setListOfCities(ListOfCities ListOfCities) {
        this.listOfCities = ListOfCities;
    }

    /**
     * Gets the list of users class reference.
     *
     * @return the listOfUsers
     */
    public ListOfUsers getListOfUsers() {
        return listOfUsers;
    }

    /**
     * Sets the list of users class reference.
     *
     * @param listOfUsers the listOfUsers to set
     */
    public void setListOfUsers(ListOfUsers listOfUsers) {
        this.listOfUsers = listOfUsers;
    }

    /**
     * Testing purposes for junit implementations.
     *
     * @param nickname
     * @param email
     * @param currentCity
     * @param friends
     * @param cities
     * @param visitPoints
     * @return
     */
    public boolean addUser(String nickname, String email, String currentCity, List<City> cities, int visitPoints) {

        AddUserController controller = new AddUserController(this);
        return controller.AddUser(nickname, email, currentCity, cities, visitPoints);

    }

    /**
     * Testing purposes.
     *
     * @param nickname
     * @return
     */
    public boolean removeUser(String nickname) {
        RemoveUserController controller = new RemoveUserController(this);
        return controller.removeUser(nickname);
    }

    /**
     * Testing purposes - Adds a new city
     *
     * @param cityName the name of the city
     * @param numberOfPointsAwarded points awarded for checking in
     * @param latitude latitude of the city
     * @param longitude longitude of the city
     * @return
     */
    public boolean addCity(String cityName, int numberOfPointsAwarded, double latitude, double longitude) {
        AddCityController citiesController = new AddCityController(this);
        return citiesController.addCity(cityName, numberOfPointsAwarded, numberOfPointsAwarded, numberOfPointsAwarded);

    }

    @Override
    public boolean checkIn(String user, String city) {
        City c = listOfCities.getCityByName(city);
        User u = (listOfUsers.getUserByNickname(user));
        if (u != null && c != null) {
            if (u.checkIn(c)) {
                return c.updateMayor(u);
            }
        }
        return false;
    }

    /**
     * Gets user's friends by city object.
     *
     * @param city the city to check
     * @return the list of friends
     */
    public Map<String, User> getFriendsByCity(String nickname, String cityName) {
        Map<String, User> friendsNearby = new HashMap();
        Set<User> usersFriends = listOfUsers.getFriendsMap().get(listOfUsers.getUserByNickname(nickname));
        if (usersFriends != null) {
            for (User u : usersFriends) {
                if (u.getCurrentCity() != null) {
                    if (u.getCurrentCity().equals(listOfCities.getCityByName(cityName))) {
                        friendsNearby.put(nickname, u);
                    }
                }
            }
            return friendsNearby;
        }
        return null;
    }

    /**
     * Gets user's friends by coordinated.
     *
     * @param latitude the latitude
     * @param longitude the longitude
     * @return the user's friends
     */
    public Map<String, User> getFriendsByCity(String nickname, double latitude, double longitude) {
        Map<String, User> friendsNearby = new HashMap();
        Set<User> usersFriends = listOfUsers.getFriendsMap().get(listOfUsers.getUserByNickname(nickname));
        if (usersFriends != null) {
            for (User u : usersFriends) {
                City c = (listOfCities.getCityByCoordinates(latitude, longitude));
                if (u.getCurrentCity() != null && c != null) {

                    if (u.getCurrentCity().equals(c)) {
                        friendsNearby.put(nickname, u);
                    }
                }
            }
            return friendsNearby;
        }
        return null;
    }

    //2.b
    public Iterable<User> getClosestFriends(String username, Double distance) {
        User user = this.listOfUsers.getUserByNickname(username);
        HashSet<User> closestFriends = new HashSet();

        Set<User> friends = this.listOfUsers.getFriendsMap().get(user);


        City currentCity = user.getCurrentCity();
        LinkedList<City> connectedCities = graphMatrizAdj.GraphAlgorithms.DFS(this.listOfCities.cityGraph, currentCity);

        for (City connectedCity : connectedCities) {
            LinkedList<City> path = new LinkedList<>();
            double distanceFromCity = graphMatrizAdj.EdgeAsDoubleGraphAlgorithms.shortestPathDistance(this.listOfCities.cityGraph, currentCity, connectedCity, path);

            if (distanceFromCity < distance) {
                for (User friend : friends) {
                    if (this.listOfUsers.getUserMap().containsValue(friend)) {

                        if (friend.getCurrentCity().equals(connectedCity)) {
                            closestFriends.add(friend);
                        }
                    }
                }
            }
        }

        return closestFriends;
    }

    //2.c
    public LinkedList<City> shortestPathBetweenUsers(User u1, User u2) {
        LinkedList<City> path = new LinkedList<>();
        City c_u1 = u1.getCurrentCity();
        City c_u2 = u2.getCurrentCity();

        graphMatrizAdj.EdgeAsDoubleGraphAlgorithms.shortestPath(this.listOfCities.cityGraph, c_u1, c_u2, path);
        return path;
    }

    //2.d
    public LinkedList<City> shortestPathMostFriendsCity(String user, String friend) {
        User u1 = this.listOfUsers.getUserByNickname(user);
        u1.setCurrentCity(u1.getCurrentCity());
        User u2 = this.listOfUsers.getUserByNickname(friend);
        u2.setCurrentCity(u2.getCurrentCity());
        City userCurrentCity = u1.getCurrentCity();
        City friendCurrentCity = u2.getCurrentCity();
        City userMostFriendsCity = this.cityWithMostFriends(u1);
        City friendMostFriendsCity = this.cityWithMostFriends(u2);

        LinkedList<City> path = new LinkedList<>();

        //se a cidade com mais amigos for comum o percurso sera shortestPath(c1,common)+shortestPath(common,c2)
        if (userMostFriendsCity.equals(friendMostFriendsCity)) {
            graphMatrizAdj.EdgeAsDoubleGraphAlgorithms.shortestPath(this.listOfCities.cityGraph, userCurrentCity, userMostFriendsCity, path);
            LinkedList<City> path2 = new LinkedList<>();
            graphMatrizAdj.EdgeAsDoubleGraphAlgorithms.shortestPath(this.listOfCities.cityGraph, userMostFriendsCity, friendCurrentCity, path);
            path2 = (LinkedList) path2.subList(1, path2.size());
            path.addAll(path2);
            return path;
        }

        // caso nao sejam iguais vai ser c1-mostFriends1-mostFriends2-c2 ou c1-mostFriends2-mostFriends1-c2, retorna o menor destes 2 caminhos
        LinkedList<City> aux_path = new LinkedList<>(); //caminho c1-mostFriends1
        double distance1 = graphMatrizAdj.EdgeAsDoubleGraphAlgorithms.shortestPathDistance(this.listOfCities.cityGraph, userCurrentCity, userMostFriendsCity, aux_path);//distancia entre c1-mostFriends1
        LinkedList<City> aux_path2 = new LinkedList<>(); //caminho c1-mostFriends2
        double distance2 = graphMatrizAdj.EdgeAsDoubleGraphAlgorithms.shortestPathDistance(this.listOfCities.cityGraph, userCurrentCity, friendMostFriendsCity, aux_path2);//distancia entre c1-mostFriends2

        if (distance1 < distance2) {
            path.addAll(aux_path); //contem c1-mostFriends1
            aux_path = new LinkedList<>();
            graphMatrizAdj.EdgeAsDoubleGraphAlgorithms.shortestPath(this.listOfCities.cityGraph, userMostFriendsCity, friendMostFriendsCity, aux_path);
            aux_path = new LinkedList<City> (aux_path.subList(1, aux_path.size()));  //contem mostFriend1.next ate mostFriends2
            path.addAll(aux_path); //contem c1-mostFriends1-mostFriends2
            aux_path = new LinkedList<>();
            graphMatrizAdj.EdgeAsDoubleGraphAlgorithms.shortestPath(this.listOfCities.cityGraph, friendMostFriendsCity, friendCurrentCity, aux_path);
            aux_path = new LinkedList<City>(aux_path.subList(1, aux_path.size())); //contem de mostFriend2.next ate c2
            path.addAll(aux_path);

            return path;
        } else {
            path.addAll(aux_path2);//contem c1-mostFriends2
            aux_path = new LinkedList<>();
            graphMatrizAdj.EdgeAsDoubleGraphAlgorithms.shortestPath(this.listOfCities.cityGraph, friendMostFriendsCity, userMostFriendsCity, aux_path);
            aux_path = new LinkedList<City>( aux_path.subList(1, aux_path.size()));//contem mostFriend2.next ate mostFriends1
            path.addAll(aux_path); //contem c1-mostFriends2-mostFriends1
            aux_path = new LinkedList<>();
            graphMatrizAdj.EdgeAsDoubleGraphAlgorithms.shortestPath(this.listOfCities.cityGraph, userMostFriendsCity, friendCurrentCity, aux_path);
            aux_path = new LinkedList<City>( aux_path.subList(1, aux_path.size()));
            path.addAll(aux_path);//contem c1-mostFriends2-mostFriends1-c2

            return path;
        }

    }

    private City cityWithMostFriends(User user) {
        HashMap<Integer, City> cities = new HashMap<>();

        for (User u : this.listOfUsers.getFriendsMap().get(user)) {
            if(u!=null){
            City currentCity = u.getCurrentCity();
            if (!cities.containsKey(currentCity)) {
                cities.put(1, currentCity);
            } else {
                for (City c : cities.values()) {
                    if (c.equals(currentCity)) {
                        for (int a : cities.keySet()) {
                            if (cities.get(a).equals(currentCity)) {
                                cities.replace(a++, c);
                            }
                        }
                    }
                }
            }
        }
        }

        TreeMap<Integer, City> sorted = new TreeMap<>(cities);

        return sorted.get(sorted.lastKey()); //como o treemap ordena por ordem crescente a ultima key sera a cidade com mais amigos

    }
    
    private void actulizaMayor(){
    this.listOfUsers.addFriendToGraph();
        for (User u:this.listOfUsers.getFriendsGraph().vertices()) {
            City current = u.getCurrentCity();
            if(u.getVisitPoints()>current.getMayor().getVisitPoints()){
                
                current.setMayor(u);
            }
                    
        }
    }
    
    
    public BST createMayorTree(){
        this.actulizaMayor();
        List<User> listOfMayors = new ArrayList<User>();
        BST<User> theTree =new BST();
        for (City city : this.getListOfCities().cityGraph.vertices()) {
            listOfMayors.add(city.getMayor());
            
        }
        Collections.sort(listOfMayors,this); //ordena por ordem descrescente de pontos
        
        for (User u : this.listOfUsers.friendsGraph.vertices()) {
            theTree.insert(u);
           
            
        }
         
        return theTree;
    }

    @Override
    public int compare(User o1, User o2) {
        return Integer.compare(o2.getVisitPoints(), o1.getVisitPoints());
    }

}


