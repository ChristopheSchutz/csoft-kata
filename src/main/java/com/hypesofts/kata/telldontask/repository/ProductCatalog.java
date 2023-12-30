package com.hypesofts.kata.telldontask.repository;

import com.hypesofts.kata.telldontask.domain.Product;

public interface ProductCatalog {
    Product getByName(String name);
}