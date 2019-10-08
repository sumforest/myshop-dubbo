package com.sen.myshop.service.search.provider.mapper;

import com.sen.myshop.service.search.dto.TbSearchDto;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/10/6 04:06
 * @Description: 用于全文检索多表联查的接口
 */
@Repository
public interface TbSearchMapper {

    /**
     * 查询所有的搜索对象
     * @return 所有的搜索dto
     */
    List<TbSearchDto> listTbSearchDto();
}
