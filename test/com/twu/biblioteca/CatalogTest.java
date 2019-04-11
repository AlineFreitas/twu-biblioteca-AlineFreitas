package com.twu.biblioteca;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
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

            catalog.addItem(book);

            catalog.addItem(movie);
    }

    @Test
    public void shouldHaveAnItem() {
        assertThat(catalog.getItems(), hasItem(book));
    }

    @Test
    public void shouldGetItemByTitle() {
        assertThat(catalog.getByTitle("Test Driven Development: By Example"), CoreMatchers.<Borrowable>is(book));
    }

    @Test
    public void shouldReturnNullIfRetrievingItemThatDoesntExist() {
        assertThat(catalog.getByTitle("Ruby: The Bible"), is(nullValue()));
    }

    @Test
    public void shouldListAvailableItems() {
        assertThat(catalog.getAvailableItems(), hasItem(movie));
        assertThat(catalog.getAvailableItems(), hasItem(book));

    }

    @Test
    public void shouldBorrowAvailableItem() {

        catalog.borrowItem("Kill Bill Vol. 1", "123-4567");
        assertThat(catalog.getAvailableItems(), not(hasItem(movie)));

    }

    @Test
    public void shouldNotBorrowUnavailableItem() {

        assertThat(catalog.borrowItem("unavailable movie", "123-4567"), is(false));

        catalog.borrowItem("Kill Bill Vol. 1", "123-4567");
        assertThat(catalog.borrowItem("Kill Bill Vol. 1", "123-4567"), is(false));
    }

    @Test
    public void shouldReturnItem() {

        catalog.borrowItem("Kill Bill Vol. 1", "123-4567");
        catalog.returnItem("Kill Bill Vol. 1");

        assertThat(catalog.getAvailableItems(), hasItem(movie));
    }

    @Test
    public void shouldNotReturnItemThatDoesntExist() {

        assertThat(catalog.returnItem("Kill Bill Vol. 2"), is(false));
    }
}