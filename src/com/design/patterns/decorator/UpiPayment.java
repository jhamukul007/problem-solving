package com.design.patterns.decorator;

public class UpiPayment implements Payment {

    @Override
    public PaymentDetails payment(PaymentDetails payment) {
        UpiPaymentDetails dc = (UpiPaymentDetails) payment;
        System.out.println(String.format("Sending amount %s to upiId %s from upiId %s", dc.getAmount(), dc.getToUpiId(),dc.getFromUpiId() ));
        return null;
    }
}
