package com.atguigu.springcloud;

import org.junit.Test;

import java.time.ZonedDateTime;

public class T2 {
  @Test
  public void test1() {
    ZonedDateTime zonedDateTime = ZonedDateTime.now();
    System.out.println(zonedDateTime);
  }
}
