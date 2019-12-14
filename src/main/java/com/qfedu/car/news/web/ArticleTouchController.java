package com.qfedu.car.news.web;

import com.qfedu.car.common.vo.R;
import com.qfedu.car.news.entity.ArticleTouch;
import com.qfedu.car.news.service.ArticleTouchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author FYY
 * @date 2019/12/14 0014 上午 11:24
 */

@Api(value = "实现点赞的相关操作", tags = "实现点赞的相关操作")
@RestController
public class ArticleTouchController {

    @Autowired
    private ArticleTouchService articleTouchService;

    @ApiOperation(value = "实现点赞操作", notes = "实现点赞操作")
    @PostMapping("/api/news/touch/like.do")
    public R like(@RequestBody ArticleTouch articleTouch) {
        return articleTouchService.like(articleTouch);
    }

    @ApiOperation(value = "实现删除点赞操作", notes = "实现删除点赞操作")
    @DeleteMapping("/api/news/touch/remove.do")
    public R del(ArticleTouch articleTouch) {
        return articleTouchService.del(articleTouch);
    }



    @ApiOperation(value = "查询我点赞的记录", notes = "查询我点赞的记录")
    @GetMapping("/api/news/touch/queryAll.do")
    public R queryAll(int mid) {
        return articleTouchService.list(mid);
    }

}




