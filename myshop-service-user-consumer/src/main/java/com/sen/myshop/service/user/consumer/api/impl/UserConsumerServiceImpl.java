package com.sen.myshop.service.user.consumer.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.sen.myshop.service.user.api.UserConsumerService;

/**
 * @Auther: Sen
 * @Date: 2019/10/5 01:10
 * @Description: 为服务聚合路由网关提供服务
 */
@Service(version = "${services.versions.user.v1}")
public class UserConsumerServiceImpl implements UserConsumerService {
    @Override
    public void info() {

    }
}
