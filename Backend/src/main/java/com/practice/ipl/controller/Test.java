package com.practice.ipl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
    
    @GetMapping("/test")
    public String testString(){
        return "Test Successfull!";
    }
}
