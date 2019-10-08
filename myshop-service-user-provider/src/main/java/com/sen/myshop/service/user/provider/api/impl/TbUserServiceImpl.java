package com.sen.myshop.service.user.provider.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sen.myshop.commons.domain.TbUser;
import com.sen.myshop.commons.mapper.TbUserMapper;
import com.sen.myshop.service.user.api.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/10/1 22:19
 * @Description:
 */
@Service(version = "${services.versions.user.v1}")
@Transactional(readOnly = true)
public class TbUserServiceImpl implements TbUserService {

    @Autowired
    private TbUserMapper tbUserMapper;

    @Override
    public List<TbUser> selectAll() {
        return tbUserMapper.selectAll();
    }

    @Override
    public PageInfo<TbUser> listTbUserByPage(int pageNum, int pageSize) {
        Example example = new Example(TbUser.class);
        PageHelper.offsetPage(pageNum, pageSize);
        List<TbUser> tbUsers = tbUserMapper.selectByExample(example);
        return new PageInfo<>(tbUsers);
    }
}
