package com.twu.biblioteca;


import java.awt.print.Book;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;

/**
 * Created by tiffaniechia on 19/06/2014.
 */
public class BibliotecaApp {

    public static void main(String[] args) {
        String firstInputChoice= "";
        BooksDatabase books1 = new BooksDatabase("harry potter", "jk rowling", 1997);
        Books books = new Books();
        books.checkIn(books1.getTitle());
        BibliotecaApp app = new BibliotecaApp();
        System.out.println(app.welcomeMessage());
        System.out.println(app.menuOptions());
        firstInputChoice = app.userFirstInput();
        System.out.println(app.readFirstInput(firstInputChoice));
        String secondInputChoice = app.userSecondInput();
        System.out.println(app.showBookInformation(secondInputChoice));
        System.out.println(app.bookActionOptions());
        String thirdInputChoice = app.userThirdInput();
        System.out.println(app.readThirdInput(thirdInputChoice, secondInputChoice));
    }


    public String welcomeMessage() {
        return "Welcome to Biblioteca";
    }

    public String menuOptions() {
        return "Hit 1 for list of books\nHit 2 to quit";
    }

    public String userFirstInput() {
        Scanner firstInput = new Scanner(System.in);
        String firstInputResult = firstInput.nextLine();
        return firstInputResult;
    }

    public String readFirstInput(String firstInputResult) {
        if(firstInputResult.equals("1")){
            System.out.println(showListOfBooks());
            return "Type in the title of the book to perform an action or get information";
        }else {
            if (firstInputResult.equals("2")) {
                System.exit(0);
                return "";
            } else {
                return "Select a valid option!";
            }
        }
    }

    public List showListOfBooks() {
       System.out.println("These are the available books");
       return Books.availableBooksList;
    }

    public String userSecondInput() {
        Scanner secondInput = new Scanner(System.in);
        String secondInputResult = secondInput.nextLine();
        return secondInputResult;
    }

    public String showBookInformation(String secondInputResult) {
        if (BooksDatabase.getTitle().equals(secondInputResult)){
            return (BooksDatabase.getAuthor() + ", " + BooksDatabase.getPublishedDate()).toString();
        }else{
            System.out.println("Book not found, system exit");
            System.exit(0);
            return "";
        }
    }

    public String bookActionOptions() {
        return "\nHit 1 to checkout this book\nHit 2 to quit";
    }

    public String userThirdInput() {
        Scanner thirdInput = new Scanner(System.in);
        String thirdInputResult = thirdInput.nextLine();
        return thirdInputResult;
    }

    public String readThirdInput(String thirdInputResult, String secondInputResult) {
        if(thirdInputResult.equals("1")){
            Object resultToObject = secondInputResult;
            return Books.checkOut(resultToObject);
        }else if(thirdInputResult.equals("2")){
            System.exit(0);
            return "";
        }else{
            return "Option not valid, system exit";
        }
    }
}
