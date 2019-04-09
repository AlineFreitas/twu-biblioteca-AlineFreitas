package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BookTest {

    public Book book;

    @Before
    public void setUp(){

        book = new Book("Test Driven Development: By Example",
                2002,
                "Kent Beck");
    }

    @Test
    public void shouldHaveTitle() {

        assertEquals("Test Driven Development: By Example",
                book.getTitle()
        );
    }

    @Test
    public void shouldHavePublishYear() {

        assertEquals(2002,
                book.getPublishYear()
        );
    }

    @Test
    public void shouldHaveAuthor() {

        assertEquals("Kent Beck",
                book.getAuthor()
        );
    }

    @Test
    public void shouldNotBeAvailableWhenSuccessfullyCheckedOut() {

        book.checkOut();

        assertFalse(
                book.isAvailable()
        );
    }

    @Test
    public void shouldBecomeAvailableWhenSuccessfullyReturned() {

        book.setAvailable(false);
        book.checkIn();

        assertTrue(
                book.isAvailable()
        );
    }

    @Test
    public void shouldPrintFormattedMetaInformation() {

        assertThat(book.toString(),
                is("Test Driven Development: By Example | Kent Beck | 2002")
        );
    }

}