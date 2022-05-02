package com.qinsicheng.springcloud.controller;

import com.qinsicheng.springcloud.entity.payment;
import com.qinsicheng.springcloud.entity.returnMessage;
import com.qinsicheng.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderFeignController
{
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public returnMessage<payment> getPaymentById(@PathVariable("id") Long id)
    {
        System.out.println("从Feign调用");
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeOut()
    {
        return paymentFeignService.paymentFeignTimeOut();
    }
}