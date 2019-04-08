package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {

        BibliotecaApp bib = new BibliotecaApp();

        bib.greet();

        int option = 0;

        do{

            bib.displayMenu();
            option = getOption();
            processOption(option);

        } while (option != 0);

    }

    public void greet() {

        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }


    public static List<String> getListOfBooks() {

        List<String> listOfBooks = new ArrayList<String>();

        listOfBooks.add("TDD By Example | Kent Beck | 2000");
        listOfBooks.add("The Clean Coder | Uncle Bob | 2011");

        return listOfBooks;
    }

    public void displayMenu() {

        System.out.println("1. View List Of Books\n2. Check-out Book\n3. Return Book\n0. Quit application");
    }

    public static int getOption() {

        Scanner input = new Scanner(System.in);

        int option = input.nextInt();

        return option;
    }

    public static void processOption(int option) {

        switch (option) {

            case 0:
                System.exit(0);
                break;

            case 1:
                System.out.println(getListOfBooks());
                break;

            case 2:
                break;

            case 3:
                break;

            default:
                System.out.println("Please select a valid option!");
        }
    }
}