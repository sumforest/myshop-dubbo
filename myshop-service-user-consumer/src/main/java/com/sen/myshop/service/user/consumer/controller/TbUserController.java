package com.sen.myshop.service.user.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.sen.myshop.commons.domain.TbUser;
import com.sen.myshop.service.user.api.TbUserService;
import com.sen.myshop.statics.backend.dto.DataTablesDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: Sen
 * @Date: 2019/10/1 23:28
 * @Description:
 */
@Controller
@RequestMapping(value = "/user")
public class TbUserController {

    @Reference(version = "${services.versions.user.v1}")
    private TbUserService tbUserService;

    /**
     * 跳转用户列表页面
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String showUsers() {
        return "user/userList";
    }

    @GetMapping(value = "/page")
    @ResponseBody
    public DataTablesDto<TbUser> showByPage(HttpServletRequest request) {
        String strdraw = request.getParameter("draw");
        String strstart = request.getParameter("start");
        String strlength = request.getParameter("length");

        //解析dataTables传过来的数据
        int draw = strdraw == null ? 0 : Integer.parseInt(strdraw);
        int start = strstart == null ? 0 : Integer.parseInt(strstart);
        int length = strlength == null ? 0 : Integer.parseInt(strlength);

        //封装DataTablesDto
        PageInfo<TbUser> tbUserPageInfo = tbUserService.listTbUserByPage(start, length);

        DataTablesDto<TbUser> dataTablesDto = new DataTablesDto<>();
        dataTablesDto.setDraw(draw);
        dataTablesDto.setData(tbUserPageInfo.getList());
        dataTablesDto.setRecordsFiltered(tbUserPageInfo.getTotal());
        dataTablesDto.setRecordsTotal(tbUserPageInfo.getTotal());

        return dataTablesDto;
    }
}
