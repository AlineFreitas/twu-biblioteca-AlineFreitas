package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> bookCatalog;
    private List<Movie> movieCatalog;
    private List<User> userList;

    public Library(List<Book> bookCatalog, List<Movie> movieCatalog) {
        this.bookCatalog = bookCatalog;
        this.movieCatalog = movieCatalog;
    }


    public boolean borrowBook(String bookTitle) {
        Book book = getBookByTitle(bookTitle);

        if (book == null) {
            System.out.println("Sorry, that book is not available");
            return false;
        } else {
            if (book.isAvailable()) {
                book.checkOut();
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
                book.checkIn();
                System.out.println("Thank you for returning the book");
                return true;
            }
        }
        return false;
    }

    public Book getBookByTitle(String bookTitle) {
        for (Book book : bookCatalog) {
            if (book.getTitle().equals(bookTitle)) {
                return book;
            }
        }
        return null;
    }

    public List<Book> getListOfAvailableBooks() {

        List<Book> listOfBooks = new ArrayList<Book>();

        for (Book book : bookCatalog) {
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

    public void printAvailableMovies() {

        for (Movie movie : getListOfAvailableMovies()) {
            System.out.println(movie.toString());
        }
    }

    private List<Movie> getListOfAvailableMovies() {
        List<Movie> listOfMovies = new ArrayList<Movie>();

        for (Movie movie : movieCatalog) {
            if (movie.isAvailable()) {
                listOfMovies.add(movie);
            }
        }
        return listOfMovies;
    }

    public boolean borrowMovie(String movieTitle) {

        Movie movie = getMovieByTitle(movieTitle);

        if (movie == null) {
            System.out.println("Sorry, that movie is not available");
            return false;
        } else {
            if (movie.isAvailable()) {
                movie.checkOut();
                System.out.println("Thank you! Enjoy the movie");
                return true;
            }
        }
        System.out.println("Sorry, that movie is not available");
        return false;
    }

    public Movie getMovieByTitle(String movieTitle) {

        for (Movie movie : movieCatalog) {
            if (movie.getTitle().equals(movieTitle)) {
                return movie;
            }
        }
        return null;
    }

    public void returnMovie(String movieTitle) {
    }
}
