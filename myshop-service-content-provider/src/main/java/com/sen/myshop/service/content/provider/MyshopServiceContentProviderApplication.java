package com.sen.myshop.service.content.provider;

import com.alibaba.dubbo.container.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Auther: Sen
 * @Date: 2019/10/4 21:54
 * @Description: 内容管理服务提供者
 */
@SpringBootApplication(scanBasePackages = "com.sen.myshop.commons")
@EnableHystrix
@EnableHystrixDashboard
@EnableTransactionManagement
@MapperScan(basePackages = "com.sen.myshop.commons.mapper")
public class MyshopServiceContentProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyshopServiceContentProviderApplication.class, args);
        Main.main(args);
    }
}
