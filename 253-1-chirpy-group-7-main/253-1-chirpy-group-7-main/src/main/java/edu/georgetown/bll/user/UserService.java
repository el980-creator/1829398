package edu.georgetown.bll.user;


import java.util.Map;
import java.util.Vector;
import java.util.logging.Logger;

import edu.georgetown.dao.*;
import java.util.HashMap;

public class UserService {

    private static Logger logger;

    private Map<String, Chirper> users; // = new HashMap<>(); 
    //just did here for easier view

    public UserService(Logger log) {
        logger = log;
        logger.info("UserService started");
        this.users = new HashMap<>(); 
    }

    //params username and password
    //false if key / username already exists, true otherwise
    public boolean registerUser(String username, String password) {
       
        if (users.containsKey(username)) {
            return false;
        }
        Chirper created = new Chirper(username, password);
        users.put(username, created);
        return true;

    }

    public boolean loginUser(String username, String password) {
        if (!users.containsKey(username)) { //just check if key exists
            return false;
        }

        Chirper user = users.get(username); //actually get object / value

        if (user.checkPassword(password)) {
            return true;
        }

        return false; 
    }

    //Chirper objects are the map values
    public Vector<Chirper> getUsers() {
        // not implemented; you'll need to change this
        return new Vector<>(users.values());
    }

    public Chirper getUserByUsername(String username) {
        return users.get(username); //returns null if not there
    }

    public Vector<String> getAllUsernames() {
        return new Vector<>(users.keySet()); //keys are just the usernames
    }
    
    // methods you'll probably want to add:
    //   registerUser
    //   loginUser
    //   etc.

}
