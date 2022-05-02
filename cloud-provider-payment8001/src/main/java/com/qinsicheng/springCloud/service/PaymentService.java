package com.qinsicheng.springCloud.service;


import com.qinsicheng.springcloud.entity.payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author qinsicheng
 * @Description 内容：
 * @Date 23/02/2022 11:18
 */
public interface PaymentService {
    //查询方法  id  对应的 是数据的id
    public payment getMessageById(@Param("id") long id);
    //插入方法
    public int addMessage(payment payment);
}
