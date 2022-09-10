package com.design.patterns.decorator;

public class UpiPaymentDecorator extends PaymentDecorator{

    public UpiPaymentDecorator(Payment payment) {
        super(payment);
    }

    @Override
    public PaymentDetails payment(PaymentDetails paymentDetails) {
        System.out.println("Upi payment started");
        return super.payment(paymentDetails);
    }


}
