package com.csoft.kata.telldontask.usecase;

import com.csoft.kata.telldontask.domain.Order;
import com.csoft.kata.telldontask.usecase.request.OrderShipmentRequest;
import com.csoft.kata.telldontask.repository.OrderRepository;
import com.csoft.kata.telldontask.service.ShipmentService;
import com.csoft.kata.telldontask.usecase.exception.OrderCannotBeShippedException;
import com.csoft.kata.telldontask.usecase.exception.OrderCannotBeShippedTwiceException;


public class OrderShipmentUseCase {
    private final OrderRepository orderRepository;
    private final ShipmentService shipmentService;

    public OrderShipmentUseCase(OrderRepository orderRepository, ShipmentService shipmentService) {
        this.orderRepository = orderRepository;
        this.shipmentService = shipmentService;
    }

    public void run(OrderShipmentRequest request) throws OrderCannotBeShippedException, OrderCannotBeShippedTwiceException{
        final Order order = orderRepository.getById(request.getOrderId());
        order.checkShipmentPossible();
        shipmentService.ship(order);
        order.ship();
        orderRepository.save(order);
    }
}