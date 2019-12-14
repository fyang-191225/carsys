package com.qfedu.car.dto;

import lombok.Data;

/**
 * @program: CarSys
 * @description:
 * @author: Feri
 * @create: 2019-12-10 14:41
 */

/**
 * 会员信息分页需要的数据
 */
@Data
public class MemberQueryDto {
    /**
     * 第几页
     */
    private int page;
    /**
     * 每页的页码
     */
    private int size;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private int sex;
}