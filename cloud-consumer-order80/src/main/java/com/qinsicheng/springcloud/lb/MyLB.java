package com.qinsicheng.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author qinsicheng
 * @Description 内容：手写轮询算法
 * @Date 02/03/2022 09:19
 */
@Component
public class MyLB implements LoadBalancer{
    //保证原子性
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current>=Integer.MAX_VALUE?0:current+1;
        } while (!atomicInteger.compareAndSet(current,next));
        System.out.println("********* next:"+next);
        return next;

    }
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        //通过自己写的轮询算法  获取对应的下标   然后从list中取出 并返回
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
