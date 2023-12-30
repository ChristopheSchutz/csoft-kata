package com.hypesofts.kata.telldontask.service;

import com.hypesofts.kata.telldontask.domain.Order;

public interface ShipmentService {
    void ship(Order order);
}