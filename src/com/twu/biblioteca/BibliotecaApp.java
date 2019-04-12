package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    private Library library;
    private static User loggedUser;

    public static void main(String[] args) {

        BibliotecaApp bib = new BibliotecaApp();
        BibliotecaApp.greet();

        bib.library = new Library();

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

        if(loggedUser == null) {
            System.out.println("7. Login");
        } else {
            System.out.println("7. View Personal Information");
        }
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
                if (loggedUser == null) {
                    processOption(7);
                }
                System.out.println("Type the book title to checkout:");
                bookTitle = input.nextLine();
                library.borrowBook(bookTitle, loggedUser.getLibraryNumber());
                break;

            case 3:
                System.out.println("Type the book title to return:");
                bookTitle = input.nextLine();
                this.library.returnBook(bookTitle);
                break;

            case 4:
                library.printAvailableMovies();
                break;

            case 5:
                System.out.println("Type the movie title to checkout:");
                movieTitle = input.nextLine();
                library.borrowMovie(movieTitle);
                break;

            case 6:
                System.out.println("Type the movie title to return:");
                movieTitle = input.nextLine();
                library.returnMovie(movieTitle);
                break;

            case 7:
                if (loggedUser == null) {
                    do {
                        System.out.println("Type the library number:");
                        String libraryNumber = input.nextLine();
                        System.out.println("Type the password:");
                        String password = input.nextLine();
                        loggedUser = UserHandler.login(libraryNumber, password);
                        if (loggedUser == null) {
                            System.out.println("Library number or password are incorrect, please try again");
                        }
                    } while (loggedUser == null);
                } else {
                    loggedUser.printPersonalInfo();
                }
                break;
            default:
                System.out.println("Please select a valid option!");
        }
    }
}