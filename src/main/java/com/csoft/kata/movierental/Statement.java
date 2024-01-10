package com.csoft.kata.movierental;

import java.util.List;

public interface Statement {

    default String print(Customer customer) {
        String result = printHeader(customer.getName());
        result += printRentals(customer.getRentalSummary().getRentals());
        result += printAmountOwned(customer.getRentalSummary().getTotalAmount());
        result += printFrequentRenterPoints(customer.getRentalSummary().getTotalFrequentRenterPoints());

        return result;
    }

    String printFrequentRenterPoints(int totalFrequentRenterPoints);

    String printAmountOwned(double totalAmount);

    String printRentals(List<Rental> rentals);

    String printHeader(String name);

}
