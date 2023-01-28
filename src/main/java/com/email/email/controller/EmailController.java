package com.email.email.controller;

import com.email.email.model.EmailRequest;
import com.email.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.email.email.model.EmailRequest;
import com.email.email.service.EmailService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class EmailController {

    @Autowired
    public EmailService emailService;


    @PostMapping("/send/mail")
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest emailRequest) {

//		System.out.println(emailRequest);
//		return ResponseEntity.status(200).body("Done");
//
        boolean result = this.emailService.sendEmail(emailRequest.getFrom(), emailRequest.getTo(), emailRequest.getTo1(), emailRequest.getSubject(), emailRequest.getMessage());
        if(result) {
            return ResponseEntity.ok("Email Sent Successfully..");
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email not sent ....");
        }
    }
}
