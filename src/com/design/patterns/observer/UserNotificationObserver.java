package com.design.patterns.observer;

public class UserNotificationObserver extends Observer{

    @Override
    void notify(NotificationMessage notificationMessage) {
        System.out.println("Sending notification to user about order state change");
    }
}
