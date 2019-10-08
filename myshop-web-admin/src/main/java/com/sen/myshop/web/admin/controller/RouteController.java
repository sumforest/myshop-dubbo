package com.sen.myshop.web.admin.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.rpc.RpcContext;
import com.sen.myshop.service.content.api.ContentConsumerService;
import com.sen.myshop.service.user.api.UserConsumerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: Sen
 * @Date: 2019/10/5 01:21
 * @Description:
 */
@Controller
@RequestMapping(value = "/route")
public class RouteController {

    @Value(value = "${services.ports.user}")
    private String userPort;

    @Value(value = "${services.ports.content}")
    private String contentPort;

    @Reference(version = "${services.versions.user.v1}")
    private UserConsumerService userConsumerService;

    @Reference(version = "${services.versions.content.v1}")
    private ContentConsumerService contentConsumerService;

    /**
     * 路由用户管理
     * @param path
     * @return
     */
    @GetMapping(value = "/user")
    public String routeUser(String path) {
        // 远程调用
        userConsumerService.info();
        return redirect(path, userPort);
    }


    /**
     * 路由内容管理
     * @param path
     * @return
     */
    @GetMapping(value = "/content")
    public String routeContent(String path) {
        // 远程调用
        contentConsumerService.info();
        return redirect(path, contentPort);
    }

    /**
     * 路由目标地址
     * @param path 地址
     * @param port 端口
     * @return
     */
    private String redirect(String path, String port) {

        // 本端是否为消费端，这里会返回true
        boolean isConsumerSide = RpcContext.getContext().isConsumerSide();
        // 获取最后一次调用的提供方IP地址
        if (isConsumerSide) {
            String serverIP = RpcContext.getContext().getRemoteHost();
            String targetUrl = String.format("http://%s:%s/%s", serverIP, port, path);
            return "redirect:" + targetUrl;
        }
        return null;
    }
}
