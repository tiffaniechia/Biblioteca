package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.NonExistentItemError;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tiffaniechia on 24/06/2014.
 */
public class Movies {

    public List<Movie> moviesList = new ArrayList<Movie>();


    public void registerMovie(Movie movie){
     moviesList.add(movie);
    }

    public int arrayCount() {
        return moviesList.size();
    }

//    public void checkIn(String movieTitle){
//
//    }
//
//    public String checkOut(String movieTitle) {
//        for(Movie movie: moviesList){
//            if(movie.getName().equals(movieTitle)){
//                moviesList.remove(movie);
//                return "Thank you! Enjoy the movie";
//            }
//        }
//        return "That book is not available";
//    }

    private Movie findMovieWithTitle(String movieTitle){
        for(Movie movie: moviesList){
            if(movie.getName().equals(movieTitle)){
                return movie;
            }
        }
        throw new NonExistentItemError();
    }

    public void checkIn(String movieTitle){
        Movie selectedMovie = findMovieWithTitle(movieTitle);
        selectedMovie.returnItem();
    }

    public void checkOut(String movieTitle) {
        Movie selectedMovie = findMovieWithTitle(movieTitle);
        selectedMovie.borrowItem();
    }

    @Override
    public String toString() {
        String result = "";
        for (Movie movie: moviesList){
            result += movie.toString() + "\n";
        }
        return result;
    }
}
