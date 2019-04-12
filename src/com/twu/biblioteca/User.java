package com.twu.biblioteca;

public class User {
    private String libraryNumber;
    private String name;
    private String email;
    private String phoneNumber;
    private String password;

    public User(String libraryNumber, String name, String email, String phoneNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
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

    public void printPersonalInfo() {
        System.out.println("----Personal Information ----");
        System.out.println("Name: " + this.name);
        System.out.println("E-mail: " + this.email);
        System.out.println("Phone Number: " + this.phoneNumber);
        System.out.println("-----------------------------");
    }
}