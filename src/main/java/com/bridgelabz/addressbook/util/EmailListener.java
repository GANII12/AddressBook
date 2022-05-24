package com.bridgelabz.addressbook.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailListener {
    @Autowired
    private EmailSenderService sender;
    public void sendMail() {
        sender.sendEmail("ganeshmoturu1467@gmail.com", "Test Email", "Registered SuccessFully");

    }
}
