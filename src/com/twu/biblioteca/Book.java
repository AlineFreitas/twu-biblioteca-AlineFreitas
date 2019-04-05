package com.twu.biblioteca;

public class Book {

    private String author;
    private int publishYear;
    private String title;

    Book(String title, int publishYear, String author){
        this.title = title;
        this.publishYear = publishYear;
        this.author = author;

    }

    public String getTitle() {
        return this.title;
    }

    public int getPublishYear() {
        return this.publishYear;
    }

    public String getAuthor() {
        return this.author;
    }
}
