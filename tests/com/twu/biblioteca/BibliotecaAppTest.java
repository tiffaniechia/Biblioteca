package com.twu.biblioteca;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class BibliotecaAppTest {

    @Test
    public void ShouldShowWelcomeMessage(){
        BibliotecaApp app = new BibliotecaApp();
        String result = app.welcomeMessage();
        assertEquals("Welcome to Biblioteca", result);
    }

    @Test
    public void shouldShowMenuOptions(){
        BibliotecaApp app = new BibliotecaApp();
        String result = app.menuOptions();
        assertEquals("Hit 1 for list of books\nHit 2 to view list of movies\nHit q to quit",result);
    }

    @Test
    public void shouldRenderUserInput(){
        BibliotecaApp app = new BibliotecaApp();
        String result = app.readFirstInput("1");
        assertEquals("Type in the title of the book to perform an action or get information",result);
    }

    @Test
    public void shouldShowListOfBooks(){
        BibliotecaApp app = new BibliotecaApp();
        Books book = new Books();
        book.availableBooksList.clear();
        book.checkIn("my little pony");
        List result = app.showListOfBooks();
        assertEquals(Arrays.asList(new String[]{"my little pony"}), result);
    }

    @Test
    public void shouldGetBookInformation(){
        Books book = new Books();
        book.availableBooksList.clear();
        BooksDatabase booksDatabase1 = new BooksDatabase("harry potter", "JK Rowling", 1997);
        book.checkIn(booksDatabase1.getTitle());
        BibliotecaApp app = new BibliotecaApp();
        String result = app.showBookInformation("harry potter");
        assertEquals("JK Rowling, 1997", result);
    }

    @Test
    public void shouldShowListOfMovies(){
        BibliotecaApp app = new BibliotecaApp();
        Movies movies = new Movies();
        movies.availableMoviesList.clear();
//        movies.checkInMovieTitle("hi again");
        List result = app.showListOfMovies();
        assertEquals(Arrays.asList(new String[]{"hi again"}), result);
    }

    @Test
    public void shouldGetMovieInformation(){
        Movie movie = new Movie("info showing", 123, "you", 10);
        BibliotecaApp app = new BibliotecaApp();
        Movies movies = new Movies();
        movies.availableMoviesList.clear();
//        movies.checkInMovieTitle("info showing");
        String result = app.showMovieInformation("info showing");
        assertEquals("info showing, 123 by you with rating of 10", result);
    }

//    @Test
//    public void shouldBeAbleToSeeUserInfo(){
//        BibliotecaApp app = new BibliotecaApp();
//        Users users = new Users();
//        users.registeredUsers.clear();
//        User user2 = new User("123-1234","password123","John","j@j.com",81009032);
//        users.registerNewUser(user2);
//        String result = app.ShowUserInformation("123-1234");
//        assertEquals("John, j@j.com, 81009032", result);
//
//    }

    @Test
    public void shouldBeAbleToLogIn(){
        Users users = new Users();
        User user1 = new User("123-1234","password123","John","j@j.com",81009032);
        User user2 = new User("567-5678","password456","Mary","m@m.com",81009031);
        users.registerNewUser(user1);
        users.registerNewUser(user2);

        BibliotecaApp app = new BibliotecaApp(users);
        Boolean result = app.logIn("123-1234","password123");
        assertEquals(true,result);

    }

    @Test
    public void testFailedLoginWithWrongPassword(){
        Users users = new Users();
        User user1 = new User("123-1234","password123","John","j@j.com",81009032);
        users.registerNewUser(user1);

        BibliotecaApp app = new BibliotecaApp(users);
        Boolean result = app.logIn("123-1234","wrong password");
        assertEquals(false, result);
    }

    @Ignore
    @Test
    public void testFailedLoginWithNonExistentUser(){
        Users users = new Users();

        BibliotecaApp app = new BibliotecaApp(users);
        Boolean result = app.logIn("123-1234","");
        assertEquals(false, result);
    }

}