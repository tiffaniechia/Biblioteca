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
    public void ShouldShowWelcomeMessage(){
        String result = app.welcomeMessage();
        assertEquals("Welcome to Biblioteca", result);
    }

    @Test
    public void shouldShowMenuOptions(){
        String result = app.menuOptions();
        assertEquals("Hit 1 for list of books\nHit 2 to view list of movies\nHit q to quit",result);
    }

    @Test
    public void shouldRenderUserInput(){
        String result = app.readFirstInput("1");
        assertEquals("Type in the title of the book to perform an action or get information",result);
    }

    @Test
    public void shouldShowListOfBooks(){
        Book book = new Book("my little pony","author",123);
        books.registerBook(book);
        List result = app.showListOfBooks();
        assertEquals(Arrays.asList(new String[]{"my little pony"}), result);
    }

    @Test
    public void shouldGetBookInformation(){
        Book book = new Book("harry potter", "JK Rowling", 1997);
        books.registerBook(book);
        String result = app.showBookInformation("harry potter");
        assertEquals("JK Rowling, 1997", result);
    }

    @Test
    public void shouldShowListOfMovies(){
        Movie movie = new Movie("name",123,"director",10);
        movies.checkInMovieTitle(movie);
        List result = app.showListOfMovies();
        assertEquals(Arrays.asList(new String[]{"name"}), result);
    }

    @Test
    public void shouldGetMovieInformation(){
        Movie movie = new Movie("info showing", 123, "you", 10);
        movies.checkInMovieTitle(movie);
        String result = app.showMovieInformation("info showing");
        assertEquals("info showing | you | 123 | 10/10", result);
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