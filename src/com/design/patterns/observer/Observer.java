package com.design.patterns.observer;

public abstract class Observer {
    OrderStateChangeSubject subject;
    abstract void notify(NotificationMessage notificationMessage);
}
