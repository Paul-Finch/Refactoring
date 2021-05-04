package tests;

import classes.Customer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CustomerTest {

    private Customer customer;

    @Before
    public void setUp() {
        customer = new Customer("Konrad");
    }

    @Test
    public void getName() {
        assertEquals("Konrad", customer.getName());
    }

    @Test
    public void statement() {
        assertTrue(customer.statement().startsWith("Rental Record for Konrad"));
        assertTrue(customer.statement().endsWith(" frequent renter points"));
    }

}