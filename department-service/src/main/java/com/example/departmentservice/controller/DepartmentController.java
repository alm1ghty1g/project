package com.example.departmentservice.controller;


import com.example.departmentservice.model.DepartmentEntity;
import com.example.departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;


    @PostMapping("/create")
    public ResponseEntity<DepartmentEntity> saveDepartment(@RequestBody DepartmentEntity departmentEntity) {
        System.out.println("save dept called");
        return ResponseEntity.ok(departmentService.saveDepartment(departmentEntity));
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<DepartmentEntity> findDepartment(@PathVariable int id) {
        System.out.println("find dept called");
        return ResponseEntity.ok(departmentService.findDepartment(id));
    }


    @PostMapping("/post-test")
    public String postTest() {
        return "post-test called";
    }


    @GetMapping("/get-test")
    public String getTest() {
        return "get-test called";
    }
}
