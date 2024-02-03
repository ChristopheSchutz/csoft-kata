package com.csoft.kata.javafeatures.sealed;

import java.math.BigDecimal;

public class PaymentUseCase {

    public static String pay(BigDecimal amount, PaymentStrategy strategy) {
        String message = "A payment has been done with ";
        String id = switch (strategy) {
            case PaypalPayment p -> {
                message += "Paypal";
                yield p.pay(amount);
            }
            case CashPayment c -> {
                message += "Cash";
                yield c.pay(amount);
            }
        };
        message += " | Id : " + id;
        return message;
    }
}
