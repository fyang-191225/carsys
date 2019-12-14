package com.qfedu.car.common.vo;

import lombok.Data;

import java.util.List;

/**
 * @author FYY
 * @date 2019/12/10 0010 下午 20:09
 */

@Data
public class PageBean<T> {
    // 页码，第几页
    private int page;
    // 总数
    private long total;
    // 每页多少条
    private int size;
    // 共多少页
    private long totalPage;
    // 具体的数据
    private List<T> data;

}
