package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    private Library library;

    public static void main(String[] args) {

        BibliotecaApp bib = new BibliotecaApp();
        BibliotecaApp.greet();

        List<Book> bookCatalog = new ArrayList<Book>();
        List<Movie> movieCatalog = new ArrayList<Movie>();

        bookCatalog.add(new Book("TDD By Example", 2002, "Kent Beck"));
        bookCatalog.add(new Book("The Clean Coder", 2011, "Uncle Bob"));
        bookCatalog.add(new Book("Clean Code", 2008, "Uncle Bob"));
        bookCatalog.add(new Book("The Pragmatic Programmer", 1999, "Andrew Hunt"));

        movieCatalog.add(new Movie("Kill Bill Vol. 1", 2003, 8, "Quentin Tarantino"));
        movieCatalog.add(new Movie("Snatch", 2000, 8, "Guy Ritchie"));
        movieCatalog.add(new Movie("Get Out", 2017, 8, "Jordan Peele"));
        movieCatalog.add(new Movie("Pulp Fiction", 1994, 9, "Quentin Tarantino"));

        bib.library = new Library(bookCatalog, movieCatalog);

        UserHandler.setUserList();

        int option;

        do{
            BibliotecaApp.displayMenu();
            option = getOption();
            bib.processOption(option);
        } while (option != 0);

    }

    public static void greet() {

        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    public static void displayMenu() {


        System.out.println("--------------Book Section------------------");
        System.out.println(
                "1. View List Of Books\n" +
                "2. Check-out Book\n" +
                "3. Return Book"
        );
        System.out.println("--------------Movie Section-----------------");
        System.out.println(
                "4. View List Of Movies\n" +
                "5. Check-out Movie\n" +
                "6. Return Movie");
        System.out.println("--------------User Section-----------------");
        System.out.println("7. Login");
        System.out.println("0. Quit application");
    }

    public static int getOption() {

        Scanner input = new Scanner(System.in);

        int option = input.nextInt();

        return option;
    }

    public void processOption(int option) {
        Scanner input = new Scanner(System.in);
        String bookTitle;
        String movieTitle;

        switch (option) {

            case 0:
                System.exit(0);
                break;

            case 1:
                this.library.printAvailableBooks();
                break;

            case 2:
                System.out.println("Type the book title to checkout:");
                bookTitle = input.nextLine();
                this.library.borrowBook(bookTitle);
                break;

            case 3:
                System.out.println("Type the book title to return:");
                bookTitle = input.nextLine();
                this.library.returnBook(bookTitle);
                break;

            case 4:
                this.library.printAvailableMovies();
                break;

            case 5:
                System.out.println("Type the movie title to checkout:");
                movieTitle = input.nextLine();
                this.library.borrowMovie(movieTitle);
                break;

            case 6:
                System.out.println("Type the movie title to return:");
                movieTitle = input.nextLine();
                this.library.returnMovie(movieTitle);
                break;

            case 7:
                System.out.println("Type the library number:");
                String libraryNumber = input.nextLine();
                System.out.println("Type the password:");
                String password = input.nextLine();
                UserHandler.login(libraryNumber, password);
                break;
            default:
                System.out.println("Please select a valid option!");
        }
    }
}