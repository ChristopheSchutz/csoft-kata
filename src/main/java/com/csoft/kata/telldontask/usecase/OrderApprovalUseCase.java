package com.csoft.kata.telldontask.usecase;

import com.csoft.kata.telldontask.domain.Order;
import com.csoft.kata.telldontask.repository.OrderRepository;
import com.csoft.kata.telldontask.usecase.request.OrderApprovalRequest;

public class OrderApprovalUseCase {
    private final OrderRepository orderRepository;

    public OrderApprovalUseCase(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void run(OrderApprovalRequest request) {
        final Order order = orderRepository.getById(request.getOrderId());
        order.approve(request);
        orderRepository.save(order);
    }
}