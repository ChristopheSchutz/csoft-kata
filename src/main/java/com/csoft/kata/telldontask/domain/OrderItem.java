package com.csoft.kata.telldontask.domain;

import java.math.BigDecimal;

public class OrderItem {
    private Product product;
    private int quantity;

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getTaxedAmount() {
        return product.taxedAmount(quantity);
    }

    public BigDecimal getTax() {
        return product.taxAmount(quantity);
    }
}