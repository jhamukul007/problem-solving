package com.design.patterns.factory.sms;

import com.design.patterns.factory.NotificationMessage;
import com.design.patterns.factory.NotificationService;

public class SMSNotificationService implements NotificationService {

    @Override
    public void notify(NotificationMessage message) {
        SMSNotificationMessage smsMessage = (SMSNotificationMessage) message;
        System.out.println(String.format("Sending sms notification to %s , from %s ", smsMessage.getTo(), smsMessage.getFrom()));
    }
}
