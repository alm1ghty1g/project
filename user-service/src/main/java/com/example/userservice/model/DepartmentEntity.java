package com.example.userservice.model;


import lombok.Data;


import javax.persistence.Id;

@Data
public class DepartmentEntity {

    @Id
    private int departmentId;

    private String departmentName;

    private String departmentLocation;
}
