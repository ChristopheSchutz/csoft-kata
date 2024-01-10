package com.csoft.kata.telldontask.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product {
    private String name;
    private BigDecimal price;
    private Category category;

    public Product(String name, BigDecimal price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public BigDecimal unitaryTax() {
        return price.divide(BigDecimal.valueOf(100)).multiply(category.getTaxPercentage()).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal unitaryTaxedAmount() {
        return price.add(unitaryTax()).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal taxedAmount(int quantity) {
        return unitaryTaxedAmount().multiply(BigDecimal.valueOf(quantity)).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal taxAmount(int quantity) {
        return unitaryTax().multiply(BigDecimal.valueOf(quantity));
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}