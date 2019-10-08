package com.sen.myshop.service.content.consumer.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.sen.myshop.service.content.api.ContentConsumerService;

/**
 * @Auther: Sen
 * @Date: 2019/10/5 01:53
 * @Description: 为服务聚合路由网关提供服务
 */
@Service(version = "${services.versions.content.v1}")
public class ContentConsumerServiceImpl implements ContentConsumerService {
    @Override
    public void info() {

    }
}
