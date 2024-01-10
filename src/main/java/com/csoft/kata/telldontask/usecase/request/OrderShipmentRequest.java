package com.csoft.kata.telldontask.usecase.request;

public class OrderShipmentRequest {
    private int orderId;

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderId() {
        return orderId;
    }
}