package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tiffaniechia on 19/06/2014.
 */
public class Books {

   public List<Book> availableBooksList = new ArrayList<Book>();

   public int arrayCount(){
        return availableBooksList.size();
    }

    public void registerBook(Book book) {
        availableBooksList.add(book);
        System.out.println("Thank you for returning the book");
    }

    public void checkInBook(String bookTitle){
        for(Book book:availableBooksList){
            if(book.getTitle().equals(bookTitle)){
                book.returnBook();
            }
        }
    }

    public String checkOut(String bookTitle) {
        for(Book book:availableBooksList){
            if(book.getTitle().equals(bookTitle)){
                book.borrow();
                return "Thank you! Enjoy the book";
            }
        }return "That book is not available";
    }

    @Override
    public String toString() {
        String result = "";
        for (Book book: availableBooksList){
            result += book.toString() + "\n";
        }
        return result;
    }
}
