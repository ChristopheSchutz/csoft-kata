package com.hypesofts.kata.telldontask.doubles;


import com.hypesofts.kata.telldontask.domain.Order;
import com.hypesofts.kata.telldontask.service.ShipmentService;

public class TestShipmentService implements ShipmentService {
    private Order shippedOrder = null;

    public Order getShippedOrder() {
        return shippedOrder;
    }

    @Override
    public void ship(Order order) {
        this.shippedOrder = order;
    }
}