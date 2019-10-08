package com.sen.myshop.service.redis.provider;

import com.alibaba.dubbo.container.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Auther: Sen
 * @Date: 2019/10/5 21:36
 * @Description:
 */
@SpringBootApplication
@EnableHystrix
@EnableHystrixDashboard
public class MyshopServiceRedisProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyshopServiceRedisProviderApplication.class, args);
        Main.main(args);
    }
}
