package com.csoft.kata.telldontask.repository;

import com.csoft.kata.telldontask.domain.Order;

public interface OrderRepository {
    void save(Order order);

    Order getById(int orderId);
}