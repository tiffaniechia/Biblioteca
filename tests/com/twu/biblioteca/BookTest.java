package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.LibraryItemAlreadyBorrowedError;
import com.twu.biblioteca.exceptions.LibraryItemNotBorrowedError;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    private Book book;

    @Before
    public void setUp() throws Exception {
        book = new Book("title", "author", 1234);
    }


    @Test
    public void whenCreatedBorrowedStatusMustBeFalse() throws Exception {
        assertFalse(book.isBorrowed());
    }

    @Test
    public void testBorrow_shouldChangeTheStatusToBorrowed() throws Exception {
        book.borrowItem();
        assertTrue(book.isBorrowed());
    }

    @Test(expected = LibraryItemAlreadyBorrowedError.class)
    public void testBorrow_shouldThrowAnErrorIfBookIsAlreadyBorrowed() throws Exception {
        book.borrowedStatus = true;
        book.borrowItem();
    }

    @Test
    public void testReturn_shouldChangeStatusToFalse() throws Exception {
        book.borrowedStatus = true;
        book.returnItem();
        assertFalse(book.isBorrowed());
    }

    @Test(expected = LibraryItemNotBorrowedError.class)
    public void testReturn_shouldThrowErrorIfBookHasNotBeenBorrowed() throws Exception {
        book.borrowedStatus = false;
        book.returnItem();
    }
}