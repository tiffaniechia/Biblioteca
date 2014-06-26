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
    private User currentUser;

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
        users.registerNewUser(new User("1", "pass", "1", "email", 1));

        BibliotecaApp app = new BibliotecaApp(books, movies, users);

        while (true) {
            System.out.println(app.welcomeMessage());
            System.out.println(app.menuOptions());
            System.out.print("> ");
            String command = new Scanner(System.in).nextLine();
            if (command.equals("q")) {
                break;
            } else if(command.equals("0")){
                System.out.print("Login!!\nEnter your libraryID: ");
                String libraryID = new Scanner(System.in).nextLine();
                System.out.print("Enter your password: ");
                String password = new Scanner(System.in).nextLine();

                User selectedUser = users.getUserInformation(libraryID);
                if(selectedUser.getPassword().equals(password)){
                    app.currentUser = selectedUser;
                }else{
                    System.out.print("Invalid login details");
                }
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
            }  else if (command.equals("5")){
                if(app.currentUser == null){
                    System.out.println("You have to be logged in to see this section");
                }else {
                    System.out.println(app.currentUser.toString());
                }
            }
        }

    }

    public String welcomeMessage() {
        return "\nWelcome to Biblioteca\n";
    }

    public String menuOptions() {
        return  "Hit 0 to login\n" +
                "Hit 1 to borrow a book & see list of books\n" +
                "Hit 2 to borrow a movie & see list of movies\n" +
                "Hit 3 to return a book\n" +
                "Hit 4 to return a movie\n" +
                "Hit 5 to print current user info\n" +
                "Hit q to quit";
    }

    public String userFirstInput() {
        Scanner firstInput = new Scanner(System.in);
        String firstInputResult = firstInput.nextLine();
        return firstInputResult;
    }
//
//    public String ShowUserInformation(String s) {
//        return Users.getUserInformation(s);
//        return null;
//    }
//
//    public String logInLibNumInput(){
//        System.out.println("Please enter your library number");
//        Scanner loginLibNumInput = new Scanner(System.in);
//        String loginLibNumInputResult = loginLibNumInput.nextLine();
//        return loginLibNumInputResult;
//    }
//
//    public String logInPassInput(){
//        System.out.println("Please enter your password");
//        Scanner loginPassInput = new Scanner(System.in);
//        String loginPassInputResult = loginPassInput.nextLine();
//        return loginPassInputResult;
//    }
//
//    public boolean logIn(String loginLibNumInputResult, String loginPassInputResult){
//        User user = users.getUserInformation(loginLibNumInputResult);
//        return user.getPassword().equals(loginPassInputResult);
//    }
}
