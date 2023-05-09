package com.example.basic1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping(value = "/home")
public class HomeController {
    @GetMapping
    public String home(Model model) {
        System.out.println(new Date() + ": Call home()");
        return "index";
    }
}
