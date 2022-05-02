package com.qinsicheng.springCloud.controller;



import com.qinsicheng.springCloud.service.PaymentService;

import com.qinsicheng.springcloud.entity.payment;
import com.qinsicheng.springcloud.entity.returnMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author qinsicheng
 * @Description 内容：
 * @Date 23/02/2022 11:20
 */
@Slf4j
@RestController
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String SERVER_PORT;

    @PostMapping(value = "/payment/create")
    public returnMessage<Integer> create(@RequestBody payment payment)
    {
        log.info("传输的信息为：{},端口号为：{}",payment,SERVER_PORT);
        int result = paymentService.addMessage(payment);
        log.info("*****插入操作返回结果:" + result);

        if(result > 0)
        {
            return new returnMessage<Integer>(200,"插入数据库成功,端口号为："+SERVER_PORT,result);
        }else{
            return new returnMessage<Integer>(444,"插入数据库失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public returnMessage<payment> getPaymentById(@PathVariable("id") Long id)
    {
        payment payment = paymentService.getMessageById(id);
        log.info("*****查询结果:{}",payment);
        if (payment != null) {
            return new returnMessage<payment>(200,"查询成功,端口号为："+SERVER_PORT,payment);
        }else{
            return new returnMessage<payment>(444,"没有对应记录,查询ID: "+id,null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery()
    {
        //discoveryClient.getServices()  获取注册中心所有服务项目
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            System.out.println(element);
        }
        //获取注册中心中具体项目的实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance element : instances) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB()
    {
        return SERVER_PORT;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeOut()
    {
        System.out.println("*****paymentFeignTimeOut from port: "+SERVER_PORT);
        //暂停几秒钟线程
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
        return SERVER_PORT;
    }
}
