package com.hypesofts.kata.telldontask.usecase;

import com.hypesofts.kata.telldontask.domain.Order;
import com.hypesofts.kata.telldontask.domain.OrderItem;
import com.hypesofts.kata.telldontask.domain.OrderStatus;
import com.hypesofts.kata.telldontask.domain.Product;
import com.hypesofts.kata.telldontask.repository.OrderRepository;
import com.hypesofts.kata.telldontask.repository.ProductCatalog;
import com.hypesofts.kata.telldontask.usecase.request.SellItemRequest;
import com.hypesofts.kata.telldontask.usecase.request.SellItemsRequest;

import java.math.BigDecimal;
import java.util.ArrayList;

public class OrderCreationUseCase {
    private final OrderRepository orderRepository;
    private final ProductCatalog productCatalog;

    public OrderCreationUseCase(OrderRepository orderRepository, ProductCatalog productCatalog) {
        this.orderRepository = orderRepository;
        this.productCatalog = productCatalog;
    }

    public void run(SellItemsRequest request) {
        Order order = new Order(OrderStatus.CREATED, new ArrayList<>(), "EUR", new BigDecimal("0.00"), new BigDecimal("0.00"));

        for (SellItemRequest itemRequest : request.getRequests()) {
            Product product = productCatalog.getByName(itemRequest.getProductName());

            final OrderItem orderItem = new OrderItem(product, itemRequest.getQuantity());
            order.addItem(orderItem);
        }

        orderRepository.save(order);
    }
}