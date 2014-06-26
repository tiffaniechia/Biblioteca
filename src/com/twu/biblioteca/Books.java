package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.NonExistentItemError;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tiffaniechia on 19/06/2014.
 */
public class Books {

   public List<Book> booksList = new ArrayList<Book>();

   public int arrayCount(){
        return booksList.size();
    }

    public void registerBook(Book book) {
        booksList.add(book);
        System.out.println("Thank you for returning the book");
    }

    private Book findBookWithTitle(String bookTitle){
        for(Book book: booksList){
            if(book.getTitle().equals(bookTitle)){
                return book;
            }
        }
        throw new NonExistentItemError();
    }

    public void checkIn(String bookTitle){
        Book selectedBook = findBookWithTitle(bookTitle);
        selectedBook.returnItem();
    }

    public void checkOut(String bookTitle) {
        Book selectedBook = findBookWithTitle(bookTitle);
        selectedBook.borrowItem();
    }

    @Override
    public String toString() {
        String result = "";
        for (Book book: booksList){
            result += book.toString() + "\n";
        }
        return result;
    }
}
