package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * @author liaowei
 */
@Slf4j
@RestController
public class OrderController {
  @Autowired
  private RestTemplate restTemplate;

  public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
  @Autowired
  private LoadBalancer loadBalancer;
  @Autowired
  private DiscoveryClient discoveryClient;

  @PostMapping(value = "/consumer/payment/create")
  public CommonResult<Payment> create(@RequestBody Payment payment) {
    return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
  }

  @GetMapping(value = "/consumer/payment/get/{id}")
  public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
    return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
  }

  @GetMapping(value = "/consumer/payment/getForEntity/{id}")
  public CommonResult<Payment> getPayment2(@PathVariable("id") Long id) {
    final ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);

    if (entity.getStatusCode().is2xxSuccessful()) {
      return entity.getBody();
    }
    return new CommonResult<>(444, "操作失败");
  }

  @GetMapping(value = "/consumer/payment/lb")
  public String getPaymentLB() {
    List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

    if (instances == null || instances.size() == 0) {
      return null;
    }
    ServiceInstance serviceInstance = loadBalancer.instances(instances);
    URI uri = serviceInstance.getUri();

    return restTemplate.getForObject(uri + "/payment/lb", String.class);
  }
}
