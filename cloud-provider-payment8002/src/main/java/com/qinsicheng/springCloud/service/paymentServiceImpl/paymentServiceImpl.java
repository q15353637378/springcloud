package com.qinsicheng.springCloud.service.paymentServiceImpl;

import com.qinsicheng.springCloud.dao.PaymentDao;
import com.qinsicheng.springCloud.service.PaymentService;
import com.qinsicheng.springcloud.entity.payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author qinsicheng
 * @Description 内容：
 * @Date 23/02/2022 11:19
 */
@Service
public class paymentServiceImpl implements PaymentService {
    @Autowired
    PaymentDao paymentDao;

    @Override
    public payment getMessageById(long id) {
        return paymentDao.getMessageById(id);
    }

    @Override
    public int addMessage(payment payment) {
        return paymentDao.addMessage(payment);
    }
}
