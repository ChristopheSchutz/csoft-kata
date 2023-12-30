package com.hypesofts.kata.telldontask.repository;

import com.hypesofts.kata.telldontask.domain.Order;

public interface OrderRepository {
    void save(Order order);

    Order getById(int orderId);
}