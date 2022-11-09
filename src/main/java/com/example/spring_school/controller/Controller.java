package com.example.spring_school.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping
public class Controller {

    @GetMapping(value = "/")
    public String ControllerTest(Model model){

        return "index";
    }

}
