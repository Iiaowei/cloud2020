package com.atguigu.spirngcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author liaowei
 */

@Slf4j
@RestController
public class PaymentController {
  @Value("${server.port}")
  private String serverPort;

  @GetMapping(value = "/payment/consul")
  public String paymentzk() {
    return "springcloud with consul: "+ serverPort + "\t" + UUID.randomUUID().toString();
  }
}
