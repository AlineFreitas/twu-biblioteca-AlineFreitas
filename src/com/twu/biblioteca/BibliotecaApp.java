package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    private Library library;

    public static void main(String[] args) {

        BibliotecaApp bib = new BibliotecaApp();
        BibliotecaApp.greet();

        List<Book> catalog = new ArrayList<Book>();

        catalog.add(new Book("TDD By Example", 2002, "Kent Beck"));
        catalog.add(new Book("The Clean Coder", 2011, "Uncle Bob"));
        catalog.add(new Book("Clean Code", 2008, "Uncle Bob"));
        catalog.add(new Book("The Pragmatic Programmer", 1999, "Andrew Hunt"));

        bib.library = new Library(catalog);

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


    public static List<String> getListOfBooks() {

        List<String> listOfBooks = new ArrayList<String>();

        listOfBooks.add("TDD By Example | Kent Beck | 2000");
        listOfBooks.add("The Clean Coder | Uncle Bob | 2011");

        return listOfBooks;
    }

    public static void displayMenu() {

        System.out.println("1. View List Of Books\n2. Check-out Book\n3. Return Book\n0. Quit application");
    }

    public static int getOption() {

        Scanner input = new Scanner(System.in);

        int option = input.nextInt();

        return option;
    }

    public void processOption(int option) {
        Scanner input = new Scanner(System.in);

        switch (option) {

            case 0:
                System.exit(0);
                break;

            case 1:
                this.library.printAvailableBooks();
                break;

            case 2:
                System.out.println("Type the book title to checkout:");
                String bookTitle = input.nextLine();
                this.library.checkoutBook(bookTitle);
                break;

            case 3:
                System.out.println("Type the book title to return:");
                bookTitle = input.nextLine();
                this.library.returnBook(bookTitle);
                break;

            default:
                System.out.println("Please select a valid option!");
        }
    }
}