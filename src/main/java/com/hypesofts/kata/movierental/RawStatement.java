package com.hypesofts.kata.movierental;

import java.util.List;

public class RawStatement implements Statement {

    @Override
    public String printHeader(String customerName) {
        return "Rental Record for " + customerName + "\n";
    }

    @Override
    public String printRentals(List<Rental> rentals) {
        String result = "";
        for (Rental rental : rentals) {
            result += "\t" + rental.getMovie().getTitle() + "\t" + rental.getAmount() + "\n";
        }
        return result;
    }

    @Override
    public String printAmountOwned(double totalAmount) {
        return "Amount owed is " + totalAmount + "\n";
    }

    @Override
    public String printFrequentRenterPoints(int totalFrequentRenterPoints) {
        return "You earned " + totalFrequentRenterPoints + " frequent renter points";
    }


}
