package com.example.userservice.ServiceImpl;

import com.example.userservice.model.DepartmentEntity;
import com.example.userservice.model.UserEntity;
import com.example.userservice.VO.*;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.service.UserService;
import com.example.userservice.service.client.DepartmentDiscoveryClient;
import com.example.userservice.service.client.DepartmentRestTemplateClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Random;
import java.util.concurrent.TimeoutException;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    DepartmentRestTemplateClient departmentRestTemplateClient;

    @Autowired
    DepartmentDiscoveryClient departmentDiscoveryClient;

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    @Override
    public ResponseTemplateVO getUserWithDepartment(int id) {
        ResponseTemplateVO vo = new ResponseTemplateVO();

        UserEntity userEntity = userRepository.findById(id);

        DepartmentEntity departmentEntity = departmentRestTemplateClient.getDepartment(userEntity.getDepartmentId());

//        DepartmentEntity departmentEntity = departmentDiscoveryClient.getDepartmentEntity(userEntity.getDepartmentId());

        System.out.println("getUserWithDepartment called");

        vo.setUserEntity(userEntity);
        vo.setDepartmentEntity(departmentEntity);
        return vo;
    }


    //    @CircuitBreaker(name = "licenseService", fallbackMethod = "buildFallbackLicenseList")
//    @RateLimiter(name = "licenseService", fallbackMethod = "buildFallbackLicenseList")
//    @Retry(name = "retryLicenseService", fallbackMethod = "buildFallbackLicenseList")
//    @Bulkhead(name = "bulkheadLicenseService", type= Bulkhead.Type.THREADPOOL, fallbackMethod = "buildFallbackLicenseList")
    @Override
    public UserEntity findUser(int id) throws UserPrincipalNotFoundException {

        UserEntity userEntity = userRepository.findById(id);
        if (userEntity == null){
            throw new UserPrincipalNotFoundException("not found");
        }
            return userRepository.findById(id);
    }

    @Override
    public UserEntity saveUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }


    private void randomlyRunLong() throws TimeoutException {
        Random rand = new Random();
        int randomNum = rand.nextInt((3 - 1) + 1) + 1;
        if (randomNum == 3) sleep();
    }

    private void sleep() throws TimeoutException {
        try {
            System.out.println("Sleep");
            Thread.sleep(5000);
            throw new java.util.concurrent.TimeoutException();
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
    }
}
