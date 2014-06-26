package com.twu.biblioteca.exceptions;

/**
 * Created by tchia on 26/6/14.
 */
public class NeedToBeLoggedInError extends RuntimeException {
    public NeedToBeLoggedInError(){
        super("You need to be logged in to see this section");
    }
}
