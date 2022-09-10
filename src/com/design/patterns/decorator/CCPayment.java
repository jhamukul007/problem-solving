package com.design.patterns.decorator;

public class CCPayment implements Payment{

    @Override
    public PaymentDetails payment(PaymentDetails payment) {
        CCPaymentDetails dc = (CCPaymentDetails) payment;
        System.out.println(String.format("Sending amount %s to account %s from account %s", dc.getAmount(), dc.getToAccount(),dc.getFromAccount() ));
        return null;
    }
}
