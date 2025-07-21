package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.CalcolatriceSomma;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class CalcolatriceController {
    private final CalcolatriceSomma calcolatriceSomma;

    @Autowired
    public CalcolatriceController(CalcolatriceSomma calcolatriceSomma) {
        this.calcolatriceSomma = calcolatriceSomma;
    }

    @GetMapping("/somma")
    public int somma(@RequestParam int a , @RequestParam int b) {
        return calcolatriceSomma.somma(a, b);
    }
    

}
