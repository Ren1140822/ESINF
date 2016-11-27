/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class User  {

    private String nickname;

    private String email;

    private City currentCity;

 

    private List<City> citiesVisited;

    private int visitPoints;

    private static String DEFAULT_NICKNAME = "No nickname";

    private static String DEFAULT_EMAIL = "No email";

    private static int DEFAULT_VISIT_POINTS = 0;

    /**
     *
     */
    public User() {
        this.nickname = DEFAULT_NICKNAME;
        this.email = DEFAULT_EMAIL;
      
        this.citiesVisited = new LinkedList<City>();
        this.visitPoints = DEFAULT_VISIT_POINTS;

    }

    /**
     *
     * @param nickname the users nickname
     * @param email        the users email
     * @param currentCity   the users current city
     * @param friends   the users friends
     * @param citiesVisited the cities visited
     * @param visitPoints   visit points
     */
    public User(String nickname, String email, String currentCity,  List<City> citiesVisited, int visitPoints) {
        this.nickname = nickname;
        this.email = email;
        
        this.citiesVisited = citiesVisited;
        this.visitPoints = visitPoints;

    }

    /**Gets user email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**Sets the users email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *Gets users current city
     * @return the current city if there's any null otherwise
     */
    public City getCurrentCity() {
         return citiesVisited.get(citiesVisited.size()-1);
      
        
    }

    /**
     *Sets the current city.
     * @param currentCity the current city
     */
    public void setCurrentCity(City currentCity) {
        this.currentCity = currentCity;
    }

   

    /**
     *Gets visit points.
     * @return the users visit points
     */
    public int getVisitPoints() {
        return visitPoints;
    }

    /**
     *Sets the visit points.
     * @param visitPoints the visit points
     */
    public void setVisitPoints(int visitPoints) {
        this.visitPoints = visitPoints;
    }

    /**
     *Gets user nickname.
     * @return the users nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     *Gets cities visited by the user.
     * @return a list of cities visited
     */
    public List<City> getCitiesVisited() {
        return citiesVisited;
    }

    /**
     *Sets user nickname
     * @param nickname the users nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     *Sees if this object is equal as another one.
     * @param otherObject the object to compare
     * @return true if they're equal
     */
    public boolean equals(Object otherObject) {

        if (this == null || (getClass() != otherObject.getClass())) {

            return false;
        }
        User otherUser = (User) otherObject;
        boolean ret = this.getNickname().equals(otherUser.getNickname()) && this.getEmail().equals(otherUser.getEmail())  && this.getVisitPoints() == otherUser.getVisitPoints();
        if (this.citiesVisited.size() > 0 && otherUser.citiesVisited.size() > 0 && ret == true) {
            ret = this.getCurrentCity().equals(otherUser.getCurrentCity());
        }
        return ret;
    }

  

    /**
     *Checks in a city.
     * @param city the city to check in for
     * @return true if checked in sucessfully false otherwise.
     */
  
    public boolean checkIn(City city) {//TODO: ALTERAR
        if (!this.getCurrentCity().equals(city)) {
            this.visitPoints += city.getNumberOfPointsAwarded();
          
            this.citiesVisited.add(city);
            return true;
        }
        return false;
    }




    
    
       /**
     *Returns a description of this object in a string
     * @return the description
     */
    public String toString(){
        return this.nickname+" "+ this.email+" "+ this.visitPoints ;
    }
    
     @Override
    public int hashCode() {
        return Objects.hash(nickname,email,visitPoints,citiesVisited);
    }

}
