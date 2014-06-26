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

        books.checkIn(books1);
        movies.checkInMovieTitle(movie1);

        Users users = new Users();

        BibliotecaApp app = new BibliotecaApp(books, movies, users);


        System.out.println(app.welcomeMessage());
        System.out.println(app.menuOptions());
        firstInputChoice = app.userFirstInput();
        System.out.println(app.readFirstInput(firstInputChoice));
        String secondInputChoice = app.userSecondInput();
        if (firstInputChoice.equals("1")) {
            System.out.println(app.showBookInformation(secondInputChoice));
            System.out.println(app.bookActionOptions());
        }else if(firstInputChoice.equals("2")){
            System.out.println(app.showMovieInformation(secondInputChoice));
            System.out.println(app.movieActionOptions());
        }else{
            System.out.println("unexpected error");
        }
        String thirdInputChoice = app.userThirdInput();
        if (firstInputChoice.equals("1")) {
            System.out.println(app.readThirdInputBooks(thirdInputChoice, secondInputChoice));
        }else if(firstInputChoice.equals("2")) {
            System.out.println(app.readThirdInputMovies(thirdInputChoice, secondInputChoice));
        }else{
            System.out.println("unexpected error");
        }

    }


    public String welcomeMessage() {
        return "Welcome to Biblioteca";
    }

    public String menuOptions() {
        return "Hit 1 for list of books\nHit 2 to view list of movies\nHit q to quit";
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
        }else if (firstInputResult.equals("q")) {
             System.exit(0);
             return "";
        }else if(firstInputResult.equals("2")){
            System.out.println(showListOfMovies());
            return "Type the title of the movie to perform an action or to learn more";
        }else {
            return "Select a valid option!";
        }
    }



    public List showListOfBooks() {
       System.out.println("These are the available books");
       ArrayList<String> names = new ArrayList<String>();
       for(Book book:books.availableBooksList){
            names.add(book.getTitle());
        }
       return names;
    }

    public String userSecondInput() {
        Scanner secondInput = new Scanner(System.in);
        String secondInputResult = secondInput.nextLine();
        return secondInputResult;
    }

    public String showBookInformation(String secondInputResult) {
        for(Book book:books.availableBooksList){
            if(book.getTitle().equals(secondInputResult)){
                return book.toString();
            }
        }
        System.out.println("Book not found, system exit");
        System.exit(0);
        return "";
    }

    public String bookActionOptions() {
        return "\nHit 1 to checkout this book\nHit q to quit";
    }

    public String movieActionOptions() {
        return "\nHit 1 to checkout this movie\nHit q to quit";
    }


    public String userThirdInput() {
        Scanner thirdInput = new Scanner(System.in);
        String thirdInputResult = thirdInput.nextLine();
        return thirdInputResult;
    }

    public String readThirdInputBooks(String thirdInputResult, String secondInputResult) {
        if (thirdInputResult.equals("1")) {
            return books.checkOut(secondInputResult);
        } else if (thirdInputResult.equals("q")) {
            System.exit(0);
            return "";
        } else {
            return "Option not valid, system exit";
        }
    }

    public List showListOfMovies() {
        System.out.println("These are the available movies");
        ArrayList<String> names = new ArrayList<String>();
        for(Movie movie:movies.availableMoviesList){
           names.add(movie.getName());
        }
        return names;
    }

    public String showMovieInformation(String secondInputResult) {
        for(Movie movie:movies.availableMoviesList){
            if(movie.getName().equals(secondInputResult)){
                return movie.toString();
            }
        }
        System.out.println("Movie not found, system exit");
        System.exit(0);
        return "";

    }

    public String readThirdInputMovies(String thirdInputResult, String secondInputResult) {
        if (thirdInputResult.equals("1")) {
            return movies.checkOut(secondInputResult);
        } else if (thirdInputResult.equals("q")) {
            System.exit(0);
            return "";
        } else {
            return "Option not valid, system exit";
        }
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
