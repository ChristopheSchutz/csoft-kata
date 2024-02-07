package com.csoft.kata.designpatterns.stepbuilder;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
public class Product {

    private UUID uuid;
    private String name;
    private BigDecimal price;
    private Optional<String> description;
    private Optional<String> category;

}
