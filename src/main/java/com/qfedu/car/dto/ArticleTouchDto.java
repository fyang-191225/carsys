package com.qfedu.car.dto;

/**
 * @author FYY
 * @date 2019/12/14 0014 上午 10:27
 */

import lombok.Data;

import java.util.Date;

/**
 * 前端需要展示的数据
 */
@Data
public class ArticleTouchDto {

    private int id;
    private int mid; // 用户id
    private int aid; // 咨询信息id
    private String title; // 标题
    private String summary;//摘要
    private String cover_pic;//封面图片
    private Date ctime; //
}