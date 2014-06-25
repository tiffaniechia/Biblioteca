package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.NonExistentLibraryIDError;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tiffaniechia on 24/06/2014.
 */
public class Users {

    public List<User> registeredUsers = new ArrayList<User>();

    public Users(){};

    public int arrayCount(){
        return registeredUsers.size();
    }

    public void registerNewUser(User userDB) {
        registeredUsers.add(userDB);
    }

    public User getUserInformation(String libraryId) {
        for (User userDB: registeredUsers) {
            if (userDB.getLibraryNumber().equals(libraryId)) {
                return userDB;
            }
        }
        throw new NonExistentLibraryIDError();
    }
}
