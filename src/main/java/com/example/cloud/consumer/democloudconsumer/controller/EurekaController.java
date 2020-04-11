package com.example.cloud.consumer.democloudconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description:
 * User: zhangll
 * Date: 2020-04-11
 * Time: 14:51
 */
@RestController
@RequestMapping("/eureka")
public class EurekaController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/movie-instance")
    public List<ServiceInstance> showInfo(){
        return discoveryClient.getInstances("movie-provider");
    }
}
