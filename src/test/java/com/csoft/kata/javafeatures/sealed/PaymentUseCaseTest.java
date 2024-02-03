package com.csoft.kata.javafeatures.sealed;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class PaymentUseCaseTest {

    @Test
    void should_return_paypal_message() {
        PaymentStrategy strategy = new PaypalPayment();
        var result = PaymentUseCase.pay(BigDecimal.TEN, strategy);
        Assertions.assertThat(result).isEqualTo("A payment has been done with Paypal | Id : Paypal - 1");
    }

    @Test
    void should_return_cash_message() {
        PaymentStrategy strategy = new CashPayment();
        var result = PaymentUseCase.pay(BigDecimal.TEN, strategy);
        Assertions.assertThat(result).isEqualTo("A payment has been done with Cash | Id : Cash - 1");
    }
}
