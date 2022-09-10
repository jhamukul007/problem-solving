package com.design.patterns.factory.push;

import com.design.patterns.factory.NotificationMessage;
import com.design.patterns.factory.NotificationService;

public class PushNotificationService implements NotificationService {
    @Override
    public void notify(NotificationMessage message) {
        PushNotificationMessage pushMessage = (PushNotificationMessage) message;
        System.out.println("Sending push notification to user " + pushMessage.getTo());
    }
}
