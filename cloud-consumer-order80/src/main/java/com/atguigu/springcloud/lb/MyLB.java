package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLB implements LoadBalancer {

  private AtomicInteger atomicInteger = new AtomicInteger(0);

  public final int getAndIncrement() {
    int current;
    int next;

    do {
      current = atomicInteger.get();
      next = current >= Integer.MAX_VALUE ? 0: current + 1;
    } while (atomicInteger.compareAndSet(current, next));

    System.out.printf("*****第几次访问,次数next:%d", next);
    return next;
  }
  @Override
  public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
    int index = getAndIncrement() % serviceInstances.size();
    return serviceInstances.get(index);
  }
}
