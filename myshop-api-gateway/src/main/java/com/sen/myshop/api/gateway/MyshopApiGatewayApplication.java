package com.sen.myshop.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Auther: Sen
 * @Date: 2019/10/5 01:16
 * @Description:
 */
@SpringBootApplication(scanBasePackages = "com.sen.myshop",exclude = DataSourceAutoConfiguration.class)
@EnableHystrixDashboard
@EnableHystrix
public class MyshopApiGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyshopApiGatewayApplication.class, args);
    }
}
