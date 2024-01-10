
package com.csoft.kata.movierental;

import java.util.List;

public class HtmlStatement implements Statement {

    @Override
    public String printHeader(String name) {
        return "<h1>Rental Record for <em>"+name+"</em></h1>\n";
    }

    @Override
    public String printRentals(List<Rental> rentals) {
        String result =  "<table>\n";
        for (Rental rental : rentals) {
            result += "\t<tr><td>"+rental.getMovie().getTitle()+"</td><td>"+rental.getAmount()+"</td></tr>\n";
        }
        result+="</table>\n";
        return result;
    }

    @Override
    public String printAmountOwned(double totalAmount) {
        return "<p>Amount owed is <em>"+totalAmount+"</em></p>\n";
    }

    @Override
    public String printFrequentRenterPoints(int totalFrequentRenterPoints) {
        return "<p>You earned <em>"+totalFrequentRenterPoints+"</em> frequent renter points</p>\n";
    }
}

