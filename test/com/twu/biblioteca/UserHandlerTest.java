package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class UserHandlerTest {

    @Before
    public void setUp() {
        UserHandler.setUserList();
    }

    @Test
    public void shouldBeAbleToLoginIfCredentialsAreCorrect() {

        assertThat(
                UserHandler.login("123-4567", "senha"),
                is(true)
        );
    }

    @Test
    public void shouldNotBeAbleToLoginIfCredentialsAreIncorrect() {

        assertThat(
                UserHandler.login("123-4567", "incorrect password"),
                is(false)
        );
        
        assertThat(
                UserHandler.login("not registered lib number", "some password"),
                is(false)
        );
    }
}