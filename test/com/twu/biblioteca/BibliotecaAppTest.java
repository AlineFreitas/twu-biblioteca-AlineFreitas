package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
    public void shouldDisplayMenu() {

        biblioteca.displayMenu();

        assertThat(
                outContent.toString(),
                is("--------------Book Section------------------\n" +
                        "1. View List Of Books\n" +
                        "2. Check-out Book\n" +
                        "3. Return Book\n" +
                        "--------------Movie Section-----------------\n" +
                        "4. View List Of Movies\n" +
                        "5. Check-out Movie\n" +
                        "6. Return Movie\n" +
                        "--------------User Section-----------------\n" +
                        "7. Login\n" +
                        "0. Quit application\n")
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
}