package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tiffaniechia on 24/06/2014.
 */
public class Movies {

    public List<Movie> availableMoviesList = new ArrayList<Movie>();


    public void checkInMovieTitle(Movie movie){
     availableMoviesList.add(movie);
    }

    public int arrayCount() {
        return availableMoviesList.size();
    }

    public String checkOut(String movieTitle) {
        for(Movie movie: availableMoviesList){
            if(movie.getName().equals(movieTitle)){
                availableMoviesList.remove(movie);
                return "Thank you! Enjoy the movie";
            }
        }
        return "That book is not available";
    }

    @Override
    public String toString() {
        String result = "";
        for (Movie movie: availableMoviesList){
            result += movie.toString() + "\n";
        }
        return result;
    }
}
