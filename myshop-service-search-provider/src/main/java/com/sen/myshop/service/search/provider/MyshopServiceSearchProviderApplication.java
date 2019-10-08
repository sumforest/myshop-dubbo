package com.sen.myshop.service.search.provider;

import com.alibaba.dubbo.container.Main;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Auther: Sen
 * @Date: 2019/10/6 04:04
 * @Description:
 */
@SpringBootApplication
@EnableHystrix
@EnableHystrixDashboard
@EnableTransactionManagement
@MapperScan(basePackages = "com.sen.myshop.service.search.provider.mapper")
public class MyshopServiceSearchProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyshopServiceSearchProviderApplication.class, args);
        Main.main(args);
    }
}
