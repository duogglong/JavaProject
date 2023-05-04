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
    @GetMapping("/1")
    public String home1(Model model) {
        log.info("Call api HomeController.home1");
        return "home";
    }

    @GetMapping("/2")
    public String home2(Model model) {
        log.info("Call api HomeController.home2 sdfsd");
        return "home2";
    }
}
