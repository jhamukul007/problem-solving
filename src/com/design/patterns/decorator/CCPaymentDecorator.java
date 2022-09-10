package com.design.patterns.decorator;

public class CCPaymentDecorator extends PaymentDecorator{

    public CCPaymentDecorator(Payment payment) {
        super(payment);
    }

    @Override
    public PaymentDetails payment(PaymentDetails paymentDetails) {
        return super.payment(paymentDetails);
    }
}
