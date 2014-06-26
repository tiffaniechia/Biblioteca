package com.twu.biblioteca;


import com.twu.biblioteca.exceptions.NeedToBeLoggedInError;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
* Created by tiffaniechia on 19/06/2014.
*/
public class BibliotecaApp {

    private Users users;
    private Movies movies;
    private Books books;
    private User currentUser;

    public BibliotecaApp(Books books, Movies movies, Users users) {
        this.movies = movies;
        this.books = books;
        this.users = users;
    }

    public BibliotecaApp() {
        movies = new Movies();
        users = new Users();
        books = new Books();
    }

    public static void main(String[] args) {
        // setting up variables to test on console
        String firstInputChoice = "";
        Book books1 = new Book("harry potter", "jk rowling", 1997);
        Movie movie1 = new Movie("hp movie", 1997, "director", 10);
        Books books = new Books();
        Movies movies = new Movies();

        books.registerBook(books1);
        books.registerBook(new Book("Book number 2", "duo", 2014));
        movies.registerMovie(movie1);

        Users users = new Users();
        users.registerNewUser(new User("1", "pass", "1", "email", 1));

        BibliotecaApp app = new BibliotecaApp(books, movies, users);
        app.run();
    }

    private void run() {
        while (true) {
            System.out.println(welcomeMessage());
            System.out.println(menuOptions());
            System.out.print("> ");

            String command = readLine();

            try {
                runCommand(command);
            } catch (RuntimeException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private void runCommand(String command) {
        if (command.equals("q")) {
            System.exit(0);
        } else if (command.equals("0")) {
            loginAction();
        } else if (command.equals("1")) {
            borrowBookAction();
        } else if (command.equals("3")) {
            returnBookAction();
        } else if (command.equals("2")) {
            borrowMovieAction();
        } else if (command.equals("4")) {
            returnMovieAction();
        } else if (command.equals("5")) {
            printUserDetailsAction();
        }
    }

    private void printUserDetailsAction() {
        if (userHasNotLoggedIn()) {throw new NeedToBeLoggedInError();}
        System.out.println(currentUser.toString());
    }

    private boolean userHasNotLoggedIn() {
        return currentUser == null;
    }

    private void returnMovieAction() {
        System.out.println(movies);
        System.out.print("enter the title of the movie you want to return: ");

        String movieTitle = readLine();
        System.out.println("Returning movie " + movieTitle);
        movies.checkIn(movieTitle);
    }

    private void borrowMovieAction() {
        System.out.println("Showing list of movies");
        System.out.println(movies);
        System.out.print("enter the title of the movie you want to borrowItem: ");

        String movieTitle = readLine();
        System.out.println("Borrowing movie " + movieTitle);
        movies.checkOut(movieTitle);
    }

    private void returnBookAction() {
        System.out.println(books);
        System.out.print("enter the title of the book you want to return: ");

        String bookTitle = readLine();
        System.out.println("Returning book " + bookTitle);
        books.checkIn(bookTitle);
    }

    private void borrowBookAction() {
        System.out.println("Showing list of books");
        System.out.println(books);
        System.out.print("enter the title of the book you want to borrowItem: ");

        String bookTitle = readLine();
        System.out.println("Borrowing book " + bookTitle);
        books.checkOut(bookTitle);
    }

    private void loginAction() {
        System.out.print("Login!!\nEnter your libraryID: ");
        String libraryID = readLine();
        System.out.print("Enter your password: ");
        String password = readLine();

        User selectedUser = users.getUserInformation(libraryID);
        if (selectedUser.getPassword().equals(password)) {
            currentUser = selectedUser;
        } else {
            System.out.print("Invalid login details");
        }
    }

    private String readLine() {
        return new Scanner(System.in).nextLine();
    }

    public String welcomeMessage() {
        return "\nWelcome to Biblioteca\n";
    }

    public String menuOptions() {
        return "Hit 0 to login\n" +
                "Hit 1 to borrow a book & see list of books\n" +
                "Hit 2 to borrow a movie & see list of movies\n" +
                "Hit 3 to return a book\n" +
                "Hit 4 to return a movie\n" +
                "Hit 5 to print current user info\n" +
                "Hit q to quit";
    }

}
