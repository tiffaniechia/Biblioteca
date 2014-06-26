package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.LibraryItemAlreadyBorrowedError;

/**
 * Created by tiffaniechia on 24/06/2014.
 */
public class Movie extends LibraryItem {

    String name;
    int year;
    String director;
    int rating;

    public Movie(String name, int year, String director, int rating){
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.borrowedStatus = false;
    }

    public String getName(){
        return name;
    }

    public int getYear(){
        return year;
    }

    public String getDirector(){
        return director;
    }

    public int getRating(){
        return rating;
    }

    @Override
    public String toString() {
        return name + " | " + director + " | " + year + " | " + rating + "/10";
    }


}
