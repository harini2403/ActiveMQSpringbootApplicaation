package com.example.EmailNotification.EmailController;

import com.example.EmailNotification.EmailDetails.EmailDetails;
import com.example.EmailNotification.EmailService.EmailService;
import com.example.EmailNotification.jmslistener.MessageReceiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    EmailService emailService;
    @Autowired
    MessageReceiver messageReceiver;

    @PostMapping("/sendEmail")
    public String sendEmail(@RequestBody EmailDetails emailDetails)
    {
        return emailService.sendEmail(emailDetails);
        //return "Email Sent Successfully";
    }

    @PostMapping("/sendEmailWithAttachment")
    public String sendEmailWithAttachment(@RequestBody EmailDetails emailDetails)
    {
        return emailService.sendMailWithAttachment(emailDetails);
        //return "Email Sent Successfully";
    }

   /* @PostMapping("/MQ/sendMessage")
    public String postMessageToMQ(@RequestBody String message)
    {

        System.err.println("Received message: " + message);
        messageReceiver.receive(message);
        return "Successfully sent message to MQ.";
    }*/
}
