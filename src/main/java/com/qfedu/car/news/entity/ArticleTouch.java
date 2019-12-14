package com.qfedu.car.news.entity;

import java.util.Date;

/**
 * 点赞信息
 *
 * @author FYY
 * @date 2019/12/14 0014 上午 9:57
 */
public class ArticleTouch {
    private Integer id;

    private Integer mid;

    private Integer aid;

    private Date ctime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }
}