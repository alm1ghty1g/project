package com.example.userservice.service.client;


import com.example.userservice.model.DepartmentEntity;
import com.example.userservice.utils.UserContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DepartmentRestTemplateClient {

    @Autowired
    RestTemplate restTemplate;


    private static final Logger logger = LoggerFactory.getLogger(DepartmentRestTemplateClient.class);


        public DepartmentEntity getDepartment(int departmentId){
        ResponseEntity<DepartmentEntity> restExchange =
                restTemplate.exchange(
                        "http://department-service/department/find/{id}",
                        HttpMethod.GET,
                        null, DepartmentEntity.class, departmentId);

        return restExchange.getBody();
    }

}
