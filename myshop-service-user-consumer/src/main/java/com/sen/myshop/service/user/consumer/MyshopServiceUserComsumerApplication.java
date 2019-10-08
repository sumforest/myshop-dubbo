package com.sen.myshop.service.user.consumer;

import com.alibaba.dubbo.container.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Auther: Sen
 * @Date: 2019/10/1 23:25
 * @Description: 用户服务消费者
 */
@SpringBootApplication(scanBasePackages = "com.sen.myshop",exclude = DataSourceAutoConfiguration.class)
@EnableHystrixDashboard
@EnableHystrix
public class MyshopServiceUserComsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyshopServiceUserComsumerApplication.class, args);
        Main.main(args);
    }
}
