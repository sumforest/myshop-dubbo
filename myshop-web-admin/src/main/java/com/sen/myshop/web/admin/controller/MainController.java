package com.sen.myshop.web.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Auther: Sen
 * @Date: 2019/10/5 02:42
 * @Description: 服务聚合
 */
@Controller
public class MainController {

    @GetMapping(value = {"", "main"})
    public String showMain() {
        return "main";
    }

    @GetMapping(value = "/index")
    public String showIndex() {
        return "index";
    }
}
