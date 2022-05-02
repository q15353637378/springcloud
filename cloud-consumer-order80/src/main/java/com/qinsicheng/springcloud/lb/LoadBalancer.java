package com.qinsicheng.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author qinsicheng
 * @Description 内容：
 * @Date 02/03/2022 09:18
 */
public interface LoadBalancer
{
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
