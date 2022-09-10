package com.design.patterns.factory.email;

import com.design.patterns.factory.NotificationMessage;
import com.design.patterns.factory.NotificationType;

import java.util.List;

public class EmailNotificationMessage implements NotificationMessage {

    private List<String> to;
    private String from;
    private List<String> cc;
    private List<String> bcc;
    private String content;
    private List<Attachment> attachments;
    private NotificationType notificationType;

    public EmailNotificationMessage() {
        this.notificationType = NotificationType.EMAIL;
    }

    public List<String> getTo() {
        return to;
    }

    public void setTo(List<String> to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public List<String> getCc() {
        return cc;
    }

    public void setCc(List<String> cc) {
        this.cc = cc;
    }

    public List<String> getBcc() {
        return bcc;
    }

    public void setBcc(List<String> bcc) {
        this.bcc = bcc;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }
}

class Attachment {
    String url;
}
