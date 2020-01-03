package com.leyou.common;

import lombok.Data;

import java.util.List;

/**
 * 分页查询返回结果集
 * @author
 * @version 1.00
 * @time 2019/12/27 0027  下午 3:15
 */
@Data
public class PageResult<T> {
    //总条数
    private Long total;
    //总页数
    private Long totalPage;
    //每页数据
    private List<T> items;

    public PageResult(Long total, List<T> items) {
        this.total = total;
        this.items = items;
    }

    public PageResult(Long total, Long totalPage, List<T> items) {
        this.total = total;
        this.totalPage = totalPage;
        this.items = items;
    }



}
