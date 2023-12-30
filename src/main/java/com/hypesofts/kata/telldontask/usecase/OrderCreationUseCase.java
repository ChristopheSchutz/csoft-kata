package com.hypesofts.kata.telldontask.usecase;

import com.hypesofts.kata.telldontask.domain.Order;
import com.hypesofts.kata.telldontask.domain.OrderItem;
import com.hypesofts.kata.telldontask.domain.OrderStatus;
import com.hypesofts.kata.telldontask.domain.Product;
import com.hypesofts.kata.telldontask.repository.OrderRepository;
import com.hypesofts.kata.telldontask.repository.ProductCatalog;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class OrderCreationUseCase {
    private final OrderRepository orderRepository;
    private final ProductCatalog productCatalog;

    public OrderCreationUseCase(OrderRepository orderRepository, ProductCatalog productCatalog) {
        this.orderRepository = orderRepository;
        this.productCatalog = productCatalog;
    }

    public void run(SellItemsRequest request) {
        Order order = new Order();
        order.setStatus(OrderStatus.CREATED);
        order.setItems(new ArrayList<>());
        order.setCurrency("EUR");
        order.setTotal(new BigDecimal("0.00"));
        order.setTax(new BigDecimal("0.00"));

        for (SellItemRequest itemRequest : request.getRequests()) {
            Product product = productCatalog.getByName(itemRequest.getProductName());

            if (product == null) {
                throw new UnknownProductException();
            }
            else {
                final BigDecimal unitaryTax = product.getPrice().divide(BigDecimal.valueOf(100)).multiply(product.getCategory().getTaxPercentage()).setScale(2, RoundingMode.HALF_UP);
                final BigDecimal unitaryTaxedAmount = product.getPrice().add(unitaryTax).setScale(2, RoundingMode.HALF_UP);
                final BigDecimal taxedAmount = unitaryTaxedAmount.multiply(BigDecimal.valueOf(itemRequest.getQuantity())).setScale(2, RoundingMode.HALF_UP);
                final BigDecimal taxAmount = unitaryTax.multiply(BigDecimal.valueOf(itemRequest.getQuantity()));

                final OrderItem orderItem = new OrderItem();
                orderItem.setProduct(product);
                orderItem.setQuantity(itemRequest.getQuantity());
                orderItem.setTax(taxAmount);
                orderItem.setTaxedAmount(taxedAmount);
                order.getItems().add(orderItem);

                order.setTotal(order.getTotal().add(taxedAmount));
                order.setTax(order.getTax().add(taxAmount));
            }
        }

        orderRepository.save(order);
    }
}