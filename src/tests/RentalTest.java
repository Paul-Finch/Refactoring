package tests;

import classes.Movie;
import classes.Rental;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RentalTest {

    private Rental rental;
    private Movie movie;

    @Before
    public void setUp() {
        movie = new Movie("Harry Potter", 0);
        rental = new Rental(movie, 1);
    }

    @Test
    public void getDaysRented() {
        assertEquals(1, rental.getDaysRented());
    }

    @Test
    public void getMovie() {
        assertEquals(movie, rental.getMovie());
    }

    @Test
    public void getCharge() {
        assertEquals(14.0, rental.getCharge(), 0);
    }

}