package com.example.basic1.controller;

import com.example.basic1.entity.AttendeeEntity;
import com.example.basic1.repository.AttendeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/api/attendees")
public class AttendeeController {
    private final AttendeeRepository attendeeRepository;

    public AttendeeController(AttendeeRepository attendeeRepository) {
        this.attendeeRepository = attendeeRepository;
    }
    @GetMapping
    public String showAttendees(Model model) {
//        List<AttendeeEntity> attendees = attendeeRepository.findAll();
        List<AttendeeEntity> attendees = new ArrayList<>();
        model.addAttribute("attendees", attendees);
        return "filter-all-attendees";
    }
}
