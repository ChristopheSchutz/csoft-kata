package com.csoft.kata.telldontask.domain;

import com.csoft.kata.telldontask.usecase.exception.RejectedOrderCannotBeApprovedException;
import com.csoft.kata.telldontask.usecase.exception.ShippedOrdersCannotBeChangedException;
import com.csoft.kata.telldontask.usecase.exception.ApprovedOrderCannotBeRejectedException;
import com.csoft.kata.telldontask.usecase.exception.OrderCannotBeShippedException;
import com.csoft.kata.telldontask.usecase.exception.OrderCannotBeShippedTwiceException;
import com.csoft.kata.telldontask.usecase.request.OrderApprovalRequest;

import java.math.BigDecimal;
import java.util.List;

public class Order {

    private OrderStatus status;
    private List<OrderItem> items;
    private String currency;
    private BigDecimal total;
    private BigDecimal tax;
    private int id;

    public Order(OrderStatus status, List<OrderItem> items, String currency, BigDecimal total, BigDecimal tax) {
        this.status = status;
        this.items = items;
        this.currency = currency;
        this.total = total;
        this.tax = tax;
    }

    public Order(OrderStatus status, int id) {
        this.status = status;
        this.id = id;
    }

    public void approve(OrderApprovalRequest request) {
        if (status.equals(OrderStatus.SHIPPED)) {
            throw new ShippedOrdersCannotBeChangedException();
        }
        if (request.isApproved() && status.equals(OrderStatus.REJECTED)) {
            throw new RejectedOrderCannotBeApprovedException();
        }
        if (!request.isApproved() && status.equals(OrderStatus.APPROVED)) {
            throw new ApprovedOrderCannotBeRejectedException();
        }
        this.setStatus(request.isApproved() ? OrderStatus.APPROVED : OrderStatus.REJECTED);
    }

    public void checkShipmentPossible() {
        if (status.equals(OrderStatus.CREATED) || status.equals(OrderStatus.REJECTED)) {
            throw new OrderCannotBeShippedException();
        }
        if (status.equals(OrderStatus.SHIPPED)) {
            throw new OrderCannotBeShippedTwiceException();
        }
    }

    public void ship() {
        this.status = OrderStatus.SHIPPED;
    }

    public void addItem(OrderItem item) {
        this.items.add(item);
        addTax(item.getTax());
        addAmount(item.getTaxedAmount());
    }

    private void addAmount(BigDecimal amount) {
        this.total = this.total.add(amount);
    }

    private void addTax(BigDecimal tax) {
        this.tax = this.tax.add(tax);
    }

    public BigDecimal getTotal() {
        return total;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public List<OrderItem> getItems() {
        return List.copyOf(items);
    }
}