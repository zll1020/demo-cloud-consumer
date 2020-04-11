package com.example.cloud.consumer.democloudconsumer.client;

import com.example.cloud.consumer.democloudconsumer.entity.User;
import com.example.cloud.consumer.democloudconsumer.service.UserFeignClient;
import org.springframework.stereotype.Component;

/**
 * Description:
 * User: zhangll
 * Date: 2020-04-11
 * Time: 20:39
 */
public class FeignClientFallback implements UserFeignClient {
    @Override
    public User findById(Long id) {
        User user = new User();
        user.setId(-2L);
        user.setUsername("feign callback默认用户");
        return user;
    }
}
