package com.sen.myshop.service.search.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sen.myshop.service.search.api.SearchService;
import com.sen.myshop.service.search.dto.TbSearchDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/10/6 23:41
 * @Description:
 */
@Controller
@ResponseBody
public class SearchController {

    @Reference(version = "${services.versions.search.v1}")
    private SearchService searchService;

    @GetMapping(value = "/search/{query}/{start}/{rows}")
    public List<TbSearchDto> listSearchDtos(@PathVariable String query,
                                            @PathVariable int start, @PathVariable int rows) {
        List<TbSearchDto> tbSearchDtos = searchService.listTbSearchDtos(query, start, rows);
        return tbSearchDtos;
    }
}
