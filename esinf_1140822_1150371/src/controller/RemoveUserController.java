/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.SocialNetwork;
import model.User;

/**
 *
 * @author Jose Silva <1150371@isep.ipp.pt>
 */
public class RemoveUserController {

    SocialNetwork r;

    /**
     *
     * @param r
     */
    public RemoveUserController(SocialNetwork r) {
        this.r = r;
    }

    /**
     *
     * @param nick
     * @return
     */
    public boolean removeUser(String nick) {
        User user = r.getListOfUsers().getUserByNickname(nick);
        if (r.getListOfUsers().getUserMap().values().contains(user)) {
            r.getListOfUsers().getUserMap().values().remove(user);
            return true;
        }
        return false;
    }
}
