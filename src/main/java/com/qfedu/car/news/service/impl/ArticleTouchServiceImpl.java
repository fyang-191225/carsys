package com.qfedu.car.news.service.impl;

import com.qfedu.car.common.vo.R;
import com.qfedu.car.news.dao.ArticleTouchMapper;
import com.qfedu.car.news.entity.ArticleTouch;
import com.qfedu.car.news.service.ArticleTouchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author FYY
 * @date 2019/12/14 0014 上午 11:07
 */
// 逻辑存在问题
@Service
public class ArticleTouchServiceImpl implements ArticleTouchService {

    @Autowired
    private ArticleTouchMapper articleTouchMapper;

    /**
     * 增加数据，点赞
     * @param articleTouch
     * @return 添加成功，返回R.ok 是200，失败 400
     */
    @Override
    public R like(ArticleTouch articleTouch) {
        if (articleTouchMapper.insert(articleTouch) > 0 ) {
            return R.OK();
        } else {
            return R.fail();
        }
    }

    /**
     * 删除数据， 取消点赞
     * @param touch
     * @return 添加成功，返回R.ok 200，失败R.fail() 400
     */
    @Override
    public R del(ArticleTouch touch) {

        if (articleTouchMapper.del(touch) > 0) {
            return R.OK();
        } else {
            return R.fail();
        }
    }

    /**
     * 获取我的点赞数据
     * @param mid
     * @return
     */
    @Override
    public R list(int mid) {
        return R.OK(articleTouchMapper.selectAll(mid));
    }
}
