package com.csoft.kata.movierental;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {

    @Test
    public void test_raw_statement() {
        Customer customer = new Customer("Bob");
        customer.addRental(new Rental(new Movie("Jaws", Movie.REGULAR), 2));
        customer.addRental(new Rental(new Movie("Golden Eye", Movie.REGULAR), 3));
        customer.addRental(new Rental(new Movie("Short New", Movie.NEW_RELEASE), 1));
        customer.addRental(new Rental(new Movie("Long New", Movie.NEW_RELEASE), 2));
        customer.addRental(new Rental(new Movie("Bambi", Movie.CHILDREN), 3));
        customer.addRental(new Rental(new Movie("Toy Story", Movie.CHILDREN), 4));

        String expected = """
                Rental Record for Bob
                \tJaws\t2.0
                \tGolden Eye\t3.5
                \tShort New\t3.0
                \tLong New\t6.0
                \tBambi\t1.5
                \tToy Story\t3.0
                Amount owed is 19.0
                You earned 7 frequent renter points""";

        assertEquals(expected, new RawStatement().print(customer));
    }

    @Test
    public void test_html_statement() {
        Customer customer = new Customer("Bob");
        customer.addRental(new Rental(new Movie("Jaws", Movie.REGULAR), 2));
        customer.addRental(new Rental(new Movie("Golden Eye", Movie.REGULAR), 3));
        customer.addRental(new Rental(new Movie("Short New", Movie.NEW_RELEASE), 1));
        customer.addRental(new Rental(new Movie("Long New", Movie.NEW_RELEASE), 2));
        customer.addRental(new Rental(new Movie("Bambi", Movie.CHILDREN), 3));
        customer.addRental(new Rental(new Movie("Toy Story", Movie.CHILDREN), 4));

        String expected = """
                <h1>Rental Record for <em>Bob</em></h1>
                <table>
                \t<tr><td>Jaws</td><td>2.0</td></tr>
                \t<tr><td>Golden Eye</td><td>3.5</td></tr>
                \t<tr><td>Short New</td><td>3.0</td></tr>
                \t<tr><td>Long New</td><td>6.0</td></tr>
                \t<tr><td>Bambi</td><td>1.5</td></tr>
                \t<tr><td>Toy Story</td><td>3.0</td></tr>
                </table>
                <p>Amount owed is <em>19.0</em></p>
                <p>You earned <em>7</em> frequent renter points</p>
                """;

        assertEquals(expected, new HtmlStatement().print(customer));
    }
}