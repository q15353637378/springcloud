package com.qinsicheng.springCloud.controller;



import com.qinsicheng.springCloud.service.PaymentService;

import com.qinsicheng.springcloud.entity.payment;
import com.qinsicheng.springcloud.entity.returnMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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

    @Value("${server.port}")
    private String SERVER_PORT;

    @PostMapping(value = "/payment/create")
    public returnMessage<Integer> create(@RequestBody payment payment)
    {
        log.info("传输的信息为：{}",payment);
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

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB()
    {
        return SERVER_PORT;
    }
}
