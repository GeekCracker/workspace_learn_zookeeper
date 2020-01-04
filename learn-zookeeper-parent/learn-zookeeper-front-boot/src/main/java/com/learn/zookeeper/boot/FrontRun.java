package com.learn.zookeeper.boot;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.learn.zookeeper"})
@DubboComponentScan(basePackages = {"com.learn.zookeeper.service"})
public class FrontRun {
    public static void main(String[] args) {
        SpringApplication.run(FrontRun.class,args);
    }
}
