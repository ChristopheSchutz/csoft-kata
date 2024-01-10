package com.csoft.kata.telldontask.repository;

import com.csoft.kata.telldontask.domain.Product;

public interface ProductCatalog {
    Product getByName(String name);
}