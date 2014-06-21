package com.twu.biblioteca;

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
        assertEquals("Hit 1 for list of books\nHit 2 to quit",result);
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

}