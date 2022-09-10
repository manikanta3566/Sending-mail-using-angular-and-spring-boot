package com.practice.emailservice.controller;

import com.practice.emailservice.dto.EmailRequestDTO;
import com.practice.emailservice.dto.EmailResponseDTO;
import com.practice.emailservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin()
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping("/sendmail")
    public ResponseEntity<EmailResponseDTO> sendSimpleMail(@RequestBody EmailRequestDTO emailRequestDTO){
        EmailResponseDTO emailResponseDTO = emailService.sendEmailWithAttachment(emailRequestDTO);
        return new ResponseEntity<>(emailResponseDTO, HttpStatus.OK);
    }
}
