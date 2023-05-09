package com.example.basic1.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/home")
@Slf4j
public class HomeController {
    @GetMapping
    public String home(Model model) {
        log.info("Call api HomeController.home");
        return "index";
    }
}
