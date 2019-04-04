package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {

        System.out.println(greet());
        System.out.println(displayMenu());
        System.out.println(processOption(getOption()));
    }

    public static String greet() {

        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }


    public static List<String> getListOfBooks() {

        List<String> listOfBooks = new ArrayList<String>();

        listOfBooks.add("TDD By Example | Kent Beck | 2000");
        listOfBooks.add("The Clean Coder | Uncle Bob | 2011");

        return listOfBooks;
    }

    public static String displayMenu() {

        return "1. View List Of Books";
    }

    public static int getOption() {

        Scanner input = new Scanner(System.in);
        int option = input.nextInt();

        return option;
    }

    public static List<String> processOption(int option) {

        switch (option) {
            case 1: return getListOfBooks();
        }
        return null;
    }
}