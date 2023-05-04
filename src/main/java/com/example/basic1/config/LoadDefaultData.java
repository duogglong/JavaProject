package com.example.basic1.config;

import com.example.basic1.repository.AttendeeRepository;
import com.example.basic1.service.impl.ExcelService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class LoadDefaultData {
    public final ExcelService excelService;
    public LoadDefaultData(ExcelService excelService) {
        this.excelService = excelService;
    }

    @Bean
    public void initialAttendees() throws IOException {
        excelService.importAttendees();
    }
}
