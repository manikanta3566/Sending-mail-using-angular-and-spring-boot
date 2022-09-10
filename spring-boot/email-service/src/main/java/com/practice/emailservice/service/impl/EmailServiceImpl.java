package com.practice.emailservice.service.impl;

import com.practice.emailservice.dto.EmailRequestDTO;
import com.practice.emailservice.dto.EmailResponseDTO;
import com.practice.emailservice.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
@Slf4j
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public EmailResponseDTO sendSimpleMail(EmailRequestDTO emailRequestDTO) {
        try {
            log.info("started sending mail");
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom("from_mail");
            simpleMailMessage.setTo(emailRequestDTO.getTo());
            simpleMailMessage.setSubject(emailRequestDTO.getSubject());
            simpleMailMessage.setText(emailRequestDTO.getBody());
            javaMailSender.send(simpleMailMessage);
            log.info("mail sent");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return new EmailResponseDTO("mail sent");
    }

    @Override
    public EmailResponseDTO sendEmailWithAttachment(EmailRequestDTO emailRequestDTO) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom("from_mail");
            mimeMessageHelper.setTo(emailRequestDTO.getTo());
            mimeMessageHelper.setText(emailRequestDTO.getBody());
            mimeMessageHelper.setSubject(emailRequestDTO.getSubject());
            File file = new ClassPathResource("/static/img/wallpaper2.png").getFile();
            mimeMessageHelper.addAttachment("attachment",file);
            javaMailSender.send(mimeMessage);
        }catch (Exception e){
         throw new RuntimeException(e.getMessage());
        }
        return new EmailResponseDTO("mail sent");
    }
}
