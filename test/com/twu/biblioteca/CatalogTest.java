package com.twu.biblioteca;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

public class CatalogTest {

    Catalog catalog;
    Book book;
    Movie movie;

    @Before
    public void setUp() {

        catalog = new Catalog();

        book = new Book("Test Driven Development: By Example",
                2002,
                "Kent Beck");

        movie = new Movie("Kill Bill Vol. 1",
                2003,
                8,
                "Quentin Tarantino");

        catalog.items.add(book);

        catalog.items.add(movie);
    }

    @Test
    public void shouldHaveAnItem() {
        assertThat(catalog.getItems(), hasItem(book));
    }

    @Test
    public void shouldRetrieveItemByTitle() {
        assertThat(catalog.getByTitle("Test Driven Development: By Example"), CoreMatchers.<Borrowable>is(book));
    }

    @Test
    public void shouldListAvailableItems() {
        assertThat(catalog.getAvailableItems(), hasItem(movie));
        assertThat(catalog.getAvailableItems(), hasItem(book));

    }

    @Test
    public void shouldBorrowItem() {

        catalog.borrowItem("Kill Bill Vol. 1");
        assertThat(catalog.getAvailableItems(), not(hasItem(movie)));

    }

    @Test
    public void shouldReturnItem() {

        catalog.borrowItem("Kill Bill Vol. 1");
        catalog.returnItem("Kill Bill Vol. 1");

        assertThat(catalog.getAvailableItems(), not(hasItem(movie)));
    }
}