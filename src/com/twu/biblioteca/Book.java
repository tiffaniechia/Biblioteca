package com.twu.biblioteca;

/**
 * Created by tiffaniechia on 20/06/2014.
 */

public class Book extends LibraryItem {
    String title;
    String author;
    int publishedDate;

    public Book(String title, String author, int publishedDate){
        super();
        this.title = title;
        this.author = author;
        this.publishedDate = publishedDate;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public int getPublishedDate(){
        return publishedDate;
    }

    //boolean preferable to is is_ rather than get_

    //    Similar unrefactored version of the one before, always better to run a positive than a negatice
//      public void borrow(){
//        if(!borrowedStatus) {
//            borrowedStatus = true;
//        } else {
//            throw new LibraryItemAlreadyBorrowedError();
//        }
//    }


    @Override
    public String toString() {
        return author+", "+ publishedDate;
    }
}
