package com.csoft.kata.movierental;

import java.util.ArrayList;
import java.util.List;

public class RentalSummary {

    private List<Rental> rentals = new ArrayList<>();

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public double getTotalAmount() {
        double totalAmount = 0;
        for (Rental rental : rentals) {
            totalAmount += rental.getAmount();
        }
        return totalAmount;
    }

    public int getTotalFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : rentals) {
            frequentRenterPoints ++;
            if (rental.isFrequentRenterBonusApplicable()) {
                frequentRenterPoints ++;
            }
        }
        return frequentRenterPoints;
    }

    public List<Rental> getRentals() {
        return rentals;
    }
}
