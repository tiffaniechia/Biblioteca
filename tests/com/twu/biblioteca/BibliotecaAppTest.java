package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class BibliotecaAppTest {
    private Books books;
    private Movies movies;
    private Users users;
    private BibliotecaApp app;

    @Before
    public void setUp() throws Exception {
        books = new Books();
        movies = new Movies();
        users = new Users();
        app = new BibliotecaApp(books, movies, users);
    }

}