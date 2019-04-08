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

    private BibliotecaApp biblioteca;

    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setup() {

        biblioteca = new BibliotecaApp();

        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldGreetUser() {

        biblioteca.greet();

        assertThat(
                outContent.toString(),
                is("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n")
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

        biblioteca.displayMenu();

        assertThat(
                outContent.toString(),
                is("1. View List Of Books\n2. Check-out Book\n3. Return Book\n0. Quit application\n")
        );
    }

    @Test
    @Ignore
    public void shouldPrintListOfBooksWhenUserSelectOption1() {

        biblioteca.processOption(1);
        assertThat(
                outContent.toString(),
                is(BibliotecaApp.getListOfBooks().toString() + "\n")
        );
    }

    @Test
    public void shouldNotifyIfSelectedOptionIsInvalid() {

        biblioteca.processOption(-1);

        assertThat(
                outContent.toString(),
                is("Please select a valid option!\n")
        );
    }

    @Test
    @Ignore
    public void shouldExitApplicationWhenOption0IsSelected() {

//        assertThat(
//                BibliotecaApp.processOption(0),
//                is(System.exit(0))
//        );
    }
}