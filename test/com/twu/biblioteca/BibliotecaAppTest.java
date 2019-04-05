package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BibliotecaAppTest {

    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setup() {

        System.setOut(new PrintStream(outContent));
    }

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
                is("1. View List Of Books\n2. Check-out Book\n3. Return Book\n0. Quit application")
        );
    }

    @Test
    public void shouldPrintListOfBooksWhenUserSelectOption1() {

        BibliotecaApp.processOption(1);
        assertThat(
                outContent.toString(),
                is(BibliotecaApp.getListOfBooks().toString() + "\n")
        );
    }

    @Test
    public void shouldNotifyIfOptionIsInvalid() {

        BibliotecaApp.processOption(-1);

        assertThat(
                outContent.toString(),
                is("Please select a valid option!\n")
        );
    }

    @Test
    @Ignore
    public void shouldExitApplicationWhenISelectThisOption() {

//        assertThat(
//                BibliotecaApp.processOption(0),
//                is(System.exit(0))
//        );
    }
}