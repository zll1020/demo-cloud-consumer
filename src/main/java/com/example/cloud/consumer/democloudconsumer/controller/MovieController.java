package com.example.cloud.consumer.democloudconsumer.controller;

import com.example.cloud.consumer.democloudconsumer.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){
        return restTemplate.getForObject("http://user-provider/user/" + id,User.class);
    }

}
