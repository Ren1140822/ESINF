/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.MainRegistry;
import model.User;

/**
 *
 * @author Jose Silva <1150371@isep.ipp.pt>
 */
public class RemoveUserController {

    MainRegistry r;

    public RemoveUserController(MainRegistry r) {
        this.r = r;
    }

    public boolean removeUser(String nick) {
        User user = r.getListOfUsers().getUserByNickname(nick);
        if (r.getListOfUsers().getMapOfUsers().keySet().contains(user)) {
            r.getListOfUsers().getMapOfUsers().keySet().remove(user);
            return true;
        }
        return false;
    }
}
