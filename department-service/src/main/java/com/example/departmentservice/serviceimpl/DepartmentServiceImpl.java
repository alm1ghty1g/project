package com.example.departmentservice.serviceimpl;

import com.example.departmentservice.model.DepartmentEntity;
import com.example.departmentservice.repositories.DepartmentRepository;
import com.example.departmentservice.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class DepartmentServiceImpl implements DepartmentService {

    private static final Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);


    @Autowired
    private DepartmentRepository departmentRepository;


    @Override
    public DepartmentEntity findDepartment(int id) {
        Optional<DepartmentEntity> departmentEntity = departmentRepository.findByDepartmentId(id);
        return (departmentEntity.isPresent()) ? departmentEntity.get(): null;
    }


    @Override
    public DepartmentEntity saveDepartment(DepartmentEntity departmentEntity) {
        departmentEntity = departmentRepository.save(departmentEntity);
        return departmentEntity;
    }
}
