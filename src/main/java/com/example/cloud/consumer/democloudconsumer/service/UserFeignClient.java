package com.example.cloud.consumer.democloudconsumer.service;

import com.example.cloud.consumer.democloudconsumer.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Description:
 * User: zhangll
 * Date: 2020-04-11
 * Time: 16:36
 */
@FeignClient(name = "user-provider")
public interface UserFeignClient {

    @RequestMapping(value = "/user/{id}" ,method = RequestMethod.GET)
    public User findbyId(@PathVariable("id") Long id);


}
