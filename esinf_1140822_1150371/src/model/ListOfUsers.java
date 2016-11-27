/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import graphbase.Graph;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Jose Silva <1150371@isep.ipp.pt>
 */
public class ListOfUsers {

    private Map<String, User> userMap;
    private Map<User, Set<User>> friendsMap;
    Graph<User, Integer> friendsGraph;

    /**
     * Builds instance of this class.
     */
    public ListOfUsers() {
        userMap = new HashMap<>();
        friendsMap = new HashMap<>();
        friendsGraph = new Graph<User, Integer>(false);
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;

    }

    public void setFriendsMap(Map<User, Set<User>> friendsMap) {
        this.friendsMap = friendsMap;
    }

    public void setFriendsGraph(Graph<User, Integer> friendsGraph) {
        this.friendsGraph = friendsGraph;
    }

    public Map<User, Set<User>> getFriendsMap() {
        return friendsMap;
    }

    public Graph<User, Integer> getFriendsGraph() {
        return friendsGraph;
    }

    /**
     * Gets user object by nickname.
     *
     * @param nick the user nickname
     * @return the user if found
     */
    public User getUserByNickname(String nick) {
        for (User user : userMap.values()) {
            if (user.getNickname().equals(nick)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Gets most influent users
     *
     * @return the list of most influent users
     */
    public List<User> getMostInfluentUsers(int numberOfResults) {
        Comparator<User> comparator = new Comparator<User>() {
            @Override
            public int compare(User t, User t1) {
                return (friendsMap.get(t).size() > friendsMap.get(t1).size()) ? -1 : friendsMap.get(t).size() < friendsMap.get(t1).size() ? 1 : 0;
            }
        };
        List<User> usersList = new LinkedList();
        for (User user : userMap.values()) {
            usersList.add(user);
        }
        Collections.sort(usersList, comparator);
        List<User> limitedUsersList = new LinkedList();
        for (int i = 0; i < numberOfResults + 1; i++) {
            limitedUsersList.add(usersList.get(i));
        }
        return limitedUsersList;
    }

    @Override
    public boolean equals(Object l2) {
        ListOfUsers aux = (ListOfUsers) l2;
        if (this == l2) {
            return true;
        }
        for (User user : userMap.values()) {
            for (User user1 : aux.userMap.values()) {
                if (!user1.equals(userMap.values())) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Adds a friend to this user.
     *
     * @param user the user to add
     * @return true if added sucessfully
     */
    public boolean addFriend(String nickname1, String nickname2) {
        if (!friendExists(nickname1, nickname2)) {
            if (!friendsMap.containsKey(getUserByNickname(nickname1))) {

                friendsMap.put(getUserByNickname(nickname1), new HashSet<User>());
            }
            if (!friendsMap.containsKey(getUserByNickname(nickname2))) {

                friendsMap.put(getUserByNickname(nickname2), new HashSet<User>());
            }

            friendsMap.get(getUserByNickname(nickname1)).add(getUserByNickname(nickname2));
            friendsMap.get(getUserByNickname(nickname2)).add(getUserByNickname(nickname1));

            return true;

        }
        return false;
    }

    public boolean addFriendToGraph() {
        for (User u : friendsMap.keySet()) {
            friendsGraph.insertVertex(u);
        }
        for (User u : friendsMap.keySet()) {
            for (User u2 : friendsMap.get(u)) {
                if (friendsGraph.getEdge(u, u2) == null) {
                    friendsGraph.insertEdge(u, u2, 0, 1);
                }
            }
        }
        return true;
    }

    public int getRelationshipDistance(String nickname1, String nickname2) {
        LinkedList<User> users = new LinkedList<>();
        graphbase.GraphAlgorithms.shortestPath(friendsGraph, getUserByNickname(nickname1), getUserByNickname(nickname2), users);

        return users.size()-2;
    }

    public Iterable<User> findUsersWithinRelationshipDistance(String nickname1, int distance) {
        LinkedList<User> users = new LinkedList<>();
 
        User usr = getUserByNickname(nickname1);
        users = graphbase.GraphAlgorithms.DepthFirstSearchWithLimit(friendsGraph, usr, distance);
        return users;
    }

    public Iterable<User> findUsersWithGreatestRelationshipDistance() {
        int maxDistance = 0;
        LinkedList<User> usersFarthestAway = new LinkedList<>();
        for (User u : friendsGraph.vertices()) {
            for (User u2 : friendsGraph.vertices()) {
                LinkedList<User> users = new LinkedList<>();
                if (!u.equals(u2)) {
                    graphbase.GraphAlgorithms.shortestPath(friendsGraph, getUserByNickname(u.getNickname()), getUserByNickname(u2.getNickname()), users);
                    if (users.size() > maxDistance) {
                        usersFarthestAway.clear();
                        usersFarthestAway.add(u);
                        usersFarthestAway.add(u2);
                        maxDistance = users.size();
                    }
                }
            }
        }
        return usersFarthestAway;
    }
      public Iterable<User> findUsersWithFriendsInCommon(String nick1,String nick2)
      {
          LinkedList<User>friendsInCommon = new LinkedList<>();
          User u = getUserByNickname(nick1);
          User u2 = getUserByNickname(nick2);
         friendsInCommon= graphbase.GraphAlgorithms.getCommonDirectVertices(friendsGraph, u, u2);
         return friendsInCommon;
      }
    
    public User findMostInfluentialUser()
    {
        return graphbase.GraphAlgorithms.graphCentrality(friendsGraph);
    }

    /**
     * Removes a friend of this user.
     *
     * @param user the user to remove
     * @return true if removed sucessfully
     */
    public boolean removeFriend(String nickname1, String nickname2) {
        if (friendExists(nickname1, nickname2)) {
            if (friendsMap.containsKey(getUserByNickname(nickname1)) && friendsMap.containsKey(getUserByNickname(nickname2))) {

                friendsMap.get(getUserByNickname(nickname1)).remove(getUserByNickname(nickname2));
                friendsMap.get(getUserByNickname(nickname2)).remove(getUserByNickname(nickname1));

                return true;
            }
        }
        return false;
    }

    /**
     * Sees if friend exists on this users list.
     *
     * @param user the friend to check for
     * @return true if exists
     */
    public boolean friendExists(String nickname1, String nickname2) {

        User user1 = getUserByNickname(nickname1);
        User user2 = getUserByNickname(nickname2);
        if (friendsMap.containsKey(user1)) {
            return friendsMap.get(user1).contains(user2);
        }
        return false;
    }

}
