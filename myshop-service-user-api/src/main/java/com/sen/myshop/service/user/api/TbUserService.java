package com.sen.myshop.service.user.api;

import com.github.pagehelper.PageInfo;
import com.sen.myshop.commons.domain.TbUser;

import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/10/1 22:06
 * @Description: 用户管理服务接口
 */
public interface TbUserService {
    /**
     * 查询所有的数据
     * @return 所有用户
     */
    List<TbUser> selectAll();

    /**
     * 分页查询
     * @param pageNum 页数
     * @param pageSize 页宽
     * @return pageInfo
     */
    PageInfo<TbUser> listTbUserByPage(int pageNum, int pageSize);
}
