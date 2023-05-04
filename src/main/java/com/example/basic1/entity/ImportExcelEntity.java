package com.example.basic1.entity;

import javax.persistence.*;

@Entity(name = "ImportExcel")
@Table(name = "import_excel")
public class ImportExcelEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
    public ImportExcelEntity() {
    }

    public ImportExcelEntity(String name) {
        this.name = name;
    }
    public ImportExcelEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
