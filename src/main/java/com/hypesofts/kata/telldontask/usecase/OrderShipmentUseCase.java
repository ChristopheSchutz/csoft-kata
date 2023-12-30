package com.hypesofts.kata.telldontask.usecase;

import com.hypesofts.kata.telldontask.domain.Order;
import com.hypesofts.kata.telldontask.repository.OrderRepository;
import com.hypesofts.kata.telldontask.service.ShipmentService;
import com.hypesofts.kata.telldontask.usecase.exception.OrderCannotBeShippedException;
import com.hypesofts.kata.telldontask.usecase.exception.OrderCannotBeShippedTwiceException;
import com.hypesofts.kata.telldontask.usecase.request.OrderShipmentRequest;


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