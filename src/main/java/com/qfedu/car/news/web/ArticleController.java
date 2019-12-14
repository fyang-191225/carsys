package com.qfedu.car.news.web;

import com.qfedu.car.common.vo.R;
import com.qfedu.car.dto.ArticleQueryDto;
import com.qfedu.car.news.entity.Article;
import com.qfedu.car.news.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author FYY
 * @date 2019/12/14 0014 下午 15:10
 */

@RestController
@Api(value = "实现资讯的相关操作", tags = "实现资讯的相关操作")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 新增
     * @param article
     * @return
     */
    @ApiOperation(value = "实现资讯的新增", notes = "实现资讯的新增")
    @PostMapping("/api/news/article/save.do")
    public R save(@RequestBody Article article) {
        return articleService.save(article);
    }

    /**
     * 查询单个
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "实现资讯的详细信息的查询", notes = "实现资讯的详细信息的查询")
    @GetMapping("/api/news/article/queryById.do")
    public R queryById(int id) {
        return articleService.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param queryDto
     * @return
     */
    @ApiOperation(value = "实现资讯的列表查询", notes = "实现资讯的列表查询")
    @GetMapping("/api/news/article/queryPage.do")
    public R queryPage(ArticleQueryDto queryDto) {
        return articleService.queryPage(queryDto);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @ApiOperation(value = "实现资讯的删除", notes = "实现资讯的删除")
    @DeleteMapping("/api/news/article/del.do")
    public R del(@RequestBody int id) {
        return articleService.del(id);
    }
}
