package com.example.departmentservice.service;

import com.example.departmentservice.model.DepartmentEntity;

public interface DepartmentService {

    DepartmentEntity saveDepartment(DepartmentEntity departmentEntity);

    DepartmentEntity findDepartment(int id);
}
