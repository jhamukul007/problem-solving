package com.design.patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class OrderStateChangeSubject {
    private List<Observer> observers = new ArrayList<>();
    private OrderState orderState;

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState, NotificationMessage message) {
        this.orderState = orderState;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(NotificationMessage message) {
        for (Observer observer : observers) {
            observer.notify(message);
        }
    }
}
