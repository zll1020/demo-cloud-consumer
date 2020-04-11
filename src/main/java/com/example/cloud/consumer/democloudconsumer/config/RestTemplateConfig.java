package com.example.cloud.consumer.democloudconsumer.config;

import com.netflix.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

/**
 * Description:
 * User: zhangll
 * Date: 2020-04-11
 * Time: 11:39
 */
@Controller
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory factory){
        return new RestTemplate(factory);
    }

    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(5000);//ms
        factory.setConnectTimeout(15000);//ms
        return factory;
    }

}

