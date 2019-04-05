package com.twu.biblioteca;

public class Book {

    private String author;
    private int publishYear;
    private String title;

    public void setAvailable(boolean available) {
        this.available = available;
    }

    private boolean available;

    Book(String title, int publishYear, String author){
        this.title = title;
        this.publishYear = publishYear;
        this.author = author;
        this.available = true;

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

    public void checkout() {
        this.available = false;
    }

    public boolean isAvailable() {
        return this.available;
    }

    public void checkin() {
        setAvailable(true);
    }
}