package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.LibraryItemAlreadyBorrowedError;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {
    private Movie movie;

    @Before
    public void setUp() throws Exception {
        movie = new Movie("name",123,"director",10);
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("name | director | 123 | 10/10", movie.toString());
    }

    @Test
    public void whenCreatedBorrowedStatusMustBeFalse() throws Exception {
        assertFalse(movie.isBorrowed());
    }

    @Test
    public void testBorrowed_whenBorrowedStatusShouldBeTrue() throws Exception {
        movie.borrow();
        assertTrue(movie.isBorrowed());
    }

    @Test(expected = LibraryItemAlreadyBorrowedError.class)
    public void testBorrowed_throwErrorIfBookIsAlreadyBorrowed() throws Exception {
        movie.borrowedStatus = true;
        movie.borrow();
    }


}