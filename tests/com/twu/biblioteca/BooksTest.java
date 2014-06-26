package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

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
    public void booksCountShouldStartWithZero() {
        Books book = new Books();
        int result = book.arrayCount();
        assertEquals(0, result);
    }

    @Test
    public void shouldShowSuccessfulCheckOutMessage() {
        Books books = new Books();
        Book book = new Book("my little pony", "author", 123);
        books.registerBook(book);
        books.checkOut("my little pony");
        assertTrue(book.isBorrowed());
    }

    @Test
    public void shouldShowUnSuccessfulCheckOutMessage() {
        Books books = new Books();
        Book book = new Book("my little pony", "author", 123);
        books.checkOut("my little pony");
        assertFalse(book.isBorrowed());
    }

    @Test
    public void shouldBeAbleToReturnBooks() {
        Books books = new Books();
        Book book = new Book("my little pony", "author", 123);
        books.registerBook(book);
        int result = books.arrayCount();
        assertEquals(1, result);
    }

}
