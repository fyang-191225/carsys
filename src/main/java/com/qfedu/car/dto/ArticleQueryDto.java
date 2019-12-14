package com.qfedu.car.dto;

/**
 * @author FYY
 * @date 2019/12/14 0014 上午 11:45
 */

import lombok.Data;

/**
 * 分页查询，接口所需参数
 */
@Data
public class ArticleQueryDto {
    private int type; // 咨询的类型
    private String title;// 标题
    private int page;// 当前页码
    private int size;//每页展示的条数
}
