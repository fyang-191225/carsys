package com.qfedu.car.news.service;

import com.qfedu.car.common.vo.R;
import com.qfedu.car.news.entity.ArticleTouch;

/**
 * @author FYY
 * @date 2019/12/14 0014 上午 11:07
 */

public interface ArticleTouchService {

    /**
     * 点赞记录，增加数据
     *
     * @param articleTouch
     * @return
     */
    R like(ArticleTouch articleTouch);

    /**
     * 删除数据， 取消点赞
     *
     * @param touch
     * @return
     */
    R del(ArticleTouch touch);

    /**
     * 查询，获取我的点赞记录
     *
     * @param mid
     * @return
     */
    R list(int mid);
}
