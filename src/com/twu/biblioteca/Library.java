package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> catalog;

    public Library(List<Book> catalog) {
        this.catalog = catalog;
    }


    public boolean checkoutBook(String bookTitle) {
        Book book = getBookByTitle(bookTitle);

        if (book == null) {
            return false;
        } else {
            if (book.isAvailable()) {
                book.check_out();
                System.out.println("Thank you! Enjoy the book");
                return true;
            }
        }
        System.out.println("Sorry, that book is not available");
        return false;
    }

    public boolean returnBook(String bookTitle) {
        Book book = getBookByTitle(bookTitle);

        if (book == null) {
            System.out.println("That is not a valid book to return");
            return false;
        } else {
            if (!book.isAvailable()) {
                book.check_in();
                System.out.println("Thank you for returning the book");
                return true;
            }
        }
        return false;
    }

    public Book getBookByTitle(String bookTitle) {
        for (Book book : catalog) {
            if (book.getTitle().equals(bookTitle)) {
                return book;
            }
        }
        return null;
    }

    public List<Book> getListOfAvailableBooks() {

        List<Book> listOfBooks = new ArrayList<Book>();

        for (Book book : catalog) {
            if (book.isAvailable()) {
                listOfBooks.add(book);
            }
        }

        return listOfBooks;
    }

    public void printAvailableBooks() {

        for (Book book : getListOfAvailableBooks()) {
            System.out.println(book.toString());
        }
    }
}
