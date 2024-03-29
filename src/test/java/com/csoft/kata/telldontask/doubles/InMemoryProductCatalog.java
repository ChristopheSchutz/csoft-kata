package com.csoft.kata.telldontask.doubles;

import com.csoft.kata.telldontask.domain.Product;
import com.csoft.kata.telldontask.repository.ProductCatalog;
import com.csoft.kata.telldontask.usecase.exception.UnknownProductException;

import java.util.List;

public class InMemoryProductCatalog implements ProductCatalog {
    private final List<Product> products;

    public InMemoryProductCatalog(List<Product> products) {
        this.products = products;
    }

    public Product getByName(final String name) {
        return products.stream().filter(p -> p.getName().equals(name)).findFirst().orElseThrow(() -> new UnknownProductException());
    }
}