package com.example.basic1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/api/home")
public class HomeController {
    @GetMapping
    public String showAttendees(Model model) {
        return "home";
    }
}
