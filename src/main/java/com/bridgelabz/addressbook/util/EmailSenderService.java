package com.bridgelabz.addressbook.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.io.InputStream;

@Component
public class EmailSenderService {
    @Autowired(required = false)
    private JavaMailSender sender;
//    JavaMailSender sender = new JavaMailSenderImpl();
    public void sendEmail(String toEmail , String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("ganeshmoturu1467@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);
        sender.send(message);
        System.out.println("Mail sent to the User....!");
    }
}
