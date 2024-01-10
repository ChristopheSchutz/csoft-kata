package com.csoft.kata.movierental;

public class Customer {

    private String name;
    private RentalSummary rentalSummary = new RentalSummary();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentalSummary.addRental(rental);
    }

    public String getName() {
        return name;
    }

    public RentalSummary getRentalSummary() {
        return rentalSummary;
    }
}
