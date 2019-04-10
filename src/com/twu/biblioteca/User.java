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

    public boolean verifyPassword(String password) {
        if (this.password.equals(password)) {
            return true;
        }
        return false;
    }
}