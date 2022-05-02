package com.qinsicheng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author qinsicheng
 * @Description 内容：
 * @Date 02/05/2022 11:52
 */
@SpringBootApplication
@EnableConfigServer
public class cloudConfigMain {
    public static void main(String[] args) {
        SpringApplication.run(cloudConfigMain.class,args);
    }
}
