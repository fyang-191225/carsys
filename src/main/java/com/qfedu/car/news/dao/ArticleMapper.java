package com.qfedu.car.news.dao;


import com.qfedu.car.dto.ArticleQueryDto;
import com.qfedu.car.news.entity.Article;

import java.util.List;

public interface ArticleMapper {
    int insert(Article record);
    Article selectById(int id);
    List<Article> selectAll(ArticleQueryDto queryDto);
    int update(int id);
}