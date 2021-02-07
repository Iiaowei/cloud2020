package com.atguigu.spirngcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author liaowei
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentMain8006 {
  public static void main(String[] args) {
    SpringApplication.run(PaymentMain8006.class, args);
  }
}
