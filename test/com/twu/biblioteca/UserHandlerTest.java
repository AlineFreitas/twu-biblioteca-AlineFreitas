package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

public class UserHandlerTest {
    private User loggedUser;

    @Before
    public void setUp() {

        UserHandler.setUserList();
        loggedUser = UserHandler.getUserByLibraryNumber("123-4567");
    }

    @Test
    public void shouldBeAbleToLoginIfCredentialsAreCorrect() {

        assertThat(
                UserHandler.login("123-4567", "senha"),
                is(loggedUser)
        );
    }

    @Test
    public void shouldNotBeAbleToLoginIfCredentialsAreIncorrect() {

        assertThat(
                UserHandler.login("123-4567", "incorrect password"),
                is(nullValue())
        );

        assertThat(
                UserHandler.login("not registered lib number", "some password"),
                is(nullValue())
        );
    }

    @Test
    public void loginShouldReturnLoggedUser() {

        assertThat(
                UserHandler.login("123-4567", "senha"),
                is(loggedUser)
        );
    }
}