package com.design.patterns.decorator;

public class PaymentDecorator implements Payment{

    private Payment payment;

    public PaymentDecorator(Payment payment){
        this.payment = payment;
    }

    @Override
    public PaymentDetails payment(PaymentDetails paymentDetails) {
        return payment.payment(paymentDetails);
    }
}
