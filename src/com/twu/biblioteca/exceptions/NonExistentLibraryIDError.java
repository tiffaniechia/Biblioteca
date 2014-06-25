package com.twu.biblioteca.exceptions;

/**
 * Created by tiffaniechia on 25/06/2014.
 */
public class NonExistentLibraryIDError extends RuntimeException {
    public NonExistentLibraryIDError() {
        super("No such library ID");
    }
}
