package com.example.demo.controller;

import java.security.MessageDigest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.MessaggioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class DemoController {

    private final MessaggioService messaggioService;

    @Autowired
    public DemoController(MessaggioService messaggioService) {
        this.messaggioService = messaggioService;
    }

    @GetMapping("/saluta")
    public String saluta() {
        messaggioService.saluta();
       return "Saluto inviato";
    }

    
    
}
