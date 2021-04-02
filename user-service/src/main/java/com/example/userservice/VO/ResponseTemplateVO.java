package com.example.userservice.VO;

import com.example.userservice.model.DepartmentEntity;
import com.example.userservice.model.UserEntity;
import lombok.Data;


@Data
public class ResponseTemplateVO {

    private UserEntity userEntity;
    private DepartmentEntity departmentEntity;
}
