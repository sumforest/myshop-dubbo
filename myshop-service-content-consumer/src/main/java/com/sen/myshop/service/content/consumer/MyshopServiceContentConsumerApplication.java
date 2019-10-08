package com.sen.myshop.service.content.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Auther: Sen
 * @Date: 2019/10/4 22:12
 * @Description: 内容管理服务消费者
 */
@SpringBootApplication(scanBasePackages = "com.sen.myshop",exclude = DataSourceAutoConfiguration.class)
@EnableHystrix
@EnableHystrixDashboard
public class MyshopServiceContentConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyshopServiceContentConsumerApplication.class, args);
    }
}
