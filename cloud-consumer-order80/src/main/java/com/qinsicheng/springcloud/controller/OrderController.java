package com.qinsicheng.springcloud.controller;


import com.qinsicheng.springcloud.entity.payment;
import com.qinsicheng.springcloud.entity.returnMessage;
import com.qinsicheng.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @Author qinsicheng
 * @Description 内容：
 * @Date 23/02/2022 13:21
 */
@RestController
@Slf4j
public class OrderController {
    public static final String PAYMENT_PATH = "http://CLOUD-PAYMENT-SERVICE";

    //网络连接
    @Autowired
    RestTemplate restTemplate;

    //发现注册中心的服务
    @Resource
    private DiscoveryClient discoveryClient;

    //自己写的轮询算法
    @Resource
    private LoadBalancer loadBalancer;

    @Value("${server.port}")
    private String SERVER_PORT;


    @GetMapping("/consumer/payment/create")
    public returnMessage<payment> create(payment payment) {
        System.out.println("获取到得到  payment"+ payment);
        //post ： 路径 + 参数  + 返回值类型
        return restTemplate.postForObject(PAYMENT_PATH + "/payment/create",payment,returnMessage.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public returnMessage<Integer> getPayment(@PathVariable Long id)
    {
        //get ： 路径 + 返回值类型
        return restTemplate.getForObject(PAYMENT_PATH + "/payment/get/"+id, returnMessage.class);
    }

    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB()
    {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        if(instances == null || instances.size()<=0) {
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        System.out.println(uri);

        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }

    @GetMapping(value = "/payment/lb")
    public String getLB()
    {
        return SERVER_PORT;
    }


}
