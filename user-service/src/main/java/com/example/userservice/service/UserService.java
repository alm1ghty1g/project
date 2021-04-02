package com.example.userservice.service;

import com.example.userservice.model.UserEntity;
import com.example.userservice.VO.ResponseTemplateVO;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.concurrent.TimeoutException;

public interface UserService {

    UserEntity saveUser(UserEntity userEntity);

    UserEntity findUser(int id) throws TimeoutException, UserPrincipalNotFoundException;

    ResponseTemplateVO getUserWithDepartment(int userId);
}
