package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author liaowei
 */
public interface LoadBalancer {
  /**
   *
   * @param serviceInstances
   * @return
   */
  ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
