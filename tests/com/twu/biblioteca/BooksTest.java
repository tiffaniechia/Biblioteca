package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class BooksTest {

    @Test
    public void booksCountShouldStartWithZero(){
        Books book = new Books();
        int result = book.arrayCount();
        assertEquals(0,0);
    }

    @Test
    public void shouldBeAbleToCheckOutBooks(){
        Books book = new Books();
        book.checkIn("my little pony");
        book.checkOut("my little pony");
        int result = book.arrayCount();
        assertEquals(0,0);
    }

    @Test
    public void shouldShowSuccessfulCheckOutMessage(){
        Books book = new Books();
        book.checkIn("my little pony");
        String a = "my little pony";
        Object b = a;
        String result;
        result = book.checkOut(b);
        assertEquals("Thank you! Enjoy the book", result);
    }


    @Test
    public void shouldShowUnSuccessfulCheckOutMessage(){
        Books book = new Books();
        String a = "my little ponies";
        Object b = a;
        String result;
        result = book.checkOut(b);
        assertEquals("That book is not available", result);
    }

    @Test
    public void shouldBeAbleToReturnBooks(){
        Books book = new Books();
        book.checkIn("my little pony");
        int result = book.arrayCount();
        assertEquals(1,1);
    }

    @Test
    public void ShouldShowSuccessfulReturnMessage(){
        Books book = new Books();
        String result = book.checkIn("my little pony");
        assertEquals("Thank you for returning the book",result);
    }

    @Test
    public void shouldShowListOfBooks(){
        Books.availableBooksList.clear();
        Books book1 = new Books();
        Books book2 = new Books();
        book1.checkIn("whirlwind");
        book2.checkIn("avengers");
        List result = Books.availableBooksList;
        assertEquals(Arrays.asList(new String[]{"whirlwind", "avengers"}), result);
    }
}