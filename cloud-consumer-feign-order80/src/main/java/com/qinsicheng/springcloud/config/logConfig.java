package com.qinsicheng.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author qinsicheng
 * @Description 内容：
 * @Date 11/03/2022 19:58
 */
@Configuration
public class logConfig {
    @Bean
    Logger.Level feignLoggerLevel()
    {
        return Logger.Level.FULL;
    }
}
