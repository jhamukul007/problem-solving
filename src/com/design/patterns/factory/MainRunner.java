package com.design.patterns.factory;

import com.design.patterns.factory.email.EmailNotificationMessage;
import com.design.patterns.factory.push.PushNotificationMessage;
import com.design.patterns.factory.sms.SMSNotificationMessage;

import java.util.List;

public class MainRunner {

    public static void main(String[] args) {
        NotificationServiceFactory factory = new NotificationServiceFactory();
        // For SMS
        SMSNotificationMessage smsMessage = new SMSNotificationMessage();
        smsMessage.setTo("9090909090");
        smsMessage.setFrom("9609606990");
        smsMessage.setContent("Hello Jack");
        factory.notificationFactory(NotificationType.SMS).notify(smsMessage);

        // For push notification
        PushNotificationMessage pushMessage = new PushNotificationMessage();
        pushMessage.setTo("1245");
        pushMessage.setContent("offer valid till 24");
        factory.notificationFactory(NotificationType.PUSH).notify(pushMessage);

        //
        EmailNotificationMessage emailMessage = new EmailNotificationMessage();
        emailMessage.setFrom("jack.xyz@jack.com");
        emailMessage.setTo(List.of("jack.123@jack.com", "jack@jack.com"));
        emailMessage.setContent("Hello offer valid till 24");
        emailMessage.setCc(List.of("tom.hardy@xyz.com"));
        factory.notificationFactory(NotificationType.EMAIL).notify(emailMessage);
    }
}
