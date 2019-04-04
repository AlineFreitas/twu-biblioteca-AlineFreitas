package com.twu.biblioteca;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BibliotecaAppTest {

    @Test
    public void shouldGreetUser() {

        assertThat(
                BibliotecaApp.greet(),
                is("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!")
        );
    }

    @Test
    public void sholdHaveAListOfBooks() {

        BibliotecaApp biblioteca = new BibliotecaApp();

        List<String> books = new ArrayList<String>();
        books.add("TDD By Example | Kent Beck | 2000");
        books.add("The Clean Coder | Uncle Bob | 2011");

        assertThat(
                biblioteca.getListOfBooks(),
                is(books)
        );
    }

    @Test
    public void shouldDisplayMenu() {

        assertThat(
                BibliotecaApp.displayMenu(),
                is("1. View List Of Books")
        );
    }

    @Test
    public void shouldPrintListOfBooksWhenUserSelectOption1() {

        BibliotecaApp.processOption(1);
        assertThat(
                ,
                is(BibliotecaApp.getListOfBooks().toString())
        );
    }

    @Test
    @Ignore
    public void shouldNotifyIfOptionIsInvalid() {

        //assertThat(
        //        BibliotecaApp.processOption(-1),
        //        is("Please select a valid option!")
        //);
    }

    @Test
    public void shouldExitApplicationWhenISelectThisOption() {



    }
}