package com.example.cloud.consumer.democloudconsumer.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description:
 * User: zhangll
 * Date: 2020-04-11
 * Time: 15:56
 */
@Configuration
public class RibbonConfig {

    @Bean
    public IRule ribbonRule(){

        // 改为随机
        return new RandomRule();
    }
}
