package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println(greet());
        System.out.println(getListOfBooks());
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


}
