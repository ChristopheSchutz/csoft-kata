package com.hypesofts.kata.telldontask.usecase;

import com.hypesofts.kata.telldontask.domain.Order;
import com.hypesofts.kata.telldontask.repository.OrderRepository;
import com.hypesofts.kata.telldontask.usecase.request.OrderApprovalRequest;

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