package com.qfedu.car.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @author FYY
 * @date 2019/12/12 0012 下午 19:47
 */

/**
 * 为上传照片，获取的路径 设置有效期 y年
 */
public class DateUtil {
    // 获取指定年的 今天
    public static Date addYear(int y) {
        Calendar calendar = Calendar.getInstance();
        // 计算日期
        calendar.add(calendar.YEAR, y);

        return calendar.getTime();
    }
}
