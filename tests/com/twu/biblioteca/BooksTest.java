package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class BooksTest {

    private Book book;
    private Books books;

    @Before
    public void setUp() throws Exception {
        book = new Book("Title", "Author", 2012);
        books = new Books();
    }

    @Test
    public void booksCountShouldStartWithZero(){
        Books book = new Books();
        int result = book.arrayCount();
        assertEquals(0,result);
    }

    @Test
    public void shouldShowSuccessfulCheckOutMessage(){
        Books books = new Books();
        Book book = new Book("my little pony","author",123);
        books.checkIn(book);
        String result = books.checkOut("my little pony");
        assertEquals("Thank you! Enjoy the book", result);
    }

    @Test
    public void shouldShowUnSuccessfulCheckOutMessage(){
        Books books = new Books();
        Book book = new Book("my little pony","author",123);
        String result = books.checkOut("my little pony");
        assertEquals("That book is not available", result);
    }

    @Test
    public void shouldBeAbleToReturnBooks(){
        Books books = new Books();
        Book book = new Book("my little pony","author",123);
        books.checkIn(book);
        int result = books.arrayCount();
        assertEquals(1,result);
    }
//        Books book1 = new Books();
//        Books book2 = new Books();
//        book1.checkIn("whirlwind");
//        book2.checkIn("avengers");
//        List result = Books.availableBooksList;
//        assertEquals(Arrays.asList(new String[]{"whirlwind", "avengers"}), result);
//    }
}