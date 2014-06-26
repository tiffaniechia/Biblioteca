package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.NonExistentLibraryIDError;
import org.junit.Test;

import static org.junit.Assert.*;

public class UsersTest {

    @Test
    public void shouldStartWithZeroRegisteredUsers(){
        Users users = new Users();
        int result = users.arrayCount();
        assertEquals(0, result);
    }

    @Test
    public void shouldAddOneUserToRegisteredList(){
        User user1 = new User("123-1234","password123","john","j@j.com",81009032);
        Users users = new Users();
        users.registerNewUser(user1);
        int result = users.arrayCount();
        assertEquals(1, result);
    }

    @Test
    public void shouldBeAbleToReadInformation(){
        Users users = new Users();
        User user2 = new User("123-1234","password123","John","j@j.com",81009032);
        users.registerNewUser(user2);

        User fetchedUserDB = users.getUserInformation("123-1234");
        assertEquals("John", fetchedUserDB.getUserName());
    }


    @Test
    public void shouldBeAbleToReadInformation2(){
        Users users = new Users();
        User user2 = new User("123-1234","password123","John","j@j.com",81009032);
        users.registerNewUser(user2);

        User otherUserDB = new User("123-000","password123","Sam","j@j.com",81009032);
        users.registerNewUser(otherUserDB);


        User fetchedUserDB = users.getUserInformation("123-000");
        assertEquals("Sam", fetchedUserDB.getUserName());
    }

    @Test
    public void testGetInformation_shouldThrowError_whenUserNotExist() throws Exception {
        Users users = new Users();

        try {
            users.getUserInformation("NonExistentLibraryID");
            fail();
        } catch (NonExistentLibraryIDError ex) {
            assertEquals("No such library ID", ex.getMessage());
        }
    }
    //similar to previous method!
    @Test(expected = NonExistentLibraryIDError.class)
    public void testGetInformation_shouldThrowError_whenUserNotExist2() throws Exception {
        Users users = new Users();
        users.getUserInformation("NonExistentLibraryID");
    }
}