package org.example.mailspringboot.service;

import org.example.mailspringboot.model.Correo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class correoService {
    @Autowired
    private JavaMailSender mailsender;
    @Value("$(spring.mail.username)")
    private String fromMail;
    public void sendMail(String mail, Correo correo) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(fromMail);
        simpleMailMessage.setSubject(correo.getSubject());
        simpleMailMessage.setText(correo.getMessage());
        simpleMailMessage.setTo(mail);

        mailsender.send(simpleMailMessage);
    }
}
