package com.twu.biblioteca;

public class Movie extends Borrowable {

    String title;
    int releaseYar;
    int rating;
    String directorName;

    public Movie(String title, int releaseYar, int rating, String directorName) {
        this.title = title;
        this.releaseYar = releaseYar;
        this.rating = rating;
        this.directorName = directorName;
    }

    @Override
    public String toString(){
        return this.title + " | " + this.releaseYar + " | " + this.directorName + " | " + this.rating;
    }
}