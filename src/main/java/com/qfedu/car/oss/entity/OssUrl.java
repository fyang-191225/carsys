package com.qfedu.car.oss.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author FYY
 * @date 2019/12/12 0012 下午 19:58
 */

/**
 * 记录每一次上传的内容和可访问路径的实体类
 */
@Data
public class OssUrl {

    // id
    private Integer id;
    //
    private String objname;
    private String url;
    private Date ctime;
    private Date endtime;

}
