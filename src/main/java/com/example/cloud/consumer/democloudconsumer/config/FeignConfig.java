package com.example.cloud.consumer.democloudconsumer.config;

import feign.Contract;
import org.springframework.context.annotation.Bean;

/**
 * Description:
 * User: zhangll
 * Date: 2020-04-11
 * Time: 16:48
 */
public class FeignConfig {

    //将契约修改feign原生的默认契约，可以使用feign自带的注解
    @Bean
    public Contract feignContract(){
        return new feign.Contract.Default();
    }
}
