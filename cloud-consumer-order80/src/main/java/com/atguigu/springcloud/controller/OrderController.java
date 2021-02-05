package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author liaowei
 */
@Slf4j
@RestController
public class OrderController {
  @Autowired
  private RestTemplate restTemplate;

  public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

  @PostMapping(value = "/consumer/payment/create")
  public CommonResult<Payment> create(@RequestBody Payment payment) {
    return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
  }

  @GetMapping(value = "/consumer/payment/get/{id}")
  public CommonResult<Payment> create(@PathVariable("id") Long id) {
    return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
  }
}
