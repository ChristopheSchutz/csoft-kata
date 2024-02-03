package com.csoft.kata.javafeatures.sealed;

import java.math.BigDecimal;

public sealed interface PaymentStrategy permits CashPayment, PaypalPayment {

    String pay(BigDecimal amount);
}
