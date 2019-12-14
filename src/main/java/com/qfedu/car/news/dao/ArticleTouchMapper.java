package com.qfedu.car.news.dao;


import com.qfedu.car.dto.ArticleTouchDto;
import com.qfedu.car.news.entity.ArticleTouch;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ArticleTouchMapper {
    /**
     * 增加数据，点赞
     *
     * @param record
     * @return
     */
    int insert(ArticleTouch record);

    /**
     * 删除信息，取消点赞
     *
     * @param touch
     * @return
     */
    int del(ArticleTouch touch);

    /**
     * 查询用户点赞的记录
     *
     * @param mid
     * @return
     */
    List<ArticleTouchDto> selectAll(int mid);
}