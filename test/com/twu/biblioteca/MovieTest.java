package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MovieTest {
    public Movie killBill;

    @Before
    public void setUp(){
        killBill = new Movie("Kill Bill Vol. 1", 2003, 8, "Quentin Tarantino");
    }

    @Test
    public void shoulHaveTitle(){
        assertThat(killBill.getTitle(), is("Kill Bill Vol. 1"));
    }

    @Test
    public void shouldPrintMovieMetadata(){
        assertThat(killBill.toString(), is("Kill Bill Vol. 1 | 2003 | Quentin Tarantino | 8"));
    }

}