package com.example.EmailNotification.jmslistener;

import com.example.EmailNotification.EmailDetails.EmailDetails;
import com.example.EmailNotification.EmailService.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

    @Autowired
    EmailService emailService;
    @JmsListener(destination = "product-test-notification")
    public void receive(String message) {

        System.err.println("received message='{}'" + message);
        EmailDetails emailDetails = new EmailDetails();
        emailDetails.setToAddress("harini.annh@gmail.com");
        emailDetails.setSubject("Product Details");
        emailDetails.setEmailBody("Product details: " + message);
        emailDetails.setIsAttachmentRequired(false);
        // emailDetails.setFilePath("");

        // Call the email sending method
        String result = emailService.sendEmail(emailDetails);

        System.out.println(result);
    }
}
