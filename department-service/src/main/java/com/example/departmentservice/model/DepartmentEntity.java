package com.example.departmentservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "departments")
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id", nullable = false)
    private int departmentId;

    @Column(name = "department_name", nullable = false)
    private String departmentName;

    @Column(name = "department_location", nullable = false)
    private String departmentLocation;

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getDepartmentId() {
        return departmentId;
    }
}
