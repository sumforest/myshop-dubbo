package com.sen.myshop.service.content.api;

import com.github.pagehelper.PageInfo;
import com.sen.myshop.commons.domain.TbContent;

import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/10/4 21:47
 * @Description: 内容管理接口
 */
public interface TbContentService {

    /**
     * 查询所有
     * @return
     */
    List<TbContent> selectAll();

    /**
     * 分页查询
     * @param pageNum 开始的记录数
     * @param pageSize 页宽
     * @return pageHelp对象
     */
    PageInfo<TbContent> listContentByPage(int pageNum, int pageSize);
}
