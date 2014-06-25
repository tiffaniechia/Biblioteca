package com.twu.biblioteca;

import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {

    @Test
    public void testToString() throws Exception {
        String title  = "Title";
        String director = "Director";
        int year = 2000;
        int rating = 10;

        Movie movie = new Movie(title, year, director, rating);
        Assert.assertEquals("Title | Director | 2000 | 10/10", movie.toString());
    }
}