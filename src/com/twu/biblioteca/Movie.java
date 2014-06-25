package com.twu.biblioteca;

/**
 * Created by tiffaniechia on 24/06/2014.
 */
public class Movie {

    public String name;
    public int year;
    public String director;
    public int rating;

    public Movie(String name, int year, String director, int rating){
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
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
