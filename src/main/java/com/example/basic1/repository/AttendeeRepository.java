package com.example.basic1.repository;

import com.example.basic1.entity.AttendeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendeeRepository extends JpaRepository<AttendeeEntity, Long> {
}
