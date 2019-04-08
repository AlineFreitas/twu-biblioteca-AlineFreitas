package com.twu.biblioteca;

import java.util.List;

public class Library {
    private List<Book> catalog;

    public Library(List<Book> catalog) {
        this.catalog = catalog;
    }


    public boolean checkoutBook(String bookTitle) {

        return false;
    }

    public boolean returnBook(String bookTitle) {
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
