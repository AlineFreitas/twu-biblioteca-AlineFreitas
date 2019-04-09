package com.twu.biblioteca;

public class User {
    private String libraryNumber;
    private String password;

    public User(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public String getLibraryNumber() {
        return this.libraryNumber;
    }

    public boolean login(String libraryNumber, String password) {
        if (this.libraryNumber == libraryNumber && this.password == password) {
            return true;
        }
        return false;
    }

    public boolean verifyPassword(String password) {
        if (this.password == password) {
            return true;
        }
        return false;
    }
}