package com.qinsicheng.springcloud;

import com.qinsicheng.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Author qinsicheng
 * @Description 内容：
 * @Date 28/02/2022 10:49
 */
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration= MySelfRule.class)
@SpringBootApplication
public class OrderZK80 {
    public static void main(String[] args)
    {
        SpringApplication.run(OrderZK80.class,args);
    }

}
