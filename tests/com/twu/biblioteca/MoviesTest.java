package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class MoviesTest {

    @Test
    public void shouldStartWithZeroMovies(){
        Movies movies = new Movies();
        int result = movies.arrayCount();
        assertEquals(0,result);
    }

    @Test
    public void shouldBeAbleToAddAMovie(){
        Movies movies = new Movies();
        Movie movie = new Movie("name",123,"director",10);
        movies.registerMovie(movie);
        int result = movies.arrayCount();
        assertEquals(1,result);
    }

    @Test
    public void shouldBeABleToCheckOutAMovie(){
        Movies movies = new Movies();
        Movie movie2 = new Movie("name",123,"director",10);
        movies.registerMovie(movie2);
        movies.checkOut(movie2.getName());
        int result = movies.arrayCount();
        assertEquals(0,result);
    }

    @Test
    public void testToString() throws Exception {
        Movies movies = new Movies();
        Movie movie1 = new Movie("name1",1223,"director",10);
        movies.registerMovie(movie1);

        Movie movie2 = new Movie("name2",1223,"director",10);
        movies.registerMovie(movie2);

        assertEquals("name1 | director | 1223 | 10/10\n" +
                    "name2 | director | 1223 | 10/10\n"
                , movies.toString());
    }
}