package com.qinsicheng.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextBean
{
    @Bean
//    @LoadBalanced  //Ribbon自带的负载均衡 默认是轮询方式
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }
}
