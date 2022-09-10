package com.design.patterns.decorator;

public class DCPaymentDecorator extends PaymentDecorator {

    public DCPaymentDecorator(Payment payment) {
        super(payment);
    }

    @Override
    public PaymentDetails payment(PaymentDetails paymentDetails) {
        System.out.println("Debit card payment started");
        return super.payment(paymentDetails);
    }
}
