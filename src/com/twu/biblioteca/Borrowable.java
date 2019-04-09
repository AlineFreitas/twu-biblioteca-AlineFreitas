package com.twu.biblioteca;

public class Borrowable {

    boolean available;

    Borrowable(){
        this.available = true;
    }


    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void checkOut() {
        this.available = false;
    }

    public boolean isAvailable() {
        return this.available;
    }

    public void checkIn() {
        setAvailable(true);
    }
}