package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.*;

public class LibraryTest {

    private Library library;

    @Before
    public void setup() {

        library = new Library();
    }

    @Test
    public void shouldPrintAvailableBooks() {

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outContent));

//        library.printAvailableBooks();
//        assertThat(
//                outContent.toString(),
//                is("TDD By Example | Kent Beck | 2002\nThe Clean Coder | Uncle Bob | 2011\n")
//        );
    }


    @Test
    public void shouldPrintAvailableMovies() {

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outContent));

//        library.printAvailableMovies();
//        assertThat(
//                outContent.toString(),
//                is("Kill Bill Vol. 1 | 2003 | Quentin Tarantino | 8\nPulp Fiction | 1994 | Quentin Tarantino | 9\n")
//        );
    }

}