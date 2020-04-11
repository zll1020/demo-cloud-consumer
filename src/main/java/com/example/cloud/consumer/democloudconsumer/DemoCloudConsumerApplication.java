package com.example.cloud.consumer.democloudconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DemoCloudConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoCloudConsumerApplication.class, args);
    }

}
