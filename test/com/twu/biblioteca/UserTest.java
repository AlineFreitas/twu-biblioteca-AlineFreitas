package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class UserTest {
    private User user;

    @Before
    public void setUp() {

        user = new User("123-4567", "password");
    }

    @Test
    public void shouldHaveValidLibraryNumber() {

        assertTrue(user.getLibraryNumber().matches("\\d{3}-\\d{4}"));
    }
}