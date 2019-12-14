package com.qfedu.car.news.dao;


import com.qfedu.car.news.entity.ArticleAction;

public interface ArticleActionMapper {
    int insert(ArticleAction record);

    int insertSelective(ArticleAction record);
}