package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BibliotecaAppTest {

    @Test
    public void greet() {
        assertEquals(
                "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!",
                BibliotecaApp.greet()
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
}