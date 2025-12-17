package com.second_mini_project.Utils;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;


@Component
public class Email_Util {


    @Autowired
    private  JavaMailSender mailSender;

    // TODO : Implement email utility methods here to send random PSW

    public  void sendEmail(String toEmail, String subject, String body) throws MessagingException {
        // Implementation for sending email
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(toEmail);
        helper.setSubject(subject);
        helper.setText(body);
        mailSender.send(message);
    }
}
