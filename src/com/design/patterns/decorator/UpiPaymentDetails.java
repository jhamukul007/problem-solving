package com.design.patterns.decorator;

public class UpiPaymentDetails implements PaymentDetails{
    private String toUpiId;
    private String fromUpiId;
    private Double amount;

    public String getToUpiId() {
        return toUpiId;
    }

    public void setToUpiId(String toUpiId) {
        this.toUpiId = toUpiId;
    }

    public String getFromUpiId() {
        return fromUpiId;
    }

    public void setFromUpiId(String fromUpiId) {
        this.fromUpiId = fromUpiId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
