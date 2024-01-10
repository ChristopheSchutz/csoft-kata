package com.csoft.kata.telldontask.doubles;


import com.csoft.kata.telldontask.domain.Order;
import com.csoft.kata.telldontask.service.ShipmentService;

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