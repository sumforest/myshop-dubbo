package com.sen.myshop.service.search.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Auther: Sen
 * @Date: 2019/10/6 23:30
 * @Description:
 */
@EnableHystrixDashboard
@EnableHystrix
@SpringBootApplication(scanBasePackages = "com.sen.myshop",exclude = DataSourceAutoConfiguration.class)
public class MyshopServiceSearchConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyshopServiceSearchConsumerApplication.class, args);
    }
}
