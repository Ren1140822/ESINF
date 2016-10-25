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
    
    public boolean addFriend(User user);
    
    public boolean friendExists(User user);
    
}
