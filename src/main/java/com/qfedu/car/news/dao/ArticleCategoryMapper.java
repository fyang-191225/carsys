package com.qfedu.car.news.dao;


import com.qfedu.car.news.entity.ArticleCategory;

public interface ArticleCategoryMapper {
    int insert(ArticleCategory record);

    int insertSelective(ArticleCategory record);
}