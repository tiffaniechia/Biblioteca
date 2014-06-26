package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.LibraryItemAlreadyBorrowedError;
import com.twu.biblioteca.exceptions.LibraryItemNotBorrowedError;

/**
 * Created by tchia on 26/6/14.
 */
public class LibraryItem {
    boolean borrowedStatus;

    public boolean isBorrowed(){
        return borrowedStatus;
    }

    public LibraryItem() {
        this.borrowedStatus = false;
    }

    public void borrowItem(){
        if(borrowedStatus) {
            throw new LibraryItemAlreadyBorrowedError();
        }
        borrowedStatus = true;
    }

    public void returnItem() {
        if (!borrowedStatus) { throw new LibraryItemNotBorrowedError(); }
        borrowedStatus = false;
    }
}
