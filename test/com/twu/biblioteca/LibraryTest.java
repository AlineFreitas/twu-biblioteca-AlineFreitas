package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
    private Movie killBill;
    private Movie pulpFiction;

    @Before
    public void setup() {

        List<Book> bookCatalog = new ArrayList<Book>();
        List<Movie> movieCatalog = new ArrayList<Movie>();

        tddByExample = new Book("TDD By Example", 2002, "Kent Beck");
        theCleanCoder = new Book("The Clean Coder", 2011, "Uncle Bob");

        killBill = new Movie("Kill Bill Vol. 1", 2003, 8, "Quentin Tarantino");
        pulpFiction = new Movie("Pulp Fiction", 1994, 9, "Quentin Tarantino");


        bookCatalog.add(tddByExample);
        bookCatalog.add(theCleanCoder);

        movieCatalog.add(killBill);
        movieCatalog.add(pulpFiction);

        library = new Library(bookCatalog, movieCatalog);
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
                library.borrowBook("TDD By Example"),
                is(true)
        );
    }

    @Test
    public void shouldReturnBookIfExistsAndUnavailable() {

        library.borrowBook("TDD By Example");

        assertThat(
                library.returnBook("TDD By Example"),
                is(true)
        );
    }

    @Test
    public void listShouldNotShowBorrowedBooks() {

        library.borrowBook("TDD By Example");

        assertThat(
                library.getListOfAvailableBooks(),
                not(hasItem(tddByExample))
        );

    }

    @Test
    public void shouldPrintAvailableBooks() {

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outContent));

        library.printAvailableBooks();
        assertThat(
                outContent.toString(),
                is("TDD By Example | Kent Beck | 2002\nThe Clean Coder | Uncle Bob | 2011\n")
        );
    }

    @Test
    public void shouldShowReturnedBook() {

        library.borrowBook("TDD By Example");
        library.returnBook("TDD By Example");

        assertThat(
                library.getListOfAvailableBooks(),
                hasItem(tddByExample)
        );
    }

    @Test
    public void shouldPrintAvailableMovies() {

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outContent));

        library.printAvailableMovies();
        assertThat(
                outContent.toString(),
                is("Kill Bill Vol. 1 | 2003 | Quentin Tarantino | 8\nPulp Fiction | 1994 | Quentin Tarantino | 9\n")
        );
    }


    @Test
    public void shouldGetMovieByTitle() {

        Movie movie = library.getMovieByTitle("Kill Bill Vol. 1");

        assertThat(movie, is(killBill));
    }

    @Test
    public void shouldBorrowAvailableMovie() {

        library.borrowMovie("Pulp Fiction");

        assertThat(pulpFiction.isAvailable(),
                is(false)
        );
    }

}