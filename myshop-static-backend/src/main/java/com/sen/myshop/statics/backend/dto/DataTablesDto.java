package com.sen.myshop.statics.backend.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/10/4 18:39
 * @Description: 用于dataTables的分页的传输对象
 */
@Data
public class DataTablesDto<T> implements Serializable {
    private int draw;
    private long recordsTotal;
    private long recordsFiltered;
    private List<T> data;
    private String error;
}
