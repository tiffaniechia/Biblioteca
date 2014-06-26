package com.twu.biblioteca.exceptions;

/**
 * Created by tchia on 26/6/14.
 */
public class LibraryItemAlreadyBorrowedError extends RuntimeException {
    public LibraryItemAlreadyBorrowedError(){
        super("Library item has already been borrowed");
    }

}
