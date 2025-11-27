package com.first_mini_project.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Component
public class Email_Util {

    @Autowired
    private JavaMailSender mailSender;

    public void sendExcel(String toEmail, byte[] excelData,String sub,String mailText,String attachmentName) throws MessagingException {

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(toEmail);
        helper.setSubject(sub);
        helper.setText(mailText);

        helper.addAttachment(attachmentName, new ByteArrayResource(excelData));

        mailSender.send(message);
    }

}
