package com.example.basic1.repository;

import com.example.basic1.entity.AttendeeEntity;
import com.example.basic1.entity.ImportExcelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ImportExcelRepository extends JpaRepository<ImportExcelEntity, Long> {
    @Query(value = "select count(*) from import_excel where name = ?1", nativeQuery = true)
    Integer countByName(String name);
}
