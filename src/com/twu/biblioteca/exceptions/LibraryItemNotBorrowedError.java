package com.twu.biblioteca.exceptions;

/**
 * Created by tchia on 26/6/14.
 */
public class LibraryItemNotBorrowedError extends RuntimeException{
    public LibraryItemNotBorrowedError() {
        super("Library Item has not been borrowed");
    }
}
