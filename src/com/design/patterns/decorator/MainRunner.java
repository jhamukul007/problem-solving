package com.design.patterns.decorator;

public class MainRunner {
    public static void main(String[] args) {
        UpiPaymentDetails upiPaymentDetails = new UpiPaymentDetails();
        upiPaymentDetails.setAmount(1230D);
        upiPaymentDetails.setFromUpiId("immukul@okaxis");
        upiPaymentDetails.setToUpiId("immukul008@okaxis");

        UpiPaymentDecorator upiPaymentDecorator = new UpiPaymentDecorator(new UpiPayment());
        upiPaymentDecorator.payment(upiPaymentDetails);

        DCPaymentDetails dcPaymentDetails = new DCPaymentDetails();
        dcPaymentDetails.setAmount(1908D);
        dcPaymentDetails.setFromAccount("12345355");
        dcPaymentDetails.setToAccount("65767557");

        DCPaymentDecorator dcPaymentDecorator = new DCPaymentDecorator(new DCPayment());
        dcPaymentDecorator.payment(dcPaymentDetails);



        CCPaymentDetails ccPaymentDetails = new CCPaymentDetails();
        ccPaymentDetails.setAmount(1208D);
        ccPaymentDetails.setFromAccount("5355");
        ccPaymentDetails.setToAccount("67557");

        CCPaymentDecorator ccPaymentDecorator = new CCPaymentDecorator(new CCPayment());
        ccPaymentDecorator.payment(ccPaymentDetails);
    }


}
