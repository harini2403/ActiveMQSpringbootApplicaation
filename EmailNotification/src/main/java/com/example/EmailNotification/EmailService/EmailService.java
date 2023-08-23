package com.example.EmailNotification.EmailService;

import com.example.EmailNotification.EmailDetails.EmailDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class  EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String fromaddress;
    public String sendEmail(EmailDetails emailDetails)
    {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(fromaddress);
            mailMessage.setTo(emailDetails.getToAddress());
            mailMessage.setText(emailDetails.getEmailBody());
            mailMessage.setSubject(emailDetails.getSubject());
            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        }
        catch (Exception e) {
            return "Error while Sending Mail";
        }
    }

    public String sendMailWithAttachment(EmailDetails emailDetails)
    {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;
        try {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(fromaddress);
            mimeMessageHelper.setTo(emailDetails.getToAddress());
            mimeMessageHelper.setText(emailDetails.getEmailBody());
            mimeMessageHelper.setSubject(emailDetails.getSubject());
            FileSystemResource file = new FileSystemResource(new File(emailDetails.getFilePath()));

            mimeMessageHelper.addAttachment(file.getFilename(), file);
            javaMailSender.send(mimeMessage);
            return "File has been sent Successfully to" + emailDetails.getToAddress();
        }
        catch (MessagingException e) {
            return "Error while sending mail!!!";
        }
    }

}
