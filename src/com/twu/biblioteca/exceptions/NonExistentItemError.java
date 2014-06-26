package com.twu.biblioteca.exceptions;

/**
 * Created by tchia on 26/6/14.
 */
public class NonExistentItemError extends RuntimeException {
    public NonExistentItemError(){
        super("Item entered does not exist");
    }
}
