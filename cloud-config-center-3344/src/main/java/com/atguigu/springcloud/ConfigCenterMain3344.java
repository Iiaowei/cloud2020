package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author liaowei
 *
 *  curl -X POST "http://localhost:3344/actuator/bus-refresh"
 *  curl -X POST "http://localhost:3344/actuator/bus-refresh/config-client:3355"
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigCenterMain3344 {
  public static void main(String[] args) {
    SpringApplication.run(ConfigCenterMain3344.class, args);
  }
}
