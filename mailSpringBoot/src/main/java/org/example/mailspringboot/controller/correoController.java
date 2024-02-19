package org.example.mailspringboot.controller;

import org.example.mailspringboot.model.Correo;
import org.example.mailspringboot.service.correoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail")
public class correoController {
    @Autowired
    private correoService correoService;

    @PostMapping("send/{mail}")
    public String sendMail(@PathVariable String mail, @RequestBody Correo correo){
        correoService.sendMail(mail, correo);
        return("Correo enviado correctamente");
    }
}
