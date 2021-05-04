package tests;

import classes.Movie;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {

    private Movie movie;

    @Before
    public void setUp() {
        movie = new Movie("Harry Potter", 0);
    }

    @Test
    public void getPriceCode() {
        assertEquals(0, movie.getPriceCode());
    }

    @Test
    public void getTitle() {
        assertEquals("Harry Potter", movie.getTitle());
    }

}