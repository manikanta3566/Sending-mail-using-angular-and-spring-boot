package com.practice.emailservice.service;

import com.practice.emailservice.dto.EmailRequestDTO;
import com.practice.emailservice.dto.EmailResponseDTO;

public interface EmailService {
    public EmailResponseDTO sendSimpleMail(EmailRequestDTO emailRequestDTO);
    public EmailResponseDTO sendEmailWithAttachment(EmailRequestDTO emailRequestDTO);
}
