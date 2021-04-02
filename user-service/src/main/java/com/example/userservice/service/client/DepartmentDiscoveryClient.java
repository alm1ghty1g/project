package com.example.userservice.service.client;


import com.example.userservice.model.DepartmentEntity;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class DepartmentDiscoveryClient {

    @Autowired
    private DiscoveryClient discoveryClient;

    public DepartmentEntity getDepartment(int id){
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance>  instances = discoveryClient.getInstances("department-service");

        if (instances.size()==0) return null;
        String serviceUrl = String.format("%s/department/find/%s", instances.get(0).getUri().toString(), id);

        ResponseEntity<DepartmentEntity> restExchange =
                restTemplate.exchange(
                        serviceUrl,
                        HttpMethod.GET,
                        null, DepartmentEntity.class, id);

        return restExchange.getBody();
    }
}
