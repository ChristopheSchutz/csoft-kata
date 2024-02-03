package com.csoft.kata.javafeatures.sealed;


import java.math.BigDecimal;

public final class CashPayment implements PaymentStrategy {

    @Override
    public String pay(BigDecimal amount) {
        // here would be written payment logic
        System.out.println("Cash payment for amount : " + amount);
        return "Cash - 1";
    }
}
