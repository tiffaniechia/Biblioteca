package com.twu.biblioteca;


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

    public BibliotecaApp(Books books, Movies movies, Users users){
        this.movies = movies;
        this.books = books;
        this.users = users;
    }

    public BibliotecaApp(){
        movies = new Movies();
        users = new Users();
        books = new Books();
    }

    public static void main(String[] args) {
        // setting up variables to test on console
        String firstInputChoice= "";
        Book books1 = new Book("harry potter", "jk rowling", 1997);
        Movie movie1 = new Movie("hp movie",1997,"director",10);
        Books books = new Books();
        Movies movies = new Movies();

        books.registerBook(books1);
        books.registerBook(new Book("Book number 2", "duo", 2014));
        movies.registerMovie(movie1);

        Users users = new Users();

        BibliotecaApp app = new BibliotecaApp(books, movies, users);

        while (true) {
            System.out.println(app.welcomeMessage());
            System.out.println(app.menuOptions());
            System.out.print("> ");
            String command = new Scanner(System.in).nextLine();
            if (command.equals("q")) {
                break;
            } else if (command.equals("1")){
                System.out.println("Showing list of books");
                System.out.println(books);
                System.out.print("enter the title of the book you want to borrowItem: ");

                String bookTitle = new Scanner(System.in).nextLine();
                System.out.println("Borrowing book " + bookTitle);
                books.checkOut(bookTitle);
            } else if(command.equals("3")){
                System.out.println(books);
                System.out.print("enter the title of the book you want to return: ");

                String bookTitle = new Scanner(System.in).nextLine();
                System.out.println("Returning book " + bookTitle);
                books.checkIn(bookTitle);
            } else if(command.equals("2")){
                System.out.println("Showing list of movies");
                System.out.println(movies);
                System.out.print("enter the title of the movie you want to borrowItem: ");

                String movieTitle = new Scanner(System.in).nextLine();
                System.out.println("Borrowing book " + movieTitle);
                movies.checkOut(movieTitle);
            }  else if(command.equals("4")) {
                System.out.println(movies);
                System.out.print("enter the title of the movie you want to return: ");

                String movieTitle = new Scanner(System.in).nextLine();
                System.out.println("Returning book " + movieTitle);
                movies.checkIn(movieTitle);
            }
        }

    }

    public String welcomeMessage() {
        return "Welcome to Biblioteca";
    }

    public String menuOptions() {
        return "Hit 1 to borrowItem a book & see list of books\nHit 2 to borrowItem a movie & see list of movies\nHit 3 to return a book\nHit 4 to return a movie\nHit q to quit";
    }

    public String userFirstInput() {
        Scanner firstInput = new Scanner(System.in);
        String firstInputResult = firstInput.nextLine();
        return firstInputResult;
    }

    public String ShowUserInformation(String s) {
//        return Users.getUserInformation(s);
        return null;
    }

    public String logInLibNumInput(){
        System.out.println("Please enter your library number");
        Scanner loginLibNumInput = new Scanner(System.in);
        String loginLibNumInputResult = loginLibNumInput.nextLine();
        return loginLibNumInputResult;
    }

    public String logInPassInput(){
        System.out.println("Please enter your password");
        Scanner loginPassInput = new Scanner(System.in);
        String loginPassInputResult = loginPassInput.nextLine();
        return loginPassInputResult;
    }

    public boolean logIn(String loginLibNumInputResult, String loginPassInputResult){
        User user = users.getUserInformation(loginLibNumInputResult);
        return user.getPassword().equals(loginPassInputResult);
    }
}
