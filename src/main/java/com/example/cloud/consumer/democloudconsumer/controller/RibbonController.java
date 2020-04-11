package com.example.cloud.consumer.democloudconsumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * User: zhangll
 * Date: 2020-04-11
 * Time: 15:29
 */
@RestController
@RequestMapping("/ribbon")
@Slf4j
public class RibbonController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/log-instance")
    public void logUserInsance(){
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("user-provider");
        log.info("{}:{}:{}",serviceInstance.getServiceId(),serviceInstance.getHost(),serviceInstance.getPort());
    }
}
