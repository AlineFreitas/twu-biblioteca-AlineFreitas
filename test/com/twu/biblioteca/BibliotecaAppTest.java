package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class BibliotecaAppTest {

    @Test
    public void greet() {
        assertEquals(
                "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!",
                BibliotecaApp.greet()
        );
    }
}