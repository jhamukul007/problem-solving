package com.design.patterns.factory.email;

import com.design.patterns.factory.NotificationMessage;
import com.design.patterns.factory.NotificationService;

public class EmailNotificationService implements NotificationService {

    @Override
    public void notify(NotificationMessage message) {
        EmailNotificationMessage emailMessage = (EmailNotificationMessage) message;
        System.out.println(String.format("Sending email notification to %s, and adding cc as %s ", emailMessage.getTo(), emailMessage.getCc()));
    }

}
