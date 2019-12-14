package com.qfedu.car.news.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qfedu.car.common.vo.R;
import com.qfedu.car.dto.ArticleQueryDto;
import com.qfedu.car.news.dao.ArticleMapper;
import com.qfedu.car.news.entity.Article;
import com.qfedu.car.news.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author FYY
 * @date 2019/12/14 0014 上午 11:35
 */


@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 新增
     * @param article
     * @return
     */
    @Override
    public R save(Article article) {
        if (articleMapper.insert(article) > 0) {
            return R.OK();
        } else {
            return R.fail();
        }
    }

    /**
     * 查询
     * @param id
     * @return
     */
    @Override
    public R queryById(int id) {
        return R.OK(articleMapper.selectById(id));
    }

    /**
     * 分页查询
     *
     * @param queryDto
     * @return
     */
    @Override
    public R queryPage(ArticleQueryDto queryDto) {
        // 判断是否传入title字段的数据，如过传入数据，设置为模糊查询，没有传入该字段消息
        // 通过其他字段实现分页查询
        if (queryDto.getTitle() != null) {
            queryDto.setTitle("%"+queryDto.getTitle()+"%");
        }
        //设置分页 当前的页码  每页显示的数量
        PageHelper.startPage(queryDto.getPage(),queryDto.getSize());
        // 查询数据
        List<Article> list = articleMapper.selectAll(queryDto);
        PageInfo<Article> page=new PageInfo<>(list);
        return R.OK(page);
    }

    /**
     * 删除，通过sql语句修改状态，来实现假删除，
     * @param id
     * @return
     */
    @Override
    public R del(int id) {
        if (articleMapper.update(id) > 0) {
            return R.OK();
        }else {
            return R.fail();
        }
    }
}
