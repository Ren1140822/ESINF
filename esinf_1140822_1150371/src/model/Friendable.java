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
public interface Friendable {
    
    /**
     *
     * @param user
     * @return
     */
    public boolean addFriend(User user);
    
    /**
     *
     * @param user
     * @return
     */
    public boolean friendExists(User user);
    
    /**
     *
     * @param user
     * @return
     */
    public boolean removeFriend(User user);
    
}
