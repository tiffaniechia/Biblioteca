package com.twu.biblioteca;

import java.util.Hashtable;

/**
 * Created by tiffaniechia on 20/06/2014.
 */
public class BooksDatabase {

    //database to record books belonging to a library
    //differs from available books, in that this is does not change
    //when books are being returned and checked out

    public static String title;
    public static String author;
    public static int publishedDate;


    public  BooksDatabase(String title, String author, int publishedDate){
        this.title = title;
        this.author = author;
        this.publishedDate = publishedDate;
    }

    public static String getTitle(){
        return title;
    }

    public static String getAuthor(){
        return author;
    }

    public static int getPublishedDate(){
        return publishedDate;
    }

}
