package com.sen.myshop.service.content.provider.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sen.myshop.commons.domain.TbContent;
import com.sen.myshop.commons.mapper.TbContentMapper;
import com.sen.myshop.service.content.api.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/10/4 22:01
 * @Description:
 */
@Service(version = "${services.versions.content.v1}")
@Transactional(readOnly = true)
public class TbContentServiceImpl implements TbContentService {

    @Autowired
    private TbContentMapper tbContentMapper;

    @Override
    public List<TbContent> selectAll() {
        return tbContentMapper.selectAll();
    }

    @Override
    public PageInfo<TbContent> listContentByPage(int pageNum, int pageSize) {
        Example example = new Example(TbContent.class);
        PageHelper.offsetPage(pageNum, pageSize);
        List<TbContent> tbContents = tbContentMapper.selectByExample(example);
        return new PageInfo<>(tbContents);
    }
}
