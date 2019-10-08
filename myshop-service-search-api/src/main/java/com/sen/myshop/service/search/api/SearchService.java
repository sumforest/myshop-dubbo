package com.sen.myshop.service.search.api;

import com.sen.myshop.service.search.dto.TbSearchDto;

import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/10/6 03:58
 * @Description: solr全文检索接口
 */
public interface SearchService {

    /**
     * 根据条件查询所有的数据
     * @param query 搜索条件
     * @param start 页数
     * @param row 页宽
     * @return
     */
    List<TbSearchDto> listTbSearchDtos(String query, int start, int row);
}
