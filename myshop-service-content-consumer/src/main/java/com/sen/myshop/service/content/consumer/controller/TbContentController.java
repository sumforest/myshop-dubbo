package com.sen.myshop.service.content.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.sen.myshop.commons.domain.TbContent;
import com.sen.myshop.service.content.api.TbContentService;
import com.sen.myshop.statics.backend.dto.DataTablesDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: Sen
 * @Date: 2019/10/4 22:16
 * @Description:
 */
@Controller
@RequestMapping(value = "/content")
public class TbContentController {

    @Reference(version = "${services.versions.content.v1}")
    private TbContentService tbContentService;

    @GetMapping(value = "/list")
    public String showContentList() {
        return "content/contentList";
    }

    @GetMapping(value = "/page")
    @ResponseBody
    public DataTablesDto<TbContent> showByPage(HttpServletRequest request) {
        String strdraw = request.getParameter("draw");
        String strstart = request.getParameter("start");
        String strlength = request.getParameter("length");

        //解析dataTables传过来的数据
        int draw = strdraw == null ? 0 : Integer.parseInt(strdraw);
        int start = strstart == null ? 0 : Integer.parseInt(strstart);
        int length = strlength == null ? 0 : Integer.parseInt(strlength);

        //封装DataTablesDto
        PageInfo<TbContent> tbContentPageInfo = tbContentService.listContentByPage(start, length);

        DataTablesDto<TbContent> dataTablesDto = new DataTablesDto<>();
        dataTablesDto.setDraw(draw);
        dataTablesDto.setData(tbContentPageInfo.getList());
        dataTablesDto.setRecordsFiltered(tbContentPageInfo.getTotal());
        dataTablesDto.setRecordsTotal(tbContentPageInfo.getTotal());

        return dataTablesDto;
    }

    /**
     * 跳转内容表单页面
     * @return
     */
    @GetMapping(value = "/form")
    public String showForm() {
        return "content/contentForm";
    }
}
