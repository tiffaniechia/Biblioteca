package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tiffaniechia on 19/06/2014.
 */
public class Books {

    public static List<String> availableBooksList = new ArrayList<String>();

    Books(){
    }

   public int arrayCount(){
        return availableBooksList.size();
    }

    public static String checkIn(String t) {
        if (availableBooksList.add(t)){
            return "Thank you for returning the book";
        }else{
            return "That is not a valid book to return";
        }
    }

    public static String checkOut(Object s) {
        if(availableBooksList.contains(s)){
            availableBooksList.remove(s);
            return "Thank you! Enjoy the book";
        }else{
            return "That book is not available";
        }
    }

}
