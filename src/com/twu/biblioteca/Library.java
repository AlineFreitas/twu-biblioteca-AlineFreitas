package com.twu.biblioteca;

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
                return true;
            }
        }
        return false;
    }

    public boolean returnBook(String bookTitle) {
        Book book = getBookByTitle(bookTitle);

        if (book == null) {
            return false;
        } else {
            if (!book.isAvailable()) {
                book.check_in();
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
}
