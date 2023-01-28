package com.email.email.service;


import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmailServiceImpl implements EmailService{


    public boolean sendEmail(String from, String to, String to1, String subject, String message) {

        boolean flag = false;

        String host = "smtp.gmail.com";
        int port = 465;

        Properties properties = System.getProperties();

        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.ssl.enable", true);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.auth", true);

//		String username = "yashkushwaha2617@gmail.com";
//        String password = "Yash@19121999";

        Session session = Session.getInstance(properties, new Authenticator(){

            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("kushwahaharshwardhan@gmail.com", "***************");


            }
        });

        session.setDebug(true);
        MimeMessage mimeMessage = new MimeMessage(session);

        try {

            mimeMessage.setFrom(from);
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to1));
            mimeMessage.setSubject(subject);
            mimeMessage.setText(message);

            Transport.send(mimeMessage);
            flag = true;

            System.out.println("Sent Successfully !!");
        }catch(Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
