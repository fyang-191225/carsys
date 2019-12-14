package com.qfedu.car.news.service;

import com.qfedu.car.common.vo.R;
import com.qfedu.car.dto.ArticleQueryDto;
import com.qfedu.car.news.entity.Article;

/**
 * @author FYY
 * @date 2019/12/14 0014 上午 11:35
 */

public interface ArticleService {
    /**
     * 新增
     * @param article
     * @return
     */
    R save(Article article);

    /**
     * 查询
     * @param id
     * @return
     */
    R queryById(int id);

    /**
     * 查询列表--分页，条件，类型
     * @param queryDto
     * @return
     */
    R queryPage(ArticleQueryDto queryDto);

    /**
     * 删除
     * @param id
     * @return
     */
    R del(int id);


}
