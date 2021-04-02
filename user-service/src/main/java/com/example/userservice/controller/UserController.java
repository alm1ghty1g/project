package com.example.userservice.controller;

import com.example.userservice.model.UserEntity;
import com.example.userservice.VO.ResponseTemplateVO;
import com.example.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.concurrent.TimeoutException;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;



    @PostMapping("/create")
    public ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity userEntity){
        System.out.println("saveUser called");
        return ResponseEntity.ok(userService.saveUser(userEntity));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<UserEntity> findUser(@PathVariable int id) throws TimeoutException, UserPrincipalNotFoundException {
        System.out.println("findUser called");
        return ResponseEntity.ok(userService.findUser(id));
    }


    @GetMapping("/find-with-dept/{userId}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("userId") int userId) {
        return userService.getUserWithDepartment(userId);
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
