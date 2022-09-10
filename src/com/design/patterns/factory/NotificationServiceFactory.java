package com.design.patterns.factory;

import com.design.patterns.factory.email.EmailNotificationService;
import com.design.patterns.factory.push.PushNotificationService;
import com.design.patterns.factory.sms.SMSNotificationService;

public class NotificationServiceFactory {
    public NotificationService notificationFactory(NotificationType type){
        switch(type){
            case SMS: return new SMSNotificationService();
            case EMAIL: return new EmailNotificationService();
            case PUSH: return new PushNotificationService();
        }
        throw new IllegalArgumentException("NotificationType does not supported");
    }
}
