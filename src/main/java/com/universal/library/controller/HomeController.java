package com.universal.library.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Value("${welcome.message}")
    private String welcomeMessage;

    @GetMapping("/api")
    public String getHome(){
        return welcomeMessage;
    }
}
