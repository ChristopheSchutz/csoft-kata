package com.csoft.kata.javafeatures.sealed;

import java.math.BigDecimal;

public final class PaypalPayment implements PaymentStrategy {

    @Override
    public String pay(BigDecimal amount) {
        System.out.println("Paypal payment for amount : " + amount);
        return "Paypal - 1";
    }
}
