package com.learn.zookeeper.boot;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.learn.zookeeper"})
@MapperScan(basePackages = {"com.learn.zookeeper.mapper"})
@DubboComponentScan(basePackages = {"com.learn.zookeeper.service"})
public class AdminRun {
    public static void main(String[] args) {
        SpringApplication.run(AdminRun.class,args);
    }
}
