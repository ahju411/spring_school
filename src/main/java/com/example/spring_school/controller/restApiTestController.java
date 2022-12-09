package com.example.spring_school.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public class restApiTestController {

    @RequestMapping("/test")
    public String method(Model model){
        return "성공했나요?";
    }

}
