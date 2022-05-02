package com.qinsicheng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author qinsicheng
 * @Description 内容：
 * @Date 24/02/2022 10:47
 */
@SpringBootApplication
@EnableEurekaServer
public class eureka7002 {
    public static void main(String[] args) {
        SpringApplication.run(eureka7002.class,args);
    }
}
