package com.example.basic1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/home")
public class HomeController {
    @GetMapping("1")
    public String home1(Model model) {
        return "home";
    }

    @GetMapping("2")
    public String home2(Model model) {
        return "home";
    }
}
