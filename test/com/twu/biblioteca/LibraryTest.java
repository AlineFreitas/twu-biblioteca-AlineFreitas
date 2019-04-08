package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.*;

public class LibraryTest {

    private Library library;
    private Book tddByExample;
    private Book theCleanCoder;

    @Before
    public void setup() {

        List<Book> catalog = new ArrayList<Book>();
        tddByExample = new Book("TDD By Example", 2002, "Kent Beck");
        theCleanCoder = new Book("The Clean Cooder", 2011, "Uncle Bob");

        catalog.add(tddByExample);

        library = new Library(catalog);
    }

    @Test
    public void shouldFindBookByTitle() {

        assertThat(
                library.getBookByTitle("TDD By Example"),
                is(tddByExample)
        );
    }

    @Test
    public void shouldReturnNullIfCantFindBook() {

        assertThat(
                library.getBookByTitle("Clean Code"),
                is(nullValue())
        );
    }

    @Test
    public void shouldCheckoutBookIfAvailable() {

        assertThat(
                library.checkoutBook("TDD By Example"),
                is(true)
        );
    }

    @Test
    public void shouldReturnBookIfExistsAndUnavailable() {

        library.checkoutBook("TDD By Example");

        assertThat(
                library.returnBook("TDD By Example"),
                is(true)
        );
    }

    @Test
    public void listShouldNotShowBorrowedBooks() {

        library.checkoutBook("TDD By Example");

        assertThat(
                library.getListOfBooks(),
                not(hasItem(tddByExample))
        );

    }
}