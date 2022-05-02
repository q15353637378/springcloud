package com.qinsicheng.springCloud.dao;

import com.qinsicheng.springcloud.entity.payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author qinsicheng
 * @Description 内容：
 * @Date 23/02/2022 10:58
 */
@Mapper
public interface PaymentDao {
    //查询方法  id  对应的 是数据的id
    public payment getMessageById(@Param("id") long id);
    //插入方法
    public int addMessage(payment payment);

}
