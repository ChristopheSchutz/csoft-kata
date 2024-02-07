package com.csoft.kata.designpatterns.stepbuilder;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

public class ProductBuilder implements ProductNameStep, ProductPriceStep, ProductFinalSteps {

    private String name;
    private BigDecimal price;
    private String description;
    private String category;

    private ProductBuilder() {
    }

    public static ProductNameStep newBuilder() {
        return new ProductBuilder();
    }

    @Override
    public ProductPriceStep name(String name) {
        this.name = name;
        return this;
    }

    @Override
    public ProductFinalSteps price(BigDecimal price) {
        this.price = price;
        return this;
    }

    @Override
    public ProductFinalSteps description(String description) {
        this.description = description;
        return this;
    }

    @Override
    public ProductFinalSteps category(String category) {
        this.category = category;
        return this;
    }

    @Override
    public Product build() {
        return new Product(UUID.randomUUID(), name, price, Optional.ofNullable(description), Optional.ofNullable(category));
    }

}

interface ProductNameStep {
    ProductPriceStep name(String name);
}

interface ProductPriceStep {
    ProductFinalSteps price(BigDecimal price);
}

interface ProductFinalSteps {
    ProductFinalSteps description(String description);

    ProductFinalSteps category(String category);

    Product build();
}