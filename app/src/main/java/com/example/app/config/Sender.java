package com.example.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class Sender {
    @Autowired
    private JmsTemplate jmsTemplate;

    public void send(String message) {
        System.out.println("Sending message: " + message);
        jmsTemplate.convertAndSend("product-test-notification", message);
        System.out.println("Message sent!");
    }
}
