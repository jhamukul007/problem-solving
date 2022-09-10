package com.design.patterns.factory.push;

import com.design.patterns.factory.NotificationMessage;

public class PushNotificationMessage implements NotificationMessage {

    private String to;
    private String content;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
