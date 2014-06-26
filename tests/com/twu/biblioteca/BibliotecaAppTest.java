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



    @Test
    public void shouldBeAbleToLogIn(){
        User user1 = new User("123-1234","password123","John","j@j.com",81009032);
        User user2 = new User("567-5678","password456","Mary","m@m.com",81009031);
        users.registerNewUser(user1);
        users.registerNewUser(user2);

        Boolean result = app.logIn("123-1234","password123");
        assertEquals(true,result);

    }

    @Test
    public void testFailedLoginWithWrongPassword(){
        User user1 = new User("123-1234","password123","John","j@j.com",81009032);
        users.registerNewUser(user1);

        Boolean result = app.logIn("123-1234","wrong password");
        assertEquals(false, result);
    }

    @Ignore
    @Test
    public void testFailedLoginWithNonExistentUser(){
        Users users = new Users();

        BibliotecaApp app = new BibliotecaApp(books, movies, users);
        Boolean result = app.logIn("123-1234","");
        assertEquals(false, result);
    }

}