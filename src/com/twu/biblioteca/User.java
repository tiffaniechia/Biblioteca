package com.twu.biblioteca;

/**
 * Created by tiffaniechia on 24/06/2014.
 */
public class User {

    public String libraryNumber;
    public String password;
    public String userName;
    public String emailAddress;
    public int phoneNumber;

    public User(String libraryNumber, String password, String userName, String emailAddress, int phoneNumber){
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.userName = userName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

   public  String getLibraryNumber(){
       return libraryNumber;
   }

   public  String getPassword(){
       return password;
   }

   public String getUserName(){
       return userName;
   }

   public String getEmailAddress(){
       return emailAddress;
   }

   public int getPhoneNumber(){
       return phoneNumber;
   }
}
