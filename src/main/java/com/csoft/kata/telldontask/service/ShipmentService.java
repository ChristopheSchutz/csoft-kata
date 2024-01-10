package com.csoft.kata.telldontask.service;

import com.csoft.kata.telldontask.domain.Order;

public interface ShipmentService {
    void ship(Order order);
}