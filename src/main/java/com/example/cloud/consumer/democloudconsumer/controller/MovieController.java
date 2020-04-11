package com.example.cloud.consumer.democloudconsumer.controller;

import com.example.cloud.consumer.democloudconsumer.entity.User;
import com.example.cloud.consumer.democloudconsumer.service.UserFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Description:
 * User: zhangll
 * Date: 2020-04-11
 * Time: 12:08
 */
@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){
        return restTemplate.getForObject("http://user-provider/user/" + id,User.class);
    }

    @GetMapping("/feign/{id}")
    public User findByIdFeign(@PathVariable Long id){
        return userFeignClient.findById(id);
    }

    @GetMapping("/hystrix/{id}")
    @HystrixCommand(fallbackMethod = "findByIdFallBack")
    public User findByIdHystrix(@PathVariable Long id){
        return restTemplate.getForObject("http://user-provider/user/" + id,User.class);
    }

    public User findByIdFallBack(Long id){
        User user = new User();
        user.setId(-1L);
        user.setUsername("默认用户");
        return user;
    }

}
