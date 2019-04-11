package com.twu.biblioteca;

public class Borrowable {

    boolean available;
    String title;

    Borrowable(){
        this.available = true;
    }

    public String getTitle() {
        return this.title;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

}